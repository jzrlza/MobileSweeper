package com.msassist.jbcom.minesweepassist;

import android.content.Context;
import android.util.Log;
import com.msassist.jbcom.minesweepassist.util.Generator;
import com.msassist.jbcom.minesweepassist.util.PrintGrid;

/**
 *
 * Created 05 July 2019
 */
public class GameEngine {

    private static GameEngine instance;

    private Context context;
    private static final int BOMBS = 20;
    private static final int WIDTH = 8;
    private static final int HEIGHT = 8;

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
    }
}
