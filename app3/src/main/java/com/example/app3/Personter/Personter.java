package com.example.app3.Personter;


import com.example.app3.intergetr.ClassResc;
import com.example.app3.intergetr.IHome;
import com.example.app3.mdelo.Mdelo;

public class Personter implements IHome.Personter {
    private IHome.View view;
    private IHome.Mdelo mdelo ;

    public Personter(IHome.View view) {
        this.view = view;
        mdelo= (IHome.Mdelo) new Mdelo();
    }

    @Override
    public void getItem() {
        mdelo.getMdelo1(new ClassResc() {
            @Override
            public void onSemm(Object o) {

            }

            @Override
            public void onGtom(String msg) {

            }
        });

    }


}
