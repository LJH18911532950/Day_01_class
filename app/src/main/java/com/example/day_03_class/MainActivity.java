package com.example.day_03_class;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day_03_class.Personter.Personter;
import com.example.day_03_class.adapter.InfoAdapter;
import com.example.day_03_class.base.Item;
import com.example.day_03_class.intergetr.IHome;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IHome.View {
    private IHome.Personter personter;
    private RecyclerView recy;
    private List<Item.ResultsBean> list;
    private InfoAdapter infoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personter = new Personter(this);
        initView();
        initDate();
    }

    private void initDate() {
        personter.getItem();
    }

    @Override
    public void getItem(Item item) {
        List<Item.ResultsBean> results = item.getResults();
        list.addAll(results);
        infoAdapter.notifyDataSetChanged();

    }

    private void initView() {
        recy = (RecyclerView) findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        infoAdapter = new InfoAdapter(list, this);
        recy.setAdapter(infoAdapter);
    }
}