package com.xiaoma.mvpdemo;

import android.arch.lifecycle.LifecycleOwner;

import com.xiaoma.mvpdemo.base.BaseContract;

/**
 * Created by Administrator on 2018/5/30.
 */

public class MainContract {

    public interface MainView extends BaseContract.BaseView {

        void showLoginStatus();
    }


    public static class MainPresenter extends BaseContract.BasePresenter<MainView> {

        @Override
        public void onCreate(LifecycleOwner owner) {
            super.onCreate(owner);

        }
    }


}
