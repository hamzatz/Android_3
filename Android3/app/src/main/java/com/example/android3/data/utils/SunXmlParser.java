package com.example.android3.data.utils;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;

public class SunXmlParser {


    private String xmlString;
    private XmlPullParser parser;

    public static final String SUNRISE = "sunrise";
    public static final String SUNSET = "sunset";

    public SunXmlParser(String xmlString) throws XmlPullParserException {
        this.xmlString = xmlString;
        parser = Xml.newPullParser();
        parser.setInput(new StringReader(xmlString));
    }

    public void setXmlString(String xmlString) throws XmlPullParserException {
        this.xmlString = xmlString;
    }

    public String parse(String tag) throws XmlPullParserException, IOException {
        parser.setInput(new StringReader(xmlString));
        int eventType = parser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if(eventType == XmlPullParser.START_TAG && parser.getName().equalsIgnoreCase(tag)) {
                parser.next();
                return parser.getText();
            }

            eventType = parser.next();
        }
        return "Not found";
    }
}

