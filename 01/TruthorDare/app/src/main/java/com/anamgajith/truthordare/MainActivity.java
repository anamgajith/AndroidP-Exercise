package com.anamgajith.truthordare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    Button button;
    int lastDirection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.bottle);
        button = findViewById(R.id.spin_button);
    }

    void spin(View view){
        Random random = new Random();
        int newDirection = random.nextInt(3600)+360+lastDirection;
        float pivotx = image.getWidth()/2;
        float pivoty = image.getHeight()/2;
        Animation rotate = new RotateAnimation(lastDirection,newDirection,pivotx,pivoty);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(rotate);
        lastDirection = newDirection;
    }
}
