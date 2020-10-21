package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class newbook extends AppCompatActivity {

    private static String TAG="newbook";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newbook);
    }
    public void newbook(View view){
        EditText datetext=findViewById(R.id.date);
        String date;
        if(!datetext.getText().toString().equals(""))
            date=datetext.toString();
        else {
            //设置日期
            Date d=new Date(System.currentTimeMillis());
            SimpleDateFormat format=new SimpleDateFormat(("yyyy/MM/dd"));
            date=format.format(d);
        }

        if(view.getId()==R.id.outbtn){
            Intent in=new Intent(this,newout.class);
            in.putExtra("date",date);
            startActivity(in);
        }
        if(view.getId()==R.id.inbtn){
            Intent in=new Intent(this,newin.class);
            in.putExtra("date",date);
            startActivity(in);
        }

    }
}
