/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author Sitth
 */
public class CategorisePane {

    static public ArrayList<Pane> paneArray = new ArrayList<Pane>();
    static public ArrayList<VBox> vboxArray = new ArrayList<VBox>();
    static public VBox vbox1;
    static public VBox vbox2;
    static public VBox vbox3;
    static public VBox vbox4;
    static public VBox vbox5;

    static public void setUp() {

        int page = 5;

        vbox1 = new VBox(noProduct());
        vbox1.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vboxArray.add(vbox1);
        
        vbox2 = new VBox(noProduct());
        vbox2.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vboxArray.add(vbox2);
        
        vbox3 = new VBox(noProduct());
        vbox3.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vboxArray.add(vbox3);
        
        vbox4 = new VBox(noProduct());
        vbox4.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vboxArray.add(vbox4);
        
        vbox5 = new VBox(noProduct());
        vbox5.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vboxArray.add(vbox5);

        for (int i = 0; i < page; i++) {
            paneArray.add(new Pane());
            //Rectangle a = new Rectangle(1920-220,1080-200);
            paneArray.get(i).setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:black ;");
            paneArray.get(i).getChildren().addAll(new Label("label" + (i+1)));
        }

        paneArray.get(0).getChildren().add(vbox1);
        paneArray.get(1).getChildren().add(vbox2);
        paneArray.get(2).getChildren().add(vbox3);
        paneArray.get(3).getChildren().add(vbox4);
        paneArray.get(4).getChildren().add(vbox5);
                
    }
    
    static private StackPane noProduct(){
        Text text = new Text("No Product");
        StackPane pane = new StackPane(text);
        pane.setMinSize(1920-220, 200);
        return pane;
    }
}
