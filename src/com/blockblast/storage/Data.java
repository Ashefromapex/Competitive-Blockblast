package com.blockblast.storage;

//declare packages
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Data {

    //this class is used to store Data and read it again at startup

    //declare directories + filepath
    final String DIRPATH = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Comp-BB";
    final String FILEPATH_DATA = DIRPATH + File.separator + "data.txt";
    final String FILEPATH_MP = DIRPATH + File.separator + "mp.txt";
    final String FILEPATH_SETTINGS = DIRPATH + File.separator + "settings.txt";

    //declare variables
    protected String currentUser;
    public File data;
    public File mp;
    public File settings;
    private String UserData;
    private String userMP;
    private int histLenght;
    private int[] history;
    private int cHigh;


    public Data(){
        // Constructor code here

        currentUser = "null";
        data = createDataFile();
        mp = createMPFile();
        settings = createSettingsFile();
        setHistLenght(5);
        histLenght = getHistLength();
        history = new int[histLenght];



    }
    private File createDataFile()
    {
        //ceates direcotry
        File dir = new File(DIRPATH);
        if(dir.exists())
        {
            //already exists

        }
        else if(dir.mkdirs()) //craeates directories
        {
            System.out.println("Created Directory");
        }
        else
        {
            //failure
            System.out.println("ERROR CREATING Direcotry");
        }
        //create file:
        File data = new File(FILEPATH_DATA);
        if(!data.exists())
        {
            try
            {
                data.createNewFile();
            }
            catch (IOException e)
            {
                System.out.println("Error creating data file:" + e.getMessage());
            }
        }

        return data;
    }

    private File createMPFile()
    {
        //directory already created in datafile method
        //create file:
        File mp = new File(FILEPATH_MP);
        if(!mp.exists())
        {
            try
            {
                mp.createNewFile();
            }
            catch (IOException e)
            {
                System.out.println("Error creating MP file:" + e.getMessage());
            }
        }

        return mp;
    }
    private File createSettingsFile()
    {
        //create file:
        File set = new File(FILEPATH_SETTINGS);
        if(!set.exists())
        {
            try
            {
                set.createNewFile();
            }
            catch (IOException e)
            {
                System.out.println("Error creating settings file:" + e.getMessage());
            }
        }

        return set;
    }

    public boolean deleteFile(File f)
    {
        if (f.exists())
        {
            return f.delete();
        }
        else
        {
            System.out.println("File does not exist.");
            return false;
        }

    }
    public void loginUser(String username)
    {
        if(username != null && !(username.equals(currentUser)))
        {
            //save current progress
            if(!currentUser.equals("null"))
            {
                exit();
            }
            currentUser = username;
            readHist();
        }
        else
        {
            System.out.println("User already logged in or invalid username.");
        }
    }
    public void pushScore(int score)
    {
        //1. read current highscore from file
        String high = getDataAtPosition(getUserData(currentUser), 2);
        //convert to double
        if(high.isEmpty())
        {
            //if file is empty, set highscore to 0
            high = "0";
        }
        cHigh = Integer.parseInt(high);

        //2. compare it with the new score
        if(score > cHigh)
        {
            //3. set new score as highscore if it is higher
            cHigh = score;
        }

        //4.push score to history
        pushHist(score);

    }
    private void writeToFile(String content, String path, int line)
    {
        //1. read the content
        Path filepath = Paths.get(path);
        List<String> lines = new ArrayList<>();
        try
        {
            lines = Files.readAllLines(filepath);
        }
        catch (IOException e)
        {
            System.out.println("Error reading File:" + e.getMessage());
        }
        //2. replace data for current user with new one
        if(!lines.isEmpty())
        {
            lines.set(line - 1, content);
            //3. Write final part to file
            try
            {
                Files.write(filepath, lines);
            }
            catch (IOException e)
            {
                System.out.println("Error writing to userdata.txt file: " + e.getMessage());
            }
        }
        else
        {
            //no lines read
            try
            {
                Files.writeString(filepath, content);
            }
            catch (IOException e) {
                System.out.println("Error writing to userdata.txt file: " + e.getMessage());
            }
        }


    }
    private String readFromFile(String path, int line)
    {
        String content = "";
        File file = new File(path);
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            try
            {
                for(int i = 0; i < line; i++)
                {
                    content = reader.readLine();
                }
                reader.close();
            }
            catch (IOException e)
            {
                System.out.println("Error reading file: " + e.getMessage());
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
        if(content != null)
        {
            return content;
        }
         return "ERROR";
    }

    private String getUserData(String username)
    {
        int pos = getUserPosition(username);
        if(pos == -1) //user doesnt exist
        {
            return defaultData(username);
        }
        return readFromFile(FILEPATH_DATA, pos);
    }
    private String defaultData(String user)
    {
        int[] hist = new int[histLenght];
        for(int i = 0; i < histLenght; i++)
        {
            hist[i] = 0;
        }
        return buildString(user, 0, hist, false);
    }
    private int getUserPosition(String username) //returns in which line the userdata is stored
    {
        String current = "";
        int i = 1;
        String line;

        while(true) {
            line = readFromFile(FILEPATH_DATA, i);
            if(line.equals("ERROR") || line == null || line.isEmpty()) {
                // User doesn't exist, return -1 or create new user entry
                return -1;
            }

            current = getDataAtPosition(line, 1);
            if(current.equals(username)) {
                return i;
            }
            i++;
        }
    }
    public int fetchHighscore()
    {
        String in = getUserData(currentUser);
        String content = "";
        //high score is at second position
        content = getDataAtPosition(in, 2);
        if(content.isEmpty())
        {
            return 0;
        }
        else
        {
            return Integer.parseInt(content);
        }
    }

    private String getDataAtPosition(String in, int pos)
    {
        String data = "";
        int j = 0;
        for(int i = 0; i < pos; i++)
        {

            data = "";
            while(in.charAt(j) != ' ')
            {
                data += in.charAt(j);
                j++;
            }
            j += 2; //skips comma
        }
        return data;
    }

    private String buildString(String username, int high, int[] hist, boolean newLine)
    {
        String out = "";
        out += username;
        out += " ,";
        out += Integer.toString(high);
        out += " ,";
        for (int j : hist) {
            out += Integer.toString(j);
            out += " ,";
        }
        if(newLine) //you only need lines sometimes idfk
        {
            out += "\n";
        }
        return out;
    }
    private int getHistLength()
    {
        String tmp = readFromFile(FILEPATH_SETTINGS, 1);
        if(isInteger(tmp))
        {
            int a = Integer.parseInt(tmp);
            if(a <= 0)
            {
                //nuh uh
                a = 1;
            }
            return a;
        }
        return 1;

    }
    private void setHistLenght(int lenght)
    {
        String tmp = Integer.toString(lenght);
        writeToFile(tmp, FILEPATH_SETTINGS, 1);
    }
    private void readHist()
    {
        String tmp = getUserData(currentUser);
        //history starts at 3 and goes to 2 + histlength
        int z = 0; //history index
        for(int i = 3; i < histLenght + 3; i++)
        {
            history[z] = Integer.parseInt(getDataAtPosition(tmp, i));  //save history
            z++;
        }
    }
    private void pushHist(int score)
    {
        //pushes every history to a previous index
        for(int i = 1; i < histLenght; i++)
        {
            history[i - 1] = history[i];
        }
        //saves new one
        history[histLenght - 1] = score;

    }

    public static boolean isInteger(String str)
    {
        if (str == null)
        {
            return false;
        }
        try
        {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }
    public void exit()
    {
        //called when program closes/user switches
        //saves everything
        int pos = getUserPosition(currentUser);
        //if user isnt already signed up (looser moment)
        if(pos == -1)
        {
            //user = looser
            //append current data to file
            try(FileWriter fw = new FileWriter(new File(FILEPATH_DATA), true))
            {
                fw.write(buildString(currentUser, cHigh, history, true));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
        else
        {
            writeToFile(buildString(currentUser, cHigh, history, false), FILEPATH_DATA, getUserPosition(currentUser));
        }


    }
}
