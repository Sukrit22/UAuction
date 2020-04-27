/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScrollPaneFolder;

import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Sitth
 */
public class ShowPruduct {
    static public VBox vbox1 = new VBox();
    static public VBox vbox2 = new VBox();
    static public VBox vbox3 = new VBox();
    static public VBox vbox4 = new VBox();
    static public VBox vbox5 = new VBox();
    static public VBox vbox6 = new VBox();
    static public VBox vbox7 = new VBox();
    static public VBox vbox8 = new VBox();
    static private Pane pane;
    static public ArrayList<VBox> vbox = new ArrayList<VBox>();
    
    static public void hobList(){
        vbox.add(vbox1);
        vbox.add(vbox2);
        vbox.add(vbox3);
        vbox.add(vbox4);
        vbox.add(vbox5);
        vbox.add(vbox6);
        vbox.add(vbox7);
        vbox.add(vbox8);
        
        for(int i = 0; i < vbox.size(); i++){
            for(int j = 0; j < 20; j++)
            vbox.get(i).getChildren().add(createPane());
        }
        
    }
    
    static private Pane createPane(){
        pane = new Pane();
        pane.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: red;");
        pane.setMinSize(1700, 200);
        return pane;
    }
}

