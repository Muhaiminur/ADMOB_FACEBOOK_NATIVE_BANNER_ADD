package com.muhaiminurabir.facebook_ad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.muhaiminurabir.facebook_ad.Admob.Admob_Recycler;

public class MainActivity extends AppCompatActivity {

    private android.widget.Button recyclernative;
    private android.widget.Button recycleradmobnative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycleradmobnative =findViewById(R.id.recycler__admob_native);
        recyclernative =findViewById(R.id.recycler_native);
        recyclernative.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Recycler_Native.class));
            }
        });
        recycleradmobnative.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Admob_Recycler.class));
            }
        });}
}
