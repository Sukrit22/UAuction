/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

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
    public static boolean registerProduct(String name, String description, String image, 
            Double startingBid, Double minimumBid, String username, Date endDate){
        //do what you want
        Product ap = new Product(name,description,image,startingBid,minimumBid,endDate);
        String fileName = username + "." + ap.getDatePosted().getTime() + ".txt";
        ap.setFileName(fileName);
        SaveAndLoad.saveProduct(ap);
        if(SaveAndLoad.saveProduct(ap))
            Database.activeProduct.add(new ActiveProduct(ap));
        
        //after registered the product, add it to activeProduct in Database class
        return SaveAndLoad.saveProduct(ap);
    }
    
    public static void deleteProduct(ActiveProduct ap, Date deleteDate){
        ProhibitProduct pp = new ProhibitProduct(ap, deleteDate);
        Database.prohibitProduct.add(pp);
        Database.activeProduct.remove(ap);
    }
    
    public static void endBidding(ActiveProduct ap){
        if(ap.getProduct().getDateEndBid().getTime() - ap.getProduct().getDatePosted().getTime() <= 0){
            AuctionedProduct auctioned = new AuctionedProduct(ap, ap.getCurrentBid(), (new Date()));
            Database.auctionedProduct.add(auctioned);
            Database.activeProduct.remove(ap);
        }
    }
    
    /**
     * These update function remove object form databaseArray and delete file after 1 hour
     */ 
    public static void updateProhibitProductArray(){
        for (ProhibitProduct pp : Database.prohibitProduct) {
            if((new Date()).getTime() - pp.getDeleteDate().getTime() <= 3_600_000){
                //Remove prohibitProduct form DatabaseArray
                Database.prohibitProduct.remove(pp);
                
                //Delete product file from ProductDatabase
                File file = new File(System.getProperty("user.dir") + "/AuctionDataBase/ProductDataBase/" + 
                   pp.getActiveProduct().getProduct().getFileName());
                if(file.exists())
                    file.delete();
            }
        }
    }
    
    public static void updateAuctionedProductArray(){
        for (AuctionedProduct ap : Database.auctionedProduct) {
            if((new Date()).getTime() - ap.finishedTime.getTime() <= 3_600_000){
                //Remove auctionedProduct form DatabaseArray
                Database.auctionedProduct.remove(ap);
                
                //Delete product file from ProductDatabase
                File file = new File(System.getProperty("user.dir") + "/AuctionDataBase/ProductDataBase/" + 
                   ap.getProduct().getFileName());
                if(file.exists())
                    file.delete();
            }
        }
    }
    
    public static void writeImportedImageFile(String initPath,String imageName){
        
        File initImage = new File(initPath);
        BufferedImage image = null;
        try {
            image = ImageIO.read(initImage);
            ImageIO.write(image,"jpg",new File(System.getProperty("user.dir")+"/AuctionDataBase/Image/"+imageName+ ".jpg"));
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
