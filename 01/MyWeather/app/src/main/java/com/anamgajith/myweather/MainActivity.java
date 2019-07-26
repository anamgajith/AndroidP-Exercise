package com.anamgajith.myweather;

import android.media.MediaRouter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    RequestQueue requestQueue;
    EditText editText;
    String url1 = "https://api.openweathermap.org/data/2.5/weather?q=";
    String url2 = "&appid=88a6c5b2aeb7b9885eb375c078a86bbd";
    String url3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
    }

    public void go(View view){

        if(TextUtils.isEmpty(editText.getText().toString())){
            editText.setError("Enter City Name");
            return;
        }
        url3 = editText.getText().toString();
        requestQueue = MySingleton.getInstance(this).getRequestQueue();
        String URL =url1+url3+url2;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    textView.setText("");
                    JSONArray obj = response.getJSONArray("weather");
                    JSONObject current = obj.getJSONObject(0);
                    textView.append(current.getString("main")+"\n");
                    textView.append(current.getString("description"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);
    }
}
