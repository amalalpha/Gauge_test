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
public class dspace {
    
    public static void main(String[] args) {
        try {
            UserAgent userAgent = new UserAgent();
            
            String content = "";
            try {
                BufferedReader in;
                in = new BufferedReader(new FileReader("/home/vishnu/Desktop/dsapce2.html"));
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
            int counter = 2;
            String pdfUrl, nextPage;
            List dataPool1 = new ArrayList();
            
            while (loopCheck) {
                try {
                    System.out.println("\n");
                    elements = table.getRow(counter);
                    for (Element element : elements) {
                        //System.out.println("hi  "+element.innerText());
                        dataPool1.add(element.innerText());  //iterate through & print elements                                        
                    }
                    dataPool1 = dataPool1.subList(0, dataPool1.size()-1);
                    System.out.println(dataPool1);
                    nextPage = (String) elements.getChildElements().get(7).findFirst("<a href>").getAt("href");
                    userAgent.visit("http://dspace.judis.nic.in/");
                    userAgent.visit(nextPage);
                    Table table2 = userAgent.doc.getTable("<table class=miscTable>");
                    Elements elements2 = table2.getCol(0);
                    pdfUrl = (String) elements2.findFirst("<a href>").getAt("href");
                    System.out.println(pdfUrl);

                    // write to mongoDB
                    counter = counter + 2;
                    
                    dataPool1.clear();
                    //userAgent.openContent(content);
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
