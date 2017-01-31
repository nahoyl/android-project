package com.example.yohan.tpnote.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yohan on 27/01/2017.
 */

public class ListeImage {
    private List<Image> _liste;

    public ListeImage(){
        this._liste = new ArrayList<>();
    }

    public ListeImage(List<Image> liste_p){
        _liste = liste_p;
    }

    public boolean addImage(String nom, String description, String url){
        Image p = new Image(nom, description, url);
        return _liste.add(p);
    }

    public boolean addAllImage(List<Image> imageList){
        return _liste.addAll(imageList);
    }

    public boolean removeImage(String nom, String description, String url){
        Image p = new Image(nom, description, url);
        return _liste.remove(p);
    }

    public List<Image>getItemImage(){
        return _liste;
    }
}
