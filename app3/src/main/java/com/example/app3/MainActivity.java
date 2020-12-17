package com.example.app3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app3.base.Item;
import com.example.app3.intergetr.IHome;
import com.example.day_03_class.adapter.InfoAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IHome.View {

    private RecyclerView refgrhtntre;
    private InfoAdapter infoAdapter;
    private List<Item.ResultsBean>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        refgrhtntre = (RecyclerView) findViewById(R.id.refgrhtntre);
        refgrhtntre.setLayoutManager(new LinearLayoutManager(this));
        refgrhtntre.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        infoAdapter = new InfoAdapter(list, this);
        refgrhtntre.setAdapter(infoAdapter);
    }

    @Override
    public void getItem(Item item) {
       
    }
}
