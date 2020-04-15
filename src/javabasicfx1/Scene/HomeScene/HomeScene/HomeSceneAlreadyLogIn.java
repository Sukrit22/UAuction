/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicfx1.Scene.HomeScene.HomeScene;

import javabasicfx1.Scene.HomeScene.Template.HomeSceneBorderPaneTemplate;
import javabasicfx1.ButtonEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author Sitth
 */
public class HomeSceneAlreadyLogIn {

    private static Pane paneLayor1;

    public HomeSceneAlreadyLogIn() {
        System.out.println("-----1-HomeSceneLogOut");
        homeSceneAlreadyLogIn();
    }

    static public void homeSceneAlreadyLogIn() {
        //Set Button Event In This Scene
        ButtonEvent.buttonEvenOnSceneAlreadyLogIn();
        HomeSceneBorderPaneTemplate paneTemplate = new HomeSceneBorderPaneTemplate();
        paneLayor1 = new Pane(paneTemplate.getBorderPaneForAlreadyLogIn());
        Label label = new Label();
        label.setText("Scene 2");
        paneLayor1.getChildren().add(label);
        
    }

    public Pane getPaneLayor1() {
        return paneLayor1;
    }
    

}
