/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene.Home;

import AuctionMain.CreateButton;
import AuctionMain.CreateTextField;
import javafx.scene.layout.Pane;

/**
 *
 * @author Sitth
 */
public class PaneTop {

    static private Pane pane = new Pane();

    public static void createPane() {
        pane.setMinSize(0, 0);
        CreateButton.buttonSearch.setLayoutX(440 + 220);
        CreateButton.buttonSearch.setLayoutY(120);
        CreateTextField.search.setMinHeight(50);
        CreateTextField.search.setMinWidth(440);
        CreateTextField.search.setLayoutX(220);
        CreateTextField.search.setLayoutY(120);
        pane.getChildren().addAll(CreateTextField.search, CreateButton.buttonSearch, CreateButton.buttonLogInPaneTop);
        
    }

    public static Pane getPane() {
        return pane;
    }
}