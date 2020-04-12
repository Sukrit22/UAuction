/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author USER
 */
public class User implements Serializable {

    /**
     * @param args the command line arguments
     */
    
    String username ;
    String password ;
    String email;
    Date dateCreated;
    double balance = 0;
    
    public User(){
        
    }
    public User(String username,String password,String email){
        
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateCreated = new Date();               
    }
   
    public double getBalance(){
        return this.balance;
    }
    public void deposit(double balance){
        
        this.balance += balance;
    }
    public String getPassword()
    {
        return password;
    }

   

    
    
}
