package com.example.yohan.tpnote.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.yohan.tpnote.R;
import com.example.yohan.tpnote.XMLParser;
import com.example.yohan.tpnote.adapter.ModelAdapter;
import com.example.yohan.tpnote.asynctask.AsyncURL;
import com.example.yohan.tpnote.controleir.ControleurCategories;
import com.example.yohan.tpnote.model.Categorie;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.jar.Attributes;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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
