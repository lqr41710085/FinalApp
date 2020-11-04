package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

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
        if(btn.getId()==R.id.pic){//new a book
            Intent in=new Intent(this,Newbook.class);
            startActivity(in);
        }
        if(btn.getId()==R.id.searchlabel) {//search
            Intent in=new Intent(this,search.class);
            startActivity(in);
        }
        if(btn.getId()==R.id.reportpic){
            Intent in=new Intent(this,report.class);
            startActivity(in);
        }
    }



}
