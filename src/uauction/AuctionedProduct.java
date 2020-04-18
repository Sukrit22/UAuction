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
public class AuctionedProduct implements java.io.Serializable {
    /**
     * this product
     */
    public Product product;
    /**
     * the most money bidden on this product
     */
    public double maxBid;
    /**
     * Who win the auction of this product
     */
    public String username;
    /**
     * What the time when the bid is finished
     */
    public Date finishedTime;
    
    //=========================== Constructor =======================
    
    public AuctionedProduct(ActiveProduct activeProduct, double maxBid, Date finishedTime){
        this.product = activeProduct.getProduct();
        this.maxBid = maxBid;
        this.username = "";
        this.finishedTime = finishedTime;
    }
    
    //=========================== method =======================
    public String getWinner(){
        return username;
    }
    public void setWinner(String username){
        this.username = username;
    }
    public double getMaxBid(){
        return this.maxBid;
    }
    public void setMaxBid(double maxBid){
        this.maxBid = maxBid;
    }
    public Product getProduct(){
        return this.product;
    }
    
    
}
