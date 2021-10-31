package com.example.mycrudoperations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<UserModel> userModelArrayList;
    public CustomAdapter(Context context, ArrayList<UserModel> userModelArrayList) {
        this.context = context;
        this.userModelArrayList = userModelArrayList;
    }
    @Override
    public int getCount() {
        return userModelArrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return userModelArrayList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lv_item, null, true);
            holder.tvname = (TextView) convertView.findViewById(R.id.name);
           // holder.tvcountry = (TextView) convertView.findViewById(R.id.model);
            convertView.setTag(holder);
        }else {
// the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }
        holder.tvname.setText("List Items: \n"+userModelArrayList.get(position).getName());
        //holder.tvcountry.setText("Model: "+userModelArrayList.get(position).getModel());
        return convertView;
    }private class ViewHolder {
        protected TextView tvname, tvcountry;
    }
}