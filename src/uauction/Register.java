/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Register {
    
    public static String register(String username,String password,String email) throws IOException, ClassNotFoundException
    {
        Boolean chosen = false;
        /*
        if condition check for any same account
        */
        
        
        File file = new File(System.getProperty("user.dir")+"/AuctionDataBase/"+username+".txt");
       
        
        /*File usernameFile = new File("C:/Users/USER/OneDrive - KMITL/AuctionDataBase/USERNAMES.txt");
        File pathFile = new File("C:/Users/USER/OneDrive - KMITL/AuctionDataBase/PATH.txt");*/
        
       
        
        if(file.exists())
        {
            chosen = true;
        }
               
        else{
        FileOutputStream writer = new FileOutputStream(file);
        ObjectOutputStream output = new ObjectOutputStream(writer);
        try{
        output.writeObject(new User(username,password,email));
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        output.close();
        writer.close();
        
        }
        if(chosen)
        {
           return username+" is Chosen...";
        }
        return "Register Success...";
        
      
        
        
    }
    public static boolean search(File dirPath,String name)
    {

        File files[] = null;
        if(dirPath.isDirectory())
        {
            files = dirPath.listFiles();
            for(File dirFiles:files)
            {
                      if(dirPath.getName() == name+".txt")
                        {
                            return true;
                            
                        }
        
        }
       /* else
        {
            if(dirPath.getName().endsWith(".txt"))
            {
                if(dirPath.getName() == name)
                        {
                            return dirFiles;
                        }
            }
        }
       */ 
        
    }
    return false;
}
}