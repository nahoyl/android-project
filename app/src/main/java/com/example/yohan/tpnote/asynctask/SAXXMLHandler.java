package com.example.yohan.tpnote.asynctask;

import com.example.yohan.tpnote.model.Image;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yohan on 28/01/2017.
 */

public class SAXXMLHandler extends DefaultHandler {
    private List<Image> images;
    private String tempVal;
    private Image tempImg;

    public SAXXMLHandler() {
        images = new ArrayList<Image>();
    }

    public List<Image> getImages() {
        return images;
    }

    // Event Handlers
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("image")) {
            // create a new instance of employee
            tempImg = new Image();
        }
        else if (qName.equalsIgnoreCase("link")){
            String attributeValue = attributes.getValue("href");
            tempImg.setUrl(attributeValue);
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("image")) {
            images.add(tempImg);
        } else if (qName.equalsIgnoreCase("name")) {
            tempImg.setNom(tempVal);
        } else if (qName.equalsIgnoreCase("description")) {
            tempImg.setDescription(tempVal);
        }


    }
}
