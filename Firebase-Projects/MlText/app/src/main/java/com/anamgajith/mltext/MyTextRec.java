package com.anamgajith.mltext;

import android.app.Application;

import com.google.firebase.FirebaseApp;

public class MyTextRec extends Application {
    public static String RESULT_TEXT = "RESULT_TEXT";

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }
}
