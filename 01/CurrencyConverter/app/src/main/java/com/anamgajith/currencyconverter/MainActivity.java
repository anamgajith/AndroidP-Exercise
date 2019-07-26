package com.anamgajith.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Formatter;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.edittext);
    }

    public void convert(View view){
        double val = 0;
        switch (view.getId()){

            case R.id.usd:
                val = 0.015;
                break;
            case R.id.euro:
                val = 0.013;
                break;
            case R.id.pound:
                val = 0.012;
                break;
            case R.id.yen:
                val = 1.59;
                break;
            case R.id.cand:
                val = 0.019;
                break;
            case R.id.dinar:
                val = 0.0044;
                break;
            case R.id.aud:
                val = 0.021;
                break;
            case R.id.nzd:
                val = 0.022;
                break;
            case R.id.rub:
                val = 0.93;
                break;
        }
        converter(val);
    }

    void converter(double val){
        String input = editText.getText().toString();
        if (TextUtils.isEmpty(input)){
            editText.setError("Enter a value");
            return;
        }
        Double v = Double.parseDouble(input);
        Double o = v*val;
        editText.setText(null);
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        textView.setText(decimalFormat.format(o));
    }
}
