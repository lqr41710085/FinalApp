package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import android.widget.Toast;


import java.util.Calendar;



public class Newbook extends AppCompatActivity {

    private static String TAG="Newbook";
    DatePicker datePicker;
    String date;
    Calendar cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newbook);
        Toast.makeText(this,"please choose date",Toast.LENGTH_LONG).show();
        datePicker=findViewById(R.id.date);
        cal=Calendar.getInstance();
        int y=cal.get(Calendar.YEAR),m=cal.get(Calendar.MONTH)+1,d=cal.get(Calendar.DATE);//初始化为今天日期,月份取值范围为0-11
        date=y+"-"+m+"-"+d;
        datePicker.init(y, m-1, d, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    monthOfYear++;
                    date=year+"-"+monthOfYear+"-"+dayOfMonth;

            }
        });
        Log.i(TAG,"date::"+date);
    }
    public void newbook(View view){

        if(view.getId()==R.id.outbtn) {
            Intent in = new Intent(this, Newout.class);
            in.putExtra("date",date);
            startActivity(in);
        }
        if(view.getId()==R.id.inbtn) {
            Intent in = new Intent(this, Newin.class);
            in.putExtra("date", date);
            startActivity(in);
        }

    }
}
