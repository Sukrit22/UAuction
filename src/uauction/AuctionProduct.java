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
    private javafx.scene.image.Image mainImage;
    //private java.util.ArrayList<javafx.scene.image.Image> additionalImage;
    
    private File ImagePath = new File(System.getProperty("user.dir")+"/AuctionDataBase/ProductImage/"+this.name+".png");
    private Image image;
    
    private String name;
    private String description;
    
    private Double startingBid;
    private Double minimumBid;
    
    private java.util.Date datePosted;
    private java.util.Date dateEndBid;
    
    private boolean registable = false;
    
            
            
    public AuctionProduct(String name,String catalog,String descriotion,double startingBid,double minimumBid,long durationInMin){
        if(registerProduct()){
        this.name = name;
        this.description = descriotion;
        this.startingBid = startingBid;
        this.minimumBid = minimumBid;
        datePosted = new Date();
        dateEndBid.setTime(datePosted.getTime()+ durationInMin*60*1000);
        registable = true;
        }
        else
        {
            registable = false;
        }
        
        //mainImage = new javafx.scene.image.Image();
    }
    
    public Boolean registerProduct()
    {
        boolean registed = false;
        try 
        {
            FileOutputStream reader = new FileOutputStream(ImagePath);
            try 
            {
                ObjectOutputStream objReader = new ObjectOutputStream(reader);
            } 
            catch (IOException ex) 
            {
                System.out.println(ex.toString());
            }
            
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println(ex.toString());
        }
        
        return registed;
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
    public Date getDateposted()
    {
        return datePosted;
    }
    public Date getDateEndBid()
    {
        return dateEndBid;
    }
    
}
