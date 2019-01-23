package com.example.administrator.frame.presenter;

import com.example.administrator.frame.view.MainView;

import java.util.Map;

public class PresenterImp<T> extends PresenterNetImp implements MainPresenter<T>, MainView {


    @Override
    public void showResult(int Apiconfig, Object o, Object[] t) {
        if(getView()!=null){
            getView().showResult(Apiconfig,o,t);
        }
    }

    @Override
    public void showError(int Apiconfig, Throwable throwable) {
        if(getView()!=null){
            getView().showError(Apiconfig,throwable);
        }
    }

    @Override
    public void setContent(int apiconfig, T... t) {
        if(getModule()!=null){
            getModule().getContent(apiconfig,this,t);
        }
    }
}
