/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicfx1.Scene.HomeScene.Template;

import javabasicfx1.MyButton;
import javabasicfx1.AllButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 *
 * @author Sitth
 */
//---- TextField --- Button(MyButton) --- Logo ----\\
public class TopPaneTemplate {

    private Pane pane;
    

    public TopPaneTemplate() {
        topPaneTemplate();
    }

    private void topPaneTemplate() {
        pane = new Pane();
        pane.setMaxSize(1920, 250);
        pane.setMinSize(1920, 250);
        
        
        
    }
    
    
    
    public Pane getPaneUnLogIn() {        
        HBox hboxButton = new HBox();
        hboxButton.getChildren().addAll(AllButton.help1.getButton(), AllButton.login.getButton(), AllButton.createAccount.getButton());
        hboxButton.setSpacing(20);
        hboxButton.setLayoutX(1460);
        hboxButton.setLayoutY(80);
        MyButton.btnTime1.setLayoutX(1580);
        MyButton.btnTime1.setLayoutY(20);
        TextField searchTextField = new TextField();
        searchTextField = AllButton.searchTextField1;
        searchTextField.setPromptText("I'm looking for...");
        Font font = new Font(20);
        searchTextField.setFont(font);
        searchTextField.setMinSize(800, 40);
        searchTextField.setMaxSize(800, 40);
        searchTextField.setLayoutX(500);
        searchTextField.setLayoutY(50);
        pane.getChildren().addAll(hboxButton, MyButton.setAndGetBtnTime(MyButton.btnTime1), searchTextField);
        return pane;
    }
    
    public Pane getPaneAlreadyLogIn() {
        HBox hboxButton = new HBox();
        hboxButton.getChildren().addAll(AllButton.help2.getButton(), AllButton.logout.getButton(), AllButton.myAccount.getButton());
        hboxButton.setSpacing(20);
        hboxButton.setLayoutX(1460);
        hboxButton.setLayoutY(80);
        MyButton.btnTime1.setLayoutX(1580);
        MyButton.btnTime1.setLayoutY(20);
        TextField searchTextField = new TextField();
        searchTextField = AllButton.searchTextField2;
        searchTextField.setPromptText("I'm looking for...");
        Font font = new Font(20);
        searchTextField.setFont(font);
        searchTextField.setMinSize(800, 40);
        searchTextField.setMaxSize(800, 40);
        searchTextField.setLayoutX(500);
        searchTextField.setLayoutY(50);
        pane.getChildren().addAll(hboxButton, searchTextField);
        return pane;
    }

}
