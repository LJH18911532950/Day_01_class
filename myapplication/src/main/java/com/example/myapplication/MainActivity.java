package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Personter.Preosntre;
import com.example.myapplication.adapter.ResultAdapter;
import com.example.myapplication.base.Result;
import com.example.myapplication.insert.IHome;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IHome.View {
    private IHome.Personter personter;
    private RecyclerView recylt;
    private List<Result.ResultsBean> list;
    private ResultAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personter = new Preosntre(this);
        initView();
        initDate();

    }

    private void initDate() {
        personter.getRsult();
    }

    @Override
    public void getResult(Result result) {
        List<Result.ResultsBean> results = result.getResults();
        list.addAll(results);
        adapter.notifyDataSetChanged();

    }

    private void initView() {
        recylt = (RecyclerView) findViewById(R.id.recylt);
        recylt.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new ResultAdapter(list, this);
        recylt.setAdapter(adapter);
    }
}
