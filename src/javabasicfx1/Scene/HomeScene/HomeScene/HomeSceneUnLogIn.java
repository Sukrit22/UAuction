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
public class HomeSceneUnLogIn {

    private static Pane paneLayor1;

    public HomeSceneUnLogIn() {
        System.out.println("-----1-HomeSceneLogOut");
        homeSceneUnLogIn();
    }

    static public void homeSceneUnLogIn() {
        //Set Button Event In This Scene
        ButtonEvent.buttonEventOnSceneUnLogIn();
        HomeSceneBorderPaneTemplate paneTemplate = new HomeSceneBorderPaneTemplate();
        paneLayor1 = new Pane(paneTemplate.getBorderPaneForUnLogIn());
        Label label = new Label();
        label.setText("Scene 1");
        paneLayor1.getChildren().add(label);
        
    }

    public static Pane getPaneLayor1() {
        return paneLayor1;
    }
    

}
