package com.example.administrator.chunhui.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;


import com.example.administrator.chunhui.application.FrameApplication;
import com.example.administrator.frame.configs.Apiconfig;
import com.example.administrator.frame.configs.NetConfig;
import com.example.administrator.frame.observer.ObServerSub;
import com.example.administrator.frame.view.MainView;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtils<T> {
    public static HttpUtils httpUtils;
    private String mString;

    public static HttpUtils getInStance() {
        if (httpUtils == null) {
            synchronized (HttpUtils.class) {
                if (httpUtils == null) {
                    httpUtils = new HttpUtils();
                }
            }
        }
        return httpUtils;
    }

    //发起异步请求
    //接口回调的view  判断请求及接口   最终解析的实体类  用于判断是get还是post请求  上传接口的请求体  传过来的参数
    public void getExcute(final MainView mainView, final int apiconfig, final Class a, Map<String, String> map, RequestBody requestBody, final T... t) {
        Request.Builder request = null;
        //固定的  第一个是接口的最后补全的值
        String strings = (String) t[0];
        if (map == null) {
            request = new Request.Builder().url(NetConfig.BASE_URL + strings);
        } else {
            request = new Request.Builder().url(NetConfig.BASE_URL + strings)
                    .post(requestBody);
        }
        if (t.length >1) {
            //大于1的话  他的第二个就是请求头
            mString = (String) t[1];
            request.addHeader("Content-Type", mString);
        }
        Request build = request.build();
        getOkHttoClient().newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("v", "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Observable<Object> objectObservable = Observable.create(new ObservableOnSubscribe<Object>() {
                    @Override
                    public void subscribe(ObservableEmitter<Object> e) throws Exception {
                        Gson gson = new Gson();
                        Object o1 = gson.fromJson(string, a);
                        if (o1 != null) {
                            e.onNext(o1);
                        } else {
                            e.onError(new NullPointerException("请求数据为空"));
                        }
                    }
                });
                ObServerSub.getServer(objectObservable, mainView, apiconfig, t);
            }
        });
    }

    public OkHttpClient getOkHttoClient() {
        MyCacheinterceptor myCacheinterceptor = new MyCacheinterceptor();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .cache(new Cache(new File(FrameApplication.getApplication().getCacheDir(), "Cache"), 1024 * 1024 * 10))
                .addInterceptor(myCacheinterceptor)
                .addNetworkInterceptor(myCacheinterceptor)
                .build();
        return okHttpClient;
    }


    class MyCacheinterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            //这里就是说判读我们的网络条件，要是有网络的话我么就直接获取网络上面的数据，要是没有网络的话我么就去缓存里面取数据
            if (!isNetworkAvailable(FrameApplication.getApplication())) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }
            Response originalResponse = chain.proceed(request);
            if (isNetworkAvailable(FrameApplication.getApplication())) {
                int maxAge = 0;
                return originalResponse.newBuilder()
                        // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 15;
                return originalResponse.newBuilder()
                        // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                        .removeHeader("Pragma")
                        //这里的设置的是我们的没有网络的缓存时间，想设置多少就是多少。
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }

        }

    }

    /**
     * 检测是否有网
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        if (context != null) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = cm.getActiveNetworkInfo();
            if (info != null) {
                return info.isAvailable();
            }
        }
        return false;
    }
}
