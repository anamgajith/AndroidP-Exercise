package com.anamgajith.musicplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    SeekBar vol,prog;
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    Handler handler = new Handler();
    Runnable seekUpdate = new Runnable() {
        @Override
        public void run() {
            prog.setProgress(mediaPlayer.getCurrentPosition());
            handler.postDelayed(this,50);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.testaudio);
        vol = findViewById(R.id.seekBar);
        prog = findViewById(R.id.timeline);
        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        vol.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        vol.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));

        prog.setMax(mediaPlayer.getDuration());

        prog.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        vol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                prog.setProgress(0);
            }
        });


    }

    public void playMe (View view){
        mediaPlayer.start();
        handler.postDelayed(seekUpdate,0);
    }

    public void pauseMe (View view){
        mediaPlayer.pause();
        handler.removeCallbacks(seekUpdate);
    }

}
