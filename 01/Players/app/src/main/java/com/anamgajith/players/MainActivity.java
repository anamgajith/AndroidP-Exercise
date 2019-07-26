package com.anamgajith.players;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<playerlist> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();
        arrayList.add(new playerlist(R.drawable.msd,"M S Dhoni"));
        arrayList.add(new playerlist(R.drawable.rohit,"Rohit Sharma"));
        arrayList.add(new playerlist(R.drawable.virat,"Virat Kohli"));
        arrayList.add(new playerlist(R.drawable.rahul,"Kl Rahul"));
        arrayList.add(new playerlist(R.drawable.dk,"Dhinesh Karthik"));

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new PlayerAdapter(arrayList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
