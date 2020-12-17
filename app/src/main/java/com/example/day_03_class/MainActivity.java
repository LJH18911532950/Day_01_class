package com.example.day_03_class;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.day_03_class.Personter.Personter;
import com.example.day_03_class.base.Item;
import com.example.day_03_class.intergetr.IHome;

public class MainActivity extends AppCompatActivity implements IHome.View {
    private IHome.Personter personter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personter=new Personter(this);
        initDate();
    }

    private void initDate() {
        personter.getItem();
    }

    @Override
    public void getItem(Item item) {

    }
}