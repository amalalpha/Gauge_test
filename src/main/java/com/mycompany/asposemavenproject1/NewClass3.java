/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asposemavenproject1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vishnu
 */
public class NewClass3 {

    public static void main(String[] args) {

        Pattern p;
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        p = Pattern.compile(regex);

        Matcher m = p.matcher("http://164.100.138.36/");
        boolean k = m.matches();
        System.out.println(k);

    }
}
