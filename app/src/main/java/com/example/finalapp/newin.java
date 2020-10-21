package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class newin extends AppCompatActivity {

    private static String TAG="newin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newin);
    }
    public void submit(View v){
        if(v.getId()==R.id.insubmit){
            Intent in=this.getIntent();
            String date=in.getStringExtra("date");//获取日期

            TextView wagetext=findViewById(R.id.wage);
            TextView parttext=findViewById(R.id.parttime);
            TextView packettext=findViewById(R.id.redpacket);
            TextView othertext=findViewById(R.id.otherin);

            Float wage=0.0f,part=0.0f,packet=0.0f,otherin=0.0f;
            if(!wagetext.getText().toString().equals(""))
                    wage=Float.parseFloat(wagetext.getText().toString());
            if(!parttext.getText().toString().equals(""))
                    part=Float.parseFloat(parttext.getText().toString());
            if(!packettext.getText().toString().equals(""))
                    packet=Float.parseFloat(packettext.getText().toString());
            if(!othertext.getText().toString().equals(""))
                    otherin=Float.parseFloat(othertext.getText().toString());//获取数据

            float totalin=wage+part+packet+otherin;//总收入
            Log.i(TAG,"hhhtotalin--"+date+"--"+totalin);
            //写入数据库收入表,日期、工资、兼职、红包、其他、总额


        }
    }
}
