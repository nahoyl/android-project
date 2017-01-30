package com.example.yohan.tpnote.asynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.example.yohan.tpnote.activity.ActivityAffichePhotos;
import com.example.yohan.tpnote.model.Image;

import org.xml.sax.SAXException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Thread pour récupérer un flux depuis une page web.
 */
public class DownloadXMLTask extends AsyncTask<Void, Void, Void>
{
    /**
     * Récupère une page web d'url $params[0] et la convertit sous forme de flux.
     * Termine l'application en cas de récupération échouée.
     *
     * @param params : doit contenir un et un seul élément, l'url de la page web à atteindre.
     * @return le flux de la page web atteinte.
     */

    private ActivityAffichePhotos _activity;
    public static final String URL = "http://public.ave-comics.com/gabriel/iut/images.xml";
    public ProgressDialog progressBar;
    private List<Image> _listImages;
    private SAXXMLHandler saxHandler;

    public DownloadXMLTask(ActivityAffichePhotos activity) {
        this._activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Gestion de la progressBar
        progressBar = new ProgressDialog(_activity);
        progressBar.setTitle("Chargement des images");
        progressBar.setMessage("Veuillez patienter");
        progressBar.setIndeterminate(false);
        progressBar.setCancelable(true);
        progressBar.show();
    }

    @Override
    protected Void doInBackground(Void... params)
    {

        URL url = null;
        saxHandler = new SAXXMLHandler();
        try {
            url = new URL(URL);
            HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
            InputStream inputStream = new BufferedInputStream(httpUrl.getInputStream());

            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            saxParser.parse(inputStream, saxHandler);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        _listImages = saxHandler.getImages();
        _activity.initItemsData(_listImages);
        progressBar.dismiss();
    }
}
