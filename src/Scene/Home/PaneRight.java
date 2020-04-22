/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene.Home;

import Scene.CategorisePane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author Sitth
 */
public class PaneRight {

    static private Pane pane = new Pane();

    static public void setUp() {
        Pane paneBar = new Pane();
        Text itemText = new Text("Item #");
        //itemText.setStyle("-fx-text-color:red");
        Text titleText = new Text("Title");
        Text priceText = new Text("Price");
        Text timeLeftText = new Text("Time Left");
        paneBar.getChildren().addAll(itemText, titleText, priceText, timeLeftText);
        pane.getChildren().addAll(paneBar, CategorisePane.paneArray.get(0));

    }
}
