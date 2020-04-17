/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction.AuctionMain;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Sitth
 */
public class CreateButton {

    static public Button button = new Button("Test");
    static public Button button1 = new Button("Test 2");
    static public Button button3 = new Button("Test 3");
    static public Group buttonPopUpCreateAccount = new Group();
    static public Group buttonPopUpLogIn = new Group();
    static public Group buttonPopUpLogIn2 = new Group();
    static public Group buttonPopUpSignUp = new Group();
    static public Group buttonSearch = new Group();
    static public Group buttonLogIn = new Group();
    static public Group buttonMyAccount = new Group();
    static public Group buttonSignOut = new Group();

    static public void buttonCreateAccount() {
        Rectangle test = new Rectangle(300, 0, 300, 140);
        test.setFill(Color.web("rgba( 240, 240, 240, 1.0)"));
        test.setArcWidth(140);
        test.setArcHeight(140);

        Rectangle test2 = new Rectangle(300, 0, 150, 140);
        test2.setFill(Color.web("rgba( 240, 240, 240, 1.0)"));

        Rectangle test3 = new Rectangle(300, 70, 300, 70);
        test3.setFill(Color.web("rgba( 240, 240, 240, 1.0)"));

        Font font = new Font(32);
        Text createAccount = new Text("SIGN UP");
        createAccount.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(300, 140);
        pane.setLayoutX(300);
        pane.setLayoutY(0);
        pane.getChildren().add(createAccount);
        buttonPopUpCreateAccount = new Group();
        buttonPopUpCreateAccount.getChildren().addAll(test, test2, test3, pane);

    }

    static public void buttonLogIn() {
        Rectangle test = new Rectangle(0, 0, 300, 140);
        test.setFill(Color.web("rgba( 240, 240, 240, 1.0)"));
        test.setArcWidth(140);
        test.setArcHeight(140);

        Rectangle test2 = new Rectangle(150, 0, 150, 140);
        test2.setFill(Color.web("rgba( 240, 240, 240, 1.0)"));

        Rectangle test3 = new Rectangle(0, 70, 300, 70);
        test3.setFill(Color.web("rgba( 240, 240, 240, 1.0)"));

        Font font = new Font(32);
        Text logIn = new Text("LOG IN");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(300, 140);
        pane.getChildren().add(logIn);
        buttonPopUpLogIn = new Group();
        buttonPopUpLogIn.getChildren().addAll(test, test2, test3, pane);

    }

    static public void buttonPopUpLogIn2() {
        Rectangle test = new Rectangle(80, 160 + 48 + 48 + 48, 600 - 160, 48);
        test.setFill(Color.web("rgba( 240, 240, 240, 1.0)"));
        //test.setArcWidth(140);
        //test.setArcHeight(140);

        Font font = new Font(24);
        Text logIn = new Text("LOG IN");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(600 - 160, 48);
        pane.getChildren().add(logIn);
        logIn.applyCss();
        //System.out.println(logIn.getBoundsInParent().getWidth() + " " + logIn.getBoundsInParent().getHeight());
        pane.setLayoutX(logIn.getBoundsInParent().getWidth() / 2 + 80 / 2);
        pane.setLayoutY(160 + 48 + 48 + 48);

        buttonPopUpLogIn2 = new Group();
        buttonPopUpLogIn2.getChildren().addAll(test, pane);
    }

    static public void buttonPopUpSignUp() {
        Rectangle test = new Rectangle(80, 160 + 48 + 48 + 48 + 48 + 24, 600 - 160, 48);
        test.setFill(Color.web("rgba( 240, 240, 240, 1.0)"));
        //test.setArcWidth(140);
        //test.setArcHeight(140);

        Font font = new Font(24);
        Text logIn = new Text("REGISTER");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(600 - 160, 48);
        pane.getChildren().add(logIn);
        logIn.applyCss();
        //System.out.println(logIn.getBoundsInParent().getWidth() + " " + logIn.getBoundsInParent().getHeight());
        pane.setLayoutX(logIn.getBoundsInParent().getWidth() / 2 + 80 / 2);
        pane.setLayoutY(160 + 48 + 48 + 48 + 48 + 24);

        buttonPopUpSignUp = new Group(test, pane);

    }

    static public void buttonSearch() {
        Rectangle test = new Rectangle(100, 50);
        test.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        //test.setArcWidth(140);
        //test.setArcHeight(140);

        Font font = new Font(24);
        Text logIn = new Text("Search");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(100, 50);
        pane.getChildren().add(logIn);
        logIn.applyCss();
        //System.out.println(logIn.getBoundsInParent().getWidth() + " " + logIn.getBoundsInParent().getHeight());
        //pane.setLayoutX(logIn.getBoundsInParent().getWidth() / 2);

        buttonSearch = new Group(test, pane);
    }
    
    static public void buttonLogIn3() {
        Rectangle test = new Rectangle(150, 50);
        test.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        //test.setArcWidth(140);
        //test.setArcHeight(140);

        Font font = new Font(24);
        Text logIn = new Text("Log In");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(150, 50);
        pane.getChildren().add(logIn);
        logIn.applyCss();
        //System.out.println(logIn.getBoundsInParent().getWidth() + " " + logIn.getBoundsInParent().getHeight());
        //pane.setLayoutX(logIn.getBoundsInParent().getWidth() / 2);

        buttonLogIn = new Group(test, pane);
    }
    
    static public void buttonMyAccount() {
        Rectangle test = new Rectangle(150, 50);
        test.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        //test.setArcWidth(140);
        //test.setArcHeight(140);

        Font font = new Font(24);
        Text logIn = new Text("My Account");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(150, 50);
        pane.getChildren().add(logIn);
        logIn.applyCss();
        //System.out.println(logIn.getBoundsInParent().getWidth() + " " + logIn.getBoundsInParent().getHeight());
        //pane.setLayoutX(logIn.getBoundsInParent().getWidth() / 2);

        buttonMyAccount = new Group(test, pane);
    }
    
    static public void buttonSignOut() {
        Rectangle test = new Rectangle(150, 0, 150, 50);
        test.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        //test.setArcWidth(140);
        //test.setArcHeight(140);

        Font font = new Font(24);
        Text logIn = new Text("Sign Out");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setLayoutX(150);
        pane.setMinSize(150, 50);
        pane.getChildren().add(logIn);
        logIn.applyCss();
        //System.out.println(logIn.getBoundsInParent().getWidth() + " " + logIn.getBoundsInParent().getHeight());
        //pane.setLayoutX(logIn.getBoundsInParent().getWidth() / 2);

        buttonSignOut = new Group(test, pane);
    }

}
