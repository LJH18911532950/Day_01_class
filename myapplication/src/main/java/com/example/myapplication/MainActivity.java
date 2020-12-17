package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.Personter.Preosntre;
import com.example.myapplication.base.Result;
import com.example.myapplication.insert.IHome;

public class MainActivity extends AppCompatActivity implements IHome.View {
    private IHome.Personter personter;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personter=new Preosntre(this);
        initDate();
    }

    private void initDate() {
         personter.getRsult();
    }

    @Override
    public void getResult(Result result) {

    }
}
