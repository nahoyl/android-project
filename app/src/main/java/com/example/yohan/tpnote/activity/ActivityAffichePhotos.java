package com.example.yohan.tpnote.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.yohan.tpnote.R;
import com.example.yohan.tpnote.asynctask.DownloadImageTask;
import com.example.yohan.tpnote.asynctask.DownloadXMLTask;
import com.example.yohan.tpnote.adapter.ModelAdapter;
import com.example.yohan.tpnote.controleur.ControleurCategories;
import com.example.yohan.tpnote.model.Image;

import java.util.List;

public class ActivityAffichePhotos extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_photos);

        String url = getIntent().getStringExtra("image");
        DownloadImageTask dit = new DownloadImageTask((ImageView)findViewById(R.id.imageZoom));
        dit.execute(url);
    }
}
