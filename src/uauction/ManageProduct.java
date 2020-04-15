/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

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
    public static boolean register(String name, String description, String image, Double startingBid, Double minimumBid, String username){
        boolean isSuccess = false;
        //do what you want
        AuctionProduct product = new AuctionProduct(name, description, image, startingBid, minimumBid);
        product.setFileName(username + "." + product.getDatePosted().getTime());
        SaveAndLoad.saveProduct(product, product.getFileName());
        
        
        //after registered the product, add it to activeProduct in Database class
        
        if(isSuccess)
            return true;
        return false;
    }
    
}
