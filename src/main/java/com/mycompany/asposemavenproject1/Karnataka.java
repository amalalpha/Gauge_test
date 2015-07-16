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
import java.util.*;

/**
 *
 * @author vishnu
 */
public class Karnataka {

    public static void main(String[] args) {
        try {
            UserAgent userAgent = new UserAgent();
            String content = "";
            try {
                BufferedReader in;
                in = new BufferedReader(new FileReader("/home/vishnu/Desktop/karnataka_test.html"));
                String str;
                while ((str = in.readLine()) != null) {
                    content += str;
                }
                in.close();
            } catch (IOException e) {
            }
            userAgent.openContent(content);
            
            Table table = userAgent.doc.getTable("<table class=miscTable>");   //get Table component via search query
            Elements elements;
            boolean loopCheck = true;
            int counter = 1;
            String nextPage;
            String pdfUrl;
            List dataPool1 = new ArrayList();

            while (loopCheck) {
                try {
                    System.out.println("\n");
                    elements = table.getRow(counter);                                               //get row at row index 0.
                    int count = 0;
                    for (Element element : elements) {
                        dataPool1.add(element.innerText());  //iterate through & print elements                    
                    //
                    }
                    
                    dataPool1 = dataPool1.subList(1, dataPool1.size());
                    System.out.println(dataPool1);
                    nextPage = (String) elements.getChildElements().get(0).findFirst("<a href>").getAt("href");
                    userAgent.visit(nextPage);
                     Table table2 = userAgent.doc.getTable("<table cellpadding=\"6\"");
                     Elements elements2 = table2.getCol(0);
                     pdfUrl = (String) elements2.findFirst("<a href>").getAt("href");
                     
                    System.out.println(pdfUrl);
                    counter++;
                    //Write to Mongo DB
                    dataPool1.clear();
                    userAgent.openContent(content);
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
