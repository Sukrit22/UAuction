/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicfx1;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Sitth
 */
public class HomeSceneUnLogIn {

    private static Pane paneLayor1;

    public HomeSceneUnLogIn() {
        System.out.println("-----1-HomeSceneLogOut");
        homeSceneLogOut();
    }

    static public void homeSceneLogOut() {
        //Set Button Event In This Scene
        ButtonEvent.buttonEvenOnSceneAlreadyLogIn();
        HomeSceneBorderPaneTemplate paneTemplate = new HomeSceneBorderPaneTemplate();
        paneLayor1 = new Pane(paneTemplate.getBorderPaneLayor1());

    }

    public static Pane getPaneLayor1() {
        return paneLayor1;
    }
    

}
