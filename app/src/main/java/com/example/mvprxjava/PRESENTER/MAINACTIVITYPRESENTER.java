package com.example.mvprxjava.PRESENTER;

import com.example.mvprxjava.MODEL.MAINMODELDATA;
import com.example.mvprxjava.MODEL.MainActivityContract;

public class MAINACTIVITYPRESENTER implements MainActivityContract.Ipresenter {
    MainActivityContract.Imodel model ;
    MainActivityContract.Iview view ;
    public MAINACTIVITYPRESENTER(MainActivityContract.Iview view){
        model =new MAINMODELDATA();
        this.view = view;
    }


    @Override
    public void getAllNewsPresnters() {
        view.getAlluserView(model.getAllNews());
    }
}
