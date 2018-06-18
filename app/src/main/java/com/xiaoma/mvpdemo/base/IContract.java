package com.xiaoma.mvpdemo.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;

import org.jetbrains.annotations.NotNull;


/**
 * Created by Administrator on 2018/5/30.
 */

public interface IContract {

    interface IView {

    }

    interface IViewModel<T,E extends BaseContract.BaseView> {
        void onChanged(E view,T t);
    }


    interface IPresenter<T extends IView> extends LifecycleObserver {

        void attachView(T iView);

        void attachContext(Context context);



        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        void onCreate(LifecycleOwner owner);

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        void onStart(LifecycleOwner owner);

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        void onResume(LifecycleOwner owner);

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        void onPause(LifecycleOwner owner);

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        void onStop(LifecycleOwner owner);

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        void onDestroy(LifecycleOwner owner);

        @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
        void onLifecycleChanged(@NotNull LifecycleOwner owner, @NotNull Lifecycle.Event event);


    }

}
