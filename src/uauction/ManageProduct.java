/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

import java.util.Date;
import javafx.scene.image.Image;

/**
 *
 * @author Sukrit22
 */
public class ManageProduct {
    public ManageProduct(){
        
    }
    
    /**@Deprecated
     * register product to database and add product to list that keep all product in server
     * take what AuctionProduct needs and registrant's username
     * 
     * @return whether the register is fail or succeed
     */
    public static boolean register(String name, String description, String image, Double startingBid, Double minimumBid, String username, long durationInMin){
        //do what you want
        AuctionProduct ap = new AuctionProduct(name,description,image,startingBid,minimumBid,durationInMin);
        String fileName = username + "." + ap.getDatePosted().getTime();
        ap.setFileName(fileName);
        SaveAndLoad.saveProduct(ap);
        
        
        //after registered the product, add it to activeProduct in Database class
        return SaveAndLoad.saveProduct(ap);
    }
    
}
