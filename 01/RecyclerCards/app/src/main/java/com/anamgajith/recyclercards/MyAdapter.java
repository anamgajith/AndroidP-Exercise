package com.anamgajith.recyclercards;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterHolder> {
    ArrayList<listItem> mList;

    public MyAdapter(ArrayList<listItem> mList) {
        this.mList = mList;
    }

    public class MyAdapterHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView textView;
        public MyAdapterHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    @NonNull
    @Override
    public MyAdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_card,viewGroup,false);
        MyAdapterHolder myAdapterHolder = new MyAdapterHolder(view);
        return myAdapterHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterHolder myAdapterHolder, int i) {
        listItem current = mList.get(i);
        myAdapterHolder.imageView.setImageResource(current.getmImageId());
        myAdapterHolder.textView.setText(current.getmText());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

}
