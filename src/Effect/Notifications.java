/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Effect;

import AuctionMain.CreateButton;
import Scene.Home.MyAccount.PaneMyAccount;
import Scene.Home.SceneHomeUnLogIn;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Sitth
 */
public class Notifications {

    static public Pane pane;
    static public VBox vboxNoti = new VBox();
    static public Pane subPane = new Pane(vboxNoti);

    static public void setUp() {
        vboxNoti.getChildren().addAll(addNotifiToUser("WELCOME", false , PaneMyAccount.getPaneMyAcclayer1()));
        pane = new Pane(subPane);
        pane.setMinSize(1920, 1080);
        pane.setMaxSize(300, 600);
        pane.setStyle("-fx-background-color:rgba(0,0,0,0.5);");
        subPane.setMinSize(300, 600);
        subPane.setMaxSize(300, 600);
        subPane.setStyle("-fx-background-color:rgba(80,80,80,1.0);");
        subPane.setLayoutX(1920 - 300);
        //subPane.setLayoutY(100);
    }

    static public Pane addNotifiToUser(String message, boolean link, Pane product) {

        if (Notifications.vboxNoti.getChildren().size() == 10) {
            Notifications.vboxNoti.getChildren().remove(9);
        }
        Pane pane = new Pane();
        pane.setMinSize(300, 60);
        Font font = new Font(16);
        Text text = new Text(message);
        text.setFont(font);
        VBox vbox = new VBox(text);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.setAlignment(Pos.CENTER_LEFT);
        
        Rectangle bg = new Rectangle(300, 50);
        bg.setFill(Color.web("rgba( 120, 120, 120, 1.0)"));

        if (link) {

            EventHandler<MouseEvent> gotoPane = (MouseEvent ActionEvent) -> {
                System.out.println("Notifi");
                SceneHomeUnLogIn.getStackPane().getChildren().remove(Notifications.pane);
                CreateButton.buttonBellHomeEff.setVisible(false);
                SceneHomeUnLogIn.getStackPane().getChildren().add(product);
            };
            pane.setOnMouseClicked(gotoPane);
        }

        pane.getChildren().addAll(bg, vbox);

        return pane;
    }

}
