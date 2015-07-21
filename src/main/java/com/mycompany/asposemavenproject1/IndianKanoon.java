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
public class IndianKanoon {

    public static void main(String[] args) {

        try {
            UserAgent userAgent = new UserAgent();

            String content = "";
            try {
                BufferedReader in;
                in = new BufferedReader(new FileReader("/home/vishnu/Desktop/indiankanoon.html"));
                String str;
                while ((str = in.readLine()) != null) {
                    content += str;
                }
                in.close();
            } catch (IOException e) {
            }
            userAgent.openContent(content);
            Elements elements = userAgent.doc.findEach("<div class=\"result\">");
            boolean loopCheck = true;
            String textUrl;
            List dataPool1 = new ArrayList();

            while (loopCheck) {
                try {
                    System.out.println("\n");
                    //elements = table.getRow(counter);
                    for (Element element : elements) {
                        dataPool1.add(element.getChildElements().get(0).innerText());  //iterate through & print elements                    
                        textUrl = (String) element.getChildElements().get(0).findFirst("<a href>").getAt("href");
                        System.out.println(textUrl);
                        System.out.println(dataPool1);
//String nextPage = (String) element.getChildElements().get(0).findFirst("<a href>").getAt("href");
                        //userAgent.visit(nextPage);
                        dataPool1.clear();
                    }
                    loopCheck = false;
                } catch (Exception ex) {
                    System.err.println(ex);
                    loopCheck = false; // exception thrown when end of loop reached. Starting to terminate.
                }

            }

        } catch (JauntException e) {
            System.err.println(e);
        }
    }

}
