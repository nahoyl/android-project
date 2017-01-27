package com.example.yohan.tpnote.asynctask;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Récupère une page web est la retourne sous forme de _flux.
 */
public class RecuperateurPageWeb
{
    //Attributs
    /** Contenu xml de la page.*/
    private InputStream _flux;

    /** Décrit la dernière erreur rencontrée, chaîne vide si aucune erreur.*/
    private String _messageErreur;

    /**
     * Vrai si et seulement si la récupération de la page
     * s'est effectuée sans problème, faux sinon.
     */
    private boolean _aucunProbleme;


    //Constructeurs
    /**
     * Constructeur lambda.
     * @param url : adresse web à atteindre, null interdit.
     */
    public RecuperateurPageWeb(String url)
    {
        _aucunProbleme = this.recupererLaPage(url);
    }


    //Méthodes
    /**
     * @return vrai si et seulement si $this s'est connecté correctement
     * à la page donnée, faux si une erreur est survenue.
     */
    public boolean pasDeProbleme()
    {
        return _aucunProbleme;
    }


    /**
     * @return le fichier XML située à l'adresse indiquée.
     */
    public InputStream getFlux()
    {
        return _flux;
    }


    /**
     * @return le dernier message d'erreur rencontré.
     */
    public String getErreur()
    {
        return _messageErreur;
    }


    /**
     * Connecte l'application à $url, récupère la page sous forme de _flux,
     * puis ferme la connection.
     *
     * @param url : la page à atteindre, null interdit.
     * @return vrai si et seulement si la page a pu être atteinte et
     * enregistrée sous forme de flux.
     */
    public boolean setURL(String url)
    {
        return _aucunProbleme = recupererLaPage(url);
    }


    //Privées
    /**
     * Connecte l'application à $url, récupère la page sous forme de _flux,
     * puis ferme la connection.
     *
     * @param url : la page à atteindre, null interdit.
     * @return vrai si et seulement si la page est récupérée, faux sinon.
     */
    private boolean recupererLaPage(String url)
    {
        boolean resultat;

        try {
            URL gestionnaire;
            gestionnaire = new URL(url);
            HttpURLConnection page = (HttpURLConnection) gestionnaire.openConnection();
            _flux = new BufferedInputStream(page.getInputStream());
            page.disconnect();
            _messageErreur = "Pas d'erreurs.";
            resultat = (page.getResponseCode() == HttpURLConnection.HTTP_OK);
        }
        catch(Exception e) {
            _messageErreur = e.getMessage();
            resultat = false;
        }
        return resultat;
    }
}
