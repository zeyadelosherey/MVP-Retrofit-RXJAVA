package com.example.mvprxjava.UTILS;

import com.example.mvprxjava.UTILS.GETNEWS;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MODEL {

    @GET("v2/top-headlines?country=us&apiKey=92f2436407be44c6a15bbe1693fd95ee")
    Observable<GETNEWS> getNEWS();

}
