/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import AuctionMain.CreateButton;
import AuctionMain.CreateTextField;
import AuctionMain.runTime;
import Effect.PopUp;
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
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import uauction.NewClient;

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
    static public Text timeEnd;
    static public int countIDAllProduct = 1;

    static public Thread timeUpdate;

    static public Pane Pane1(Image image, String productName, String dis, double currentPrice, int ID) {
        //imageview จำกัดความสูงไว้ที่ 250
        System.out.println("Product Added");
        btnView = new Button("View");
        btnView.setLayoutX(25);
        btnView.setLayoutY(200 - 40);
        btnView.setMinSize(200, 25);
        PopUpProduct.createpopUpBackground(productName);
        //=========================== อาจจะต้องรีเควสไอเทมชิ้นนั้น =======================
        EventHandler<ActionEvent> ev = (ActionEvent ActionEvent) -> {
            //Do code here
            System.out.println("popUpItem");
            System.out.println(NewClient.user.canBuy());
            PopUpProduct.yourBid.setText("");
            if (!NewClient.user.canBuy()) {
                System.out.println("buttonLogInPaneTop");
                CreateButton.buttonPopUpSwitchToLogIn.setVisible(false);
                CreateButton.buttonPopSwitchToSignUp.setVisible(true);
                CreateTextField.userName.setVisible(true);
                CreateTextField.password.setVisible(true);
                CreateTextField.passwordC.setVisible(false);
                CreateButton.buttonPopUpLogIn.setVisible(true);
                CreateButton.buttonPopUpRegister.setVisible(false);
                CreateTextField.userName.setText("");
                CreateTextField.password.setText("");
                CreateTextField.passwordC.setText("");
                PopUp.incorrecypassPane.setVisible(false);
                PopUp.passwordNotSamePane.setVisible(false);
                PopUp.emailUsedPane.setVisible(false);
                SceneHomeUnLogIn.getStackPane().getChildren().addAll(PopUpProduct.getStackPane(), PopUp.getStackPane());
            } else {
                SceneHomeUnLogIn.getStackPane().getChildren().add(PopUpProduct.getStackPane());

                timeUpdate = new Thread(new Runnable() {
                    boolean enough = false;

                    //=========================== เวลาที่น่าจะยังไม่เสร็จ =======================
                    @Override
                    public void run() {
                        SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss");
                        while (!enough) {
                            try {
                                // running "long" operation not on UI thread
                                Thread.sleep(1000);
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
            }

        };
        btnView.setOnAction(ev);

        Font font = new Font(16);
        String itemID;//=========================== here =======================
        SimpleDateFormat dt = new SimpleDateFormat("ddMMyyhhmm");
        //String time = dt.format(new Date());

        //String b = String.format("%04d", countIDAllProduct++).substring(0, 4);
        //=========================== ต้องรับเข้ามา ======================= ID
        //เป้น Item id
        //item = new Text(time + b + " " + ID);
        item = new Text(ID + "");
        item.setFont(font);
        item.setLayoutX(300 - 25);
        item.setLayoutY(50);

        //=========================== ตัวนี้ต้องรับเข้า =======================
        //รับ String มาตั้งเป็น ชื่อสินค้า
        title = new Text("Subaru WRX STI GDB 2015");
        if (!productName.isEmpty()) {
            title.setText(productName);
        }
        title.setFont(font);
        title.setLayoutX(500 - 15);
        title.setLayoutY(50);
//===========================ตัวนี้ต้องรับเข้ามา =======================
        //รับ double เข้ามาตั้งราคา format price+"Baht"
        price = new Text("12300.00 Baht");
        if (!productName.isEmpty()) {
            price.setText(currentPrice + "");
        }
        price.setFont(font);
        price.setLayoutX(1300 - 15);
        price.setLayoutY(50);

        //runTime.textArrayforCal.add(new Label("30"));
        //runTime.textArray.add(new Label(""));
        //runTime.textArray.get(ID-1).setFont(font);
        //runTime.textArray.get(ID-1).setLayoutX(1500 - 20);
        //runTime.textArray.get(ID-1).setLayoutY(50-12);
        timeEnd = new Text("45 Min 33 Sec");
        timeEnd.setFill(Color.web("rgba( 255, 0, 0, 1.0)"));
        timeEnd.setFont(font);
        timeEnd.setLayoutX(1500 - 20);
        timeEnd.setLayoutY(50);

        Rectangle pic = new Rectangle(25, 10, 200, 150);
        Rectangle bgRec = new Rectangle(0, 0, 1920 - 220, 200);
        bgRec.setFill(Color.web("rgba( 200, 200, 200, 1.0)"));
        //Rectangle pic2 = new Rectangle(0, 0, 150, 150);
        productView1 = new Pane(bgRec);
        productView1.getChildren().addAll(pic, item, timeEnd, title, price, btnView);
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
