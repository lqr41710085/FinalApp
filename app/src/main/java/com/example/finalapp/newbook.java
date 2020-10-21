package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class newbook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newbook);
    }
    public void newbook(View view){
        EditText datetext=findViewById(R.id.date);
        String date=datetext.toString();
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
