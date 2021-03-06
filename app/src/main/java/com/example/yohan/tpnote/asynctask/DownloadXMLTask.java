package com.example.yohan.tpnote.asynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.example.yohan.tpnote.activity.ActivityMain;
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
public class DownloadXMLTask extends AsyncTask<String, Void, Void>
{
    private ActivityMain _activity;
    private ProgressDialog _progressBar;
    private List<Image> _listeImages;
    private SAXXMLHandler _saxHandler;

    public DownloadXMLTask(ActivityMain activity) {
        this._activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Init de la progressBar
        _progressBar = new ProgressDialog(_activity);
        _progressBar.setTitle("Chargement des images");
        _progressBar.setMessage("Veuillez patienter");
        _progressBar.setIndeterminate(false);
        _progressBar.setCancelable(true);
        _progressBar.show();
    }

    @Override
    protected Void doInBackground(String... params)
    {
        _saxHandler = new SAXXMLHandler();

        try {
            URL url = new URL(params[0]);
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
        _activity.afficherListeImage(_listeImages);
        _progressBar.dismiss();
    }
}
