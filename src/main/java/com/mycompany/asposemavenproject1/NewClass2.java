/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asposemavenproject1;

import com.jaunt.JauntException;
import com.jaunt.UserAgent;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.w3c.tidy.Tidy;

/**
 *
 * @author vishnu
 */
public class NewClass2 {

    public static void main(String[] args) { 

        try {
            String field = "http://stackoverflow.com/questions/26608365/how-to-validate-html-using-jtidy";
            UserAgent userAgent = new UserAgent();                       //create new userAgent (headless browser).
            String Urls = (String) field;
            userAgent.visit(Urls); 
            String htmlData;
            htmlData = (String)userAgent.doc.innerHTML();
            Tidy tidy = new Tidy();
            InputStream stream = new ByteArrayInputStream(htmlData.getBytes());
            tidy.parse(stream, System.out);
            if(tidy.getParseErrors() == 0){
                System.out.println("True");
            }else{
                System.out.println("False");
            }
        } catch (JauntException e) {         //if an HTTP/connection error occurs, handle JauntException.
            System.err.println(e);
        }
    }

}
