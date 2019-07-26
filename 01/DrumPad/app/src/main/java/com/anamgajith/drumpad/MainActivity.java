package com.anamgajith.drumpad;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playS(View view){
        int rd = R.raw.eighth;

        switch (view.getId()){
            case R.id.imageButton1:
                rd = R.raw.one;
                break;
            case R.id.imageButton2:
                rd = R.raw.two;
                break;
            case R.id.imageButton3:
                rd = R.raw.three;
                break;
            case R.id.imageButton4:
                rd = R.raw.four;
                break;
            case R.id.imageButton5:
                rd = R.raw.fv;
                break;
            case R.id.imageButton6:
                rd = R.raw.sixth;
                break;
            case R.id.imageButton7:
                rd = R.raw.seventh;
                break;
            case R.id.imageButton8:
                rd = R.raw.eighth;
                break;
            case R.id.imageButton9:
                rd = R.raw.one;
                break;
            case R.id.imageButton10:
                rd = R.raw.sixth;
                break;
            case R.id.imageButton11:
                rd = R.raw.one;
                break;
            case R.id.imageButton12:
                rd = R.raw.eighth;
                break;
        }

        plays(rd);
    }

    void plays(int rid){
        final MediaPlayer m1 = MediaPlayer.create(this,rid);
        m1.start();
        m1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                m1.release();
            }
        });
    }
}
