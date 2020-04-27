/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene.Home.MyAccount;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import AuctionMain.CreateButton;

/**
 *
 * @author Sitth
 */
public class MyProfliePane {

    static public Pane pane;
    static private Text nameText;

    static public Pane getAndSetPane() {
        pane = new Pane();
        pane.setMinSize(1920, 1080);
        Font font = new Font(24);
        nameText = new Text(" Name ");
        VBox nameTextPane = new VBox(nameText);
        nameText.setFont(font);
        
        
        
        Button edit = new Button("Edit Profile");
        edit.setMinSize(150, 30);
        edit.setLayoutX(1920-200-150);
        edit.setLayoutY(0);
        pane.getChildren().addAll(nameTextPane, CreateButton.buttonEditProfile);
        return pane;
    }
    
    static public void update(String name){
        nameText.setText(name);
    }
}
