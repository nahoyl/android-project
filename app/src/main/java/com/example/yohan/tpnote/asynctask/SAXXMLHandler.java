package com.example.yohan.tpnote.asynctask;

import com.example.yohan.tpnote.model.Image;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yohan on 27/01/2017.
 */

public class SAXXMLHandler extends DefaultHandler {

/*
    private List<Image> images;
    private String tempVal;
    private Image tempImg;

    public SAXXMLHandler() {
        images = new ArrayList<Image>();
    }

    public List<Image> getEmployees() {
        return images;
    }

    // Event Handlers
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        // reset
        tempVal = "";
        if (qName.equalsIgnoreCase("employee")) {
            // create a new instance of employee
            tempImg = new Image();
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("employee")) {
            // add it to the list
            images.add(tempImg);
        } else if (qName.equalsIgnoreCase("id")) {
            tempImg.setId(Integer.parseInt(tempVal));
        } else if (qName.equalsIgnoreCase("name")) {
            tempImg.setName(tempVal);
        } else if (qName.equalsIgnoreCase("department")) {
            tempImg.setDepartment(tempVal);
        } else if (qName.equalsIgnoreCase("type")) {
            tempImg.setType(tempVal);
        } else if (qName.equalsIgnoreCase("email")) {
            tempImg.setEmail(tempVal);
        }
    }
    */
}

