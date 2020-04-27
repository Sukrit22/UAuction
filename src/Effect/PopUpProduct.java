/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Effect;

import AuctionMain.runTime;
import Scene.Home.SceneHomeUnLogIn;
import Scene.ProductPaneInVbox;
import static Scene.ProductPaneInVbox.timeUpdate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import uauction.ActiveProduct;
import uauction.NewClient;

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
    public static boolean enough;

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
    

    static public void createpopUpBackground(String nameofProduct,String str,String currentPrice,Date timeEnd,String minBid,ActiveProduct ap) {

        timeUpdate = new Thread(new Runnable() {
            Date endDate = timeEnd;

            //=========================== โอเคแล้ว =======================
            @Override
            public void run() {
                SimpleDateFormat dt;
                enough = false;
                while (!enough) {
                    
                    if (timeEnd.getTime() - (new Date()).getTime() >= 86400000) { //ถ้า เวลามากกว่า24 ชั่วโมง แสดงเป็นวัน
                        dt = new SimpleDateFormat("dd-MM-yyyy");
                        try {
                            // running "long" operation not on UI thread
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                        PopUpProduct.getTimeLeft().setText(dt.format(timeEnd));
                    } else if (timeEnd.getTime() - (new Date()).getTime() < 86400000 ) { //ถ้าเวลาน้อยกว่า 24ชม แสดงเป็น ชม
                        dt = new SimpleDateFormat("hh:mm:ss");
                        if(timeEnd.getTime() - (new Date()).getTime()<3600000) {
                            dt = new SimpleDateFormat("mm:ss");
                        }
                        try {
                            // running "long" operation not on UI thread
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            
                        }
                        
                        long timeL = timeEnd.getTime() - (new Date()).getTime();
                        timeL-=25200000;
                        PopUpProduct.getTimeLeft().setText(dt.format(new Date(timeL)));
                        
//                        String Shh = "00",Smm = "00",Sss = "00";
//                        int ss=0,mm=0,hh=0;
//                        ss = timeEnd.getSeconds()-(new Date()).getSeconds();
//                        mm = timeEnd.getMinutes()-(new Date()).getMinutes();
//                        hh = timeEnd.getHours()-(new Date()).getHours();
//                        if(ss<0){
//                            mm-=1;
//                            ss+=60;
//                        }
//                        if(mm<0){
//                            hh-=1;
//                            mm+=60;
//                        }
//                        if(ss<10)
//                            Sss = "0"+ss;
//                        if(ss<10)
//                            Sss = ss+"";
//                        if(mm<10)
//                            Smm = "0"+mm;
//                        if(mm<10)
//                            Smm = mm+"";
//                        if(hh<10)
//                            Shh = "0"+hh;
//                        if(hh<10)
//                            Shh = hh+"";
//                            
//                        PopUpProduct.getTimeLeft().setText(Shh+":"+Smm+":"+Sss);
//                    Platform.runLater(() -> {
//                        //System.out.println("Run Ja");
//                        //PopUpProduct.getTimeLeft().setText(time);
//                    });
                    }
                }
            }
        });

        
        Font font = new Font(24);

        productName = new Text("Product Name");
        productName.setFont(font);
        productName.setLayoutX(450 + 40);
        productName.setLayoutY(20 + 40);

        productName2 = new Text(nameofProduct);
        productName2.setFont(font);
        productName2.setLayoutX(450 + 40 + 36);
        productName2.setLayoutY(20 + 40 + 36);

        price = new Text("Current Price");
        price.setFont(font);
        price.setLayoutX(450 + 40);
        price.setLayoutY(60 + 48 + 48);
//=========================== need to be updatable =======================
        price2 = new Text(currentPrice);
        price2.setFont(font);
        price2.setLayoutX(450 + 40 + 23);
        price2.setLayoutY(60 + 48 + 48 + 36);
//=========================== already updatable =======================
        //runTime.textArray.get(0).setLayoutY(20);
        timeLeft = new Text("timeLeft");
        timeLeft.setFont(font);
        timeLeft.setLayoutX(450 + 40);
        timeLeft.setLayoutY(60 + 48 + 48 + 48 + 48);
        
        timeLeft2 = new Text("");
        timeLeft2.setFont(font);
        timeLeft2.setLayoutX(450 + 40 + 36);
        timeLeft2.setLayoutY(60 + 48 + 48 + 48 + 48 + 36);

        minimumBid = new Text("Minimum Bid\n    ");
        minimumBid.setFont(font);
        minimumBid.setLayoutX(450 + 40);
        minimumBid.setLayoutY(60 + 48 + 48 + 48 + 48 + 48 + 48);
        //=========================== fixed date =======================
        minimumBid2 = new Text(minBid);
        minimumBid2.setFont(font);
        minimumBid2.setLayoutX(450 + 40 + 36);
        minimumBid2.setLayoutY(60 + 48 + 48 + 48 + 48 + 48 + 48 + 36);
        //=========================== only number =======================
        yourBid = new TextField();
        yourBid.setPromptText("BID");
        //yourBid.setFont(font);
        yourBid.setMinSize(60, 30);
        yourBid.setMaxSize(60, 30);
        yourBid.setLayoutX(40);
        yourBid.setLayoutY(400);
        //=========================== need to set event =======================
        btnBid = new Button("Bid");
        btnBid.setLayoutX(40 + 60);
        btnBid.setLayoutY(400);
        btnBid.setMinSize(40, 30);
        btnBid.setOnAction(eh -> {
            if (Double.parseDouble(yourBid.getText())>=ap.getProduct().getMinimumBid()+ap.getCurrentBid()) {//เงินบิดห้ามต่ำกว่า currentBid+minimunBid
                try {
                    NewClient.reqBid(ap.getProduct().getFileName(), yourBid.getText(), NewClient.user.getUsername());
                    //ปิด popupProduct
                    SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUpProduct.getStackPane());
                    System.out.println("Click");
                    PopUpProduct.enough = true;
                    NewClient.reqMarket();
                    NewClient.showMarket(NewClient.myViewSelected);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("reqBid in PopUpPro");
                }
            }else{
                System.out.println("your bid is less than current+minimun");
            }
        });
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
            PopUpProduct.enough = true;

        };
        recBGFade.setOnMouseClicked(mcc);

        panepane = new Pane();
        panepane.setMaxSize(800, 600);
        pic = new Rectangle(40, 40, 400, 300);
        pic.setFill(new ImagePattern(new Image("file:///"+System.getProperty("user.dir")+"/AuctionDataBase/Image/"+ap.getProduct().getImageName())));
        name = new Label("");
        name.setLayoutX(200);
        name.setLayoutY(20);

        //Pane fadePane = new Pane(recBGFade);
        panepane.getChildren().addAll(recBGPopUp, pic, name, btnMoreDetail, productName, productName2, price, price2, timeLeft, timeLeft2, minimumBid, minimumBid2, yourBid, btnBid);

        stackPane = new StackPane();
        stackPane.getChildren().addAll(recBGFade, panepane);

    }

    public static StackPane getStackPane() {
        return stackPane;
    }
}
