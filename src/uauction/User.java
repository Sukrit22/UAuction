/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author USER
 */
public class User implements Serializable {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(boolean adminStatus) {
        this.adminStatus = adminStatus;
    }

    public Permission getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(Permission userPermission) {
        this.userPermission = userPermission;
    }

    public ArrayList<Product> getMyProduct() {
        return myProduct;
    }

    public void setMyProduct(ArrayList<Product> myProduct) {
        this.myProduct = myProduct;
    }

    
    /**
     * @param args the command line arguments
     */
    enum Permission{none, buyer, seller, both};
    
    private String username ;
    String password ;
    private String email;
    private Date dateCreated;
    double balance = 0;
    private boolean adminStatus;
    private Permission userPermission;
    private ArrayList<Product> myProduct;
    
    //Guest
    public User() {
        this.userPermission = Permission.none;
    }

    public User(String username,String password){
        this.username = username;
        this.password = password;
        this.dateCreated = new Date();   
        this.adminStatus = false;
        this.userPermission = Permission.none;
    }
   
    public double getBalance(){
        return this.balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public boolean withdraw(double balance){
        if (this.balance >= balance){
            this.balance -= balance;
            return true;
        }
        return false;
    }
    public void deposit(double balance){
        
        this.balance += balance;
    }
    
    public String getPassword()
    {
        return password;
    }
    public void setToSeller()
    {
         userPermission = Permission.seller;
    }
    public void setToBuyer()
    {
        userPermission = Permission.buyer;
    }
    public void setToBoth()
    {
        userPermission = Permission.both;
    }
    public void bid(double cash)
    {
        this.balance -= cash;
    }
    //Methods
    public boolean canBuy(){
        if (userPermission.equals(Permission.seller)||userPermission.equals(Permission.both))
            return true;
        return false;
    }
    public boolean canSell(){
        if (userPermission.equals(Permission.seller)||userPermission.equals(Permission.both))
            return true;
        return false;
    }

    
}
