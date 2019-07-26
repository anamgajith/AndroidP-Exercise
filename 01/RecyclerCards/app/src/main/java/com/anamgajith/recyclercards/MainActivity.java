package com.anamgajith.recyclercards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<listItem> arrayList;
    Button addButton,removeButton;
    EditText add,remove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generatefakedata();
        recyclerViewconfig();
        grabresources();
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(add.getText().toString());
                addItem(position);
            }
        });
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(add.getText().toString());
                removeItem(position);
            }
        });
    }

    private void removeItem(int position) {
        arrayList.remove(position);
        adapter.notifyItemRemoved(position);
    }

    private void addItem(int position) {
        arrayList.add(position,new listItem(R.drawable.oner,"Image Added"));
        adapter.notifyItemInserted(position);
    }

    private void grabresources() {
        addButton = findViewById(R.id.buttonadd);
        removeButton = findViewById(R.id.buttondelete);
        add = findViewById(R.id.edittextadd);
        remove = findViewById(R.id.edittextdelete);
    }

    private void recyclerViewconfig() {
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        adapter = new MyAdapter(arrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void generatefakedata() {
        arrayList = new ArrayList<>();

        arrayList.add(new listItem(R.drawable.node,"Clicked at Studio"));
        arrayList.add(new listItem(R.drawable.oner,"Clicked at Rome"));
        arrayList.add(new listItem(R.drawable.twor,"Clicked at Italy"));
        arrayList.add(new listItem(R.drawable.threer,"Clicked at South Africa"));
        arrayList.add(new listItem(R.drawable.fourr,"Clicked at India"));
        arrayList.add(new listItem(R.drawable.fiver,"Clicked at Australia"));
        arrayList.add(new listItem(R.drawable.sixr,"Clicked at UK"));
    }
}