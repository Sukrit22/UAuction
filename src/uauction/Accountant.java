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
               return "try again later";
           }
        } catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return "there is no username matched";
        }
        try {
            user = (User)input.readObject();
            System.out.println("load user to be checked success");
            if(password.equals(user.password)) {
                return user;
            }
        } catch(IOException ex) {
            System.out.println("can not read the Object");
            return "try again later";
        } catch(ClassNotFoundException ex) {
            System.out.println("can not find the class");
            return "try again later";
        }
        return "error"; // this line mean unexpected error has occured
    }
    
    public static Object register(String username,String password){
        //load the path
        File dirPath = new File(System.getProperty("user.dir")+"/AuctionDataBase/UserDataBase/"+ username +".txt");
        //if there already is the file exist there
        if(dirPath.exists())
            return "this username already exit please use forget password to recover your account";
        //proceed further when the username is not registered
        Database.usernamePasswordPair.put(username, password);
        User user = new User(username, password);
        boolean a = SaveAndLoad.saveUser(user);
        if (!a)
            return "try again later";
        return user;
    }
}
