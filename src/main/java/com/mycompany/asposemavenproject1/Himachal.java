/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asposemavenproject1;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;
import com.jaunt.component.Table;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vishnu
 */
public class Himachal {
    public static void main(String[] args) {
        try {
            UserAgent userAgent = new UserAgent();
            
            String content = ""; // String for storing the html file
            try {
                BufferedReader in;
                in = new BufferedReader(new FileReader("/home/vishnu/Desktop/himachal_test.html"));
                String str;
                while ((str = in.readLine()) != null) {
                    content += str;
                }
                in.close();
            } catch (IOException e) {
            }
            userAgent.openContent(content); // opening html file in userAgent
            
            Table table = userAgent.doc.getTable("<table cellspacing=\"5\" cellpadding=\"5\" width=\"100%\" border=\"1\" align=\"center\">");   //get Table component via search query
            Elements elements;
            boolean loopCheck = true;
            int counter = 2;
            String pdfUrl;
            List dataPool1 = new ArrayList();

            while (loopCheck) {
                try {
                    System.out.println("\n");
                    elements = table.getRow(counter);
                    for (Element element : elements) {
                        dataPool1.add(element.innerText());  //iterate through & print elements                    
                        //
                    }
                    
                    dataPool1 = dataPool1.subList(0, dataPool1.size()-1);
                    pdfUrl = (String) elements.getChildElements().get(2).findFirst("<a href>").getAt("href");
                    String pdfUrl1 = pdfUrl.replaceAll("&amp;", "&");
                    System.out.println(pdfUrl1);
                    System.out.println(dataPool1);
                    counter++;
                    // write to mongoDB
                    dataPool1.clear();

                } catch (Exception ex) {
                    //System.err.println(ex);
                    loopCheck = false;
                }

            }
        } catch (JauntException e) {
            System.err.println(e);
        }

    }
}
