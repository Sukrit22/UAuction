/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uauction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**SaveAndLoad is a class that ..
 *
 * @author Sukrit22
 */
public class SaveAndLoad {

    public static boolean saveProduct(AuctionProduct ap) {
        boolean success;
        File file;
        FileOutputStream fileOut;
        ObjectOutputStream output;
        try {
            file = new File(System.getProperty("user.dir")+"/AuctionDataBase/ProductDataBase/"+ 
                   ap.getFileName() + "." + ap.getDatePosted().getTime() + ".txt");
            fileOut = new FileOutputStream(file);
            output = new ObjectOutputStream(fileOut);
            output.writeObject(ap);
            output.close();
            fileOut.close();
            success = true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            success = false;
        }
        return success;
    }

    public static AuctionProduct loadProduct(String fileName){
        File file;
        FileInputStream fileIn;
        ObjectInputStream input;
        try {
            file = new File(System.getProperty("user.dir")+"/AuctionDataBase/ProductDataBase/"+ fileName);
            fileIn = new FileInputStream(file);
            input = new ObjectInputStream(fileIn);
            AuctionProduct ap = (AuctionProduct) input.readObject();
            input.close();
            fileIn.close();
            return ap;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static boolean saveUser(User user) {
        boolean success = false;
        
        File filePath;
        FileOutputStream file;
        ObjectOutputStream out;
        try {
            filePath = new File(System.getProperty("user.dir")+"/AuctionDataBase/UserDataBase/"+ user.username +".txt");
            file = new FileOutputStream(filePath);
            out = new ObjectOutputStream(file);
            out.writeObject(user);
            out.close();
            file.close();
            success = true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        return success;
    }

    public static User loadUser(String username) {
        File filePath;
        FileInputStream file;
        ObjectInputStream input;
        try {
            filePath = new File(System.getProperty("user.dir")+"/AuctionDataBase/UserDataBase/"+ username +".txt");
            file = new FileInputStream(filePath);
            input = new ObjectInputStream(file);
            User user = (User) input.readObject();
            input.close();
            
            return user;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static boolean saveDatabase() {
        boolean success = false;
        
        File file;
        FileOutputStream fileOut;
        ObjectOutputStream objectOutput;
        
        try {
            file = new File(System.getProperty("user.dir")+"/AuctionDataBase/DatabaseDataBase/database.txt");
            fileOut = new FileOutputStream(file);
            
            objectOutput = new ObjectOutputStream(fileOut);
            
            //Write WHat
            Database d = new Database();
            objectOutput.writeObject(d);
            objectOutput.close();
            fileOut.close();
            success = true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            
        }
        return success;
    }

    public static boolean loadDatabase() {
        File file;
        FileInputStream fileInput;
        ObjectInputStream objectInput;
        Database database = new Database();
        file = new File(System.getProperty("user.dir")+"/AuctionDataBase/DatabaseDataBase/database.txt");
        try {
            fileInput = new FileInputStream(file);
            objectInput = new ObjectInputStream(fileInput);
            database = (Database)objectInput.readObject();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("IO");
            return false;
        } catch ( ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("ClassNotFound");
            return false;
        }
        database.loadToStatic();
        return true;
    }
    
}
