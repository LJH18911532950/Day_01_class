package com.example.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.base.Result;

import java.util.List;

public class ResultAdapter extends BaseAdapter {
    public ResultAdapter(List mDate, Context context) {
        super(mDate, context);
    }

    @Override
    protected int getLoim() {
        return R.layout.layout_result;
    }

    @Override
    protected void bind(Object date, VH vh) {
        Result.ResultsBean resultsBean= (Result.ResultsBean) date;
        ImageView iv_img2 = (ImageView) vh.getViewByid(R.id.iv_img2);
        Glide.with(vh.itemView).load(resultsBean.getUrl()).into(iv_img2);

    }
}
