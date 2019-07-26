package com.anamgajith.examtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    TextView mtext,mtime,mstat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this,R.raw.sixth);
        mtext = findViewById(R.id.textView);
        mtime = findViewById(R.id.textView2);
        mstat = findViewById(R.id.textView3);

        new CountDownTimer(10000,1000){
            public void onTick(long millisUntilFinished){
                    if((millisUntilFinished/1000) == 1){
                        mtime.setText(""+(millisUntilFinished/1000)+" Second");
                    }else {
                        mtime.setText("" + (millisUntilFinished / 1000) + " Seconds");
                    }
            }
            public void onFinish(){
                    mtime.setText("0");
                    mstat.setText("You are done");
                    mp.start();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
            }
        }.start();
    }
}
