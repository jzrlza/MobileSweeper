package com.msassist.jbcom.minesweepassist;

import android.content.Context;
import android.util.Log;
import com.msassist.jbcom.minesweepassist.util.Generator;
import com.msassist.jbcom.minesweepassist.util.PrintGrid;
import com.msassist.jbcom.minesweepassist.views.grid.Cell;

/**
 *
 * Created 05 July 2019
 */
public class GameEngine {

    private static GameEngine instance;

    private Context context;
    public static final int BOMBS = 20;
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private Cell[][] MinesweeperGrid = new Cell[WIDTH][HEIGHT];

    public static GameEngine getInstance() {
        if (instance == null) {
            instance = new GameEngine();
        }
        return instance;
    }

    private GameEngine() {}

    public void createGrid(Context context) {
        Log.e("GameEngine","createGrid is working");
        this.context = context;

        // create the grid and store it
        int[][] GeneratedGrid = Generator.generate(BOMBS, WIDTH, HEIGHT);
        PrintGrid.print(GeneratedGrid,WIDTH,HEIGHT);
        setGrid(context,GeneratedGrid);
    }

    private void setGrid( final Context context, final int[][] grid ){
        for( int x = 0 ; x < WIDTH ; x++ ){
            for( int y = 0 ; y < HEIGHT ; y++ ){
                if( MinesweeperGrid[x][y] == null ){
                    MinesweeperGrid[x][y] = new Cell( context , x,y);
                }
                MinesweeperGrid[x][y].setValue(grid[x][y]);
                MinesweeperGrid[x][y].invalidate();
            }
        }
    }

    public Cell getCellAt(int position) {
        int x = position % WIDTH;
        int y = position / WIDTH;

        return MinesweeperGrid[x][y];
    }
}
