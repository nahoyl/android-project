package com.example.yohan.tpnote.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yohan.tpnote.R;
import com.example.yohan.tpnote.asynctask.AsyncURL;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        AsyncURL aurl = new AsyncURL();
//        String [] url = {"http://public.ave-comics.com/gabriel/iut/images.xml"};
//        aurl.execute(url);
        Intent intent = new Intent(this, ActivityAffichePhotos.class);

        startActivity(intent);
    }
}
