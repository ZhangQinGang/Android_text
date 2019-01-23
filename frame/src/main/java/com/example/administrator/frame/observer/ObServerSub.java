package com.example.administrator.frame.observer;


import com.example.administrator.frame.view.MainView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ObServerSub {
    public static <T> void getServer(Observable observable, final MainView mainView, final int apiConfig, final T...t){
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ObServerUtil() {
            @Override
            public void getValue(Object o) {
                mainView.showResult(apiConfig,o,t);
            }

            @Override
            public void getError(Throwable throwable) {
                mainView.showError(apiConfig,throwable);
            }
        });
    }
}
