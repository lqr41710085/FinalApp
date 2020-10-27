package com.example.finalapp;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Newout extends AppCompatActivity {
    private static String TAG="Newout";
    float food=0f,entertain=0f,traffic=0f,clothes=0f,house=0f,study=0f,medical=0f,others=0f,all=0.0f;
    String notes="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newout);

    }
    public void outclick(View view){
        Intent in=this.getIntent();
        String date=in.getStringExtra("date");

        if(view.getId()==R.id.outsubmit){
            EditText t1=findViewById(R.id.food);
            EditText t2 = findViewById(R.id.entertain);
            EditText t3=findViewById(R.id.traffic);
            EditText t4=findViewById(R.id.clothes);
            EditText t5=findViewById(R.id.house);
            EditText t6=findViewById(R.id.study);
            EditText t7=findViewById(R.id.medical);
            EditText t8=findViewById(R.id.others);
            EditText t9=findViewById(R.id.notes2);
            if(!t1.getText().toString().equals(""))
                food=Float.parseFloat(t1.getText().toString());
            if(!t2.getText().toString().equals(""))
                entertain=Float.parseFloat(t2.getText().toString());
            if(!t3.getText().toString().equals(""))
                traffic=Float.parseFloat(t3.getText().toString());
            if(!t4.getText().toString().equals(""))
                clothes=Float.parseFloat(t4.getText().toString());
            if(!t5.getText().toString().equals(""))
                house=Float.parseFloat(t5.getText().toString());
            if(!t6.getText().toString().equals(""))
                study=Float.parseFloat(t6.getText().toString());
            if(!t7.getText().toString().equals(""))
                medical =Float.parseFloat(t7.getText().toString());
            if(!t8.getText().toString().equals(""))
                others=Float.parseFloat(t8.getText().toString());
            if(!t9.getText().toString().equals(""))
                notes=t9.getText().toString();
            all=food+entertain+traffic+clothes+house+study+medical+others;
            Log.i(TAG,"hhhhall=="+all+"--"+date+"  "+notes);
            //写入数据库
            DBmanager m=new DBmanager(Newout.this);
           // String date, String type, String note, float food, float entertain, float traffic, float clothes, float house,
            //float study, float medical, float others
            Item item=new Item(date,"out",notes,food,entertain,traffic,clothes,house,study,medical,others);
            m.add(item,"out");
            Log.i(TAG,"hhhsubmit=="+all);
            Toast.makeText(Newout.this,"submit successfully! "+date,Toast.LENGTH_LONG);
        }
        this.finish();
    }

}
