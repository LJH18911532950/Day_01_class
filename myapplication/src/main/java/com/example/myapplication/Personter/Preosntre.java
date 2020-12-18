package com.example.myapplication.Personter;

import com.example.myapplication.base.Result;
import com.example.myapplication.insert.IHome;
import com.example.myapplication.insert.ResultClass;
import com.example.myapplication.mdelo.mdelo;

public class Preosntre implements IHome.Personter {
    private IHome.View view;
    private IHome.Mdelo mdelo;

    public Preosntre(IHome.View view) {
        this.view = view;
        mdelo=new mdelo();
    }

    @Override
    public void getRsult() {
        mdelo.getMdelo1(new ResultClass() {
            @Override
            public void onsere(Object o) {
                view.getResult((Result) o);
            }

            @Override
            public void onmfoopm(String msg) {

            }
        });

    }
}
