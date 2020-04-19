/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

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

        vbox1 = new VBox();
        vbox1.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vboxArray.add(vbox1);
        
        vbox2 = new VBox();
        vbox2.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vboxArray.add(vbox2);
        
        vbox3 = new VBox();
        vbox3.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vboxArray.add(vbox3);
        
        vbox4 = new VBox();
        vbox4.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vboxArray.add(vbox4);
        
        vbox5 = new VBox();
        vbox5.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vboxArray.add(vbox5);

        for (int i = 0; i < page; i++) {
            paneArray.add(new Pane());
            paneArray.get(i).setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:black ;");
            paneArray.get(i).getChildren().add(new Label("label" + (i+1)));
        }

        paneArray.get(0).getChildren().add(vbox1);
        paneArray.get(1).getChildren().add(vbox2);
        paneArray.get(2).getChildren().add(vbox3);
        paneArray.get(3).getChildren().add(vbox4);
        paneArray.get(4).getChildren().add(vbox5);
                
    }
}
