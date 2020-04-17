/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction.ScrollPaneFolder;

import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author Sitth
 */
public class PaneDefault {

    static private Pane pane1 = new Pane();
    static private Pane pane2 = new Pane();
    static private Pane pane3 = new Pane();
    static private Pane pane4 = new Pane();

    static public ArrayList<Pane> pane = new ArrayList<Pane>();

    static public void array() {
        pane.add(pane1);
        pane.add(pane2);
        pane.add(pane3);
        pane.add(pane4);
        ShowPruduct.hobList();
        for (int i = 0; i < pane.size(); i++) {
            createPane(pane.get(i), i+1);
            PaneDefault.pane.get(i).setVisible(false);
            PaneDefault.pane.get(i).getChildren().add(ShowPruduct.vbox.get(i));
        }
    }

    static private void createPane(Pane pane, int i) {
        Label label = new Label("Pane" + i);
        pane.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: red;");
        pane.getChildren().addAll(label);
    }

    /*static public Pane getpane1(){
        Label label = new Label("Pane1");
        pane1.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: red;");
        pane1.getChildren().addAll(label);
        return pane1;
        
    }
    static public Pane getpane2(){
        Label label = new Label("Pane2");
        pane2.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: red;");
        pane2.getChildren().addAll(label);
        pane2.setVisible(false);
        return pane2;
        
    }
    static public Pane getpane3(){
        Label label = new Label("Pane3");
        pane3.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: red;");
        pane3.getChildren().addAll(label);
        pane3.setVisible(false);
        return pane3;
        
    }
    static public Pane getpane4(){
        Label label = new Label("Pane4");
        pane4.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: red;");
        pane4.getChildren().addAll(label);
        pane4.setVisible(false);
        return pane4;
        
    }*/
}
