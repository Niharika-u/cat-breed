package com.example.multiactivitycats;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

class CatFromXml {
    private ArrayList<Cat> cats;
    private Context context;

    public CatFromXml(Context context) {
        this.context = context;
        //open a stream to the XML file + docuilder + doc

        InputStream stream = null;
        DocumentBuilder builder = null;
        Document xmlDoc = null;

        try {
            stream = this.context.getResources().openRawResource(R.raw.cat);
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmlDoc = builder.parse(stream);

        } catch (Exception e) {

        }

        //slice xmlDoc to node list
        NodeList breedList = xmlDoc.getElementsByTagName("breed");
        NodeList sizeList = xmlDoc.getElementsByTagName("size");
        NodeList eyeColorList = xmlDoc.getElementsByTagName("eyecolor");
        NodeList imageList = xmlDoc.getElementsByTagName("image");
        NodeList thumbnailList = xmlDoc.getElementsByTagName("thumbnail");
        NodeList descriptionList = xmlDoc.getElementsByTagName("description");
        NodeList shortDescriptionList = xmlDoc.getElementsByTagName("shortdescription");
        NodeList furTypeList = xmlDoc.getElementsByTagName("furtype");
        NodeList foundInList = xmlDoc.getElementsByTagName("foundin");
        NodeList moreInfoUrl = xmlDoc.getElementsByTagName("moreinfourl");


        //make People
        cats = new ArrayList<>();
        for (int i =0;i<breedList.getLength();i++) {
            String breed = breedList.item(i).getFirstChild().getNodeValue();
            String size = sizeList.item(i).getFirstChild().getNodeValue();
            String eyeColor = eyeColorList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String thumbnail = thumbnailList.item(i).getFirstChild().getNodeValue();
            String description = descriptionList.item(i).getFirstChild().getNodeValue();
            String shortDescription = shortDescriptionList.item(i).getFirstChild().getNodeValue();
            String furType = furTypeList.item(i).getFirstChild().getNodeValue();
            String foundIn = foundInList.item(i).getFirstChild().getNodeValue();
            String moreInfo = moreInfoUrl.item(i).getFirstChild().getNodeValue();


            cats.add( new Cat(breed, size, eyeColor, image, thumbnail, description, shortDescription,
                    furType,foundIn,moreInfo));
        }
    }

    public int getLength() {
        return cats.size();
    }

    public Cat getCat(int index) {
        return cats.get(index);
    }



    public ArrayList<Cat> getAllCats() {
        return this.cats;
    }

}


