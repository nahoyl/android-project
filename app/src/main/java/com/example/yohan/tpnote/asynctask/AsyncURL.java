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
    /**
     * Récupère une page web d'url $params[0] et la convertit sous forme de flux.
     * Termine l'application en cas de récupération échouée.
     *
     * @param params : doit contenir un et un seul élément, l'url de la page web à atteindre.
     * @return le flux de la page web atteinte.
     */
    @Override
    protected InputStream doInBackground(String... params)
    {
        RecuperateurPageWeb rpw = new RecuperateurPageWeb(params[0]);

        if (! rpw.pasDeProbleme()) {
            Log.i("Erreur", rpw.getErreur());
            System.exit(1);
        }
        return rpw.getFlux();
    }

    //TODO : faire une méthode onProgress (le TP demande une barre de progression).
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
