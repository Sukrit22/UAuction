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
    
    public static Object login(String username, String password){
        //Boolean loginStatus = false;

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
               return "tryagainlater";
           }
        } catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return "there is no username matched";
        }
        try {
            user = (User)input.readObject();
            if(password.equals(user.password)) {
                System.out.println("that rigth");
                return user;
            }
        } catch(IOException ex) {
            System.out.println("can not read the Object");
            return "tryagainlater";
        } catch(ClassNotFoundException ex) {
            System.out.println("can not find the class");
            return "tryagainlater";
        }
        return "error";
    }
    
    public static Object register(String username,String password){
        File dirPath = new File(System.getProperty("user.dir")+"/AuctionDataBase/UserDataBase/"+ username +".txt");
        //No file occurs
        if(dirPath.exists())
            return "this username already exit please use forget password to recover your account";
        Database.userHashMap.put(username, password);
        User user = new User(username, password);
        boolean a = SaveAndLoad.saveUser(user);
        if (!a)
            return "";
        return user;
    }
}
