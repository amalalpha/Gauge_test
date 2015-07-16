/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asposemavenproject1;

/**
 *
 * @author vishnu
 */
import com.jaunt.*;
import com.jaunt.util.HandlerForText;
import java.io.File;
import java.io.IOException;


public class NewClass{
  public static void main(String[] args) throws IOException{
    try{
      UserAgent userAgent = new UserAgent();
     
      //userAgent.visit("http://164.100.138.36/casest/generatenew.php?path=data/judgment/2013old/&fname=ARB.C372004.pdf&smflag=N");
      String s = "http://judis.nic.in/Judis_Jammu/qrydisp.aspx?filename=1649";
      
      String path1 = "/home/vishnu/test1.txt"; 
      File path2 = new File(path1);
      System.out.println(path2.getAbsolutePath());
      userAgent.download(s,path2);
      
    }
    catch(JauntException e){
      System.out.println(e);
    } 
  }
}

