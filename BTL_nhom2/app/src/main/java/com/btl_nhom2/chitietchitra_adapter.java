package com.btl_nhom2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class chitietchitra_adapter extends ArrayAdapter {
    Activity context = null;
    ArrayList<user_detail> myArray = null;
    int resource;

    public chitietchitra_adapter(Activity context, int resource, ArrayList<user_detail> myArray) {
        super(context, resource, myArray);
        this.context = context;
        this.resource = resource;
        this.myArray = myArray;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(resource, null);
        if (myArray.size() > 0 && position >= 0) {
            final TextView txtTuThang, txtDenThang, txtMucDongBHXH;
            txtTuThang = convertView.findViewById(R.id.txtTuThang);
            txtDenThang = convertView.findViewById(R.id.txtDenThang);
            txtMucDongBHXH = convertView.findViewById(R.id.txtMucDongBHXH);

            final user_detail us = myArray.get(position);

            txtTuThang.setText(us.getTuthang());
            txtDenThang.setText(us.getDenthang());
            txtMucDongBHXH.setText("Chưa tính");
        }
        return convertView;
    }
}