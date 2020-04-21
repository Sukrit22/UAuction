/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Sitth
 */
public class ActionPane {
    static private StackPane pane;
    public static void setUpPane(){
        
        /*Rectangle fade = new Rectangle();
        fade.setWidth(1920);
        fade.setHeight(1080);
        fade.setFill(Color.web("rgba( 0, 0, 0,0.5)"));
        Pane bg = new Pane(fade);
        pane.getChildren().add(bg);*/
        pane = new StackPane(new Label("View ProductPane"));
                
        
        
    }

    public static StackPane getPane() {
        return pane;
    }
    
}
