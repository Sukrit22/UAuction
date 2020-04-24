/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author Sukrit22
 */
public class ManageProduct {
    public ManageProduct(){
        
    }
    
    /**
     * @param name * @Deprecated
     * register product to database and add product to list that keep all product in server
     * take what AuctionProduct needs and registrant's username
     * @param description
     * @param image
     * @param startingBid
     * @param minimumBid
     * @param username
     * @param endDate
     * 
     * @return whether the register is fail or succeed
     */
    /*public static void registerProduct(String name, String description, String image, 
        Double startingBid, Double minimumBid, Date endDate){
        //do what you want
        Product ap = new Product(name,description,startingBid,minimumBid,endDate);
        String fileName = name + "." + ap.getDatePosted().getTime() + ".txt";
        ap.setFileName(fileName);
        SaveAndLoad.saveProduct(ap);
        if(SaveAndLoad.saveProduct(ap))
            Database.activeProduct.add(new ActiveProduct(ap));
        
        //after registered the product, add it to activeProduct in Database class
        
    }*/
    public static void registerProduct(Product product,BufferedImage image)
    {
        System.out.println(image==null);
        String fileName = product.getMyOwnerName()+ "." + product.getDatePosted().getTime() + ".txt";
        String imageName = product.getMyOwnerName()+ "." + product.getDatePosted().getTime() + ".jpg";
        product.setFileName(fileName);
        product.setImageName(imageName);
        //SaveAndLoad.saveProduct(product);
        try {
            ImageIO.write(image, /*imageName.substring(imageName.length() - 3, imageName.length() - 1)*/"jpg", new File(System.getProperty("user.dir") + "/AuctionDataBase/Image/" + imageName));
            SaveAndLoad.saveProduct(product);
            Database.activeProduct.add(new ActiveProduct(product));

        } catch (IOException ex) {
            System.out.println("save Image fail after saved product");
            System.out.println(ex.getMessage());
        }
    }

    
        
    public static void deleteProduct(ActiveProduct ap, Date deleteDate){
        ProhibitProduct pp = new ProhibitProduct(ap, deleteDate);
        Database.prohibitProduct.add(pp);
        Database.activeProduct.remove(ap);
    }
    
    public static void endBidding(ActiveProduct ap){
        if(ap.getProduct().getDateEndBid().getTime() - ap.getProduct().getDatePosted().getTime() <= 0){
            AuctionedProduct auctioned = new AuctionedProduct(ap);
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
    //=========================== อะไรวะ ภูมิมาดูดิ๊ =======================
//    public static void updateAuctionedProductArray(){
//        for (AuctionedProduct ap : Database.auctionedProduct) {
//            if((new Date()).getTime() - ap.finishedTime.getTime() <= 3_600_000){
//                //Remove auctionedProduct form DatabaseArray
//                Database.auctionedProduct.remove(ap);
//                
//                //Delete product file from ProductDatabase
//                File file = new File(System.getProperty("user.dir") + "/AuctionDataBase/ProductDataBase/" + 
//                   ap.getProduct().getFileName());
//                if(file.exists())
//                    file.delete();
//            }
//        }
//    }
    
//    public static void registerImage(BufferedImage image/*product.getFilename*/,String imageName) throws IOException 
//    {
//        File file = new File(System.getProperty("user.dir")+"/AuctionDataBase/Image/"+imageName);
//        ImageIO.write(image,"jpg",file);
//    }
    
    
    //called by client----------------------------------------------------------------------
    //client have to creat BufferedImage instance to recive this method returned object and send to ImPr()
    public static BufferedImage ImportImageFile(String initPath){
        
        File initImage = new File(initPath);
        BufferedImage bufferedimage = null;
        try {
            bufferedimage = ImageIO.read(initImage);
            
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return bufferedimage;
    }
}
//when user register product 
//1.call product constructor
//2.create BufferedImage's instance to reciev ImportImageFile method's returned object
//3.group 1&2 by calling ImPr clss's constructor
//4.send to server
