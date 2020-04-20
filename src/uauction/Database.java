/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

import java.io.Serializable;

/**
 *
 * @author Sukrit22
 */
public class Database implements Serializable {
    Database(){
        this.forSaveActiveProduct = new java.util.ArrayList<ActiveProduct>();
        this.forSaveAuctionedProduct = new java.util.ArrayList<AuctionedProduct>();
        this.forSaveProhibitProduct = new java.util.ArrayList<ProhibitProduct>();
        this.forSaveUserHashMap = new java.util.HashMap<String,String>();
    }
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
    public static java.util.ArrayList<ActiveProduct> activeProduct = new java.util.ArrayList<ActiveProduct>();//whenIt'sOnTheMarket
    
    /**
     * Use to keep track of which product is out of market
     * by auctioned
     */
    public static java.util.ArrayList<AuctionedProduct> auctionedProduct = new java.util.ArrayList<AuctionedProduct>();//whenIt'sPassedItsEndBidDate
    /**
     * Use to keep track of which product is delete from market
     */
    public static java.util.ArrayList<ProhibitProduct> prohibitProduct = new java.util.ArrayList<ProhibitProduct>();//whenIt'sBeenDelete
    /**
     * Use to keep User in cache to avoid loading every time when use
     */
    public static java.util.HashMap<String, String> userHashMap = new java.util.HashMap<String, String>();//whenIt'sBeenDelete
    /**
     * temporary data field used in saving and loading
     */
    private java.util.ArrayList<ActiveProduct> forSaveActiveProduct;
    /**
     * temporary data field used in saving and loading
     */            
    private java.util.ArrayList<AuctionedProduct> forSaveAuctionedProduct;
    /**
     * temporary data field used in saving and loading
     */            
    private java.util.ArrayList<ProhibitProduct> forSaveProhibitProduct;
    /**
     * temporary data field used in saving and loading
     */            
    private java.util.HashMap<String, String> forSaveUserHashMap;
    /**
     * use to load database in one command
     * @return whether load success or not
     */
    public static boolean load(){
        return SaveAndLoad.loadDatabase();
    }
    /**
     * use to save database in one command
     * @return whether save success or not
     */
    public static boolean save(){
        return SaveAndLoad.saveDatabase();
    }
    /**
     * transfer data from loaded object to static database
     */
    public void loadToStatic(){
        Database.activeProduct = this.forSaveActiveProduct;
        Database.auctionedProduct = this.forSaveAuctionedProduct;
        Database.prohibitProduct = this.forSaveProhibitProduct;
        Database.userHashMap = this.forSaveUserHashMap;
    }
    /**
     * transfer data in static database to data in object for saving
     */
    public void saveFromStatic(){
        this.forSaveActiveProduct = Database.activeProduct;
        this.forSaveAuctionedProduct = Database.auctionedProduct;
        this.forSaveProhibitProduct = Database.prohibitProduct;
        this.forSaveUserHashMap = Database.userHashMap;
    }
    
    
}
