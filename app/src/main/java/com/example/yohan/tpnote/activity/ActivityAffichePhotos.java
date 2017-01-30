package com.example.yohan.tpnote.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.yohan.tpnote.R;
import com.example.yohan.tpnote.asynctask.DownloadXMLTask;
import com.example.yohan.tpnote.adapter.ModelAdapter;
import com.example.yohan.tpnote.controleur.ControleurCategories;
import com.example.yohan.tpnote.model.Image;

import java.util.List;

public class ActivityAffichePhotos extends AppCompatActivity {

    ControleurCategories ci = new ControleurCategories(ActivityAffichePhotos.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_photos);

        DownloadXMLTask dxt = new DownloadXMLTask(this);
        dxt.execute();
    }

    public void initItemsData(List<Image> listImages) {
        ci.ajouterTousImage(listImages);
        lancerAdaptateur();
    }

    private void lancerAdaptateur() {
        ListView mListView = (ListView)findViewById(R.id.mListView);
        ModelAdapter adapter = new ModelAdapter(ActivityAffichePhotos.this, ci.recupererListe());
        mListView.setAdapter(adapter);
    }
}
