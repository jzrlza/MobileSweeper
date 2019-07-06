package com.msassist.jbcom.minesweepassist.views.grid;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.BaseAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.msassist.jbcom.minesweepassist.GameEngine;

/**
 * Grid class object to display grid
 * Created 05 July 2019
 */
public class Grid extends GridView{

    public Grid(Context context , AttributeSet attrs){
        super(context,attrs);

        GameEngine.getInstance().createGrid(context);

        setNumColumns(GameEngine.WIDTH);
        setAdapter(new GridAdapter());

    }

    private class GridAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return GameEngine.getInstance().WIDTH * GameEngine.getInstance().HEIGHT;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return GameEngine.getInstance().getCellAt(position);
        }
    }
}
