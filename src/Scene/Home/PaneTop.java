/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene.Home;

import AuctionMain.CreateButton;
import AuctionMain.CreateTextField;
import Stage.StageStorage;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Sitth
 */
public class PaneTop {

    static private Pane pane = new Pane();

    public static void createPane() {
        Image im = new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/topPane3.png");
        ImageView iv = new ImageView(im);
        iv.setFitHeight(180);
        iv.setFitWidth(360);
        iv.setLayoutX(1920/2-362/2-100);
        iv.setLayoutY(48+12);
        iv.setPreserveRatio(true);
        
        Image im4 = new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/letter-a.png");
        ImageView iv4 = new ImageView(im4);
        iv4.setFitHeight(170);
        iv4.setFitWidth(360);
        iv4.setLayoutX(25);
        iv4.setLayoutY(24+6);
        iv4.setPreserveRatio(true);
        
        Image im5 = new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/topPane4.png");
        ImageView iv5 = new ImageView(im5);
        //iv5.setFitHeight(170);
        //iv5.setFitWidth(360);
        //iv5.setLayoutX(25);
        //iv5.setLayoutY(24+6);
        //iv5.setPreserveRatio(true);
        
        pane.setMinSize(0, 0);
        //pane.setStyle("-fx-stroke:rgba( 88, 88, 88, 1.0)");
        CreateButton.buttonSearch.setLayoutX(440 + 1920 - 400 - 150 - 300 - 300 - 100 - 100);
        CreateButton.buttonSearch.setLayoutY(120);
        //CreateTextField.search.setMaxHeight(48);
        CreateTextField.search.setMinWidth(440);
        CreateTextField.search.setLayoutX(1920 - 400 - 150 - 300 - 300 - 100);
        CreateTextField.search.setLayoutY(120);
        CreateButton.buttonBellHome.setLayoutX(1920 - 40);
        CreateButton.buttonBellHome.setLayoutY(50 + 40 + 24);
        CreateButton.buttonBellHomeEff.setLayoutX(1920 - 40 + 10);
        CreateButton.buttonBellHomeEff.setLayoutY(50 + 40 - 10 +24);

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
        
        Rectangle rec = new Rectangle(1920,24);
        rec.setArcHeight(8);
        rec.setArcWidth(4);
        rec.setFill(Color.web("rgba( 200, 200, 200, 1.0)"));

        pane.getChildren().addAll(iv5, iv, rec, iv2, iv3, CreateTextField.search, CreateButton.buttonSearch, CreateButton.buttonLogInPaneTop, CreateButton.buttonBellHome, CreateButton.buttonBellHomeEff);

    }

    public static Pane getPane() {
        return pane;
    }
}
