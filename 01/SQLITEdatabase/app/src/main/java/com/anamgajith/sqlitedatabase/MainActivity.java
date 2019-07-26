package com.anamgajith.sqlitedatabase;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    databaseHelp db;
    Button addData,view,update,delete,viewAll;
    EditText id,name,email,cc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grabItems();
        adddata();
        getdata();
        viewall();
        updatE();
        dElete();
    }

    private void dElete() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(id.getText().toString())){
                    id.setError("Enter Id");
                    return;
                }
                if(db.deleteData(id.getText().toString()) > 0){
                    Toast.makeText(MainActivity.this,"Deleted Successfully",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"Oops",Toast.LENGTH_SHORT).show();
                }
                clearAll();
            }
        });
    }

    private void updatE() {
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(id.getText().toString())){
                    id.setError("Enter Id");
                    return;
                }
                if(db.updateData(id.getText().toString(),name.getText().toString(),email.getText().toString(),cc.getText().toString())){
                    Toast.makeText(MainActivity.this,"Updated Successfully",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Oops",Toast.LENGTH_SHORT).show();
                }
                clearAll();
            }
        });
    }

    private void viewall() {
        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = db.getAll();
                if(cursor.getCount() == 0){
                    showAlert("Error","No item found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();

                while (cursor.moveToNext()){
                    buffer.append("ID : "+cursor.getString(0)+"\n");
                    buffer.append("NAME : "+cursor.getString(1)+"\n");
                    buffer.append("EMAIL : "+cursor.getString(2)+"\n");
                    buffer.append("COURSE COUNT : "+cursor.getString(3)+"\n\n");
                }
                showAlert("All datas",buffer.toString());
                clearAll();
            }
        });
    }

    private void getdata() {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(id.getText().toString())){
                    id.setError("Enter Id");
                    return;
                }
                Cursor cursor = db.readData(id.getText().toString());
                if(cursor.getCount() == 0){
                    showAlert("Error","No item found");
                    return;
                }
                if(cursor.moveToNext()){
                    String data = null;
                    data = "ID : "+cursor.getString(0)+"\nName : "+
                            cursor.getString(1)+"\nEmail : "+
                            cursor.getString(2)+"\nCourse Count : "+
                            cursor.getString(3);
                    showAlert("Datas",data);
                }
                clearAll();
            }
        });
    }

    private void adddata() {
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.insertData(name.getText().toString(),email.getText().toString(),cc.getText().toString())){
                    Toast.makeText(MainActivity.this,"Data added",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"Something Went Wrong",Toast.LENGTH_SHORT).show();
                }
                clearAll();
            }
        });
    }

    private void showAlert(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    private void grabItems() {
        db = new databaseHelp(this);

        addData = findViewById(R.id.button_add);
        view = findViewById(R.id.button_view);
        update = findViewById(R.id.button_update);
        delete = findViewById(R.id.button_delete);
        viewAll = findViewById(R.id.button_viewAll);

        id = findViewById(R.id.editText_id);
        name = findViewById(R.id.editText_name);
        email = findViewById(R.id.editText_email);
        cc= findViewById(R.id.editText_CC);
    }

    public void clearAll(){
        id.setText("");
        name.setText("");
        email.setText("");
        cc.setText("");
    }
}
