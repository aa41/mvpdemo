package com.xiaoma.mvpdemo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2018/5/31.
 */

public class CV extends View {


    public CV(Context context) {
        super(context);
    }

    public CV(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CV(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("c_dispatchTouchEvent", "down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("c_dispatchTouchEvent", "move");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("c_dispatchTouchEvent", "up");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e("c_dispatchTouchEvent", "cancel");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("c_onTouchEvent", "down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("c_onTouchEvent", "move");

                break;
            case MotionEvent.ACTION_UP:
                Log.e("c_onTouchEvent", "up");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e("c_onTouchEvent", "cancel");
                break;
        }
        return true;
    }
}
