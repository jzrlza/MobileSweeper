package com.msassist.jbcom.minesweepassist;

import android.content.Context;
import android.util.Log;

import com.msassist.jbcom.minesweepassist.util.Generator;
import com.msassist.jbcom.minesweepassist.util.PrintGrid;
import com.msassist.jbcom.minesweepassist.views.grid.Cell;

/**
 * Game Engine, A Singleton Class to run game
 * Created 05 July 2019
 */
public class GameEngine {

    private static GameEngine instance;

    private Context context;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    public int[][] GeneratedGrid;

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
        GeneratedGrid = Generator.generateEmpty(WIDTH, HEIGHT);
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

    public Cell getCellAt( int x , int y ){
        return MinesweeperGrid[x][y];
    }

    public void click( int x , int y ){
        if( x >= 0 && y >= 0 && x < WIDTH && y < HEIGHT ){
            if( GeneratedGrid[x][y] >= 0 ){
                GeneratedGrid[x][y] = -1;
            } else {
                GeneratedGrid[x][y] = 0;
            }
            GeneratedGrid = Generator.calculateNeigbours(GeneratedGrid,WIDTH,HEIGHT);
            setGrid(context,GeneratedGrid);
        }
    }


    public void flag( int x , int y ){
        boolean isFlagged = getCellAt(x,y).isFlagged();
        getCellAt(x,y).setFlagged(!isFlagged);
        getCellAt(x,y).invalidate();
    }


    public void clearBoard() {
        GeneratedGrid = Generator.generateEmpty(WIDTH, HEIGHT);
        PrintGrid.print(GeneratedGrid,WIDTH,HEIGHT);
        setGrid(context,GeneratedGrid);
    }
}
