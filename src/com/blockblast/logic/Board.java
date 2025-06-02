package com.blockblast.logic;

//import java.lang.reflect.Array;

public class Board
{
    int[][] board;
    public Board()
    {

        board = new int[8][8];
        for(int x = 0; x < 8; x++) //set all values in matrix to false
        {
            for(int y = 0; y < 8; y++)
            {
                board[x][y] = 0;//x is row and y is column
            }
        }
    }

    public void check_field(int[][] board)//score ?
    {
        for (int x = 0; x < 8; x++)
        {
            check_column(x);
            check_row(x);
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

    BlockAlgo bA = new BlockAlgo();
    Translator t = new Translator();


    public void buildCompleteBlock()
    {
        System.out.println();
        int code = bA.generateBlock();
        System.out.println(code);
        System.out.println();
        t.printBlock(t.translate(code));

    }


}




