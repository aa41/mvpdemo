package com.xiaoma.mvpdemo.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/2.
 */

public class BaseContract implements IContract {

    public interface BaseView extends IView {
        void showToast(String text);

        void showProgressDialog();

        void dismissProgressDialog();

    }

    public static abstract class BaseViewModel<T, E extends BaseView> implements IViewModel<T, E> {

        @Override
        public void onChanged(E view, T t) {

        }
    }


    public static abstract class BasePresenter<T extends BaseView> implements IPresenter<T> {
        protected T mView;
        protected Context mContext;

        @Override
        public void attachView(T iView) {
            this.mView = iView;
        }

        @Override
        public void attachContext(Context context) {
            mContext = context;
        }

        @Override
        public void onCreate(LifecycleOwner owner) {

        }

        @Override
        public void onStart(LifecycleOwner owner) {

        }

        @Override
        public void onResume(LifecycleOwner owner) {

        }

        @Override
        public void onPause(LifecycleOwner owner) {

        }

        @Override
        public void onStop(LifecycleOwner owner) {

        }

        @Override
        public void onDestroy(LifecycleOwner owner) {
            mView = null;
            mContext = null;
        }

        @Override
        public void onLifecycleChanged(@NotNull LifecycleOwner owner, @NotNull Lifecycle.Event event) {

        }
    }


}
