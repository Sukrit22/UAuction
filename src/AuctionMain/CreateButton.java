/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionMain;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
    static public Group buttonPopSwitchToSignUp = new Group();
    static public Group buttonPopUpSwitchToLogIn = new Group();
    static public Group buttonPopUpLogIn = new Group();
    static public Group buttonPopUpRegister = new Group();
    static public Group buttonSearch = new Group();
    static public Group buttonLogInPaneTop = new Group();
    static public Group buttonMyAccount = new Group();
    static public Group buttonSignOutTopPane = new Group();
    static public Group buttonTime = new Group();
    static public Group buttonTime2 = new Group();
    static public Group buttonHelpPaneTop = new Group();
    static public Group buttonMyProfileOnMyACC = new Group();
    static public Group buttonMyProductOnACC = new Group();
    static public Group buttonAddProductOnACC = new Group();
    static public Group buttonBackOnACC = new Group();
    static public Group buttonBackOnACC2 = new Group();
    static public Group buttonBlankOnACC = new Group();
    static public Group buttonMyAuctionOnACC = new Group();
    static public Group buttonBellHome = new Group();

    static public Text timeText = new Text("dd/mm/yyyy hh:mm:ss a XXX");
    static public Text timeText2 = new Text("dd/mm/yyyy hh:mm:ss a XXX");

    static public void setUpAllButton() {
        buttonCreateAccount();
        buttonHelp();
        buttonLogIn();
        buttonLogInPaneTopMethod();
        buttonMyAccount();
        buttonPopUpLogIn2();
        buttonPopUpSignUp();
        buttonSearch();
        buttonSignOut();
        buttonTime();
        buttonTime2();
        buttonMyProductOnMyAccount();
        buttonMyProfileOnMyAccount();
        buttonAddProductOnMyAccount();
        buttonBackOnMyAccount();
        buttonBackOnMyAccount2();
        buttonBlankMyAccount();
        buttonMyAuctionMyAccount();
        buttonBellHome();
    }

    static private void buttonCreateAccount() {
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
        buttonPopSwitchToSignUp = new Group();
        buttonPopSwitchToSignUp.getChildren().addAll(test, test2, test3, pane);

    }

    static private void buttonLogIn() {
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
        buttonPopUpSwitchToLogIn = new Group();
        buttonPopUpSwitchToLogIn.getChildren().addAll(test, test2, test3, pane);

    }

    static private void buttonPopUpLogIn2() {
        Rectangle test = new Rectangle(80, 160 + 48 + 48 + 48, 600 - 160, 48);
        test.setFill(Color.web("rgba( 240, 240, 240, 1.0)"));
        Font font = new Font(24);
        Text logIn = new Text("LOG IN");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(600 - 160, 48);
        pane.getChildren().add(logIn);
        logIn.applyCss();
        pane.setLayoutX(logIn.getBoundsInParent().getWidth() / 2 + 80 / 2);
        pane.setLayoutY(160 + 48 + 48 + 48);

        buttonPopUpLogIn = new Group();
        buttonPopUpLogIn.getChildren().addAll(test, pane);
    }

    static private void buttonPopUpSignUp() {
        Rectangle test = new Rectangle(80, 160 + 48 + 48 + 48 + 48 + 24, 600 - 160, 48);
        test.setFill(Color.web("rgba( 240, 240, 240, 1.0)"));
        Font font = new Font(24);
        Text logIn = new Text("REGISTER");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(600 - 160, 48);
        pane.getChildren().add(logIn);
        pane.setLayoutX(logIn.getBoundsInParent().getWidth() / 2 + 80 / 2);
        pane.setLayoutY(160 + 48 + 48 + 48 + 48 + 24);
        buttonPopUpRegister = new Group();
        buttonPopUpRegister.getChildren().addAll(test, pane);

    }

    static private void buttonSearch() {
        Rectangle test = new Rectangle(100, 50);
        test.setFill(Color.web("rgba( 255, 255, 255, 0.0)"));
        //test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(24);
        Text logIn = new Text("Search");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(100, 50);
        pane.getChildren().add(logIn);
        logIn.applyCss();

        buttonSearch = new Group(test, pane);
    }

    static private void buttonLogInPaneTopMethod() {
        Rectangle test = new Rectangle(150, 50);
        test.setFill(Color.web("rgba( 88, 88, 88, 1.0)"));
        test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2);");
        Font font = new Font(24);
        Text logIn = new Text("Log In");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(150, 50);
        //pane.setLayoutX(500);
        pane.getChildren().add(logIn);
        logIn.applyCss();
        logIn.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        buttonLogInPaneTop = new Group(test, pane);
        buttonLogInPaneTop.setLayoutX(1920 - 400 - 150 - 150);
    }

    static private void buttonMyAccount() {
        Rectangle test = new Rectangle(150, 50);
        test.setFill(Color.web("rgba( 88, 88, 88, 1.0)"));
        test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(24);
        Text logIn = new Text("My Account");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(150, 50);
        pane.getChildren().add(logIn);
        logIn.applyCss();
        logIn.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        buttonMyAccount = new Group(test, pane);
        buttonMyAccount.setLayoutX(1920 - 400 - 150 - 150 - 150);
    }

    static private void buttonSignOut() {
        Rectangle test = new Rectangle(0, 0, 150, 50);
        test.setFill(Color.web("rgba( 88, 88, 88, 1.0)"));
        test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        //test.setArcWidth(140);
        //test.setArcHeight(140);

        Font font = new Font(24);
        Text logIn = new Text("Sign Out");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setLayoutX(0);
        pane.setMinSize(150, 50);
        pane.getChildren().add(logIn);
        logIn.applyCss();
        logIn.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        //System.out.println(logIn.getBoundsInParent().getWidth() + " " + logIn.getBoundsInParent().getHeight());
        //

        buttonSignOutTopPane = new Group(test, pane);
        buttonSignOutTopPane.setLayoutX(1920 - 400 - 150);
    }

    static private void buttonTime() {
        Rectangle test = new Rectangle(1920 - 400, 0, 400, 50);
        test.setFill(Color.web("rgba( 88, 88, 88, 1.0)"));
        test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(24);
        timeText.setFont(font);
        StackPane pane = new StackPane();
        pane.getChildren().add(timeText);
        timeText.applyCss();
        //pane.setLayoutX(300);
        pane.setMinSize(400, 50);
        timeText.applyCss();
        timeText.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        //System.out.println(timeText.getBoundsInParent().getWidth());
        pane.setLayoutX(1920 - 150 - 250);

        buttonTime = new Group(test, pane);
    }

    static private void buttonTime2() {
        Rectangle test = new Rectangle(1920 - 400, 0, 400, 50);
        test.setFill(Color.web("rgba( 88, 88, 88, 1.0)"));
        test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(24);
        timeText2.setFont(font);
        StackPane pane = new StackPane();
        pane.getChildren().add(timeText2);
        timeText2.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        //timeText2.applyCss();
        //pane.setLayoutX(300);
        pane.setMinSize(400, 50);
        //timeText2.applyCss();
        //System.out.println(timeText.getBoundsInParent().getWidth());
        pane.setLayoutX(1920 - 150 - 250);

        buttonTime2 = new Group(test, pane);
    }

    static private void buttonHelp() {
        Rectangle test = new Rectangle(0, 0, 150, 50);
        test.setFill(Color.web("rgba( 88, 88, 88, 1.0)"));
        test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(24);
        Text logIn = new Text("Help");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(150, 50);
        pane.getChildren().add(logIn);
        pane.setLayoutX(0);
        logIn.applyCss();
        logIn.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        buttonHelpPaneTop = new Group(test, pane);
        buttonHelpPaneTop.setLayoutX(1920 - 400 - 150);
    }
    
    
    static private void buttonBellHome() {
        Rectangle test = new Rectangle(220, 50);
        Circle cir = new Circle(30);
        cir.setFill(Color.web("rgba( 255, 255, 0, 1.0)"));
        Image im = new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/bell.png");
        ImageView iv = new ImageView(im);
        iv.setFitHeight(30);
        iv.setFitWidth(30);
        //iv.setClip(cir);
        
        test.setFill(Color.web("rgba( 88, 88, 88, 1.0)"));
        test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(24);
        Text logIn = new Text("Bell");
        logIn.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setLayoutX(0);
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);

        buttonBellHome = new Group(cir);
    }

    static private void buttonMyProductOnMyAccount() {
        Rectangle test = new Rectangle(220, 50);
        test.setFill(Color.web("rgba( 88, 88, 88, 1.0)"));
        test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        Text logIn = new Text("My Product");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        logIn.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        pane.setLayoutX(0);
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);

        buttonMyProductOnACC = new Group(test, pane);
    }

    static private void buttonMyProfileOnMyAccount() {
        Rectangle test = new Rectangle(220, 50);
        test.setFill(Color.web("rgba( 88, 88, 88, 1.0)"));
        test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        Text logIn = new Text("My Profile");
        logIn.setFont(font);
        logIn.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        StackPane pane = new StackPane();
        pane.setLayoutX(0);
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);

        buttonMyProfileOnMyACC = new Group(test, pane);
    }

    static private void buttonAddProductOnMyAccount() {
        Rectangle test = new Rectangle(220, 50);
        test.setFill(Color.web("rgba( 88, 88, 88, 1.0)"));
        test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        Text logIn = new Text("Add Product");
        logIn.setFont(font);
        logIn.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        StackPane pane = new StackPane();
        pane.setLayoutX(0);
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);

        buttonAddProductOnACC = new Group(test, pane);
    }

    static private void buttonMyAuctionMyAccount() {
        Rectangle test = new Rectangle(220, 50);
        test.setFill(Color.web("rgba( 88, 88, 88, 1.0)"));
        test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        Text logIn = new Text("My Auction");
        logIn.setFont(font);
        logIn.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        StackPane pane = new StackPane();
        pane.setLayoutX(0);
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);

        buttonMyAuctionOnACC = new Group(test, pane);
        
    }
    static private void buttonBackOnMyAccount() {
        Rectangle test = new Rectangle(220, 50);
        test.setFill(Color.web("rgba( 88, 88, 88, 1.0)"));
        test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(24);
        Text logIn = new Text("Home");
        logIn.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setLayoutX(0);
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);

        buttonBackOnACC = new Group(test, pane);
    }

    static private void buttonBackOnMyAccount2() {
        Rectangle test = new Rectangle(150, 50);
        test.setFill(Color.web("rgba( 88, 88, 88, 1.0)"));
        test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(24);
        Text logIn = new Text("Home");
        logIn.setFont(font);
        logIn.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        StackPane pane = new StackPane();
        pane.setLayoutX(0);
        pane.setMinSize(150, 50);
        pane.getChildren().add(logIn);

        buttonBackOnACC2 = new Group(test, pane);
    }

    static private void buttonBlankMyAccount() {
        Rectangle test = new Rectangle(220, 0);
        test.setFill(Color.web("rgba( 88, 88, 88, 1.0)"));
        test.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(24);
        Text logIn = new Text("");
        logIn.setFont(font);
        logIn.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        StackPane pane = new StackPane();
        pane.setLayoutX(0);
        pane.setMinSize(220, 710-40-50);
        pane.getChildren().add(logIn);

        buttonBlankOnACC = new Group(test, pane);
    }

}
