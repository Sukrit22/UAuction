/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Effect;

import Scene.Home.SceneHomeUnLogIn;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    static private Text productName;
    static private Text price;
    static private Text timeLeft;
    static private Text minimumBid;

    static public void createpopUpBackground() {
        
        Font font = new Font(24);
        
        productName = new Text("Product Name\n    Hello World");
        productName.setFont(font);
        productName.setLayoutX(450+40);
        productName.setLayoutY(20+40);
        
        price = new Text("Current Price\n    123 Baht");
        price.setFont(font);
        price.setLayoutX(450+40);
        price.setLayoutY(60+48+48);
                
        timeLeft = new Text("Time Left\n    12 HR 12 Min");
        timeLeft.setFont(font);
        timeLeft.setLayoutX(450+40);
        timeLeft.setLayoutY(60+48+48+48+48);
        
        minimumBid = new Text("Minimum Bid\n    30 Baht");
        minimumBid.setFont(font);
        minimumBid.setLayoutX(450+40);
        minimumBid.setLayoutY(60+48+48+48+48+48+48);
        
        
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
        recBGFade.setFill(Color.web("rgba( 0, 0, 0,0.5)"));

        EventHandler<MouseEvent> mcc = (MouseEvent ActionEvent) -> {
            //Do code here
            SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUpProduct.getStackPane());
            System.out.println("Click");

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
