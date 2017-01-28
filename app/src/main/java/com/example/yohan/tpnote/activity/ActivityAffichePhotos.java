package com.example.yohan.tpnote.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.yohan.tpnote.R;
import com.example.yohan.tpnote.asynctask.XMLParser;
import com.example.yohan.tpnote.adapter.ModelAdapter;
import com.example.yohan.tpnote.controleur.ControleurCategories;

public class ActivityAffichePhotos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_photos);

        ControleurCategories ci = new ControleurCategories(ActivityAffichePhotos.this);

        String[] urlPageWeb = {"http://public.ave-comics.com/gabriel/iut/images.xml"};

        XMLParser xmlp = new XMLParser();
        ci.ajouterTousImage(xmlp.parse(urlPageWeb));

        ListView mListView = (ListView)findViewById(R.id.mListView);
        ModelAdapter adapter = new ModelAdapter(ActivityAffichePhotos.this, ci.recupererListe());
        mListView.setAdapter(adapter);
    }
}
