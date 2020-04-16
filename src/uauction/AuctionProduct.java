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
public class AuctionProduct implements java.io.Serializable {
    //private java.util.ArrayList<javafx.scene.image.Image> additionalImage;
    
    private String imageName;
    
    private String name;
    private String description;
    private String myFileName;
    
    private double startingBid;
    private double minimumBid;
    
    private java.util.Date datePosted;
    private java.util.Date dateEndBid;
    
            
            
    public AuctionProduct(String name, String description, String imageName, double startingBid, double minimumBid,long durationInMin){
        datePosted = new Date();
        dateEndBid.setTime(datePosted.getTime()+ durationInMin*60*1000);
        this.name = name;
        this.description = description;
        this.startingBid = startingBid;
        this.minimumBid = minimumBid;
        this.imageName = imageName;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Date getDatePosted(){
        return datePosted;
    }
    public Date getDateEndBid(){
        return dateEndBid;
    }
    public String getFileName(){
        return this.myFileName;
    }
    public void setFileName(String fileName){
        this.myFileName = fileName;
    }
    public String getImageName(){
        return this.imageName;
    }

    public double getStartingBid() {
        return startingBid;
    }

    public double getMinimumBid() {
        return minimumBid;
    }
    
}
