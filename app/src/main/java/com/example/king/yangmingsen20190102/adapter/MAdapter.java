package com.example.king.yangmingsen20190102.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.king.yangmingsen20190102.R;
import com.example.king.yangmingsen20190102.beans.GoodsBean;

import java.util.ArrayList;
import java.util.List;

public class MAdapter extends BaseAdapter {

    private Context context;
    private List<GoodsBean.DataBean.TuijianBean.ListBeanX> list;

    public MAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    public void setList(List<GoodsBean.DataBean.TuijianBean.ListBeanX> list) {
        if (list!= null) {
            this.list = list;
        }
        notifyDataSetChanged();
    }

    public void delList(GoodsBean.DataBean.TuijianBean.ListBeanX list) {
        if (list!= null) {
            this.list.remove(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public GoodsBean.DataBean.TuijianBean.ListBeanX getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.gv_item,parent,false);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.setData(list.get(position));

        return convertView;
    }

    class ViewHolder{
        ImageView img;
        TextView title,subhead,price;

        public ViewHolder(View view) {
            this.img = view.findViewById(R.id.img_item);
            this.title = view.findViewById(R.id._title);
            this.subhead = view.findViewById(R.id.subhead);
            this.price = view.findViewById(R.id.price);

            view.setTag(this);
        }

        public void setData(GoodsBean.DataBean.TuijianBean.ListBeanX listBeanX) {
            title.setText(listBeanX.getTitle());
            subhead.setText(listBeanX.getSubhead());
            price.setText("￥"+listBeanX.getPrice());

            String images = listBeanX.getImages();
            String[] split = images.split("\\|");
            if (split.length > 0) {
                Glide.with(context).load(split[0]).into(img);
            } else {
                Glide.with(context).load(listBeanX.getImages()).into(img);
            }
        }
    }
}
