package com.blockblast.logic;

//import java.lang.reflect.Array;
import com.blockblast.blocks.Blockelement;

import java.util.Arrays;

public class Board {
    public Blockelement b1;
    public Blockelement b2;
    public Blockelement b3;
    public Blockelement[] blockarr;
    public int code1;
    public int code2;
    public int code3;
    public int[][] bm1; //--> converted Blockmatrix of block 1
    public int[][] bm2;
    public int[][] bm3;
    public int[][] optimalPlacements;
    public Algo alg;
    int[][] faki;
    int[][] board;
    boolean[][][] allPossible;
    int score;
    int kombo;
    public boolean gameOver;
    int missedKombo;
    public boolean[] blocksplaced;
    int tempAtkLvL;
    boolean allClear;

    public Board() {
        System.out.println("Board created");
        board = new int[8][8];
        faki = new int[8][8];
        allPossible = new boolean[3][8][8];
        alg = new Algo();
        blockarr = new Blockelement[3];
        bm1 = new int[5][5];
        bm2 = new int[5][5];
        bm3 = new int[5][5];
        score = 0;
        kombo = 0;
        optimalPlacements = new int[3][2];
        gameOver = false;
        missedKombo = 0;
        blocksplaced = new boolean[3];
    }

    public int[][] getBoard() {
        return board;
    }

    public void check_field()//score ?
    {
        int komboTest = kombo;
        int[] fullrow = check_row();
        int[] fullcollumn = check_column(); //checks where a row/column is full
        //clears full rows/columns
        reset_row(fullrow);
        reset_column(fullcollumn);
        if(allClear())
        {
            score += 10000 * kombo;
        }
        if (kombo == komboTest)
        {
            missedKombo++;
        }
        if(missedKombo == 3)
        {
            missedKombo = 0;
            kombo = 0;
        }
        SetScore();
    }

    public int SetScore()
    {

        if(kombo > 0)
        {
            score += 1000 * kombo;
        }
        else
        {
            score += 100;
        }
        return score;
    }

    public int getDefenseLvL()
    {
        if(allClear)
        {
            allClear = false;
            return 8;
        }
        else
        {
            return tempAtkLvL;
        }
    }

    public int calcDiff(int inc)
    {
        if(allClear)
        {
            return 8 - inc;
        }
        else
        {
            return tempAtkLvL- inc;
        }
    }

    public void getBlocks()
    {
      alg.genBlocks();
      b1 = alg.b1;
      b2 = alg.b2;
      b3 = alg.b3;
      code1 = alg.code1;
      code2 = alg.code2;
      code3 = alg.code3;
    }
    public int getSeed()
    {
        return alg.getSeed();
    }
    public boolean[][][] getAllPossible()
    {
        checkAll();
        return allPossible;
    }
    public void reset()
    {
        for(int i = 0; i < 3; i++)
        {
            blocksplaced[i] = false;
        }
        clearBlockMatrices();
        getBlocks();
        createBlockmatrix();
        checkAll();
    }


    public boolean checkPlacement(int y, int x, Blockelement b)
    {
        if(y>= 0 && y < 8 && x >= 0 && x < 8 && board[y][x] == 0)
        {
            int placeable = 0;
            if (!b.above.isEnd()) {
                if(!checkPlacement( y - 1, x, (Blockelement) b.above))
                {
                    placeable = 1;
                }
            }
            if (!b.left.isEnd()) {
                if(!checkPlacement(y, x - 1,  (Blockelement) b.left))
                {
                    placeable = 1;
                }
            }
            if (!b.below.isEnd()) {
                if(!checkPlacement(y + 1, x, (Blockelement) b.below))
                {
                    placeable = 1;
                }
            }
            if (!b.right.isEnd()) {
                if(!checkPlacement(y, x + 1,  (Blockelement) b.right))
                {
                    placeable = 1;
                }
            }
            return placeable == 0;
        }
        return false;
    }

    public boolean checkSpezField(int y, int x)//useless rn lmao
    {
        if (board[y][x] == 0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }


    public boolean checkAll()
    {
        //resets board
        for (int i = 0; i < 3; i++) {
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    allPossible[i][x][y] = false;
                }
            }
        }
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                copyBoardToFaki();



                if(checkPlacement(x,y,b1))
                {
                    allPossible[0][x][y] = true;
                }
                if(checkPlacement(x,y,b2))
                {
                    allPossible[1][x][y] = true;
                }
                if(checkPlacement(x,y,b3))
                {
                    allPossible[2][x][y] = true;
                }
            }
        }
        return true;// nur damit fehlermedlung weg ist sonst ist des eigl nicht hier bzw ohne gedanken hier
    }


    public void copyBoardToFaki()
    {
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                faki[x][y] = board[x][y];
            }
        }
    }

    // wird ausgeführt wenn der nutzer den block platzieren will
    public boolean placeBlock(int blocknr, int x, int y)
    {
        if(!blocksplaced[0] && !blocksplaced[1] && !blocksplaced[2])
        {
            tempAtkLvL = 0;
        }
        switch (blocknr)
        {
            case 1:
                if(checkPlacement(x, y, b1))
                {
                    setBlockinArray(b1, x, y, board);
                }
                else
                {
                    System.out.println("Error placing block '"+ blocknr + "' at '"+ x + "," + y + "' :" + "\n" + "checkplacement: " + checkPlacement(x, y, b1) );
                    return false;
                }
                break;
            case 2:
                if(checkPlacement(x, y, b2))
                {
                    setBlockinArray(b2, x, y, board);
                }
                else
                {
                    System.out.println("Error placing block '"+ blocknr + "' at '"+ x + "," + y + "' :" + "\n" + "checkplacement: " + checkPlacement(x, y, b2) );
                    return false;
                }
                break;
            case 3:
                if(checkPlacement(x, y, b3))
                {
                    setBlockinArray(b3, x, y, board);
                }
                else
                {
                    System.out.println("Error placing block '"+ blocknr + "' at '"+ x + "," + y + "' :" + "\n" + "checkplacement: " + checkPlacement(x, y, b3) );
                    return false;
                }
                break;
        }
        blocksplaced[blocknr - 1] = true;
        check_field(); // cleared feld, fals reihe voll + combo + score

        //checks if all three blocks were placed
        if(blocksplaced[0] && blocksplaced[1] && blocksplaced[2])
        {
            reset();
        }
        checkAll(); // all possible geupdated
        checkGameOver();
        return true;

    }

    private void checkGameOver()
    {
        int x;
        int y;
        int z;
        int kek = 0;
        {
            for (z = 0; z < 3; z++)
            {
                if(blocksplaced[z])
                {
                    continue;
                }
                for (x = 0; x < 8; x++)
                {
                    for (y = 0; y < 8; y++)
                    {



                        if(allPossible[z][x][y])
                        {
                            kek++;
                        }


                    }
                }
            }

        }
        if(kek == 0 )
        {
            System.out.println("Game Over");
            gameOver = true;

        }
    }



    public void clearBlockMatrices()
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                bm1[i][j] = 0;
                bm2[i][j] = 0;
                bm3[i][j] = 0;
            }
        }
    }

    public int[] check_column()
    {
        int[] full = new int[8];
        for(int i = 0; i < 8; i++)
        {
            int check = 0;
            for(int x = 0; x < 8;x++)//check if column Y is full
            {
                check = check + board[x][i];
            }
            if(check == 8)//check is only 8 if all einträge = 1 aka the column is full and needs to be cleared
            {
                full[i] = 1;
            }
        }
        return full;

    }

    public int[] check_row()
    {
        int[] full = new int[8];
        for(int i = 0; i < 8; i++)
        {
            int check = 0;
            for(int y = 0; y < 8;y++)//check if row X is full
            {
                check = check + board[i][y];
            }
            if(check == 8)
            {
                full[i] = 1;
            }
        }
        return full;
    }

    private void reset_column(int[] full)
    {
        for(int i = 0; i < 8; i++)
        {
            if(full[i] == 1)
            {
                for (int y = 0; y < 8; y++)
                {
                    board[y][i] = 0;
                }
                kombo++;
                tempAtkLvL++;
            }
        }

    }

    private void reset_row(int[] full)
    {
        for(int i = 0; i < 8; i++)
        {
            if (full[i] == 1)
            {
                for (int y = 0; y < 8; y++)
                {
                    board[i][y] = 0;
                }
                kombo++;
                tempAtkLvL++;
            }
        }
    }
    private boolean allClear() {
        int check = 0;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                check = check + board[x][y];
            }

        }
        if (!allClear)
        {
            allClear = check == 0;
        }
        return check == 0;
    }






    public void printi()
    {
        System.out.println("faki" +"\n"+ Arrays.deepToString(faki));
        System.out.println("board" +"\n"+ Arrays.deepToString(board));
        System.out.println("allPossible" +"\n"+ Arrays.deepToString(allPossible));
    }

    public void setBlockinArray(Blockelement b, int x, int y, int[][] array)
    {
        /*
         *  It is assumed that only possible placements are made
         *  credits to mau for recursion magic
         */
        array[x][y] = array[x][y] + b.placeBlock(x, y);
        if (!b.above.isEnd()) {
            setBlockinArray((Blockelement) b.above, x - 1, y , array);
        }
        if (!b.left.isEnd()) {
            setBlockinArray((Blockelement) b.left, x , y - 1, array);
        }
        if (!b.below.isEnd()) {
            setBlockinArray((Blockelement) b.below, x + 1, y , array);
        }
        if (!b.right.isEnd()) {
            setBlockinArray((Blockelement) b.right, x , y + 1, array);
        }
    }

    public void createBlockmatrix()
    {
        optimalPlacements[0]= optimalPlacement(code1);
        optimalPlacements[1]= optimalPlacement(code2);
        optimalPlacements[2]= optimalPlacement(code3);
        setBlockinArray(b1, optimalPlacements[0][0], optimalPlacements[0][1], bm1);
        setBlockinArray(b2, optimalPlacements[1][0], optimalPlacements[1][1], bm2);
        setBlockinArray(b3, optimalPlacements[2][0], optimalPlacements[2][1], bm3);
    }
    public int[] optimalPlacement(int code)
    {
        /*
         *  returns the optimal x (at index 0) and y (at index 1) positions for the block
         */
        int tmp = code % 100;
        int ammount = (code - tmp) / 100;
        int type = (tmp - tmp % 10) / 10;
        int rotation = tmp % 10;

        // array works like this:
        // x determines the vertical row (normally called y)
        // y determines the position within a row from left to right (normally called x)

        int[] arr = new int[2];

        switch (ammount)
        {

            case 1, 2:
                arr = new int[]{2, 2};
                break;
            case 3:
                if(type == 0)
                {
                    arr = new int[]{2, 1};
                }
                else
                {
                    arr = new int[]{2, 2};
                }
                break;
            case 4:
                switch (type)
                {
                    case 0:
                        arr =  new int[]{2, 0};
                        break;
                    case 1:
                        arr =  new int[]{2, 2};
                        break;
                    case 2:
                        arr =  new int[]{1, 1};
                        break;
                    case 3:
                        switch (rotation)
                        {
                            case 1:
                                return new int[]{1, 3};
                            case 2:
                                return new int[]{3, 3};
                            case 3:
                                return new int[]{4, 1};
                            case 4:
                                return new int[]{1, 1};
                        }
                        break;
                    case 4, 5:
                        arr =  new int[]{2, 1};
                        break;
                    case 6:
                        arr =  new int[]{2, 2};
                        break;
                }
                break;
            case 5:
                if(type == 0)
                {
                    arr = new int[]{2, 0};
                }
                else
                {
                    arr = new int[]{1, 1};
                }
                break;
            case 6:
                arr =  new int[]{1, 1};
                break;
            case 9:
                arr = new int[]{1, 1};
                break;
            default:
                arr =  new int[]{2, 2};
        }
        //now some rotation magic (again)
        //calculates x diff and y diff to then invert them as needed
        int dx = arr[0] - 2;
        int dy = arr[1] - 2;

        switch (rotation) //dont even fucking ask
        {
            case 1:
                break;
            case 2:
                if(dx == 0)
                {
                    dx = dy;
                    dy = 0;
                }
                else
                {
                    dy *= -1;
                }
                break;
            case 3:
                if(dx == 0)
                {
                    dy *= -1;
                }
                else
                {
                    dx *= -1;
                    dy *= -1;
                }
                break;
            case 4:
               if(dx == 0)
               {
                   dx = -1* dy;
                   dy = 0;
               }
               else
               {
                   dx *= -1;
               }
                break;
        }
        //apply diff to original positions
        arr[0] = 2 + dx;
        arr[1] = 2 + dy;
        return arr;
    }
    public void printArray(int[][] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public int getScore()
    {
        return score;
    }
    public int getDif()
    {
        return alg.difficulty;
    }
    public int getKombo(){return kombo;}


}




