package com.blockblast.logic;

//import java.lang.reflect.Array;

public class board
{
    boolean[][] board;
    public board()
    {

        board = new boolean[8][8];
        for(int x = 0; x < 8; x++) //set all values in matrix to false
        {
            for(int y = 0; y < 8; y++)
            {
                board[x][y] = false;
            }
        }
    }

}
