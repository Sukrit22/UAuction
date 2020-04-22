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
    
    static public void setUp(){
        pane = new Pane();
        pane.setMinSize(300, 600);
        pane.setStyle("-fx-background-color:rgba(0,0,255,1.0);");
    }
    
}
