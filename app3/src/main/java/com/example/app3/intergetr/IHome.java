package com.example.app3.intergetr;


import com.example.app3.base.Item;

public interface IHome {
    interface View{
        void getItem(Item item);
    }
    interface Personter{
        void getItem();
    }
    interface Mdelo{
        void getMdelo1(ClassResc classResc);
    }
}
