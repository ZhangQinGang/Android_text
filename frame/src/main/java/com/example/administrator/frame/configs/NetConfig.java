package com.example.administrator.frame.configs;

public class NetConfig {
    public static int apiType = 1;
    public static String BASE_URL;
    static {
        if (apiType == 1){
            BASE_URL = "http://www.pengchen.net.cn/data/";
        } else if (apiType == 2){
            BASE_URL = "http://47.104.23.233:8083/ylfwypt/swagger-ui.html#/";
        } else {
            BASE_URL = "https://www.firstgainfo.com/firstga/app/";
        }
    }

    public static final String TENCENT_ID = "1804rxl";
    public static final String TENCENT_CONSIG = "eJx1kEFPgzAUgO-8iqZXjaxQQLxtYyx1zMWM6dylaWjnmim0UBbA*N9H0EQuvuv3vXwv78sCAMA02d6xLCvq3FDTKgHBA4BB6MDbP6yU5JQZ6pZ8wAhP*kGe644s0ShZCsqORpSD5Xih02sjRXKRG3mUvwK6n*Cy*RgJFT-TofZ-ppLvA1wv3ubkOXJzTQrdyUbP7DS*2I9InoNDHAuy0nt-Hz0pf8mX81O-Rk7TTZJN-bS77ArWbkJG1gtBZp2o9c3hJYlXdlhXkdi9BqrFo6SRnz9vQR4O*oMcH0Pr27oC7vNXew__";
}
