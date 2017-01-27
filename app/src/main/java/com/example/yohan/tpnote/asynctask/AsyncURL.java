package com.example.yohan.tpnote.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Thread pour récupérer un flux depuis une page web.
 */
public class AsyncURL extends AsyncTask<String, Void, InputStream>
{
    @Override
    protected InputStream doInBackground(String... params)
    {
        String urlFichier = params[0];
        URL url;
        HttpURLConnection urlConnection;
        InputStream is;


        try {
            url = new URL(urlFichier);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            url = null;
        }

        /*
        if(url == null)
            return null;
        */

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            is = new BufferedInputStream(urlConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            is = null;
        }

        return is;
    }
    /*
    @Override
    protected void onPostExecute(InputStream result) {
        Log.i("HTTP GET","DONE");
        //ControllerPresentation.getInstance().remplirCategorie(result);
        XmlParser mapper = new XmlParser(); // XMLParser est une classe de valentin, je sais pas si on va en utliser une similair ou si ce code nous sera utile
        mapper.execute(result);
    }
    */
}
