package com.example.yohan.tpnote.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.example.yohan.tpnote.asynctask.AsyncURL;
import com.example.yohan.tpnote.asynctask.DownloadImageTask;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

    public Bitmap getImgBmp() {
        return _imgBmp;
    }

    private void setImgBmp() {
        // Pas sur qu'on devrait faire ça ici
        DownloadImageTask dit = new DownloadImageTask();
        String[] url = {_url};
        dit.execute(url);

        try {
            _imgBmp = dit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
