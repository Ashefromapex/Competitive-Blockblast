package com.blockblast.logic;

//import java.lang.reflect.Array;
import com.blockblast.blocks.Blockelement;
import com.blockblast.controller.controller;

import java.util.Arrays;

public class Board {
    public Blockelement b1;
    public Blockelement b2;
    public Blockelement b3;
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
    }

    public boolean[][][] getAllPossible()
    {
        checkAll();
        return allPossible;
    }

    public boolean checkPlacement(int blockx, int x, int y)
    {
        // int x = 2;
        // if ( x == 1 /* da muss noch was gescheids rein, kp wie man checkt ob das geht oder nicht*/)
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
        return true; // nur damit fehlermedlung weg ist sonst ist des eigl nicht hier bzw ohne gedanken hier
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
    public void placeBlock(int blockx, int x, int y)
    {
        if (this.checkPlacement(blockx, x, y)) // or allPossible
        {
            switch(blockx) {
                case 1:
                    board[x][y] = board[x][y] + b1.placeBlock(x, y);
                    if (!b1.above.isEnd()) {
                        placeBlock(blockx, x, y - 1);
                    }
                    if (!b1.left.isEnd()) {
                        placeBlock(blockx, x - 1, y);
                    }
                    if (!b1.below.isEnd()) {
                        placeBlock(blockx, x, y + 1);
                    }
                    if (!b1.right.isEnd()) {
                        placeBlock(blockx, x + 1, y);
                    }
                    break;


                case 2:
                    board[x][y] = board[x][y] + b2.placeBlock(x, y);
                    if (!b2.above.isEnd()) {
                        placeBlock(blockx, x, y - 1);
                    }
                    if (!b2.left.isEnd()) {
                        placeBlock(blockx, x - 1, y);
                    }
                    if (!b2.below.isEnd()) {
                        placeBlock(blockx, x, y + 1);
                    }
                    if (!b2.right.isEnd()) {
                        placeBlock(blockx, x + 1, y);
                    }
                    break;

                case 3:
                    board[x][y] = board[x][y] + b3.placeBlock(x, y);
                    if (!b3.above.isEnd()) {
                        placeBlock(blockx, x, y - 1);
                    }
                    if (!b3.left.isEnd()) {
                        placeBlock(blockx, x - 1, y);
                    }
                    if (!b3.below.isEnd()) {
                        placeBlock(blockx, x, y + 1);
                    }
                    if (!b3.right.isEnd()) {
                        placeBlock(blockx, x + 1, y);
                    }
                    break;
            }
        }
        else
        {
            System.out.println("Placement failed");
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
}




