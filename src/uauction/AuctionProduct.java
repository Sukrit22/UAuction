/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

import java.util.Date;

/**
 *
 * @author Sukrit22
 */
public class AuctionProduct {
    private javafx.scene.image.Image mainImage;
    //private java.util.ArrayList<javafx.scene.image.Image> additionalImage;
    
    private String name;
    private String description;
    
    private Double startingBid;
    private Double minimumBid;
    
    private java.util.Date datePosted;
    private java.util.Date dateEndBid;
    
    
    AuctionProduct(String name,String descriotion,double startingBid,double minimumBid,long durationInMin){
        this.name = name;
        this.description = descriotion;
        this.startingBid = startingBid;
        this.minimumBid = minimumBid;
        datePosted = new Date();
        dateEndBid.setTime(datePosted.getTime()+ durationInMin*60*1000);
        
    }
}
