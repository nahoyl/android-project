package com.example.yohan.tpnote.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.yohan.tpnote.R;
import com.example.yohan.tpnote.adapter.ModelAdapter;
import com.example.yohan.tpnote.controleir.ControleurCategories;
import com.example.yohan.tpnote.model.Categorie;

public class ActivityAffichePhotos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_photos);

        ControleurCategories ci = new ControleurCategories(ActivityAffichePhotos.this);

        String[] urlPageWeb = {"http://public.ave-comics.com/gabriel/iut/images.xml"};

        /*
        AsyncRecuperateur ar = new AsyncRecuperateur();
        ar.execute(urlPageWeb);
        InputStream is = null;
        try {
            is = ar.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        LecteurXML lecteur = new LecteurXML(is);

        Categorie liste = lecteur.getListeImage();
        */

        //ci.ajouterTousImage(liste.getItemImage());

        ListView mListView = (ListView)findViewById(R.id.mListView);
        ModelAdapter adapter = new ModelAdapter(ActivityAffichePhotos.this, ci.recupererListe());
        mListView.setAdapter(adapter);
    }
}
