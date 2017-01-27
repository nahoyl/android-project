package com.example.yohan.tpnote.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.yohan.tpnote.R;
import com.example.yohan.tpnote.adapter.ModelAdapter;
import com.example.yohan.tpnote.asynctask.AsyncURL;
import com.example.yohan.tpnote.controleur.ControleurCategories;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ActivityAffichePhotos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_photos);

        ControleurCategories ci = new ControleurCategories(ActivityAffichePhotos.this);

        String[] urlPageWeb = {"http://public.ave-comics.com/gabriel/iut/images.xml"};

        AsyncURL au = new AsyncURL();

        au.execute(urlPageWeb);

        InputStream is = null;

        try {
            is=au.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            Element element=doc.getDocumentElement();
            element.normalize();

            NodeList nList = doc.getElementsByTagName("image");

            for (int i=0; i<nList.getLength(); i++) {

                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element2 = (Element) node;
                    String nom = getValue("name", element2);
                    String desc = getValue("description", element2);
                    String url = gethrefValue("link", element2); // ERREUR A CAUSE DU HREF
                    System.out.println("Resultat :" +nom + "/" + desc + "/" + url);
                }

            }

        } catch (Exception e) {e.printStackTrace();}


        /*

        LecteurXML lecteur = new LecteurXML(is);

        Categorie liste = lecteur.getListeImage();
        */

        //ci.ajouterTousImage(liste.getItemImage());

        ListView mListView = (ListView)findViewById(R.id.mListView);
        ModelAdapter adapter = new ModelAdapter(ActivityAffichePhotos.this, ci.recupererListe());
        mListView.setAdapter(adapter);
    }

    private static String getValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    private static String gethrefValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Element node = (Element)nodeList.item(0);

        return node.getAttribute("href");
    }


}
