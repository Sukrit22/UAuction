/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction.Scene;

import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Sitth
 */
public class CategorisePane {

    static public ArrayList<Pane> pane = new ArrayList<Pane>();
    static public ArrayList<VBox> vbox = new ArrayList<VBox>();
    static public VBox vbox1;
    static public VBox vbox2;
    static public VBox vbox3;
    static public VBox vbox4;
    static public VBox vbox5;

    static public void setUp() {

        int page = 5;

        vbox1 = new VBox();
        vbox1.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vbox2 = new VBox();
        vbox2.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vbox3 = new VBox();
        vbox3.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vbox4 = new VBox();
        vbox4.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vbox5 = new VBox();
        vbox5.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        //vbox.add(vbox1);
        //VBox sasas = new VBox();
        //vbox.add(sasas);

        for (int i = 0; i < page; i++) {
            pane.add(new Pane());
            pane.get(i).setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:black ;");
            pane.get(i).getChildren().add(new Label("label" + i+1));
            //boxV = new VBox();
            //boxV.setMinSize(60, 40);
            //boxV.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        }

        pane.get(0).getChildren().add(vbox1);
        pane.get(1).getChildren().add(vbox2);
        pane.get(2).getChildren().add(vbox3);
        pane.get(3).getChildren().add(vbox4);
        pane.get(4).getChildren().add(vbox5);
        //pane.get(0).getChildren().add(vbox.get(0));            //pane.get(i).getChildren().add(boxV);
        //pane.get(0).getChildren()
        //pane.get(1).getChildren().add(vbox2);
        //pane.get(2).getChildren().add(vbox3);
        //pane.get(3).getChildren().add(vbox4);
        //pane.get(4).getChildren().add(vbox5);
                
    }
}
