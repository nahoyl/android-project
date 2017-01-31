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
    private List<Image> _images;
    private String _tempVal;
    private Image _tempImg;

    public SAXXMLHandler() {
        _images = new ArrayList<Image>();
    }

    public List<Image> getImages() {
        return _images;
    }

    // Event Handlers
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("image")) {
            // create a new instance of employee
            _tempImg = new Image();
        }
        else if (qName.equalsIgnoreCase("link")){
            String attributeValue = attributes.getValue("href");
            _tempImg.setUrl(attributeValue);
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        _tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("image")) {
            _images.add(_tempImg);
        } else if (qName.equalsIgnoreCase("name")) {
            _tempImg.setNom(_tempVal);
        } else if (qName.equalsIgnoreCase("description")) {
            _tempImg.setDescription(_tempVal);
        }


    }
}
