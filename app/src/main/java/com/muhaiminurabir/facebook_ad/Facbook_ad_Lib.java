package com.muhaiminurabir.facebook_ad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.timos.thuanle.fbnativeadadapter.FBNativeAdAdapter;

public class Facbook_ad_Lib extends AppCompatActivity {

    private List<String> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Facbook_ad_Lib_Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facbook_ad__lib);
        /*recyclerView = (RecyclerView) findViewById(R.id.facebook_ad_recycler);

        mAdapter = new Facbook_ad_Lib_Adapter(movieList);
        recyclerView.setHasFixedSize(true);
        // vertical RecyclerView
        // keep movie_list_row.xml width to `match_parent`
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        // horizontal RecyclerView
        // keep movie_list_row.xml width to `wrap_content`
        // RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        //recyclerView.setLayoutManager(mLayoutManager);
        // adding inbuilt divider line
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
        FBNativeAdAdapter fbAdapter = FBNativeAdAdapter.Builder.with("YOUR_PLACEMENT_ID", mAdapter)
                .build();

        *//*RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setAdapter(fbAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));*//*
        recyclerView.setAdapter(fbAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/

        prepareMovieData();
        mAdapter = new Facbook_ad_Lib_Adapter(movieList);
        FBNativeAdAdapter fbAdapter = FBNativeAdAdapter.Builder.with("469109283477914_473204296401746", mAdapter)
                .build();

        RecyclerView rv = (RecyclerView) findViewById(R.id.facebook_ad_recycler);
        rv.setAdapter(fbAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
    private void prepareMovieData() {
        for (int c=0;c<20;c++){
            movieList.add("Abir = "+c);
        }
        //mAdapter.notifyDataSetChanged();
    }
}
