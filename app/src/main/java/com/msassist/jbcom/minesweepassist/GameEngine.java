package com.msassist.jbcom.minesweepassist;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

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
    public static final int BOMBS = 0;
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
        //int[][] GeneratedGrid = Generator.generate(BOMBS, WIDTH, HEIGHT);
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
        /*
        if( x >= 0 && y >= 0 && x < WIDTH && y < HEIGHT && !getCellAt(x,y).isClicked() ){
            getCellAt(x,y).setClicked();

            if( getCellAt(x,y).getValue() == 0 ){
                for( int xt = -1 ; xt <= 1 ; xt++ ){
                    for( int yt = -1 ; yt <= 1 ; yt++){
                        if( xt != yt ){
                            click(x + xt , y + yt);
                        }
                    }
                }
            }

            if( getCellAt(x,y).isBomb() ){
                onGameLost();
            }
        }*/

        //checkEnd();

        if( x >= 0 && y >= 0 && x < WIDTH && y < HEIGHT ){
            //getCellAt(x,y).setClicked();

            if( GeneratedGrid[x][y] >= 0 ){
                //getCellAt(x,y).setValue(-1);
                GeneratedGrid[x][y] = -1;
            } else {
                //getCellAt(x,y).setValue(0);
                GeneratedGrid[x][y] = 0;
            }
            GeneratedGrid = Generator.calculateNeigbours(GeneratedGrid,WIDTH,HEIGHT);
            setGrid(context,GeneratedGrid);
            //getCellAt(x,y).invalidate();


        }
    }

    private boolean checkEnd(){
        int bombNotFound = BOMBS;
        int notRevealed = WIDTH * HEIGHT;
        for ( int x = 0 ; x < WIDTH ; x++ ){
            for( int y = 0 ; y < HEIGHT ; y++ ){
                if( getCellAt(x,y).isRevealed() || getCellAt(x,y).isFlagged() ){
                    notRevealed--;
                }

                if( getCellAt(x,y).isFlagged() && getCellAt(x,y).isBomb() ){
                    bombNotFound--;
                }
            }
        }

        if( bombNotFound == 0 && notRevealed == 0 ){
            Toast.makeText(context,"Game won", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public void flag( int x , int y ){
        boolean isFlagged = getCellAt(x,y).isFlagged();
        getCellAt(x,y).setFlagged(!isFlagged);
        getCellAt(x,y).invalidate();
    }

    private void onGameLost(){
        // handle lost game
        Toast.makeText(context,"Game lost", Toast.LENGTH_SHORT).show();

        for ( int x = 0 ; x < WIDTH ; x++ ) {
            for (int y = 0; y < HEIGHT; y++) {
                getCellAt(x,y).setRevealed();
            }
        }
    }

    public void clearBoard() {
        GeneratedGrid = Generator.generateEmpty(WIDTH, HEIGHT);
        PrintGrid.print(GeneratedGrid,WIDTH,HEIGHT);
        setGrid(context,GeneratedGrid);
    }
}
