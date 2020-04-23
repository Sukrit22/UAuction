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
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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

        SimpleDateFormat minDT = new SimpleDateFormat("ddMMyyyyhhmmss");
        long minI = Long.parseLong(minDT.format(new Date()));
        System.out.println(minDT.format(new Date()));
        Label test1 = new Label(minDT.format(new Date()));


        Label test2 = new Label(minDT.format(new Date()));

        runTime.textArrayforCal.add(test1);
        runTime.textArray.add(test2);
        //test1.setFill(Color.web("rgba( 240, 240, 240, 1.0)"));
        //Pane testPane = new Pane(test1);
        //testPane.setLayoutX(0);
        //testPane.setLayoutY(0);
        //testPane.setMinSize(200, 50);
        //runTime.textArray.add(e)
        runTime.textArray.get(0).setLayoutY(20);

        pane.getChildren().addAll(runTime.textArray.get(0), runTime.textArrayforCal.get(0), CreateTextField.search, CreateButton.buttonSearch, CreateButton.buttonLogInPaneTop, CreateButton.buttonBellHome, CreateButton.buttonBellHomeEff);

    }

    public static Pane getPane() {
        return pane;
    }
}
