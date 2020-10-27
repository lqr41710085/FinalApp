package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Newin extends AppCompatActivity {

    private static String TAG="Newin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newin);
    }
    public void submit(View v){
        if(v.getId()==R.id.insubmit){
            Intent in=this.getIntent();
            String date=in.getStringExtra("date");//获取日期
            String note="";
            TextView wagetext=findViewById(R.id.wage);
            TextView parttext=findViewById(R.id.parttime);
            TextView packettext=findViewById(R.id.redpacket);
            TextView othertext=findViewById(R.id.otherin);
            TextView notetext=findViewById(R.id.notes1);
            Float wage=0.0f,part=0.0f,packet=0.0f,otherin=0.0f;
            if(!wagetext.getText().toString().equals(""))
                    wage=Float.parseFloat(wagetext.getText().toString());
            if(!parttext.getText().toString().equals(""))
                    part=Float.parseFloat(parttext.getText().toString());
            if(!packettext.getText().toString().equals(""))
                    packet=Float.parseFloat(packettext.getText().toString());
            if(!othertext.getText().toString().equals(""))
                    otherin=Float.parseFloat(othertext.getText().toString());//获取数据
            if(!notetext.getText().toString().equals(""))
                     note=notetext.getText().toString();
            float totalin=wage+part+packet+otherin;//总收入
            Log.i(TAG,"hhhtotalin--"+date+"--"+totalin);
            //写入数据库收入表,日期、工资、兼职、红包、其他、总额
            DBmanager m=new DBmanager(Newin.this);
            //String date, String type, String note, float wage, float partime, float packet, float others
            Item item=new Item(date,"in",note,wage,part,packet,otherin);
            m.add(item,"in");
            Log.i(TAG,"hhhsubmit=="+totalin);
            Toast.makeText(Newin.this,"submit successfully! "+date,Toast.LENGTH_LONG);
        }
        this.finish();
    }
}
