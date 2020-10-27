package com.example.finalapp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class searchListView extends ListView {
    public searchListView(Context context) {
        super(context);
    }
    public searchListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public searchListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
