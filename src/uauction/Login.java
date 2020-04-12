/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public  class Login {
    
    
   public static User getUser(String username) throws FileNotFoundException, IOException, ClassNotFoundException
   {
       FileInputStream reader = new FileInputStream(System.getProperty("user.dir")+"/AuctionDataBase/"+username+".txt");
       ObjectInputStream input = new ObjectInputStream(reader);
       User user = (User)input.readObject();
       
       return user;
   }
    
    public static Boolean login(String username, String password) {
        
       Boolean loginStatus = false;
    
       Boolean found = true;
       FileInputStream reader = null;
       ObjectInputStream input = null;
       User user = null;
       
        try 
        {
            reader = new FileInputStream(System.getProperty("user.dir")+"/AuctionDataBase/"+username+".txt");
            
            
           try {
               input = new ObjectInputStream(reader);
           } 
           catch (IOException ex) {
               System.out.println(ex.getMessage());
           }
        }
        catch(FileNotFoundException ex)
        {
            found =false;
            System.out.println(ex.getMessage());
        }
        
        if(found)
        {
            
            try
            {
            user = (User)input.readObject();
            
                
                
            if(user.password.matches(password))
            {
                System.out.println("that rigth");
                loginStatus = true;
            }
            else
            {
                loginStatus = false;
            }
            }
            catch(IOException ex)
            {
                System.out.println("can not read the Object");
            }
            catch(ClassNotFoundException ex)
            {
                System.out.println("can not find the class");
            }
            
            
        }
            
        
                
    
   return loginStatus;
}
}


