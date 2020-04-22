/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionMain;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 *
 * @author Sitth
 */
public class CreateTextField {

    static public TextField userName = new TextField();
    static public PasswordField password = new PasswordField();
    static public PasswordField passwordC = new PasswordField();
    static public TextField search = new TextField();

    static public void createEmailField() {
        //.setText("Email");
        userName.setPromptText("Username");
    }

    static public void createPasswordField() {
        //.setText("Email");
        password.setPromptText("Password");
    }

    static public void createPasswordCField() {
        //.setText("Email");
        passwordC.setPromptText("Confirm Password");
    }

    static public void searchField() {
        //.setText("Email");
        search.setPromptText("I'm looking for....");
        search.setStyle("-fx-focus-color:rgba( 2, 2, 2, 1.0);");
        Font font = new Font(24);
        search.setFont(font);
    }

}
