package com.example.administrator.frame.observer;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class ObServerUtil<T> implements Observer {
    Disposable mDisposable;

    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
    }

    @Override
    public void onNext(Object value) {
        getValue(value);
        unbind();
    }

    @Override
    public void onError(Throwable e) {
        getError(e);
        unbind();
    }

    @Override
    public void onComplete() {

    }

    public void unbind() {
        if (mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

    public abstract void getValue(Object o);

    public abstract void getError(Throwable throwable);
}
