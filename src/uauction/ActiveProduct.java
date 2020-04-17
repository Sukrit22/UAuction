/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

import java.util.ArrayList;

/**
 *
 * @author Sukrit22
 */
public class ActiveProduct implements java.io.Serializable {
    //=========================== dataField =======================
    /**
     * bidding history compose to username+":"currentBid
     */
    private java.util.ArrayList<String> biddingHistory;
    /**
     * the currentBid at the moment
     */
    private double currentBid;
    /**
     * the product to keep track
     */
    private final Product product;
    //=========================== Constructor =======================
    ActiveProduct(Product product){
        this.product = product;
        this.biddingHistory = new java.util.ArrayList<String>();
        this.currentBid = this.product.getStartingBid();
    }
    
    //=========================== method =======================

    public ArrayList<String> getBiddingHistory() {
        return biddingHistory;
    }

    public void setBiddingHistory(ArrayList<String> biddingHistory) {
        this.biddingHistory = biddingHistory;
    }
    
    public void addBiddingHistory(String lastBidder){
        this.biddingHistory.add(lastBidder);
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    public Product getProduct() {
        return product;
    }
}
