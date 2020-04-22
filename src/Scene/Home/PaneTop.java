/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene.Home;

import AuctionMain.CreateButton;
import AuctionMain.CreateTextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Sitth
 */
public class PaneTop {

    static private Pane pane = new Pane();

    public static void createPane() {
        Image im = new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/TopPane.png");
        ImageView iv = new ImageView(im);
        pane.setMinSize(0, 0);
        //pane.setStyle("-fx-stroke:rgba( 88, 88, 88, 1.0)");
        CreateButton.buttonSearch.setLayoutX(440 + 1920 - 400 - 150 - 300 - 300 - 100 - 100);
        CreateButton.buttonSearch.setLayoutY(120);
        //CreateTextField.search.setMaxHeight(48);
        CreateTextField.search.setMinWidth(440);
        CreateTextField.search.setLayoutX(1920 - 400 - 150 - 300 - 300 - 100);
        CreateTextField.search.setLayoutY(120);
        pane.getChildren().addAll(CreateTextField.search, CreateButton.buttonSearch, CreateButton.buttonLogInPaneTop);

    }

    public static Pane getPane() {
        return pane;
    }
}
