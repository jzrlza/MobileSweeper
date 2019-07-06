package com.msassist.jbcom.minesweepassist.util;

import android.util.Log;

/**
 * Early testing class to see if the grid works
 * Created 05 July 2019
 */
public class PrintGrid {

    public static void print( final int[][] grid , final int width , final int height ){
        for( int x = 0 ; x < width ; x++ ){
            String printedText = "| ";
            for( int y = 0 ; y < height ; y++ ){
                printedText += String.valueOf(grid[x][y]).replace("-1", "B") + " | ";
            }
            Log.e("",printedText);

        }
    }
}