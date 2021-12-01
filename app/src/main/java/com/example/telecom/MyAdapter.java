package com.example.telecom;

import static android.media.CamcorderProfile.get;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<MainActivity.Contact> contacts;

    MyAdapter(ArrayList<MainActivity.Contact> data) {
        contacts = data;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_name;
        private TextView tv_phone;
        private ImageView img_delete;

        ViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_phone = (TextView) itemView.findViewById(R.id.tv_phone);
            img_delete = (ImageView) itemView.findViewById(R.id.img_delete);
        }
    }
    //建立 ViewHolder 與 Layout 並連結彼此
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.adapter_row, parent, false);
        return new ViewHolder(view);
    }
    //回傳資料數量
    @Override
    public int getItemCount() {
        return contacts.size();
    }

    //將資料指派給元件呈現
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_name.setText( (CharSequence) contacts.get(position));
        holder.tv_phone.setText( (CharSequence) contacts.get(position));

        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //移除聯絡人
                contacts.remove(position);
                //更新列表資料
                notifyDataSetChanged();
            }
        });
    }
}