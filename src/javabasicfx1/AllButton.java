/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicfx1;

import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 *
 * @author Sitth
 */
public class AllButton {
    
    static public TextField searchTextField1 = new TextField();
    static public TextField searchTextField2 = new TextField();
    static public MyButton login = new MyButton("Log In", 20 , 1 , 1);
    static public MyButton logout = new MyButton("Log Out", 20 , 1 , 1);
    static public MyButton createAccount = new MyButton("Create Account", 20 , 1 , 1);
    static public MyButton myAccount = new MyButton("My Account", 20 , 1 , 1);
    static public MyButton help1 = new MyButton("Help", 20 , 1 , 1);
    static public MyButton help2 = new MyButton("Help", 20 , 1 , 1);
    
    /*
    searchTextField = new TextField();
        searchTextField.setPromptText("I'm looking for...");
        Font font = new Font(20);
        searchTextField.setFont(font);
        searchTextField.setMinSize(800, 40);
        searchTextField.setMaxSize(800, 40);
        //(String text, int font, double sizeWidth, double sizeHeight)
        login = new MyButton("Log In", 20 , 1 , 1);
        
        logout = new MyButton("Log Out", 20 , 1 , 1);
        
        createAccount = new MyButton("Create Account", 20 , 1 , 1);
        
        myAccount = new MyButton("My Account", 20 , 1 , 1);
        
        help = new MyButton("Help", 20 , 1 , 1);*/
}
