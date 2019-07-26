package com.anamgajith.order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {
    TextView total;
    Button order;
    Button payment;

    TextView coffe;
    TextView mocha;
    TextView java;
    TextView caramel;
    TextView cjc;

    int coffe_q;
    int mocha_q;
    int java_q;
    int caramel_q;
    int cjc_q;

    float sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coffe = findViewById(R.id.coffe_qnt);
        mocha = findViewById(R.id.mocha_qnt);
        java = findViewById(R.id.java_qnt);
        caramel = findViewById(R.id.caramell_qnt);
        cjc = findViewById(R.id.cjc_qnt);
        order = findViewById(R.id.order_btn);
        total = findViewById(R.id.total_amount);
        payment = findViewById(R.id.pay_btn);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum = ((coffe_q*250)+(mocha_q*295)+(java_q*290)+(caramel_q*290)+(cjc_q*325));

                if(sum != 0){
                    total.setText(String.format("\u20B9 %.2f",sum));
                    show_order();
                }
                else {
                    total.setText("");
                    show_err();
                }
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sum == 0){
                    show_err();
                }
                else {
                    Toasty.success(getApplicationContext(),"THANK YOU",Toast.LENGTH_SHORT).show();
                    sum = coffe_q = mocha_q = java_q = caramel_q = cjc_q = 0;
                    coffe.setText(""+coffe_q);
                    java.setText(""+java_q);
                    mocha.setText(""+mocha_q);
                    caramel.setText(""+caramel_q);
                    cjc.setText(""+cjc_q);
                    total.setText("");
                }
            }
        });
    }

    void decrease(View view){
        switch (view.getId()){
            case R.id.coffe_decrease:
                if(coffe_q == 0) break;
                coffe_q--;
                coffe.setText(""+coffe_q);
                break;
            case R.id.java_decrease:
                if(java_q == 0) break;
                java_q--;
                java.setText(""+java_q);
                break;
            case R.id.mocha_decrease:
                if(mocha_q == 0) break;
                mocha_q--;
                mocha.setText(""+mocha_q);
                break;
            case R.id.caramel_decrease:
                if(caramel_q == 0) break;
                caramel_q--;
                caramel.setText(""+caramel_q);
                break;
            case R.id.cjc_decrease:
                if(cjc_q == 0) break;
                cjc_q--;
                cjc.setText(""+cjc_q);
                break;
        }
    }

    void increase(View view){
        switch (view.getId()){
            case R.id.coffe_increase:
                coffe_q++;
                coffe.setText(""+coffe_q);
                break;
            case R.id.java_increase:
                java_q++;
                java.setText(""+java_q);
                break;
            case R.id.mocha_increase:
                mocha_q++;
                mocha.setText(""+mocha_q);
                break;
            case R.id.caramel_increase:
                caramel_q++;
                caramel.setText(""+caramel_q);
                break;
            case R.id.cjc_increase:
                cjc_q++;
                cjc.setText(""+cjc_q);
                break;
        }
    }

    void show_order(){
        LayoutInflater inflater = getLayoutInflater();
        View pay = inflater.inflate(R.layout.payment_layout,(ViewGroup) findViewById(R.id.pay_root));

        Toast pay_toast = new Toast(getApplicationContext());
        pay_toast.setView(pay);
        pay_toast.setDuration(Toast.LENGTH_SHORT);
        pay_toast.setGravity(Gravity.BOTTOM,0,0);
        pay_toast.show();
    }

    void show_err(){
        Toasty.error(getApplicationContext(),"PROVIDE QUANTITY",Toast.LENGTH_SHORT).show();
    }
}
