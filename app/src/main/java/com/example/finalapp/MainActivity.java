package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onclick(View btn){
        if(btn.getId()==R.id.about){ //about
            Intent in=new Intent(this,About.class);
            startActivity(in);
        }
        else if(btn.getId()==R.id.pic){//new a book
            Intent in=new Intent(this,newbook.class);
            startActivity(in);
        }
        else {//search

        }
    }
}
