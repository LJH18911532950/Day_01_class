package com.example.myapplication.insert;

import android.view.View;

import com.example.myapplication.base.Result;

public interface IHome {
    interface View{
        void getResult(Result result);
    }
    interface Personter{
        void getRsult();
    }
    interface Mdelo{
        void getMdelo1(ResultClass resultClass);
    }
}
