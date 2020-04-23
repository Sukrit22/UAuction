/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import AuctionMain.runTime;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import Effect.PopUpProduct;
import Scene.Home.MyAccount.AddProduct;
import Scene.Home.SceneHomeUnLogIn;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Sitth
 */
public class ProductPaneInVbox {

    static private Pane productView1;
    static private Pane productView2;
    static private Pane productView3;
    static private Pane productView4;
    static public Button btnView;

    static public Text item;
    static public Text title;
    static public Text price;
    static public Text timeLeft;
    static public int countIDAllProduct = 1;

    static public Thread timeUpdate;

    static public Pane Pane1(String str, int ID) {
        System.out.println("Product Added");
        btnView = new Button("View");
        btnView.setLayoutX(25);
        btnView.setLayoutY(200 - 40);
        btnView.setMinSize(200, 25);
        PopUpProduct.createpopUpBackground(str);
        EventHandler<ActionEvent> ev = (ActionEvent ActionEvent) -> {
            //Do code here
            System.out.println("popUpItem");
            SceneHomeUnLogIn.getStackPane().getChildren().add(PopUpProduct.getStackPane());
            timeUpdate = new Thread(new Runnable() {
                boolean enough = false;

                @Override
                public void run() {
                    SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss");
                    while (!enough) {
                        try {
                            // running "long" operation not on UI thread
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                        }
                        final String time = dt.format(new Date());
                        Platform.runLater(() -> {
                            //System.out.println("Run Ja");
                            //PopUpProduct.getTimeLeft().setText(time);
                        });
                    }
                }
            });
            timeUpdate.start();

        };
        btnView.setOnAction(ev);

        Font font = new Font(16);
        String itemID;
        SimpleDateFormat dt = new SimpleDateFormat("ddMMyyhhmm");
        String time = dt.format(new Date());

        String b = String.format("%04d", countIDAllProduct++).substring(0, 4);
        //=========================== ต้องรับเข้ามา =======================
        item = new Text(time + b);
        item.setFont(font);
        item.setLayoutX(300 - 25);
        item.setLayoutY(50);

        //=========================== ตัวนี้ต้องรับเข้า =======================
        title = new Text("Subaru WRX STI GDB 2015"); 
        if (!str.isEmpty()) {
            title.setText(str);
        }
        title.setFont(font);
        title.setLayoutX(500 - 15);
        title.setLayoutY(50);
//===========================ตัวนี้ต้องรับเข้ามา =======================
        price = new Text("12300.00 Baht");
        price.setFont(font);
        price.setLayoutX(1300 - 15);
        price.setLayoutY(50);

        runTime.textArrayforCal.add(new Label("30"));
        runTime.textArray.add(new Label(""));
        
        runTime.textArray.get(ID-1).setFont(font);
        runTime.textArray.get(ID-1).setLayoutX(1500 - 20);
        runTime.textArray.get(ID-1).setLayoutY(50-12);

        
        timeLeft = new Text("45 Min 33 Sec");
        timeLeft.setFill(Color.web("rgba( 255, 0, 0, 1.0)"));
        timeLeft.setFont(font);
        timeLeft.setLayoutX(1500 - 20);
        timeLeft.setLayoutY(50);

        Rectangle pic = new Rectangle(25, 10, 200, 150);
        Rectangle bgRec = new Rectangle(0, 0, 1920 - 220, 200);
        bgRec.setFill(Color.web("rgba( 200, 200, 200, 1.0)"));
        //Rectangle pic2 = new Rectangle(0, 0, 150, 150);
        productView1 = new Pane(bgRec);
        productView1.getChildren().addAll(pic, item, runTime.textArray.get(ID-1), title, price , btnView);
        //productView1.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: red;");
        productView1.setMinSize(1920 - 220, 200);
        //____ Left
        productView1.setPadding(new Insets(10, 0, 0, 0));
        return productView1;
    }

    static public Pane Pane2() {
        Rectangle pic = new Rectangle(150, 150);
        productView2 = new Pane(pic);
        productView2.setMinSize(1920 - 220, 200);
        return productView2;
    }

    static public Pane Pane3() {
        Rectangle pic = new Rectangle(150, 150);
        productView3 = new Pane(pic);
        productView3.setMinSize(1920 - 220, 200);
        return productView3;
    }

    static public Pane Pane4() {
        Rectangle pic = new Rectangle(150, 150);
        productView4 = new Pane(pic);
        productView4.setMinSize(1920 - 220, 200);
        return productView4;
    }

}
