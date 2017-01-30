package com.example.yohan.tpnote.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.yohan.tpnote.asynctask.DownloadImageTask;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

/**
 * Created by Yohan on 27/01/2017.
 */

public class Image {

    private String _nom;
    private String _description;
    private String _url;
    private Bitmap _imgBmp;

    public Image() {
        _nom = null;
        _description = null;
        _url = null;
        _imgBmp = null;
    }

    public Image(String nom, String description, String url) {
        _nom = nom;
        _description = description;
        _url = url;
        setImgBmp();
    }

    public String getNom() {
        return _nom;
    }

    public String getDescription() {
        return _description;
    }

    public String getUrl() {
        return _url;
    }

    public void setNom(String nom){_nom = nom;}

    public void setDescription (String description){ _description = description;}

    public void setUrl(String url) {
        _url = url;
        setImgBmp();
    }

    public Bitmap getImgBmp() {
        return _imgBmp;
    }

    // Set la variable Bitmap _imgBmp avec le String _url de l'image.
    private void setImgBmp() {

        try {
            InputStream in = new java.net.URL(_url).openStream();
            _imgBmp = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

    }
}
