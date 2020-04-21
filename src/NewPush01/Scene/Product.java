/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import Effect.PopUpProduct;
import Scene.Home.SceneHomeUnLogIn;

/**
 *
 * @author Sitth
 */
public class Product {

    static private Pane productView1;
    static private Pane productView2;
    static private Pane productView3;
    static private Pane productView4;
    static public Button btnView;

    static public Pane Pane1() {
        System.out.println("Product Added");
        btnView = new Button("View");
        EventHandler<ActionEvent> ev = (ActionEvent ActionEvent) -> {
            //Do code here
            System.out.println("buttonLogInPaneTop");

            SceneHomeUnLogIn.getStackPane().getChildren().add(PopUpProduct.getStackPane());

        };
        btnView.setOnAction(ev);

        Rectangle pic = new Rectangle(0, 0, 150, 150);
        //Rectangle pic2 = new Rectangle(0, 0, 150, 150);
        productView1 = new Pane(pic);
        productView1.getChildren().add(btnView);
        productView1.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: red;");
        productView1.setMinSize(1920 - 220, 200);
        return productView1;
    }

    static public Pane Pane2() {
        Rectangle pic = new Rectangle(150, 150);
        productView2 = new Pane(pic);
        productView2.setMinSize(1920 - 220, 200);
        return productView2;
    }

    static public Pane Pane3() {
        Rectangle pic = new Rectangle(150, 150);
        productView3 = new Pane(pic);
        productView3.setMinSize(1920 - 220, 200);
        return productView3;
    }

    static public Pane Pane4() {
        Rectangle pic = new Rectangle(150, 150);
        productView4 = new Pane(pic);
        productView4.setMinSize(1920 - 220, 200);
        return productView4;
    }

}
