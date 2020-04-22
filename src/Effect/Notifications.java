/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Effect;

import javafx.scene.layout.Pane;

/**
 *
 * @author Sitth
 */
public class Notifications {

    static public Pane pane;
    static public Pane subPane = new Pane();

    static public void setUp() {
        pane = new Pane(subPane);
        pane.setMinSize(1920, 1080);
        pane.setMaxSize(300, 600);
        pane.setStyle("-fx-background-color:rgba(0,0,0,0.5);");
        subPane.setMinSize(300, 600);
        subPane.setMaxSize(300, 600);
        subPane.setStyle("-fx-background-color:rgba(80,80,80,1.0);");
        subPane.setLayoutX(1920-300);
        //subPane.setLayoutY(100);
    }

}
