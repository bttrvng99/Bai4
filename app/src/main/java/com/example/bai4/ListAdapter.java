package com.example.bai4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Employee> {
    Activity context=null;
    ArrayList<Employee> myArray = null;
    int layoutId;

    public ListAdapter(Activity context, int layoutId, ArrayList<Employee> arr){
        super(context,layoutId,arr);
        this.context = context;
        this.layoutId = layoutId;
        this.myArray = arr;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        view = inflater.inflate(layoutId,null);
        if(myArray.size()>0 && position>=0){
            final TextView txtDisplay = (TextView) view.findViewById(R.id.id_name);
            final Employee emp = myArray.get(position);
            txtDisplay.setText(emp.toString());
            final ImageView img = (ImageView) view.findViewById(R.id.gender_icon);
            if(emp.isGender()) img.setImageResource(R.drawable.female_icon);
            else img.setImageResource(R.drawable.male_icon);
        }
        return view;
    }
}
