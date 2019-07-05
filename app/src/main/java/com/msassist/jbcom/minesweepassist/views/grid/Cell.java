package com.msassist.jbcom.minesweepassist.views.grid;

import android.content.Context;
import android.util.Log;
import android.graphics.Canvas;
import android.support.v4.content.ContextCompat;

import android.graphics.drawable.Drawable;

import com.msassist.jbcom.minesweepassist.GameEngine;
import com.msassist.jbcom.minesweepassist.R;

public class Cell extends BaseCell{

    public Cell( Context context , int x , int y ){
        super(context);

        setPosition(x,y);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("Minesweeper" , "Cell::onDraw");
        drawButton(canvas);


    }

    private void drawButton(Canvas canvas ){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.button);
        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }

}
