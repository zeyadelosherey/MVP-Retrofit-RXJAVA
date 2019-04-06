package com.example.mvprxjava.MODEL;

import com.example.mvprxjava.UTILS.GETNEWS;
import com.example.mvprxjava.UTILS.MODEL;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MAINMODELDATA implements  MainActivityContract.Imodel {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://newsapi.org/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    final MODEL model = retrofit.create(MODEL.class);

    @Override
    public Observable<GETNEWS> getAllNews() {
        return model.getNEWS();
    }

}
