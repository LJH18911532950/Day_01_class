package com.example.day_03_class.Personter;


import com.example.day_03_class.base.Item;
import com.example.day_03_class.intergetr.ClassResc;
import com.example.day_03_class.intergetr.IHome;
import com.example.day_03_class.mdelo.Mdelo;

public class Personter implements IHome.Personter {
    private IHome.View view;
    private IHome.Mdelo mdelo;

    public Personter(IHome.View view) {
        this.view = view;
        this.mdelo=new Mdelo();
    }

    @Override
    public void getItem() {
        mdelo.getMdelo1(new ClassResc() {
            @Override
            public void onSemm(Object o) {
                view.getItem((Item) o);
            }

            @Override
            public void onGtom(String msg) {

            }
        });
    }


}
