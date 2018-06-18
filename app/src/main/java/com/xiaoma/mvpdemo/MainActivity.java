package com.xiaoma.mvpdemo;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.xiaoma.mvpdemo.base.BaseActivity;
import com.xiaoma.mvpdemo.stateviewmodel.ModelBinding;
import com.xiaoma.mvpdemo.stateviewmodel.StateViewModel;
import com.xiaoma.mvpdemo.view.CV;
import com.xiaoma.mvpdemo.view.PV;

public class MainActivity extends BaseActivity<MainContract.MainPresenter> implements MainContract.MainView {

    private String ppp;

    private String ccc;

    @ModelBinding(value = "ccc")
    private EditText cv;
    @ModelBinding(value = "ppp")
    private EditText pv;
    private Button bt;

    private boolean isCv = false;
    private int times = 0;

    @Override
    protected void onCreate_(Bundle savedInstanceState) {
        cv = (EditText) findViewById(R.id.cv);
        pv = (EditText) findViewById(R.id.pv);
        bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                times++;
                if (isCv) {
                    getViewModel(cv).setValue("test" + times);
                    showToast(ccc);
                } else {
                    getViewModel(pv).setValue("test" + times);
                    showToast(ppp);
                }
                isCv = !isCv;
            }
        });
        StateViewModel.bind(this, new com.xiaoma.mvpdemo.stateviewmodel.Observer() {
            @Override
            public void onChange(Object o, View view) {
                switch (view.getId()) {
                    case R.id.cv:
                        cv.setText((CharSequence) o);
                        break;
                    case R.id.pv:
                        pv.setText((CharSequence) o);
                        break;
                }
            }
        });
    }

    @Override
    public MainContract.MainPresenter getPresenter() {
        return new MainContract.MainPresenter();
    }

    @Override
    public MainContract.MainView getView() {
        return this;
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void showLoginStatus() {
        showToast("login suc!");
    }
}
