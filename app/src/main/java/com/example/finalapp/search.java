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
import android.view.inputmethod.InputMethodManager;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class search extends AppCompatActivity {
    EditText words;
    searchListView listview;
    TextView clear,history;
    SimpleCursorAdapter adapter;
    Cursor cursor;
    searchDBManager m;
    private static String TAG="searchhhh";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        words=findViewById(R.id.words);
        listview=findViewById(R.id.listView);
        clear=findViewById(R.id.clear);
        history=findViewById(R.id.history);
        m=new searchDBManager(this);
        cursor=m.getRecord();
        adapter=new SimpleCursorAdapter(this,R.layout.listitem,cursor,new String[]{"words"},new int[]{R.id.item}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listview.setAdapter(adapter);
        words.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==KeyEvent.KEYCODE_ENTER && event.getAction()==KeyEvent.ACTION_DOWN){
                    ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                    m.addRecord(words.getText().toString().trim());
                }
                return false;
            }
        });
        words.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if(words.getText().toString().equals("")){
                    history.setText("History");
                    clear.setVisibility(View.VISIBLE);
                    cursor=m.getRecord();
                }else {
                    history.setText("Result");
                    clear.setVisibility(View.GONE);
                    cursor=m.findRecord(words.getText().toString());
                }
                adapter.notifyDataSetChanged();
                adapter.swapCursor(cursor);
            }
        });
    }
    public void click(View view){
        if(view.getId()==R.id.search){

        }
        if(view.getId()==R.id.clear){
            m.clearRecord();
            Log.i(TAG,"clear finished!");
        }
    }


}
