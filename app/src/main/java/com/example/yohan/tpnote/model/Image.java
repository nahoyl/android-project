package com.example.yohan.tpnote.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;

/**
 * Created by Yohan on 27/01/2017.
 */

public class Image {

    private String _nom;
    private String _description;
    private Bitmap _url;

    public Image(){
        _nom = null;
        _description = null;
        _url = null;
    }

    public Image(String nom, String description, InputStream url){
        _nom = nom;
        _description = description;
        _url = BitmapFactory.decodeStream(url);

    }

    public String getNom(){
        return _nom;
    }

    public String getDescription(){
        return _description;
    }

    public Bitmap getUrl(){
        return _url;
    }
}
