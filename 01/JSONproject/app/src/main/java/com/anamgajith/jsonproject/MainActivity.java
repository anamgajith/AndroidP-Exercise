package com.anamgajith.jsonproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Course course = new Course("Java","Bootcamp");
        Student student = new Student(2,"arjun@gmail.com","Arjun",course);
        Gson gson = new Gson();
        String json = gson.toJson(student);
        Log.d("Test",json.toString());
    }
}
