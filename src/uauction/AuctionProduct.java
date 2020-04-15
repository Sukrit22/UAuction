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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

/**
 *
 * @author Sukrit22
 */
public class AuctionProduct {
    //private java.util.ArrayList<javafx.scene.image.Image> additionalImage;
    
    private File ImagePath = new File(System.getProperty("user.dir")+"/AuctionDataBase/ProductImage/"+this.name+".png");
    private Image image;
    
    private String name;
    private String description;
    private String myFileName;
    
    private double startingBid;
    private double minimumBid;
    
    private java.util.Date datePosted;
    private java.util.Date dateEndBid;
    
            
            
    public AuctionProduct(String name, String description, Image image, double startingBid, double minimumBid){
        datePosted = new Date();
        this.name = name;
        this.description = description;
        this.startingBid = startingBid;
        this.minimumBid = minimumBid;
    }
    
    public void setImage()
    {
        try 
        {
            FileInputStream input = new FileInputStream(ImagePath);
            image = new Image(input);
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println(ex.toString());
        }
    }
    
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }
    public Date getDatePosted()
    {
        return datePosted;
    }
    public Date getDateEndBid()
    {
        return dateEndBid;
    }
    public String getFileName(){
        return this.myFileName;
    }
    public void setFileName(String fileName){
        this.myFileName = fileName;
    }
    
}
