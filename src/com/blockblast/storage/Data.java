package com.blockblast.storage;

//declare packages
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Data {

    //this class is used to store Data and read it again at startup

    //declare filepath
    final String FILEPATH = "resources/userdata.txt";
    //declare variables
    protected String currentUser;
    public File data;

    public Data(){
        // Constructor code here

        currentUser = "null";
        data = createFile();
    }
    private File createFile()
    {

        File data = new File(FILEPATH);
        if(!data.exists())
        {
            try
            {
                data.createNewFile();
            }
            catch (IOException e)
            {
                System.out.println("Error creating userdata.txt file: " + e.getMessage());
            }
        }
        return data;
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
    private void loginUser(String username)
    {
        if(username != null && !(username.equals(currentUser)))
        {
            currentUser = username;
        }
        else
        {
            System.out.println("User already logged in or invalid username.");
        }
    }
    public void pushScore(int score)
    {
        //1. read current highscore from file
        String high = readFromFile();
        //convert to double
        if(high.isEmpty())
        {
            //if file is empty, set highscore to 0
            high = "0";
        }
        int highscore = Integer.parseInt(high);

        //2. compare it with the new score
        if(score > highscore)
        {
            //3. set new score as highscore if it is higher
            highscore = score;
            high = Integer.toString(highscore);
            writeToFile(high);
        }

        //4.push score to history
        //history is still in progress :(
    }
    private void writeToFile(String content)
    {
        try
        {
            FileWriter writer = new FileWriter(FILEPATH);
            writer.write(content);
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("Error writing to userdata.txt file: " + e.getMessage());
        }
    }
    private String readFromFile()
    {
        String content = "";
        try
        {
            File data = new File(FILEPATH);
            Scanner s = new Scanner(data);


            while(s.hasNextLine())
            {
                content = s.nextLine();
            }
            s.close();

        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error reading userdata.txt file: " + e.getMessage());
        }
        return content;
    }
    public int fetchHighscore()
    {
        String content = readFromFile();
        if(content.isEmpty())
        {
            return 0;
        }
        else
        {
            return Integer.parseInt(content);
        }
    }
}
