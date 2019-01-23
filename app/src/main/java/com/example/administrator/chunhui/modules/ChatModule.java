package com.example.administrator.chunhui.modules;

import com.example.administrator.chunhui.beans.ListNewsBean;
import com.example.administrator.chunhui.beans.News;
import com.example.administrator.chunhui.beans.PersonInfoBean;
import com.example.administrator.chunhui.beans.ResultBean;
import com.example.administrator.chunhui.utils.HttpUtils;
import com.example.administrator.frame.configs.Apiconfig;
import com.example.administrator.frame.configs.NetConfig;
import com.example.administrator.frame.module.MainModule;
import com.example.administrator.frame.view.MainView;

import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class ChatModule implements MainModule {

    @Override
    public void getContent(int apiconfig, MainView mainView, Object[] t) {
        switch (apiconfig) {
            case Apiconfig.APICONFIG_FIRST:
                HttpUtils.getInStance().getExcute(mainView, apiconfig, ListNewsBean.class, new HashMap<String, String>(), new FormBody.Builder().build(), "news/listNewsChannel", "application/x-www-form-urlencoded");
                break;
            case Apiconfig.APICONFIG_SECOND:
                Map<String, String> map = new HashMap<>();
                map.put("userId", "c383f4c9026d471da0184ad5b24c0365");
                FormBody.Builder builder = new FormBody.Builder();
                for (String key : map.keySet()) {
                    builder.add(key, map.get(key));
                }
                FormBody formBody = builder.build();
                HttpUtils.getInStance().getExcute(mainView, apiconfig, PersonInfoBean.class, map, formBody, "users/info", "application/x-www-form-urlencoded");
                break;
            case Apiconfig.APICONFIG_THRID:
                Map<String, String> map1 = new HashMap<>();
                String a = "{\n" +
                        "\"keyword\": \"无人机\", \n" +
                        "\"cursor\": \"0\"\n" +
                        "}";
                RequestBody detailBody = RequestBody.create(MediaType.parse("application/json,charset-UTF-8"), a);
                HttpUtils.getInStance().getExcute(mainView, apiconfig, ResultBean.class, map1, detailBody, "tags/search", "application/json");
                break;
            case Apiconfig.APICONFIG_FORTH:
                HttpUtils.getInStance().getExcute(mainView, apiconfig, News.class, null, new FormBody.Builder().build(), "diyiti.json");
                break;
        }
    }
}
