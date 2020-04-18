/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Sitth
 */
public class Product {
    static private Rectangle a;
    static private Label label;
    static private Pane pane;
    static private Pane pane2;
    static private Pane pane3;
    static public int x = 0;

    static public Pane product(String productName, String userName) {
        a = new Rectangle(150,150);
        label = new Label(productName);
        label.setLayoutX(200);
        Label label2 = new Label(userName);
        label2.setLayoutX(200);
        label2.setLayoutY(100);
        pane = new Pane();
        pane.setMinHeight(200);
        pane.getChildren().addAll(a , label, label2);
        x++;
        return pane;
    }
    
    
}
