package com.msassist.jbcom.minesweepassist.views.grid;

import android.content.Context;

public class Cell extends BaseCell{

    public Cell( Context context , int x , int y ){
        super(context);

        setPosition(x,y);

    }

}
