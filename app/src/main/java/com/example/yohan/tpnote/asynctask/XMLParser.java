package com.example.yohan.tpnote.asynctask;

import com.example.yohan.tpnote.model.Image;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Yohan on 27/01/2017.
 */

public class XMLParser {
    public XMLParser(){}

    public List<Image> parse(String[] urlPageWeb){

        DownloadXMLTask au = new DownloadXMLTask();
        au.execute(urlPageWeb);
        InputStream is = null;

        try {
            is=au.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        List<Image> liste_image = new ArrayList<>();

        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            Element element=doc.getDocumentElement();
            element.normalize();

            NodeList nList = doc.getElementsByTagName("image");

            for (int i=0; i<nList.getLength(); i++) {

                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element2 = (Element) node;
                    String nom = getValue("name", element2);
                    String desc = getValue("description", element2);
                    String url = gethrefValue("link", element2);

                    Image img = new Image(nom, desc, url);
                    liste_image.add(img);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();

        }


        return liste_image;
    }

    private static String getValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    private static String gethrefValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag);
        Node node = nodeList.item(0);
        return node.getAttributes().getNamedItem("href").getNodeValue();
    }
}
