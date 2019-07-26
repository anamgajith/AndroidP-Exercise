package com.anamgajith.diceroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView dice_1;
    ImageView dice_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice_1 = findViewById(R.id.dice1);
        dice_2 = findViewById(R.id.dice2);
    }

    public void roll(ImageView img){
        int num = (int) (Math.random() * 6) + 1;
        switch (num){
            case 1:
                img.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                img.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                img.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                img.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                img.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                img.setImageResource(R.drawable.dice_6);
                break;
        }
    }

    public void roll_dice(View view){
            roll(dice_1);
            roll(dice_2);
    }
}
