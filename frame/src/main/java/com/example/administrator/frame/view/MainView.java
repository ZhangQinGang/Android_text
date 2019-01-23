package com.example.administrator.frame.view;

public interface MainView<T> {
    void showResult(int Apiconfig, T o, T... t);
    void showError(int Apiconfig, Throwable throwable);
}
