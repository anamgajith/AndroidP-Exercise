package com.anamgajith.players;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.VH> {

    ArrayList<playerlist> mList;

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_card,viewGroup,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        playerlist current = mList.get(i);
        vh.textView.setText(current.getName());
        vh.imageView.setImageResource(current.getImageId());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class VH extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public VH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            textView = itemView.findViewById(R.id.textview);
        }
    }

    public PlayerAdapter(ArrayList<playerlist> mList) {
        this.mList = mList;
    }
}
