/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

/**
 *
 * @author Sukrit22
 */
public class Database {

    /** keep registered product
     *
     */
    //public static java.util.Map<String,String> fileNameOfItemId;
    
    //public static java.util.Map<String,String> fileNameOf;
    
    //not needed this can be scanned from product directory
    //public static java.util.ArrayList<String> productList;
    
    /**
     * Use to keep track of which product is on the market
     */
    public static java.util.ArrayList<AuctionProduct> activeProduct;//whenIt'sOnTheMarket
    
    /**
     * Use to keep track of which product is out of market
     * by auctioned
     */
    public static java.util.ArrayList<AuctionedProduct> auctionedProduct;//whenIt'sPassedItsEndBidDate
    
    
    
    
}
