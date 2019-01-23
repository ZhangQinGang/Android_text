package com.example.administrator.frame.module;


import com.example.administrator.frame.view.MainView;

import java.util.Map;

public interface MainModule<T> {
    void getContent(int apiconfig, MainView mainView, T... t);
}
