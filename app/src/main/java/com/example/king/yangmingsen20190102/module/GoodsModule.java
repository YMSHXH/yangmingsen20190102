package com.example.king.yangmingsen20190102.module;

import com.example.king.yangmingsen20190102.contact.GoodsContact;
import com.example.king.yangmingsen20190102.utils.OkHttpUtils;

import java.util.Map;

public class GoodsModule implements GoodsContact.IGoodsModule {
    @Override
    public void setData(String api, Map<String, String> params, GoodsContact.Pr pr) {
        OkHttpUtils.getInact().toPost(api,params,pr);
    }
}
