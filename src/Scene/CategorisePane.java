/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import AuctionMain.runTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Sitth
 */
public class CategorisePane {

    static public ArrayList<Pane> paneArray = new ArrayList<Pane>();
    static public ArrayList<VBox> vboxArray = new ArrayList<VBox>();
    static public VBox vbox1;
    static public VBox vbox2;
    static public VBox vbox3;
    static public VBox vbox4;
    static public VBox vbox5;

    static public StackPane pane1 = new StackPane();
    static public StackPane pane2 = new StackPane();
    static public StackPane pane3 = new StackPane();
    static public StackPane pane4 = new StackPane();
    static public StackPane pane5 = new StackPane();

    static public Text itemText;
    static public Text titleText;
    static public Text priceText;
    static public Text timeLeftText;
    static public Pane paneBar;
    static public Group topBar;

    static public void setUp() {

        int page = 5;
        Pane p = new Pane(new Text("Kuy"));
        vbox1 = new VBox(noProduct(pane1));//คือ Vbox ที่แสดงหน้า market noProduct(pane1)
        //vbox1.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vbox1.setLayoutY(60);
        vboxArray.add(vbox1);
        vboxArray.get(0).getChildren().add(new Text ("555 kam mai?"));
        
        vbox2 = new VBox(noProduct(pane2));
        //vbox2.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vbox2.setLayoutY(60);
        vboxArray.add(vbox2);

        vbox3 = new VBox(noProduct(pane3));
        //vbox3.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vbox3.setLayoutY(60);
        vboxArray.add(vbox3);

        vbox4 = new VBox(noProduct(pane4));
        //vbox4.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vbox4.setLayoutY(60);
        vboxArray.add(vbox4);

        vbox5 = new VBox(noProduct(pane5));
        //vbox5.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:orange ;");
        vbox5.setLayoutY(60);
        vboxArray.add(vbox5);

        for (int i = 0; i < page; i++) {
            paneArray.add(new Pane());
            //Rectangle a = new Rectangle(1920-220,1080-200);
            //paneArray.get(i).setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:black ;");
            Font font = new Font(16);
            StackPane textSP = new StackPane();
            StackPane bgSP = new StackPane();
            Rectangle bgBar = new Rectangle(0, 0, 1920 - 220, 60);
            Pane pane = new Pane();
            bgBar.setFill(Color.web("rgba( 80, 80, 80, 1.0)"));
            itemText = new Text("Item #");
            itemText.setFont(font);
            itemText.setLayoutX(300);
            itemText.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
            titleText = new Text("Title");
            titleText.setFont(font);
            titleText.setLayoutX(500);
            titleText.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
            priceText = new Text("Price");
            priceText.setFont(font);
            priceText.setLayoutX(1500 - 200);
            priceText.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));

            
            //runTime.textArray.get(1) = new Text("Time Left");
            //runTime.textArray.get(1).setFont(font);
            //runTime.textArray.get(1).setLayoutX(1500);
            //timeLeftText.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
            
            timeLeftText = new Text("Time End");
            timeLeftText.setFont(font);
            timeLeftText.setLayoutX(1500);
            timeLeftText.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
            pane.setMinSize(1920 - 220, 0);
            topBar = new Group(pane, itemText, titleText, priceText, timeLeftText);
            //pane.getChildren().addAll(itemText, titleText, priceText, timeLeftText);

            textSP.getChildren().add(topBar);
            bgSP.getChildren().add(bgBar);
            paneBar = new StackPane(bgSP, textSP);
            paneBar.setMinSize(1920 - 220, 60);
            //paneBar.getChildren().addAll();

            paneArray.get(i).setStyle("-fx-background-color:rgba(100,100,100,1.0);");
            paneArray.get(i).getChildren().addAll(paneBar);

        }
        //VBox testVbox = new VBox( );
        paneArray.get(0).getChildren().add(vbox1);
        paneArray.get(1).getChildren().add(vbox2);
        paneArray.get(2).getChildren().add(vbox3);
        paneArray.get(3).getChildren().add(vbox4);
        paneArray.get(4).getChildren().add(vbox5);
        

    }

    static private StackPane noProduct(StackPane pane) {
        Font font = new Font(32);
        Text text = new Text("No Product");
        text.setFont(font);
        text.setFill(Color.web("rgba( 0, 255, 255, 1.0)"));
        pane.getChildren().add(text);
        pane.setMinSize(1920 - 220, 200);
        Button btnPaneNo = new Button();
        btnPaneNo.setOnAction(eh->{
            System.out.println("Kuy I sus Ku kor ha tang nan");
        });
        pane.getChildren().add(btnPaneNo);
        return pane;
    }
}
