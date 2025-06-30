package com.blockblast.logic;

//import java.lang.reflect.Array;
import com.blockblast.blocks.Blockelement;
import com.blockblast.controller.controller;

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
    public Algo alg;
    int[][] faki;
    int[][] board;
    boolean[][][] allPossible;
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
    }

    public int[][] getBoard() {
        return board;
    }

    public void check_field(int[][] board)//score ?
    {
        for (int x = 0; x < 8; x++) {
            check_column(x);
            check_row(x);
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

    public boolean checkPlacement(int blockx, int x, int y)
    {
        // int x = 2;
        // if (x == 1 /* da muss noch was gescheids rein, kp wie man checkt ob das geht oder nicht*/)
        // {
            switch(blockx)
            {
                case 0:
                while(x >= 0 && y >= 0 && x < 8 && y < 8 && faki[x][y] < 2) {


                        faki[x][y] = faki[x][y] + b1.checkPlacement(x, y);
                        if (!b1.above.isEnd()) {
                            checkPlacement(blockx, x, y - 1);
                        }
                        if (!b1.left.isEnd()) {
                            checkPlacement(blockx, x - 1, y);
                        }
                        if (!b1.below.isEnd()) {
                            checkPlacement(blockx, x, y + 1);
                        }
                        if (!b1.right.isEnd()) {
                            checkPlacement(blockx, x + 1, y);
                        }

                        return true;


                }
                return false;


                case 1:
                    while(x >= 0 && y >= 0 && x < 8 && y < 8 && faki[x][y] < 2) {

                            faki[x][y] = faki[x][y] + b2.checkPlacement(x, y);
                            if (!b2.above.isEnd()) {
                                checkPlacement(blockx, x, y - 1);
                            }
                            if (!b2.left.isEnd()) {
                                checkPlacement(blockx, x - 1, y);
                            }
                            if (!b2.below.isEnd()) {
                                checkPlacement(blockx, x, y + 1);
                            }
                            if (!b2.right.isEnd()) {
                                checkPlacement(blockx, x + 1, y);
                            }

                            return true;

                        }


                    return false;

                case 2:
                    while(x >= 0 && y >= 0 && x < 8 && y < 8 && faki[x][y] < 2) {

                            faki[x][y] = faki[x][y] + b3.checkPlacement(x, y);
                            if (!b3.above.isEnd()) {
                                checkPlacement(blockx, x, y - 1);
                            }
                            if (!b3.left.isEnd()) {
                                checkPlacement(blockx, x - 1, y);
                            }
                            if (!b3.below.isEnd()) {
                                checkPlacement(blockx, x, y + 1);
                            }
                            if (!b3.right.isEnd()) {
                                checkPlacement(blockx, x + 1, y);
                            }

                            return true;


                    }
                    return false;
            }



       /*     return true;
        }
        else
        {
        return false;
        }
        */
        return false;
    }

    public boolean checkSpezField(int x, int y)//useless rn lmao
    {
        if (board[x][y] == 0)
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
        for(int z = 0; z < 3; z++)
        {
            for (int x = 0; x < 8; x++)
            {
                for (int y = 0; y < 8; y++)
                {
                    copyBoardToFaki();



                        if(checkPlacement(z, x, y))
                        {
                            allPossible[z][x][y] = true;
                        }

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
    public boolean placeBlock(int blockx, int x, int y)
    {
        if (this.checkPlacement(blockx, x, y)) // or allPossible
        {
            switch(blockx) {
                case 1:
                    setBlockinArray(b1, x, y, board);
                    break;


                case 2:
                    setBlockinArray(b2, x, y, board);
                    break;

                case 3:
                    setBlockinArray(b3, x, y, board);
                    break;
            }
            return true;
        }
        else
        {
            return false;
        }
    }







    public void check_column(int columnY)
    {
        int check = 0;
        for(int x = 0; x < 8;)//check if column Y is full
        {
            check = check + board[x][columnY];
        }
        if(check == 8)//check is only 8 if all einträge = 1 aka the column is full and needs to be cleared
        {
            reset_column(columnY);//resets the column
        }
    }

    public void check_row(int rowX)
    {
        int check = 0;
        for(int y = 0; y < 8;)//check if row X is full
        {
            check = check + board[rowX][y];
        }
        if(check == 8)
        {
            reset_row(rowX);
        }
    }

    private void reset_column(int columnY)
    {
        for (int y = 0; y < 8; y++)
        {
            board[y][columnY] = 0;
        }
    }

    private void reset_row(int rowX)
    {
        for (int y = 0; y < 8; y++)
        {
            board[rowX][y] = 0;
        }
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
        setBlockinArray(b1, optimalPlacement(code1)[0], optimalPlacement(code1)[1], bm1);
        setBlockinArray(b2, optimalPlacement(code2)[0], optimalPlacement(code2)[1], bm2);
        setBlockinArray(b3, optimalPlacement(code3)[0], optimalPlacement(code3)[1], bm3);
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
                        arr =  new int[]{1, 3};
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

}




