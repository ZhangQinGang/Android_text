package com.example.administrator.frame.presenter;


import com.example.administrator.frame.module.MainModule;
import com.example.administrator.frame.view.MainView;

import java.lang.ref.SoftReference;

public class PresenterNetImp<V extends MainView,M extends MainModule>{
    SoftReference<V> mVSoftReference;
    SoftReference<M> mMSoftReference;
    public void onAttach(V view,M module){
        mVSoftReference=new SoftReference<>(view);
        mMSoftReference=new SoftReference<>(module);
    }

    public void onDetch(){
        if(mVSoftReference!=null){
            mVSoftReference.clear();
            mVSoftReference=null;
        }

        if(mMSoftReference!=null){
            mMSoftReference.clear();
            mMSoftReference=null;
        }
    }

    public V getView(){
        return mVSoftReference!=null?mVSoftReference.get():null;
    }

    public M getModule(){
        return mMSoftReference!=null?mMSoftReference.get():null;
    }
}
