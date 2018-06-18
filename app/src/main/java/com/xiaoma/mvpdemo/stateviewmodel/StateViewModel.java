package com.xiaoma.mvpdemo.stateviewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2018/6/18.
 */

public class StateViewModel {


    public static void bind(final FragmentActivity activity, final Observer observer) {
        try {
            Field[] fields = activity.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(ModelBinding.class)) {
                    field.setAccessible(true);
                    final Object view = field.get(activity);
                    if (view instanceof View) {
                        String value = field.getAnnotation(ModelBinding.class).value();
                        for (final Field f : fields) {
                            if (value.equals(f.getName())) {
                                f.setAccessible(true);
                                final Object obj = f.get(activity);
                                DataViewModel.TViewModel<?> tViewModel = DataViewModel.bindView(activity, Object.class, (View) view);
                                tViewModel.getLiveData().observe(activity, new android.arch.lifecycle.Observer() {
                                    @Override
                                    public void onChanged(@Nullable Object o) {
                                        try {
                                            f.set(activity, o);
                                            observer.onChange(o, (View) view);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }


                                    }
                                });
                            }
                        }
                    } else {
                        throw new IllegalAccessException("must binding on view");
                    }
                }
            }
        } catch (Exception e) {
            Log.e("err", e.getMessage());
        }

    }

    public static MutableLiveData<Object> getView(FragmentActivity activity, View view) {
        return DataViewModel.bindView(activity, Object.class, view).getLiveData();
    }

    public static <T> void setState(FragmentActivity activity, T oldValue, T newValue) {
        if (oldValue instanceof String) {

        }
    }
}
