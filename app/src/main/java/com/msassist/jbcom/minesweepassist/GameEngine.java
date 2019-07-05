package com.msassist.jbcom.minesweepassist;

import android.content.Context;

/**
 *
 * Created 05 July 2019
 */
public class GameEngine {

    private static GameEngine instance;

    private Context context;

    public static GameEngine getInstance() {
        if (instance == null) {
            instance = new GameEngine();
        }
        return instance;
    }

    private GameEngine() {}

    public void createGrid(Context context) {
        this.context = context;


    }
}
