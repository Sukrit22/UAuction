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
    }
//=========================== product on market here =======================
    public static java.util.ArrayList<ActiveProduct> activeProduct = new java.util.ArrayList<ActiveProduct>()
    
 //=========================== product that is auctioned =======================
    public static java.util.ArrayList<AuctionedProduct> auctionedProduct = new java.util.ArrayList<AuctionedProduct>();
    
//=========================== this one is removed from market =======================
    public static java.util.ArrayList<ProhibitProduct> prohibitProduct = new java.util.ArrayList<ProhibitProduct>();
    
//=========================== proload username password pair =======================
    public static java.util.HashMap<String, String> usernamePasswordPair = new java.util.HashMap<String, String>();
    
//=========================== these are for load and save of static =======================
    private java.util.ArrayList<ActiveProduct> forSaveActiveProduct;
    private java.util.ArrayList<AuctionedProduct> forSaveAuctionedProduct;
    private java.util.ArrayList<ProhibitProduct> forSaveProhibitProduct;
    
    /**
     * use to load database in one command
     * @return whether load success or not
     */
    public static boolean load(){
        //give the 
        return (SaveAndLoad.loadDatabase() && true);
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
    }
    /**
     * transfer data in static database to data in object for saving
     */
    public void saveFromStatic(){
        this.forSaveActiveProduct = Database.activeProduct;
        this.forSaveAuctionedProduct = Database.auctionedProduct;
        this.forSaveProhibitProduct = Database.prohibitProduct;
    }
    
    public void loadUserToArray(){
        
    }
    public void saveArrayToUser(){
        
    }
    
    
}
