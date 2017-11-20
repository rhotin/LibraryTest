package com.roman.librarytest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by roman on 11/5/2015.
 */
public class LibraryAdapter extends BaseAdapter {

    ArrayList<LibraryObject> list;
    Context context;

    LibraryAdapter(Context c, ArrayList<LibraryObject> librraryObjects){
        this.context = c;
        this.list = librraryObjects;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_lib_row, parent, false);

        TextView libName = (TextView) row.findViewById(R.id.libTextView);

        LibraryObject theLibObject = list.get(position);
        libName.setText(theLibObject.name);

        return row;
    }
}
