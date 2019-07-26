package com.anamgajith.myintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edittext);
    }

    public void next(View view){
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        String value = editText.getText().toString();
        if(TextUtils.isEmpty(value)){
            editText.setError("Enter Something");
            return;
        }
        intent.putExtra("name",value);
        startActivity(intent);
    }
}
