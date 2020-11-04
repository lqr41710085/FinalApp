package com.example.finalapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class report extends AppCompatActivity {

    TextView balancet;
    TextView allint,alloutt;
    DBmanager m;
    String TAG="reporthhh";
    DatePicker d;
    String date;
    Calendar cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        d=findViewById(R.id.ym);
        Locale l=getResources().getConfiguration().locale;
        String language=l.getLanguage();
        if(language.endsWith("en"))
            ((ViewGroup)((ViewGroup)d.getChildAt(0)).getChildAt(0)).getChildAt(1).setVisibility(View.GONE);
        else    //检测中英文
            ((ViewGroup)((ViewGroup)d.getChildAt(0)).getChildAt(0)).getChildAt(2).setVisibility(View.GONE);
        cal= Calendar.getInstance();
        int y=cal.get(Calendar.YEAR),m=cal.get(Calendar.MONTH)+1;//初始化为今天日期,月份取值范围为0-11
        date=y+"-"+m;
        Date dd=new Date();
        d.setMaxDate(dd.getTime());
        d.init(y, m,0, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear++;
                date=year+"-"+monthOfYear;

            }
        });
        Toast.makeText(this,"please choose year and month",Toast.LENGTH_LONG).show();
    }
    public void onclick(View v){


            if(v.getId()==R.id.reportbtn){
                m=new DBmanager(this);
                balancet=findViewById(R.id.m_balance);
                allint=findViewById(R.id.m_in);
                alloutt=findViewById(R.id.m_out);
                Log.i(TAG,"date::"+date);
                Cursor cursor= m.findDetails(date);
                float balance=0,allin=0,allout=0;
                while (cursor.moveToNext()){
                    Log.i(TAG,"cursor ok");
                    balance+=cursor.getFloat(15);
                    allin+=cursor.getFloat(14)+cursor.getFloat(13)+cursor.getFloat(12)+cursor.getFloat(11);
                    allout+=cursor.getFloat(10)+cursor.getFloat(9)+cursor.getFloat(8)+cursor.getFloat(7)+
                            cursor.getFloat(6)+cursor.getFloat(5)+cursor.getFloat(4)+cursor.getFloat(3);
                }
                balancet.setText(String.valueOf(balance));
                allint.setText(String.valueOf(allin));
                alloutt.setText(String.valueOf(allout));
                if(balance<0){
                    balancet.setTextColor(Color.parseColor("#F44336"));
                }


            if(v.getId()==R.id.detail){
                Intent in=new Intent(this,search.class);
                startActivity(in);
            }
        }
    }
}
