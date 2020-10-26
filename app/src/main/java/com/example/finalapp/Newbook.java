package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Newbook extends AppCompatActivity {

    private static String TAG="Newbook";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newbook);
    }
    public void newbook(View view){
        EditText datetext=findViewById(R.id.date);
        String date;
        if(!datetext.getText().toString().equals(""))
            date=datetext.getText().toString();
        else {
            //设置日期
            Date d=new Date(System.currentTimeMillis());
            SimpleDateFormat format=new SimpleDateFormat(("yyyy/MM/dd"));
            date=format.format(d);
        }

        if(view.getId()==R.id.outbtn){
            Intent in=new Intent(this, Newout.class);
            in.putExtra("date",date);
            startActivity(in);
        }
        if(view.getId()==R.id.inbtn){
            Intent in=new Intent(this, Newin.class);
            in.putExtra("date",date);
            startActivity(in);
        }

    }
}
