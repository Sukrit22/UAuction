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
import javafx.scene.image.Image;

/**SaveAndLoad is a class that ..
 *
 * @author Sukrit22
 */
public class SaveAndLoad {

    public static boolean saveProduct(Product ap) {
//        try {
            //        boolean success;
//        File file;
//        FileOutputStream fileOut;
//        ObjectOutputStream output;
//        try {
//            file = new File(System.getProperty("user.dir")+"/AuctionDataBase/ProductDataBase/"+ ap.getFileName());
//            System.out.println("1");
//            fileOut = new FileOutputStream(file);
//            System.out.println("2");
//            output = new ObjectOutputStream(fileOut);
//            System.out.println("3");
//            output.writeObject(ap);
//            output.close();
//            fileOut.close();
//            success = true;
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//            System.out.println("SavePro????");
//            success = false;
//        }
//        return success;

            File filePath;
            FileOutputStream file;
            ObjectOutputStream out;
            try {
                filePath = new File(System.getProperty("user.dir") + "/AuctionDataBase/ProductsDataBase/" + ap.getFileName());
                file = new FileOutputStream(filePath);
                out = new ObjectOutputStream(file);
                out.writeObject(ap);
                out.close();
                file.close();
                return true;
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                //error with io, saving process
                return false;
            }

    }

    public static Product loadProduct(String fileName){
        File file;
        FileInputStream fileIn;
        ObjectInputStream input;
        try {
            file = new File(System.getProperty("user.dir")+"/AuctionDataBase/ProductsDataBase/"+ fileName);
            fileIn = new FileInputStream(file);
            input = new ObjectInputStream(fileIn);
            Product ap = (Product) input.readObject();
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
        //save the user to txt file
        File filePath;
        FileOutputStream file;
        ObjectOutputStream out;
        try {
            filePath = new File(System.getProperty("user.dir")+"/AuctionDataBase/UserDataBase/"+ user.getUsername() +".txt");
            file = new FileOutputStream(filePath);
            out = new ObjectOutputStream(file);
            out.writeObject(user);
            out.close();
            file.close();
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            //error with io, saving process
            return false;
        }
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
        
        File file;
        FileOutputStream fileOut;
        ObjectOutputStream objectOutput;
        
        try {
            file = new File(System.getProperty("user.dir")+"/AuctionDataBase/DatabaseDataBase/database.txt");
            fileOut = new FileOutputStream(file);
            
            objectOutput = new ObjectOutputStream(fileOut);
            
            //Write WHat
            Database d = new Database();
            d.saveFromStatic();
            objectOutput.writeObject(d);
            objectOutput.close();
            fileOut.close();
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
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
    
        //public static Image loadImageClient(String imageName){ //ถ้ามีไฟล์จะโหลดขึ้นมาจาก imageName ถ้าไม่มีจะขอ server โดยส่งfileNameไป
        //Image image = new Image("file:///"+System.getProperty("user.dir")+"/AuctionDataBase/Image/"+imageName+".png");
            
        //return (new Image());
    //}
    
}
