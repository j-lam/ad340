package com.jenniferlam.jlam;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by jennifer on 4/26/2017.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context mContext;
    private String[] name;
    public GridViewAdapter(Context c, String[] name){
        mContext = c;
        this.name = name;
    }
    @Override
    public int getCount() {
        return name.length;
    }
    @Override
    public Object getItem(int position){
        return null;
    }
    @Override
    public long getItemId(int position){
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
      View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_layout, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            textView.setText(name[position]);
        }
        else{
            grid = (View) convertView;
        }

        return grid;
    }

    };


