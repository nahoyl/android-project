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

    private ActivityAffichePhotos _activity;
    private static final String _URL = "http://public.ave-comics.com/gabriel/iut/images.xml";
    private ProgressDialog _progressBar;
    private List<Image> _listeImages;
    private SAXXMLHandler _saxHandler;

    public DownloadXMLTask(ActivityAffichePhotos activity) {
        this._activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        _progressBar = new ProgressDialog(_activity);
        _progressBar.setTitle("Chargement des images");
        _progressBar.setMessage("Veuillez patienter");
        _progressBar.setIndeterminate(false);
        _progressBar.setCancelable(true);
        _progressBar.show();
    }

    @Override
    protected Void doInBackground(Void... params)
    {
        _saxHandler = new SAXXMLHandler();

        try {
            URL url = new URL(_URL);
            HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
            InputStream inputStream = new BufferedInputStream(httpUrl.getInputStream());

            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            saxParser.parse(inputStream, _saxHandler);

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
        _listeImages = _saxHandler.getImages();
        _activity.initItemsData(_listeImages);
        _progressBar.dismiss();
    }
}
