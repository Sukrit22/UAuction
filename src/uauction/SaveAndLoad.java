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
public class SaveAndLoad implements SaveAndLoadAbility {

    @Override
    public void saveProduct(AuctionProduct ap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AuctionProduct loadProduct(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveUser(User user) {
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

    @Override
    public User loadUser(String username) {
        File filePath;
        FileInputStream file;
        ObjectInputStream input;
        try {
            filePath = new File(System.getProperty("user.dir")+"/AuctionDataBase/UserDataBase/"+ username +".txt");
            file = new FileInputStream(filePath);
            input = new ObjectInputStream(file);
            User user = (User) input.readObject();
            return user;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean saveDatabase() {
        boolean success = false;
        
        File filePath;
        FileOutputStream file;
        ObjectOutputStream output;
        
        try {
            filePath = new File(System.getProperty("user.dir")+"/AuctionDataBase/DatabaseDataBase/database.txt");
            file = new FileOutputStream(filePath);
            output = new ObjectOutputStream(file);
            
            //Write WHat
            
            output.close();
            file.close();
            
            success = true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        return success;
    }

    @Override
    public void loadDatabase() {
        File filePath;
        FileInputStream file;
        ObjectInputStream input;
        try {
            filePath = new File(System.getProperty("user.dir")+"/AuctionDataBase/DatabaseDataBase/database.txt");
            file = new FileInputStream(filePath);
            input = new ObjectInputStream(file);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
