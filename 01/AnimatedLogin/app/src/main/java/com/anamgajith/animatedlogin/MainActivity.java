package com.anamgajith.animatedlogin;

import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.root_view);

        AnimationDrawable animation = (AnimationDrawable) layout.getBackground();
        animation.setEnterFadeDuration(2000);
        animation.setExitFadeDuration(3000);
        animation.start();
    }
}
