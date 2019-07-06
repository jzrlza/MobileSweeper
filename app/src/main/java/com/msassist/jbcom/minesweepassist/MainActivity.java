package com.msassist.jbcom.minesweepassist;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Main Activity
 * Created 05 July 2019
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("MainActivity","onCreate");
        GameEngine.getInstance().createGrid(this);
    }

    public void clearClick(View v) {
        GameEngine.getInstance().clearBoard();
    }
}
