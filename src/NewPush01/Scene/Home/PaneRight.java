/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene.Home;

import Scene.CategorisePane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Sitth
 */
public class PaneRight {

    static private Pane pane = new Pane();

    static public void setUp() {

        pane.getChildren().add(CategorisePane.paneArray.get(0));

    }
}
