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
            boolean loopCheck = true;
            Elements elements;
            int counter = 4, count;
            String loopCheck1, loopCheck2;
            List pdfUrl = new ArrayList();
            List dataPool1 = new ArrayList();
            
            while (loopCheck) {
                try {
                    System.out.println("\n");
                    for (count = 0; count < 7; count++) {
                        loopCheck1 = (String) table.getRow(count + counter).getChildElements().get(2).innerText();
                        loopCheck2 = (String) table.getRow(count + counter).getChildElements().get(1).innerText();
                        loopCheck1 = loopCheck1.replaceAll("&amp;", "&");
                        dataPool1.add(loopCheck1);
                        if ("".equals(loopCheck2) && "".equals(loopCheck1)) {
                            break;
                        }
                    }
                        elements = table.getRow(counter).getChildElements().get(3).findEach("<a href>");
                        for (Element element : elements) {
                            pdfUrl.add(element.getAt("href"));
                        }
                    counter = counter + count + 2;
                    System.out.println(dataPool1);
                    System.out.println(pdfUrl);
                    
                    //Write to Mongo DB
                    
                    dataPool1.clear();
                    pdfUrl.clear();
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
