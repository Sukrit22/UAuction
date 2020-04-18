/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import AuctionMain.ButtonEvent;
import AuctionMain.CreateButton;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Sitth
 */
public class SceneHomeAlreadyLogIn {

    static private StackPane stackPane = new StackPane();
    static private Scene scene = new Scene(stackPane);

    static public void sceneHomeAlreadyLogIn() {

        ButtonEvent.buttonEventForSceneHomeAlreadyLogIn();
        stackPane.getChildren().add(createBorderPane());


    }

    public static Scene getScene() {
        return scene;
    }

    public SceneHomeAlreadyLogIn() {
    }

    static private Pane createPaneTop() {
        Pane pane = new Pane(CreateButton.button1);
        pane.setMinSize(1920, 200);
        return pane;
    }

    static private ScrollPane createPaneRight() {
        
        
        Button button = new Button("ADD");
        Pane pane1 = new Pane();
        Pane pane2 = new Pane(button);
        pane2.setMinSize(1700, 400);
        pane2.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: red;");
        Pane pane3 = new Pane();
        pane3.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: red;");
                
        pane1.getChildren().addAll(pane2, pane3);
        
        
        
        
        //----------------------------------------------------------------------
        ScrollPane pane = new ScrollPane(pane1);        
        pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        pane.setMinSize(1700, 1000-200);
        return pane;
    }

    static private BorderPane createBorderPane() {
        BorderPane borderPane = new BorderPane();
        borderPane.setMinSize(1920, 1080);
        borderPane.setTop(createPaneTop());
        borderPane.setRight(createPaneRight());

        return borderPane;
    }
}
