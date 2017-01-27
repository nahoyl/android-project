package com.example.yohan.tpnote.controleur;

import android.content.Context;

import com.example.yohan.tpnote.model.Categorie;
import com.example.yohan.tpnote.model.Image;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Yohan on 27/01/2017.
 */

public class ControleurCategories {
    private Categorie _categorie;
    private Context _context;

    public ControleurCategories(Context context){
        this._context = context;
        _categorie = new Categorie();

    }

    public boolean ajouterImage(String nom, String description, InputStream url){
        return _categorie.addImage(nom, description, url);
    }

    public boolean ajouterTousImage(List<Image> imageList){
        return _categorie.addAllImage(imageList);
    }

    public boolean supprimerImage(String nom, String description, InputStream url){
        return _categorie.removeImage(nom, description, url);
    }

    public List<Image> recupererListe(){
        return _categorie.getItemImage();
    }
}
