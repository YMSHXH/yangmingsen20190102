package com.example.king.yangmingsen20190102.contact;

import java.util.Map;

public interface GoodsContact {

    interface Pr{
        void onSuccess(String meg);
        void onFail(String s);
    }

    interface IGoodsModule{
        void setData(String api, Map<String,String> params,Pr pr);
    }

    interface IGoodsView{
        void onSuccess(String meg);
        void onFail(String s);
    }
}
