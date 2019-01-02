package com.example.king.yangmingsen20190102.utils;

import android.os.Handler;
import android.text.TextUtils;
import android.text.format.Time;
import android.widget.TextView;

import com.example.king.yangmingsen20190102.contact.GoodsContact;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtils {

    /**
     * 单例模式
     */
    private static OkHttpUtils inact;
    private final OkHttpClient okHttpClient;
    private final Handler handler;

    private OkHttpUtils() {
        handler = new Handler();
        okHttpClient = new OkHttpClient.Builder()
                //.addInterceptor();
                .writeTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .build();

    }

    public static OkHttpUtils getInact(){
        if (inact == null){
            synchronized (OkHttpUtils.class){
                if (inact == null){
                    inact = new OkHttpUtils();
                }
            }
        }
        return inact;
    }

    /**
     * Post请求
     * @param api
     * @param params
     * @param pr
     */
    public void toPost(String api, Map<String, String> params, final GoodsContact.Pr pr){
        Request request;
        if (params == null){
            request = new Request.Builder()
                    .url(api)
                    .get()
                    .build();
        }else {
            FormBody.Builder builder = new FormBody.Builder();
            for (Map.Entry<String, String> p : params.entrySet()) {
                builder.add(p.getKey(), p.getValue());
            }

            request = new Request.Builder()
                    .url(api)
                    .post(builder.build())
                    .build();
        }
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        pr.onFail("网络错误");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String res = response.body().string();
                if (!TextUtils.isEmpty(res)){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pr.onSuccess(res);
                        }
                    });
                }
            }
        });

    }

}
