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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
/**handle register and login of a user as well as to help user manage their account
 *
 * @author Sukrit22
 */
public class Accountant {
    public static boolean login(String username, String password){
        Boolean loginStatus = false;
    
        Boolean found = true;
        FileInputStream reader = null;
        ObjectInputStream input = null;
        User user = null;
       
        try {
           reader = new FileInputStream(System.getProperty("user.dir")+"/AuctionDataBase/UserDataBase/"+username+".txt");
           try {
               input = new ObjectInputStream(reader);
           } 
           catch (IOException ex) {
               System.out.println(ex.getMessage());
           }
        } catch(FileNotFoundException ex) {
            found = false;
            System.out.println(ex.getMessage());
        }
        
        if(found) {
            try {
                user = (User)input.readObject();
            
                if(user.password.matches(password)) {
                    System.out.println("that rigth");
                    loginStatus = true;
                }
                else {
                    loginStatus = false;
                } 
            } catch(IOException ex) {
                System.out.println("can not read the Object");
            } catch(ClassNotFoundException ex) {
                System.out.println("can not find the class");
            }
        }
        return loginStatus;
    }
    
    public static boolean register(String username,String password,String email) throws IOException, ClassNotFoundException{
        File dirPath = new File(System.getProperty("user.dir")+"/AuctionDataBase/UserDataBase/"+ username +".txt");
        if(dirPath.exists())
            return false;
        return SaveAndLoad.saveUser(new User(username, password, email));
    }
}
