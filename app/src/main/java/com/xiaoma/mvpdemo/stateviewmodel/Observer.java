package com.xiaoma.mvpdemo.stateviewmodel;

import android.view.View;

/**
 * Created by Administrator on 2018/6/18.
 */

public interface Observer {
    void onChange(Object o, View view);
}
