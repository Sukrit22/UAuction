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
    static private Text minimumBid;
    static private Text productName2;
    static private Text price2;
    static private Text timeLeft2;
    static private Text minimumBid2;

    public static Text getProductName() {
        return productName2;
    }

    public static Text getPrice() {
        return price2;
    }

    public static Text getTimeLeft() {
        return timeLeft2;
    }

    public static Text getMinimumBid() {
        return minimumBid2;
    }
    

    static public void createpopUpBackground(String str) {

        Font font = new Font(24);

        productName = new Text("Product Name");
        productName.setFont(font);
        productName.setLayoutX(450 + 40);
        productName.setLayoutY(20 + 40);

        productName2 = new Text(str);
        productName2.setFont(font);
        productName2.setLayoutX(450 + 40 + 36);
        productName2.setLayoutY(20 + 40 + 36);

        price = new Text("Current Price");
        price.setFont(font);
        price.setLayoutX(450 + 40);
        price.setLayoutY(60 + 48 + 48);

        price2 = new Text("165 Baht");
        price2.setFont(font);
        price2.setLayoutX(450 + 40 + 23);
        price2.setLayoutY(60 + 48 + 48 + 36);

        //runTime.textArray.get(0).setLayoutY(20);
        timeLeft = new Text("Time Left");
        timeLeft.setFont(font);
        timeLeft.setLayoutX(450 + 40);
        timeLeft.setLayoutY(60 + 48 + 48 + 48 + 48);
        
        timeLeft2 = new Text("12 h 43 min");
        timeLeft2.setFont(font);
        timeLeft2.setLayoutX(450 + 40 + 36);
        timeLeft2.setLayoutY(60 + 48 + 48 + 48 + 48 + 36);

        minimumBid = new Text("Minimum Bid\n    ");
        minimumBid.setFont(font);
        minimumBid.setLayoutX(450 + 40);
        minimumBid.setLayoutY(60 + 48 + 48 + 48 + 48 + 48 + 48);
        
        minimumBid2 = new Text("1 Baht");
        minimumBid2.setFont(font);
        minimumBid2.setLayoutX(450 + 40 + 36);
        minimumBid2.setLayoutY(60 + 48 + 48 + 48 + 48 + 48 + 48 + 36);

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
        panepane.getChildren().addAll(recBGPopUp, pic, name, btnMoreDetail, productName, productName2, price, price2, timeLeft, timeLeft2, minimumBid, minimumBid2);

        stackPane = new StackPane();
        stackPane.getChildren().addAll(recBGFade, panepane);

    }

    public static StackPane getStackPane() {
        return stackPane;
    }
}
