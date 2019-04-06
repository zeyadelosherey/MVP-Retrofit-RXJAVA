package com.example.mvprxjava.VIEW;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.mvprxjava.R;
import com.example.mvprxjava.UTILS.GETNEWS;
import com.example.mvprxjava.UTILS.RecyclerAdapter;
import com.example.mvprxjava.MODEL.MainActivityContract;
import com.example.mvprxjava.PRESENTER.MAINACTIVITYPRESENTER;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements MainActivityContract.Iview {
    MAINACTIVITYPRESENTER mainpresenter;
    List<GETNEWS> NEWSLIST = new ArrayList();
    RecyclerView newsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainpresenter = new MAINACTIVITYPRESENTER(MainActivity.this);
        mainpresenter.getAllNewsPresnters();




    }


    @Override
    public void getAlluserView(Observable<GETNEWS> newsList) {
     newsList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GETNEWS>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(GETNEWS getnews) {
                        NEWSLIST.add(getnews);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.e("hello" , String.valueOf(NEWSLIST.get(0).articles.size()));
                        newsRecycler = findViewById(R.id.newsRecycler);
                        RecyclerAdapter recyclerViewAdapterF = new RecyclerAdapter(NEWSLIST.get(0).articles , MainActivity.this);
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this );
                        newsRecycler.setLayoutManager(mLayoutManager);
                        newsRecycler.setHasFixedSize(true);
                        newsRecycler.setAdapter(recyclerViewAdapterF);
                    }
                });
    }
}