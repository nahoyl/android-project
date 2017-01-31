package com.example.yohan.tpnote.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by Yohan on 31/01/2017.
 */

public class DownloadImageTask extends AsyncTask<String, Void, Void> {
    ImageView bmImage;
    Bitmap bmp;

    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    protected Void doInBackground(String... urls) {
        String urldisplay = urls[0];
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            bmp = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Void aVoid) {
        bmImage.setImageBitmap(bmp);
    }
}
