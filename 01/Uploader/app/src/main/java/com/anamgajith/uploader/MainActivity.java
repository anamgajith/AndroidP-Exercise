package com.anamgajith.uploader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar,progressBarH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        progressBarH = findViewById(R.id.progressBar3);

        progressBar.setVisibility(View.GONE);
    }

    public void start(View view){
        progressBar.setVisibility(View.VISIBLE);
    }
    public void end(View view){
        progressBar.setVisibility(View.GONE);
    }
    public void upload(View view){
        fakeProgress(0);
    }

    void fakeProgress(final int progress){
        progressBarH.setProgress(progress);
        if(progress == 100){
            return;
        }
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fakeProgress(progress+10);
            }
        });
        thread.start();
    }
}
