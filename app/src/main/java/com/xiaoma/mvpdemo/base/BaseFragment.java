package com.xiaoma.mvpdemo.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/6/18.
 */

public abstract class BaseFragment<P extends BaseContract.BasePresenter> extends Fragment implements BaseContract.BaseView {

    protected Context context;
    protected P presenter;
    protected BaseContract.BaseView mView;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        presenter = getPresenter();
        mView = getIView();
        presenter.attachContext(context);
        presenter.attachView(mView);
        getLifecycle().addObserver(presenter);
        onCreate_(savedInstanceState);
        return inflater.inflate(getLayoutId(), container, false);
    }

    protected abstract void onCreate_(Bundle savedInstanceState);

    public abstract P getPresenter();

    protected abstract BaseContract.BaseView getIView();

    protected abstract int getLayoutId();


    @Override
    public void showToast(String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissProgressDialog() {

    }
}
