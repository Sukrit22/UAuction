/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class FirstTestLoginByBeanRenamedByGame {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       Scanner input = new Scanner (System.in);
       String username = null;
       String password = null;
       String email = null;
       User user = null;
       System.out.print("Enter Username : ");
       username = input.nextLine();
       System.out.print("Enter Password : ");
       password = input.nextLine();
       System.out.print("Enter E-mail address : ");
       email = input.nextLine();
       
       System.out.println(Register.register(username,password,email)+"\n");
       
      
       
       System.out.println("----------------------Login test----------------------");    
       System.out.print("Enter Username : ");
       username = input.nextLine();
       System.out.print("Enter Password : ");
       password = input.nextLine();
        
       
       if(Login.login(username, password))
       {
            System.out.println("Login Success!!!");
            user = Login.getUser(username);
            
            System.out.println("Usernam of this User : "+user.username);
            System.out.println("Balance of this User = "+user.balance);
            System.out.println("Date created : "+user.dateCreated.toString());
            
       }
       else
       {
           System.out.println("Login Fail!!!");
       }
     
       
       //ObjectInputStream objReader = new ObjectInputStream(reader);
       
       
        //register
        //Register.regis(input.nextLine(),input.nextLine());
        
       
      
        /*System.out.println(user1.username);
        System.out.println(user1.password);*/
        /*FileInputStream reader = new FileInputStream("C:/Users/USER/OneDrive - KMITL/AuctionDataBase/Boogieman.txt");
        ObjectInputStream inpt = new ObjectInputStream(reader);
        */
       
    }            

   
  

}