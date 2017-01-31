package com.example.yohan.tpnote.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.yohan.tpnote.R;
import com.example.yohan.tpnote.adapter.ModelAdapter;
import com.example.yohan.tpnote.asynctask.DownloadXMLTask;
import com.example.yohan.tpnote.controleur.ControleurCategories;
import com.example.yohan.tpnote.model.Image;

import java.util.List;


public class ActivityMain extends AppCompatActivity {

    private static final String _URL = "http://public.ave-comics.com/gabriel/iut/images.xml";
    ControleurCategories ci = new ControleurCategories(ActivityMain.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lancer le dl des images
        DownloadXMLTask dxt = new DownloadXMLTask(this);
        dxt.execute(_URL);
    }

    public void afficherListeImage(List<Image> listImages) {
        ci.ajouterTousImage(listImages);
        lancerAdaptateur();
    }

    private void lancerAdaptateur() {
        final ListView mListView = (ListView)findViewById(R.id.mListView);
        ModelAdapter adapter = new ModelAdapter(ActivityMain.this, ci.recupererListe());
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Image img = (Image)parent.getItemAtPosition(position);
                Intent intent = new Intent(ActivityMain.this, ActivityAffichePhotos.class);
                intent.putExtra("image", img.getUrl());
                startActivity(intent);
            }
        });
    }
}
