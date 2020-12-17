package com.example.app3.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.app3.R;
import com.example.app3.base.Item;


import java.util.List;

public  class InfoAdapter extends BaseAdapter {
    public InfoAdapter(List mDate, Context context) {
        super(mDate, context);
    }

    @Override
    protected int getLoght() {
        return R.layout.layout;
    }

    @Override
    protected void bind(Object date, VH vh) {
        Item.ResultsBean resultsBean= (Item.ResultsBean) date;
        ImageView iv_img = (ImageView) vh.getViewByid(R.id.iv_img3);
        Glide.with(vh.itemView).load(resultsBean.getUrl()).into(iv_img);
    }
}
