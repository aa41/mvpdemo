package com.xiaoma.mvpdemo.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by Administrator on 2018/5/31.
 */

public class PV extends FrameLayout {


    public PV(@NonNull Context context) {
        super(context);
    }

    public PV(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PV(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e("p_onInterceptTouchEvent","down");
                return false;
            case MotionEvent.ACTION_MOVE:
                Log.e("p_onInterceptTouchEvent","move");
                return true;
            case MotionEvent.ACTION_UP:
                Log.e("p_onInterceptTouchEvent","up");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e("p_onInterceptTouchEvent","cancel");
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e("p_dispatchTouchEvent","down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("p_dispatchTouchEvent","move");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("p_dispatchTouchEvent","up");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e("p_dispatchTouchEvent","cancel");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e("p_onTouchEvent","down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("p_onTouchEvent","move");
              break;
            case MotionEvent.ACTION_UP:
                Log.e("p_onTouchEvent","up");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e("p_onTouchEvent","cancel");
                break;
        }
        return super.onTouchEvent(event);
    }
}
