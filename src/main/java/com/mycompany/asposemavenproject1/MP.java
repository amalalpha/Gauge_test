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
public class MP {

    public static void main(String[] args) {
        try {
            UserAgent userAgent = new UserAgent();
            String content = "";
            try {
                BufferedReader in;
                in = new BufferedReader(new FileReader("/home/vishnu/Desktop/mpj_test1.html"));
                String str;
                while ((str = in.readLine()) != null) {
                    content += str;
                }
                in.close();
            } catch (IOException e) {
            }
            userAgent.openContent(content);

            Table table = userAgent.doc.getTable("<table cellspacing=\"0\" cellpadding=\"0\" width=\"80%\" border=\"0\" align=\"center\">");   //get Table component via search query
            Elements elements,elements2;
            boolean loopCheck = true;
            int counter = 2;
            List pdfUrl = new ArrayList();
            List dataPool1 = new ArrayList();

            while (loopCheck) {
                try {
                    System.out.println("\n");
                    elements = table.getCol(counter); 
                    for (Element element : elements) {
                        //dataPool1.add(element.getChildElements().get(1).innerText());  //iterate through & print elements                    
                    System.out.println(element.innerText());
                    }

System.out.println("Hi"+counter);
//dataPool1 = dataPool1.subList(1, dataPool1.size());
                    System.out.println(dataPool1);
                    String pdfUrl1 = (String)elements.findFirst("<a href>").getAt("href");
                    //pdfUrl.add((String)elements.findEvery("<a href>").getAt("href"));
                    System.out.println(pdfUrl1);
                    counter++;
                    //Write to Mongo DB
                    dataPool1.clear();
                    userAgent.openContent(content);
                } catch (Exception ex) {
                    System.err.println(ex);
                    loopCheck = false;
                }

            }
        } catch (JauntException e) {
            System.err.println(e);
        }

    }

}
