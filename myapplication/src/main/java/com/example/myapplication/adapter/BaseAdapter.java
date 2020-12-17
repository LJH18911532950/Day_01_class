package com.example.myapplication.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseAdapter<D> extends RecyclerView.Adapter {
    private List<D>mDate;
    private Context context;

    public BaseAdapter(List<D> mDate, Context context) {
        this.mDate = mDate;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(getLoim(), parent, false);
        return new VH(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        bind(mDate.get(position), (VH) holder);
    }


    @Override
    public int getItemCount() {
        return mDate.size();
    }

    protected abstract int getLoim();
    protected abstract void bind(D date,VH vh);
    class VH extends RecyclerView.ViewHolder{
        SparseArray sparseArray=new SparseArray();
        public VH(@NonNull View itemView) {
            super(itemView);
        }
        public View getViewByid(int id){
            View view = (View) sparseArray.get(id);
            if(view==null){
                view=itemView.findViewById(id);
                sparseArray.append(id,view);
            }
            return view;
        }
    }

}
