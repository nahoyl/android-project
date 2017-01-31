package com.example.yohan.tpnote.controleur;

import android.content.Context;

import com.example.yohan.tpnote.model.ListeImage;
import com.example.yohan.tpnote.model.Image;

import java.util.List;

/**
 * Created by Yohan on 27/01/2017.
 */

public class ControleurCategories {
    private ListeImage _listeImage;
    private Context _context;

    public ControleurCategories(Context context){
        this._context = context;
        _listeImage = new ListeImage();

    }

    public boolean ajouterImage(String nom, String description, String url){
        return _listeImage.addImage(nom, description, url);
    }

    public boolean ajouterTousImage(List<Image> imageList){
        return _listeImage.addAllImage(imageList);
    }

    public boolean supprimerImage(String nom, String description, String url){
        return _listeImage.removeImage(nom, description, url);
    }

    public List<Image> recupererListe(){
        return _listeImage.getItemImage();
    }
}
