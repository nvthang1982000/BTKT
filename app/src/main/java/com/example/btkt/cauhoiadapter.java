package com.example.btkt;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class cauhoiadapter extends BaseAdapter {
    Activity context;
    ArrayList<cauhoi> arr;

    public cauhoiadapter(Activity context, ArrayList<cauhoi> arr) {
        this.context = context;
        this.arr = arr;
    }

    @Override
    public int getCount() {
        return arr.size();
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
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.cauhoi,null);
       // TextView socau=(TextView) row.findViewById(R.id.socau);
        TextView txtcauhoi=(TextView) row.findViewById(R.id.hoi);
        TextView txcauhoi=(TextView) row.findViewById(R.id.cauhoi);
        Button btntl1=(Button) row.findViewById(R.id.dapan1);
        Button btntl2=(Button) row.findViewById(R.id.dapan2);
        Button btntl3=(Button) row.findViewById(R.id.dapan3);
        Button btntl4=(Button) row.findViewById(R.id.dapan4);


        cauhoi nv=arr.get(position);
        txcauhoi.setText(nv.cauhoii);
        btntl1.setText(nv.dapan1);
        btntl2.setText(nv.dapan2);
        btntl3.setText(nv.dapan3);
        btntl4.setText(nv.dapan4);
        return row;
    }
}
