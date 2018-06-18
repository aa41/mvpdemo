package com.xiaoma.mvpdemo.base;

import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.xiaoma.mvpdemo.stateviewmodel.StateViewModel;

/**
 * Created by Administrator on 2018/5/30.
 */

public abstract class BaseActivity<P extends BaseContract.BasePresenter> extends AppCompatActivity implements BaseContract.BaseView {


    protected P presenter;
    protected BaseContract.BaseView mView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        presenter = getPresenter();
        mView = getView();
        presenter.attachView(mView);
        presenter.attachContext(this);
        getLifecycle().addObserver(presenter);
        onCreate_(savedInstanceState);

    }

    public abstract P getPresenter();

    public abstract BaseContract.BaseView getView();

    public abstract @LayoutRes
    int getLayoutId();

    protected abstract void onCreate_(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
    }

    public MutableLiveData<Object> getViewModel(View view) {
        return StateViewModel.getView(this, view);
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissProgressDialog() {

    }
}
