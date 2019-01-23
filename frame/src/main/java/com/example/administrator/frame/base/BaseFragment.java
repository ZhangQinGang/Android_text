package com.example.administrator.frame.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.frame.module.MainModule;
import com.example.administrator.frame.presenter.PresenterImp;
import com.example.administrator.frame.view.MainView;

import butterknife.ButterKnife;


public abstract class BaseFragment<P extends PresenterImp, M extends MainModule> extends BaseNetFragment implements MainView {

    public P mPresenter;
    private M mModule;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayout(), null);
        ButterKnife.bind(this, inflate);
        initView();
        mPresenter = getPresenter();
        mModule = getModule();
        mPresenter.onAttach(this, mModule);
        initData();
        return inflate;
    }

    public abstract int getLayout();

    public abstract P getPresenter();

    public abstract M getModule();

    public abstract void initView();

    public abstract void initData();
}
