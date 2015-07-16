/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asposemavenproject1;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import com.jaunt.component.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vishnu
 */
public class NewClass5 {

    public static void main(String[] args) throws NotFound, ResponseException {
        UserAgent userAgent = new UserAgent();
        try {
           userAgent.visit("http://dspace.judis.nic.in/handle/123456789/60463/browse?type=datejudgement&sort_by=2&order=ASC&rpp=5&submit_browse=Update");
            userAgent.visit("http://dspace.judis.nic.in/handle/123456789/60463/browse?type=datejudgement&sort_by=2&order=ASC&rpp=5&submit_browse=Update");
        } catch (ResponseException ex) {
            Logger.getLogger(NewClass5.class.getName()).log(Level.SEVERE, null, ex);
        }
            Table table = null;   
        try {
            table = userAgent.doc.getTable("<table class=\"miscTable\" align=\"center\" summary=\"This table browses all dspace content\">"); //get Table component via search query
        } catch (NotFound ex) {
            Logger.getLogger(NewClass5.class.getName()).log(Level.SEVERE, null, ex);
        }
            Elements elements;
            boolean loopCheck = true;
            int counter = 1;
            String pdfUrl,nextPage;
            List dataPool1 = new ArrayList();

            while (loopCheck) {
            
                    System.out.println("\n");
                    String k = table.toString();
                    System.out.print(k);
                    elements = table.getRow(counter);
                    for (Element element : elements) {
                        dataPool1.add(element.innerText());  //iterate through & print elements                    
                        //
                    }
                    //dataPool1 = dataPool1.subList(1, dataPool1.size());
                    System.out.println(dataPool1);
                    /*nextPage = (String) elements.getChildElements().get(7).findFirst("<a href>").getAt("href");
                    userAgent.visit(nextPage);
                     Table table2 = userAgent.doc.getTable("<table cellpadding=\"6\"");
                     Elements elements2 = table2.getCol(0);
                     pdfUrl = (String) elements2.findFirst("<a href>").getAt("href");
                     userAgent.visit("");
                    System.out.println(pdfUrl);
                    counter++;
                    // write to mongoDB
                    dataPool1.clear();*/

            }
    }
}


