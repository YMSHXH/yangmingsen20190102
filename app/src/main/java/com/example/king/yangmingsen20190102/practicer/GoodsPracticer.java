package com.example.king.yangmingsen20190102.practicer;

import com.example.king.yangmingsen20190102.contact.GoodsContact;
import com.example.king.yangmingsen20190102.module.GoodsModule;

import java.util.Map;

public class GoodsPracticer {

    private GoodsContact.IGoodsView iGoodsView;
    private GoodsModule goodsModule;

    public GoodsPracticer(GoodsContact.IGoodsView iGoodsView) {
        this.iGoodsView = iGoodsView;
        this.goodsModule = new GoodsModule();
    }


    public void login(String goodsApi, Map<String,String> params) {
        if (iGoodsView != null){
            goodsModule.setData(goodsApi, params, new GoodsContact.Pr() {
                @Override
                public void onSuccess(String meg) {
                    if (iGoodsView != null){
                        iGoodsView.onSuccess(meg);
                    }
                }

                @Override
                public void onFail(String s) {
                    if (iGoodsView != null){
                        iGoodsView.onFail(s);
                    }
                }
            });
        }
    }
}
