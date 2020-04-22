/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

import java.awt.image.BufferedImage;
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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Sukrit22
 */
public final class Product implements java.io.Serializable {
    //private java.util.ArrayList<javafx.scene.image.Image> additionalImage;
    
    private String imageName=null;
    
    private String name;
    private String description;
    private String myFileName;
    
    private double startingBid;
    private double minimumBid;
    
    private java.util.Date datePosted;
    private java.util.Date dateEndBid;
    
    private Image image;
            
            
    public Product(String name, String description, double startingBid, double minimumBid,Date endDate){
        datePosted = new Date();
        dateEndBid = endDate;
        this.name = name;
        this.description = description;
        this.startingBid = startingBid;
        this.minimumBid = minimumBid;
        
        
        //image = new Image(System.getProperty("user.dir")+"/AuctionDataBase/Image/"+ this.getImageName()+ ".jpg"); บอกว่าไม่เอา
        //ใช้ imageName ไปหา ถ้าไม่เจอจะขอจากเซิฟ
    }
    /*
    public Product(String name, String description, String imageName,String initImagePath, double startingBid, double minimumBid,Date endDate){
    
        datePosted = new Date();
        dateEndBid = endDate;
        this.name = name;
        this.description = description;
        this.startingBid = startingBid;
        this.minimumBid = minimumBid;
        this.imageName = imageName;
        ManageProduct.writeImportedImageFile(initImagePath,imageName);
        image = new Image(System.getProperty("user.dir")+"/AuctionDataBase/Image/"+imageName+ ".jpg");
        
    }*/ //ไม่จำเป็น
    
    
    public void setImage(String imageName)
    {
        this.imageName = imageName;
    }
    public String getImageName(){
        return this.imageName;
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
    public void setImageName(String newImageName)
    {
        this.imageName = newImageName;
    }
    public double getStartingBid() {
        return startingBid;
    }
    public double getMinimumBid() {
        return minimumBid;
    }
    public Image getImage()
    {
       
        return image;
    }
}
