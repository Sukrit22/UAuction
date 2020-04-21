/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene.Home;

import AuctionMain.CreateButton;
import static AuctionMain.CreateButton.buttonHelpPaneTop;
import Scene.CategorisePane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
public class PaneLeft {

    static private Pane pane = new Pane();
    static private VBox titleVbox = new VBox();
    static private VBox inTitleVbox1 = new VBox();
    static private VBox inTitleVbox2 = new VBox();
    static private VBox inTitleVbox3 = new VBox();
    static private VBox inTitleVbox4 = new VBox();
    static private Group titleGroup1;
    static private Group titleGroup2;
    static private Group titleGroup3;
    static private Group titleGroup4;
    static private Group titleGroup5;

    static private Group intitleGroup101;
    static private Group intitleGroup102;
    static private Group intitleGroup103;
    static private Group intitleGroup104;

    static public void setUp() {
        //Button a = new Button();
        title1();
        title2();
        title3();
        title4();
        title5();
        intitle1_1();
        intitle1_2();
        intitle1_3();
        intitle1_4();

        inTitleVbox1.getChildren().addAll(intitleGroup101, intitleGroup102, intitleGroup103, intitleGroup104);
        Label labelT21 = new Label("labelT21");
        Label labelT22 = new Label("labelT22");
        Label labelT23 = new Label("labelT23");
        inTitleVbox2.getChildren().addAll(labelT21, labelT22, labelT23);
        Label labelT31 = new Label("labelT31");
        Label labelT32 = new Label("labelT32");
        Label labelT33 = new Label("labelT33");
        inTitleVbox3.getChildren().addAll(labelT31, labelT32, labelT33);

        titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);

        EventHandler<MouseEvent> evTitle1 = (MouseEvent ActionEvent) -> {
            for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                titleVbox.getChildren().remove(i);
            }
            titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
            for (int i = 0; i < CategorisePane.paneArray.size(); i++) {
                CategorisePane.paneArray.get(i).setVisible(false);
            }
            CategorisePane.paneArray.get(0).setVisible(true);

        };
        titleGroup1.setOnMouseClicked(evTitle1);

        EventHandler<MouseEvent> evTitle2 = (MouseEvent ActionEvent) -> {
            if (titleVbox.getChildren().get(2) != inTitleVbox1) {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
                titleVbox.getChildren().add(2, inTitleVbox1);
            } else {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
            }
            for (int i = 0; i < CategorisePane.paneArray.size(); i++) {
                CategorisePane.paneArray.get(i).setVisible(false);
            }
            CategorisePane.paneArray.get(1).setVisible(true);
        };
        titleGroup2.setOnMouseClicked(evTitle2);

        EventHandler<MouseEvent> evTitle3 = (MouseEvent ActionEvent) -> {
            if (titleVbox.getChildren().get(3) != inTitleVbox2) {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
                titleVbox.getChildren().add(3, inTitleVbox2);
            } else {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
            }
            for (int i = 0; i < CategorisePane.paneArray.size(); i++) {
                CategorisePane.paneArray.get(i).setVisible(false);
            }
            CategorisePane.paneArray.get(2).setVisible(true);
        };
        titleGroup3.setOnMouseClicked(evTitle3);

        EventHandler<MouseEvent> evTitle4 = (MouseEvent ActionEvent) -> {
            if (titleVbox.getChildren().get(4) != inTitleVbox3) {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
                titleVbox.getChildren().add(4, inTitleVbox3);
            } else {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
            }
            for (int i = 0; i < CategorisePane.paneArray.size(); i++) {
                CategorisePane.paneArray.get(i).setVisible(false);
            }
            CategorisePane.paneArray.get(3).setVisible(true);
        };
        titleGroup4.setOnMouseClicked(evTitle4);

        EventHandler<MouseEvent> evTitle5 = (MouseEvent ActionEvent) -> {
            if (titleVbox.getChildren().size() == 6) {
                if (titleVbox.getChildren().get(5) != inTitleVbox4) {
                    for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                        titleVbox.getChildren().remove(i);
                    }
                    titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
                    //titleVbox.getChildren().add(5, inTitleVbox3);
                } else {
                    for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                        titleVbox.getChildren().remove(i);
                    }
                    titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
                }
            } else {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
                titleVbox.getChildren().add(5, inTitleVbox4);
            }
            for (int i = 0; i < CategorisePane.paneArray.size(); i++) {
                CategorisePane.paneArray.get(i).setVisible(false);
            }
            CategorisePane.paneArray.get(4).setVisible(true);

        };
        titleGroup5.setOnMouseClicked(evTitle5);

        pane.getChildren().add(titleVbox);
    }

    static private void title1() {
        Rectangle rect = new Rectangle(220, 40);
        rect.setFill(Color.web("rgba( 125, 125, 125, 1.0)"));
        rect.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        Text logIn = new Text("All");
        logIn.setLayoutX(0);
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);
        pane.setLayoutX(0);
        //pane.setLayoutX(1920 - 400 - 150);
        logIn.applyCss();
        titleGroup1 = new Group(rect, pane);
    }

    static private void title2() {
        Rectangle rect = new Rectangle(220, 40);
        rect.setFill(Color.web("rgba( 125, 125, 125, 1.0)"));
        rect.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        Text logIn = new Text("Electronic");
        logIn.setLayoutX(0);
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);
        pane.setLayoutX(0);
        //pane.setLayoutX(1920 - 400 - 150);
        logIn.applyCss();
        titleGroup2 = new Group(rect, pane);
    }

    static private void title3() {
        Rectangle rect = new Rectangle(220, 40);
        rect.setFill(Color.web("rgba( 125, 125, 125, 1.0)"));
        rect.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        Text logIn = new Text("Health & Beauty");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);
        pane.setLayoutX(0);
        logIn.applyCss();
        titleGroup3 = new Group(rect, pane);
    }

    static private void title4() {
        Rectangle rect = new Rectangle(220, 40);
        rect.setFill(Color.web("rgba( 125, 125, 125, 1.0)"));
        rect.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        Text logIn = new Text("Home & Lifestyle");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);
        pane.setLayoutX(0);
        logIn.applyCss();
        titleGroup4 = new Group(rect, pane);
    }

    static private void title5() {
        Rectangle rect = new Rectangle(220, 40);
        rect.setFill(Color.web("rgba( 125, 125, 125, 1.0)"));
        rect.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        Text logIn = new Text("Automotive");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);
        pane.setLayoutX(0);
        logIn.applyCss();
        titleGroup5 = new Group(rect, pane);
    }

    static private void intitle1_1() {
        Rectangle rect = new Rectangle(220, 40);
        rect.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        rect.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        Text logIn = new Text("Mobiles & Tablets");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);
        logIn.applyCss();
        intitleGroup101 = new Group(rect, pane);
    }

    static private void intitle1_2() {
        Rectangle rect = new Rectangle(220, 40);
        rect.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        rect.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        Text logIn = new Text("Laptops & Desktops");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);
        logIn.applyCss();
        intitleGroup102 = new Group(rect, pane);
    }

    static private void intitle1_3() {
        Rectangle rect = new Rectangle(220, 40);
        rect.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        rect.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        Text logIn = new Text("Camera");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);
        logIn.applyCss();
        intitleGroup103 = new Group(rect, pane);
    }

    static private void intitle1_4() {
        Rectangle rect = new Rectangle(220, 40);
        rect.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        rect.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        Text logIn = new Text("Else");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);
        logIn.applyCss();
        intitleGroup104 = new Group(rect, pane);
    }

    static public Pane getPane() {
        return pane;
    }
}
