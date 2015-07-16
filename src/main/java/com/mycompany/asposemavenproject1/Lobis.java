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
public class Lobis {

    public static void main(String[] args) {
        try {
            UserAgent userAgent = new UserAgent();
            
            String content = "";
            try {
                BufferedReader in;
                in = new BufferedReader(new FileReader("/home/vishnu/Desktop/lobis_test1.html"));
                String str;
                while ((str = in.readLine()) != null) {
                    content += str;
                }
                in.close();
            } catch (IOException e) {
            }
            userAgent.openContent(content);
            
            Table table = userAgent.doc.getTable("<table width=\"46%\" border=\"1\" align=\"center\">");   //get Table component via search query
            Elements elements;
            boolean loopCheck = true;
            int counter = 1;
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
                    dataPool1 = dataPool1.subList(1, dataPool1.size());
                    System.out.println(dataPool1);
                    pdfUrl = (String) elements.getChildElements().get(1).findFirst("<a href>").getAt("href");
                    System.out.println(pdfUrl);
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
