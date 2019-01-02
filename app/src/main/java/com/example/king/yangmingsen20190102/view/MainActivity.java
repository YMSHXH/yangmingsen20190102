package com.example.king.yangmingsen20190102.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.king.yangmingsen20190102.R;
import com.example.king.yangmingsen20190102.adapter.MAdapter;
import com.example.king.yangmingsen20190102.apis.GoodsApi;
import com.example.king.yangmingsen20190102.beans.GoodsBean;
import com.example.king.yangmingsen20190102.contact.GoodsContact;
import com.example.king.yangmingsen20190102.practicer.GoodsPracticer;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements GoodsContact.IGoodsView {

    private GridView mGv;
    private GoodsPracticer goodsPracticer;
    private MAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        goodsPracticer = new GoodsPracticer(this);
        //Map<String, String> params = new HashMap<>();
        goodsPracticer.login(GoodsApi.GOODS_API,null);
    }

    private void initView() {
        mGv = (GridView) findViewById(R.id.gv);
        //设置适配器
        mAdapter = new MAdapter(MainActivity.this);
        mGv.setAdapter(mAdapter);

        mGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,GoodsActivity.class);
                intent.putExtra("pid",mAdapter.getItem(position).getPid());
                startActivity(intent);
            }
        });

        mGv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mAdapter.delList(mAdapter.getItem(position));
                Toast.makeText(MainActivity.this,"删除成功!",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public void onSuccess(String meg) {
        GoodsBean goodsBean = new Gson().fromJson(meg, GoodsBean.class);
        //Toast.makeText(MainActivity.this,""+goodsBean.getCode(),Toast.LENGTH_SHORT).show();
        List<GoodsBean.DataBean.TuijianBean.ListBeanX> list = goodsBean.getData().getTuijian().getList();
        mAdapter.setList(list);
    }

    @Override
    public void onFail(String s) {
        Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
    }
}
