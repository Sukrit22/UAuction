/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction.Scene;

import uauction.AuctionMain.CreateButton;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Sitth
 */
public class PaneCenter {

    static private Pane pane = new Pane();
    static private Pane r = new Pane();
    static private Pane addItem = new Pane();
    //static private Pane r = new Pane();
    static public Button b1 = new Button("ADD");
    static public Button b2 = new Button("DELETE");
    static public Button b3 = new Button("Back");
    static private VBox v1 = new VBox();

    static public Pane getPane() {

        r.setMinWidth(1700);
        r.setMinHeight(1080 - 200);
        r.setLayoutX(220);
        r.setLayoutY(200);
        r.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:yellow ; ");
        pane.setMinSize(1920, 1080);
        pane.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:black ;");

        return pane;
    }

    static public void makePane() {
        System.out.println("YOOOOOOOOOO");
        r.getChildren().add(addItem);
        pane.getChildren().add(r);
        v1.getChildren().addAll(b1, b2, b3);
        r.getChildren().addAll(v1);

    }

}
