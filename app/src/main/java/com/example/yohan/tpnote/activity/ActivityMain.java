package com.example.yohan.tpnote.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yohan.tpnote.R;
import com.example.yohan.tpnote.asynctask.DownloadXMLTask;
import com.example.yohan.tpnote.model.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, ActivityAffichePhotos.class);
        startActivity(intent);
    }
}
