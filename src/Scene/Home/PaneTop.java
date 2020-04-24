/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene.Home;

import AuctionMain.CreateButton;
import static AuctionMain.CreateButton.buttonBellHomeEff;
import AuctionMain.CreateTextField;
import AuctionMain.runTime;
import Effect.PopUp;
import Stage.StageStorage;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

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
        CreateButton.buttonBellHome.setLayoutX(1920 - 40);
        CreateButton.buttonBellHome.setLayoutY(50 + 40);
        CreateButton.buttonBellHomeEff.setLayoutX(1920 - 40 + 10);
        CreateButton.buttonBellHomeEff.setLayoutY(50 + 40 - 10);

        Image im2 = new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/exitRed255.png");
        ImageView iv2 = new ImageView(im2);
        iv2.setFitHeight(20);
        iv2.setLayoutX(2);
        iv2.setLayoutY(2);
        iv2.setPreserveRatio(true);
        
        EventHandler<MouseEvent> eh = (MouseEvent ActionEvent) -> {
            //Do code here
            StageStorage.Auction.close();
        };
        
        iv2.setOnMouseClicked(eh);
        
        Image im3 = new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/minimizeBlack.png");
        ImageView iv3 = new ImageView(im3);
        iv3.setFitHeight(20);
        iv3.setLayoutX(2+20+10);
        iv3.setLayoutY(2);
        iv3.setPreserveRatio(true);
        
        EventHandler<MouseEvent> eh3 = (MouseEvent ActionEvent) -> {
            //Do code here
            StageStorage.Auction.setIconified(true);
        };
        
        iv3.setOnMouseClicked(eh3);
        
        Rectangle rec = new Rectangle(54,24);
        rec.setArcHeight(8);
        rec.setArcWidth(4);
        rec.setFill(Color.web("rgba( 200, 200, 200, 1.0)"));

        pane.getChildren().addAll(rec, iv2, iv3, CreateTextField.search, CreateButton.buttonSearch, CreateButton.buttonLogInPaneTop, CreateButton.buttonBellHome, CreateButton.buttonBellHomeEff);

    }

    public static Pane getPane() {
        return pane;
    }
}
