package com.anamgajith.mltext;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    String resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        button = findViewById(R.id.back_button);
        textView = findViewById(R.id.result_textview);
        resultText = getIntent().getStringExtra(MyTextRec.RESULT_TEXT);
        textView.setText(resultText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
