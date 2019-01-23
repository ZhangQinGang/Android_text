package com.example.administrator.frame.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.administrator.frame.module.MainModule;
import com.example.administrator.frame.presenter.PresenterImp;
import com.example.administrator.frame.view.MainView;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends PresenterImp,M extends MainModule> extends BaseNetActivity implements MainView {

    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        getView();
        mPresenter = getPresenter();
        mPresenter.onAttach(this,getModule());
        getData();
    }

    public abstract int getLayout();
    public abstract P getPresenter();
    public abstract M getModule();
    public abstract void getView();
    public abstract void getData();
}
