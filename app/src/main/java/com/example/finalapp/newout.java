package com.example.finalapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class newout extends AppCompatActivity {
    private static String TAG="newout";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newout);

    }

    public void outclick(View view){
        Intent in=this.getIntent();
        String date=in.getStringExtra("date");
        float food=0f,entertain=0f,traffic=0f,house=0f,study=0f,clothes=0f,tour=0f,medical=0f,others=0f;
        if(view.getId()==R.id.outsubmit){
            float all=food+entertain+traffic+house+study+clothes+tour+medical+others;
            //写入数据库

        }else{
            //显示输入框，获取输入值


            switch (view.getId()){//输入值赋值
                case R.id.foodbtn:
                    break;
                case R.id.entertainbtn:
                    break;
                case R.id.trafficbtn:
                    break;
                case R.id.housebtn:
                    break;
                case  R.id.studybtn:
                    break;
                case R.id.clothesbtn:
                    break;
                case R.id.tourbtn:
                    break;
                case R.id.medicalbtn:
                    break;
                case R.id.otheroutbtn:
                    break;
                    default:

            }
        }

    }
}
