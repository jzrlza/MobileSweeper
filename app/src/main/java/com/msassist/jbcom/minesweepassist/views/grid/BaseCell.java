package com.msassist.jbcom.minesweepassist.views.grid;

import android.content.Context;
import android.view.View;

import com.msassist.jbcom.minesweepassist.GameEngine;

/**
 * Base class of each cell
 * Created 05 July 2019
 */
public abstract class BaseCell extends View {

    private int value;
    private boolean isBomb;
    private boolean isRevealed = true;
    private boolean isClicked;
    private boolean isFlagged;

    private int x , y;
    private int position;

    public BaseCell(Context context ){
        super(context);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        isBomb = false;
        isRevealed = false;
        isClicked = false;
        isFlagged = false;

        if( value == -1 ){
            isBomb = true;
        }

        this.value = value;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public int getXPos() {
        return x;
    }

    public int getYPos() {
        return y;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition( int x , int y ){
        this.x = x;
        this.y = y;

        this.position = y * GameEngine.WIDTH + x;

        invalidate();
    }

}