/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Effect;

import AuctionMain.runTime;
import Scene.Home.SceneHomeUnLogIn;
import Scene.ProductPaneInVbox;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Sitth
 */
public class PopUpProduct {

    static private Rectangle recBGFade;
    static private Rectangle recBGPopUp;
    static private StackPane stackPane;
    static private Pane panepane;
    static private Rectangle pic;
    static private Label name;
    static public Button btnMoreDetail;
    static public Button btnBid;
    static public TextField yourBid;
    static private Text productName;
    static private Text price;
    static private Text timeLeft;

    public static Text getProductName() {
        return productName;
    }

    public static Text getPrice() {
        return price;
    }

    public static Text getTimeLeft() {
        return timeLeft;
    }

    public static Text getMinimumBid() {
        return minimumBid;
    }
    static private Text minimumBid;

    static public void createpopUpBackground(String str) {

        Font font = new Font(24);

        productName = new Text("Product Name\n    " + str);
        productName.setFont(font);
        productName.setLayoutX(450 + 40);
        productName.setLayoutY(20 + 40);

        price = new Text("Current Price\n    ");
        price.setFont(font);
        price.setLayoutX(450 + 40);
        price.setLayoutY(60 + 48 + 48);
        
        //runTime.textArray.get(0).setLayoutY(20);
        
        timeLeft = new Text("Time Left");
        timeLeft.setFont(font);
        timeLeft.setLayoutX(450 + 40);
        timeLeft.setLayoutY(60 + 48 + 48 + 48 + 48);        

        minimumBid = new Text("Minimum Bid\n    ");
        minimumBid.setFont(font);
        minimumBid.setLayoutX(450 + 40);
        minimumBid.setLayoutY(60 + 48 + 48 + 48 + 48 + 48 + 48);

        btnMoreDetail = new Button("More Details");
        btnMoreDetail.setLayoutX(40);
        btnMoreDetail.setLayoutY(350);
        btnMoreDetail.setMinSize(400, 30);

        recBGPopUp = new Rectangle();
        recBGPopUp.setWidth(800);
        recBGPopUp.setHeight(600);
        recBGPopUp.setFill(Color.web("rgba( 200, 200, 200,1.0)"));
        recBGPopUp.setArcWidth(40);
        recBGPopUp.setArcHeight(40);

        recBGFade = new Rectangle();
        recBGFade.setWidth(1920);
        recBGFade.setHeight(1080);
        recBGFade.setFill(Color.web("rgba( 0, 0, 0,0.9)"));

        EventHandler<MouseEvent> mcc = (MouseEvent ActionEvent) -> {
            //Do code here
            SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUpProduct.getStackPane());
            System.out.println("Click");
            ProductPaneInVbox.timeUpdate.stop();

        };
        recBGFade.setOnMouseClicked(mcc);

        panepane = new Pane();
        panepane.setMaxSize(800, 600);
        pic = new Rectangle(40, 40, 400, 300);
        name = new Label("Name");
        name.setLayoutX(200);
        name.setLayoutY(20);

        //Pane fadePane = new Pane(recBGFade);
        panepane.getChildren().addAll(recBGPopUp, pic, name, btnMoreDetail, productName, price, timeLeft, minimumBid);

        stackPane = new StackPane();
        stackPane.getChildren().addAll(recBGFade, panepane);
        

    }

    public static StackPane getStackPane() {
        return stackPane;
    }
}
