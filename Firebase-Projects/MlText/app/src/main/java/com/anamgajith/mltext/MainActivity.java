package com.anamgajith.mltext;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;

public class MainActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 22;
    FirebaseVisionImage image;
    FirebaseVisionTextRecognizer recognizer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
    }

    void openCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent,CAMERA_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_REQUEST && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");
            recoganizeText(bitmap);
        }
    }

    private void recoganizeText(Bitmap bitmap) {
        try {
            image = FirebaseVisionImage.fromBitmap(bitmap);
            recognizer = FirebaseVision.getInstance()
                    .getOnDeviceTextRecognizer();
            recognizer.processImage(image).addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
                @Override
                public void onSuccess(FirebaseVisionText firebaseVisionText) {
                    String resultText = firebaseVisionText.getText();
                    if(resultText.isEmpty()){
                        Toast.makeText(MainActivity.this,"No Text Detected",Toast.LENGTH_SHORT).show();
                    }else {
                        Intent next = new Intent(MainActivity.this,ResultActivity.class);
                        next.putExtra(MyTextRec.RESULT_TEXT,resultText);
                        startActivity(next);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
