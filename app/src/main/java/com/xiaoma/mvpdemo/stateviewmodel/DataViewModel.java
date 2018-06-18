package com.xiaoma.mvpdemo.stateviewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Administrator on 2018/6/16.
 */

public class DataViewModel {
    private static final String DEFAULT_KEY =
            "android.arch.lifecycle.ViewModelProvider.DefaultKey";

    public static <E> TViewModel<E> create(FragmentActivity activity, Class<E> cls) {
        String clsCanonicalName = cls.getCanonicalName();
        String canonicalName = TViewModel.class.getCanonicalName();
        TViewModel tViewModel = ViewModelProviders.of(activity).get(DEFAULT_KEY + ":" + canonicalName + "_" + clsCanonicalName, TViewModel.class);

        return (TViewModel<E>) tViewModel;
    }

    public static <E> TViewModel<E> create(Fragment fragment, Class<E> cls) {
        String clsCanonicalName = cls.getCanonicalName();
        String canonicalName = TViewModel.class.getCanonicalName();
        TViewModel tViewModel = ViewModelProviders.of(fragment).get(DEFAULT_KEY + ":" + canonicalName + "_" + clsCanonicalName, TViewModel.class);
        tViewModel.getLiveData().observe(fragment, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {

            }
        });
        return (TViewModel<E>) tViewModel;
    }

    public static <E> TViewModel<E> bindView(FragmentActivity activity, Class<E> cls, View view) {
        String clsCanonicalName = cls.getCanonicalName();
        String canonicalName = TViewModel.class.getCanonicalName();
        int id = view.getId();
        TViewModel tViewModel = ViewModelProviders.of(activity).get(DEFAULT_KEY + ":" + canonicalName + "_" + clsCanonicalName + "_" + id, TViewModel.class);

        return (TViewModel<E>) tViewModel;
    }

    public static <E> TViewModel<E> bindView(Fragment fragment, Class<E> cls, View view) {
        String clsCanonicalName = cls.getCanonicalName();
        String canonicalName = TViewModel.class.getCanonicalName();
        int id = view.getId();

        TViewModel tViewModel = ViewModelProviders.of(fragment).get(DEFAULT_KEY + ":" + canonicalName + "_" + clsCanonicalName + "_" + id, TViewModel.class);

        return (TViewModel<E>) tViewModel;
    }



    public static class TViewModel<T> extends ViewModel {
        private MutableLiveData<T> liveData = new MutableLiveData<>();


        public TViewModel() {
        }

        public void setValue(T t) {
            liveData.setValue(t);
        }

        public void postValue(T t) {
            liveData.postValue(t);
        }


        public MutableLiveData<T> getLiveData() {
            return liveData;
        }


    }

}
