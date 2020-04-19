/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import AuctionMain.UserData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 *
 * @author Sitth
 */
public class PaneMyAccount {

    static private Pane paneMyAcclayer1 = new Pane();
    static private Pane paneRight = new Pane();
    static private Pane paneLeft = new Pane();
    static private Pane paneTop = new Pane();
    static private Pane addItem = new Pane();
    static private Pane paneMyProfile = new Pane();
    static public Pane paneMyObject = new Pane();
    static public ScrollPane scrollPaneMyObject = new ScrollPane();
    static private Pane paneBla = new Pane();
    //static private Pane r = new Pane();
    static public Label name = new Label("Name");
    static public Button btnAdd = new Button("ADD");
    static public Button btnDelete = new Button("DELETE");
    static public Button btnBack = new Button("Back");
    static public Button pr = new Button("Profile");
    static public Button my = new Button("My _____");
    static public Button bl = new Button("Bla______");
    static private VBox v1 = new VBox();

    static public Pane setUpPane() {

        EventHandler<ActionEvent> my1 = (ActionEvent ActionEvent) -> {
            paneMyProfile.setVisible(true);
            scrollPaneMyObject.setVisible(false);
            paneBla.setVisible(false);
        };
        PaneMyAccount.pr.setOnAction(my1);

        EventHandler<ActionEvent> my2 = (ActionEvent ActionEvent) -> {
            paneMyProfile.setVisible(false);
            System.out.println("Hello");
            System.out.println(paneMyObject.getChildren().size());
            if (paneMyObject.getChildren().isEmpty()) {
                System.out.println("Hello2");
                paneMyObject.getChildren().add(UserData.userPaneArray.get(UserData.ID_UserThatLogIn));
            }
            scrollPaneMyObject.setVisible(true);
            paneBla.setVisible(false);
            //paneRight.getChildren().remove(paneRight.getChildren().size());
            //paneRight.getChildren().add(paneMyObject);
        };
        PaneMyAccount.my.setOnAction(my2);

        EventHandler<ActionEvent> my3 = (ActionEvent ActionEvent) -> {
            paneMyProfile.setVisible(false);
            scrollPaneMyObject.setVisible(false);
            paneBla.setVisible(true);
            //paneRight.getChildren().remove(paneRight.getChildren().size());
            //paneRight.getChildren().add(paneBla);
        };
        PaneMyAccount.bl.setOnAction(my3);

        scrollPaneMyObject.setContent(paneMyObject);
        scrollPaneMyObject.setMinSize(1700, 500);
        scrollPaneMyObject.setMaxSize(1700, 500);
        scrollPaneMyObject.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        paneMyProfile.setVisible(true);
        paneMyProfile.getChildren().addAll(new Label("My Profile"), new Button("1"));
        scrollPaneMyObject.setVisible(false);
        //paneMyObject.getChildren().addAll(new Label("My Object"), new Button("2"));
        paneBla.setVisible(false);
        VBox vbox0 = new VBox();
        vbox0.getChildren().addAll(new Label("My________"), new Button("3"), btnAdd, btnDelete, btnBack);
        paneBla.getChildren().addAll(vbox0);

        paneRight.setMinWidth(1700);
        paneRight.setMinHeight(1080 - 200);
        paneRight.setLayoutX(220);
        paneRight.setLayoutY(200);
        paneRight.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:yellow ; ");

        paneTop.setMinWidth(1920);
        paneTop.setMinHeight(200);
        paneTop.setLayoutX(0);
        paneTop.setLayoutY(0);
        paneTop.setStyle("-fx-background-color:yellow ; ");
        paneTop.getChildren().add(name);
        Font font = new Font(32);
        name.setFont(font);

        paneLeft.setMinWidth(220);
        paneLeft.setMinHeight(1080 - 200);
        paneLeft.setLayoutX(0);
        paneLeft.setLayoutY(200);
        paneLeft.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:yellow ; ");
        VBox vbox = new VBox();
        paneLeft.getChildren().add(vbox);
        vbox.getChildren().addAll(pr, my, bl);
        paneMyAcclayer1.setMinSize(1920, 1080);
        paneMyAcclayer1.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:black ;");

        return paneMyAcclayer1;
    }

    public static Pane getPaneMyAcclayer1() {
        return paneMyAcclayer1;
    }

    static public void makePane() {
        System.out.println("YOOOOOOOOOO");
        Rectangle bg = new Rectangle();
        bg.setFill(Color.rgb(155, 155, 255, 1.0));
        bg.setWidth(1700);
        bg.setHeight(880);
        addItem.getChildren().add(bg);
        paneRight.getChildren().addAll(addItem, paneBla, paneMyProfile , scrollPaneMyObject);
        paneMyAcclayer1.getChildren().addAll(paneRight, paneTop, paneLeft);
        //v1.getChildren().addAll(b1, b2, b3);
        //paneRight.getChildren().addAll(v1);

    }

}
