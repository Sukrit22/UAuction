/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction.Scene;

import uauction.AuctionMain.ButtonEvent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Sitth
 */
public class SceneAuctionHouse {

    static private StackPane stackPane = new StackPane();
    static private Scene scene = new Scene(stackPane);

    static public void sceneAuctionHouse() {

        ButtonEvent.buttonEventForSceneAuctionHouse();
        stackPane.getChildren().add(createBorderPane());


    }

    public static Scene getScene() {
        return scene;
    }

    static private Pane createPaneTop() {
        Pane pane = new Pane();
        return pane;
    }

    static private ScrollPane createPaneLeft() {
        ScrollPane pane = new ScrollPane();
        return pane;
    }

    static private BorderPane createBorderPane() {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(createPaneTop());
        borderPane.setLeft(createPaneLeft());

        return borderPane;
    }
}
