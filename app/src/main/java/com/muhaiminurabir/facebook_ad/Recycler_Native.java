package com.muhaiminurabir.facebook_ad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.facebook.ads.AdError;
import com.facebook.ads.NativeAdsManager;

import java.util.ArrayList;

public class Recycler_Native extends AppCompatActivity implements NativeAdsManager.Listener {

    private ArrayList<RecyclerPostItem> mPostItemList;
    private NativeAdsManager mNativeAdsManager;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler__native);
        // Create some dummy post items
        mPostItemList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            mPostItemList.add(new RecyclerPostItem("RecyclerView Item #" + i));
        }

        String placement_id = "YOUR_PLACEMENT_ID";
        mNativeAdsManager = new NativeAdsManager(Recycler_Native.this, placement_id, 5);
        mNativeAdsManager.loadAds();
        mNativeAdsManager.setListener(this);

        // Inflate the layout for this fragment
        //View view = inflater.inflate(R.layout.fragment_native_ad_recycler, container, false);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        DividerItemDecoration itemDecoration =
                new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
        NativeAdRecyclerAdapter adapter =
                new NativeAdRecyclerAdapter(Recycler_Native.this, mPostItemList, mNativeAdsManager);
        mRecyclerView.setAdapter(adapter);
    }
    @Override
    public void onAdsLoaded() {
        if (getApplicationContext() == null) {
            return;
        }
    }

    @Override
    public void onAdError(AdError error) {}
}

