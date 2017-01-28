package com.example.yohan.tpnote.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;

/**
 * Created by Yohan on 28/01/2017.
 * OK : les InputStream sont vraiment bizarres. Après avoir lu 15000 sujets sur stackoverflow
 * il semblerait qu'on ne puisse pas utiliser "2 fois le même inputstream".
 * Je capte pas encore trop ce que ça veut dire mais dupliquer le code semble marcher pour le moment.
 * On verra ce qu'on peut réfactorer plus tard.
 * Quelque sujet SOF :
 * http://stackoverflow.com/questions/10650660/android-bitmapfactory-decodestream-returns-null
 * http://stackoverflow.com/questions/5776851/load-image-from-url
 * http://stackoverflow.com/questions/477572/strange-out-of-memory-issue-while-loading-an-image-to-a-bitmap-object/823966#823966
 */


public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap bmp = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            bmp = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return bmp;
    }

}
