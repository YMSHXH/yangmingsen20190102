package com.example.king.yangmingsen20190102.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.king.yangmingsen20190102.R;
import com.example.king.yangmingsen20190102.apis.GoodsApi;
import com.example.king.yangmingsen20190102.beans.PrudentBean;
import com.example.king.yangmingsen20190102.contact.GoodsContact;
import com.example.king.yangmingsen20190102.practicer.GoodsPracticer;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class GoodsActivity extends AppCompatActivity implements GoodsContact.IGoodsView {

    private ImageView mHead;
    private TextView mTTitle;
    private TextView mSubhead;
    private TextView mPrice;
    private GoodsPracticer goodsPracticer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        initView();
        initData();
    }

    private void initData() {
        //获取信使数据
        Intent intent = getIntent();
        String pid = intent.getStringExtra("pid");
        goodsPracticer = new GoodsPracticer(this);
        Map<String, String> params = new HashMap<>();
        params.put("pid",pid);
        goodsPracticer.login(GoodsApi.PR_API,params);
    }

    private void initView() {
        mHead = (ImageView) findViewById(R.id.head);
        mTTitle = (TextView) findViewById(R.id.t_title);
        mSubhead = (TextView) findViewById(R.id.subhead);
        mPrice = (TextView) findViewById(R.id.price);
    }

    @Override
    public void onSuccess(String meg) {
        PrudentBean prudentBean = new Gson().fromJson(meg, PrudentBean.class);
        Toast.makeText(GoodsActivity.this,prudentBean.getCode(),Toast.LENGTH_SHORT).show();
        PrudentBean.Data data = prudentBean.getData();
        mTTitle.setText(data.getTitle());
        mSubhead.setText(data.getSubhead());
        mPrice.setText("￥"+data.getPrice());

        //加载图片
        String images = data.getImages();
        String[] split = images.split("\\|");
        if (split.length > 0) {
            Glide.with(GoodsActivity.this).load(split[0]).into(mHead);
        } else {
            Glide.with(GoodsActivity.this).load(data.getImages()).into(mHead);
        }

    }

    @Override
    public void onFail(String s) {
        Toast.makeText(GoodsActivity.this,s,Toast.LENGTH_SHORT).show();
    }
}
