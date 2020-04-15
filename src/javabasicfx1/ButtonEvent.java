/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicfx1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Sitth
 */
public class ButtonEvent {
      
    //Set All Button On Scene LogIn
    public static void buttonEventOnSceneUnLogIn(){
        
        setEvenOnSceneUnLogIn_LogIn();       
        
    }
       
    //Set All Button On Scene LogOut
    public static void buttonEvenOnSceneAlreadyLogIn(){

        setEvenOnSceneUnLogIn_LogOut();

    }
    
    //-----BUTTON----\\
    
    //-----BUTTON-OnSceneUnLogIn_LogIn-----\\
    static public void setEvenOnSceneUnLogIn_LogIn(){
        EventHandler<ActionEvent> logOut = (ActionEvent ActionEvent) -> {
            //Do code here
            System.out.println("Log Out Button Click");
            JavaBasicFX1.stage.setScene(JavaBasicFX1.sceneStorage.getHomeSceneUnLogInFromSS());
        };        
        //BUTTON Set even -> Event
        
        
    }
    
    //-----BUTTON-OnSceneUnLogIn_LogOut-----\\
    static public void setEvenOnSceneUnLogIn_LogOut(){
        EventHandler<ActionEvent> logIn = (ActionEvent ActionEvent) -> {
            System.out.println("Log Out Button Click");
            JavaBasicFX1.stage.setScene(JavaBasicFX1.sceneStorage.getHomeSceneAlreadyLogInFromSS());
        };       
        //BUTTON Set even -> Event

    }
    
    
}
