/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asposemavenproject1;

import com.jaunt.HttpResponse;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

/**
 *
 * @author vishnu
 */
public class NewClass1 {

    public static void main(String[] args) {

        try {
            UserAgent userAgent = new UserAgent();
            String UrlCheck;
            UrlCheck = "http://www.amazon.com/";
            userAgent.visit(UrlCheck);
            System.out.println("Response:\n" + userAgent.response);  //print response data
        } catch (ResponseException e) {                                //catch HTTP/Connection error
            HttpResponse response = e.getResponse();                 //or check userAgent.response
            if (response != null) {                                    //print response data field by field
                System.err.println("Requested url: " + response.getRequestedUrlMsg()); //print the requested url
                System.err.println("HTTP error code: " + response.getStatus());        //print HTTP error code
                System.err.println("Error message: " + response.getMessage());         //print HTTP status message
            } else {
                System.out.println("Connection error, no response!");
            }
        }

    }

}
