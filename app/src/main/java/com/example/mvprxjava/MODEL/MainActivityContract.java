package com.example.mvprxjava.MODEL;



import com.example.mvprxjava.UTILS.GETNEWS;

import io.reactivex.Observable;

public interface MainActivityContract {

     interface  Iview{
        void getAlluserView(Observable<GETNEWS> newsList);
    }



     interface  Ipresenter{
        void getAllNewsPresnters();
    }



     interface  Imodel{
        Observable<GETNEWS> getAllNews();
    }


}
