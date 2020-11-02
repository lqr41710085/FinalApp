package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;

import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class search extends AppCompatActivity{
    EditText words;
    ListView listview;
    TextView clear,history;
    SimpleAdapter adapter;
    Cursor cursor;
    searchDBManager m_search;
    DBmanager m_db;
    ArrayList<HashMap<String,String>> listitem;
    private static String TAG="searchhhh";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        words = findViewById(R.id.words);//搜索框内容
        listview = findViewById(R.id.listView);
        clear = findViewById(R.id.clear);
        history = findViewById(R.id.history);
        m_search = new searchDBManager(this);
        m_db = new DBmanager(this);
        cursor = m_search.getRecord();
        Log.i(TAG,"cursor ok::");
        changeAdapter(cursor);
        Log.i(TAG, "adapter  ok");
        words.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    if (!m_search.findRecord(words.getText().toString().trim()).moveToNext()) {
                        m_search.addRecord(words.getText().toString().trim());
                        Log.i(TAG,"add ok");
                    }
                }
                return false;
            }
        });
        words.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (words.getText().toString().equals("")) {
                    history.setText("History");

                    cursor = m_search.getRecord();//历史
                } else {
                    history.setText("Result");
                    //结果
                    cursor = m_db.findRecord(words.getText().toString());
                }
                //修改adapter
                changeAdapter(cursor);
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //显示记录

                    //插入serach_db
                    if(!m_search.findRecord(words.getText().toString().trim()).moveToNext()) {
                        m_search.addRecord(words.getText().toString().trim());
                        cursor = m_search.getRecord();
                        changeAdapter(cursor);
                    }

            }
        });

    }
    public void click(View view){
        if(view.getId()==R.id.search){
            ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
            cursor = m_db.findRecord(words.getText().toString().trim());
            changeAdapter(cursor);
            m_search.addRecord(words.getText().toString().trim());
            Log.i(TAG,"add ok ");
        }
        if(view.getId()==R.id.clear){
            m_search.clearRecord();
            Log.i(TAG,"clear finished! ");
            cursor = m_search.getRecord();
            changeAdapter(cursor);
        }

    }
    public void changeAdapter(Cursor cursor){
        listitem=new  ArrayList<HashMap<String,String>>();
        while(cursor.moveToNext()){
            HashMap<String,String> map=new HashMap<>();
            map.put("words",cursor.getString(1));
            listitem.add(map);
            Log.i(TAG,"record::"+cursor.getString(1));
        }
        adapter = new SimpleAdapter(search.this, listitem,R.layout.listitem, new String[]{"words"}, new int[]{R.id.item});
        listview.setAdapter(adapter);
        setListViewHeightBasedOnChildren(listview);
    }


        public void setListViewHeightBasedOnChildren(ListView listView) {
//获取ListView对应的Adapter
            ListAdapter adapter = listView.getAdapter();
            if (adapter == null)  return;
            int totalHeight = 0, len = adapter.getCount();
            for (int i = 0; i < len; i++) { //listAdapter.getCount()返回数据项的数目
                View listItem = adapter.getView(i, null, listView);
                listItem.measure(0, 0);//计算子项View 的宽高
                totalHeight += listItem.getMeasuredHeight();//统计所有子项的总高度
            }
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));

 //listView.getDividerHeight()获取子项间分隔符占用的高度

 //params.height最后得到整个ListView完整显示需要的高度
            listView.setLayoutParams(params);

        }

}

