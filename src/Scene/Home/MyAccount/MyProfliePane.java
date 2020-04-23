/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene.Home.MyAccount;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Sitth
 */
public class MyProfliePane {

    static public Pane pane;

    static public Pane getAndSetPane(String name) {
        pane = new Pane();
        pane.setMinSize(1920, 1080);
        Font font = new Font(24);

        Label nameLabel = new Label(name);
        nameLabel.setLayoutX(60);
        Text nameText = new Text(name);
        VBox nameTextPane = new VBox(nameText);
        nameText.setFont(font);

        pane.getChildren().addAll(nameTextPane, nameLabel);
        return pane;
    }
}
