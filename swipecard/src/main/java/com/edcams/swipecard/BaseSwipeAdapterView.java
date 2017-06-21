package com.edcams.swipecard;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Adapter;
import android.widget.AdapterView;

/**
 * Created by hp on 6/20/2017.
 */

abstract class BaseSwipeAdapterView extends AdapterView{

    private int heightMeasureSpec;
    private int widthMeasureSpec;

    public BaseSwipeAdapterView(Context context){
        super(context);
    }

    public BaseSwipeAdapterView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public BaseSwipeAdapterView(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        this.widthMeasureSpec = widthSpec;
        this.heightMeasureSpec = heightSpec;
    }

    @Override
    public void setSelection(int i) {
        throw new UnsupportedOperationException("Not supported");
    }

    public int getWidthMeasureSpec() {
        return widthMeasureSpec;
    }

    public int getHeightMeasureSpec() {
        return heightMeasureSpec;
    }
}
