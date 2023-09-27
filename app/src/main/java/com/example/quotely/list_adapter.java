package com.example.quotely;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class list_adapter extends ArrayAdapter<menu> {
    private Context mContext;

    private int Resource;
    public list_adapter(@NonNull Context context, int resource, @NonNull ArrayList<menu> objects) {
        super(context, resource, objects);

        this.mContext = context;
        this.Resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(Resource,parent,false);
        ImageView imageView = convertView.findViewById(R.id.imageView14);
        TextView txtName = convertView.findViewById(R.id.textView6);
        imageView.setImageResource(getItem(position).getImage());
        txtName.setText(getItem(position).getName());

        return convertView;
    }
}
