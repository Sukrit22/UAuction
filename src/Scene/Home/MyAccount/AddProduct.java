/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene.Home.MyAccount;

import static Scene.Home.MyAccount.PaneMyAccount.scrollPaneMyObject;
import com.sun.javafx.logging.PlatformLogger.Level;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Sitth
 */
public class AddProduct {

    static private Text selectText = new Text();
    static public VBox titleVbox = new VBox();
    static private Group titleGroup1;
    static private Group titleGroup2;
    static private Group titleGroup3;
    static private Group titleGroup4;
    static private Group titleGroup5;

    static public DatePicker datePicker;
    static public ComboBox comboBoxHour;
    static public ComboBox comboBoxAmPm;

    static public TextField productName;
    static public TextField startBid;
    static public TextField minimumBid;
    static public TextArea productDescription;
    static public Rectangle pic;

    static private Desktop desktop = Desktop.getDesktop();

    static public void makeAddProductPane() {
        title1();
        title2();
        title3();
        title4();
        title5();
        makeAllTextField();

        //vbox0.getChildren().addAll(new Label("Add Product"), productName, productCategorise, btncheck, btnAdd, btnBack);
        datePicker = new DatePicker();
        datePicker.setLayoutX(0);
        datePicker.setLayoutY(250);
        datePicker.setMinSize(205, 40);
        datePicker.applyCss();
        //datePicker.setStyle("-fx-text-inner-color:black; -fx-background-radius:10; -fx-background-color:rgba( 125, 125, 125, 1.0); ");

        comboBoxHour = new ComboBox();
        comboBoxAmPm = new ComboBox();
        comboBoxHour.setPromptText("Hour");
        comboBoxHour.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
        comboBoxHour.setMinSize(50, 40);
        comboBoxHour.setLayoutX(0);
        comboBoxHour.setLayoutY(200);
        comboBoxHour.applyCss();

        comboBoxAmPm = new ComboBox();
        comboBoxAmPm.getItems().addAll("A.M.", "P.M.");
        comboBoxAmPm.setValue("A.M");
        comboBoxAmPm.setMinSize(50, 40);
        comboBoxAmPm.setLayoutX(70);
        comboBoxAmPm.setLayoutY(200);
        comboBoxAmPm.applyCss();

        Button btnCheck = new Button("Check!");
        titleVbox.setLayoutX(500);
        titleVbox.setLayoutY(200);
        titleVbox.getChildren().addAll(titleGroup1);

        EventHandler<ActionEvent> btnCheckEV = (ActionEvent ActionEvent) -> {
            System.out.println("btnCheck " + selectText.getText());

        };
        btnCheck.setOnAction(btnCheckEV);

        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");

        EventHandler<MouseEvent> addpicEV = (MouseEvent ActionEvent) -> {
            System.out.println("btnCheck " + selectText.getText());
            Stage stage = new Stage();
            File file = fileChooser.showOpenDialog(stage);
            System.out.println(file.toString());
            Image image = new Image(file.toString());
            ImageView imv = new ImageView(image);
            pic.setClip(imv);
            /*if (file != null) {
                openFile(file);
            }*/

        };
        pic.setOnMouseClicked(addpicEV);

        EventHandler<MouseEvent> evTitle1 = (MouseEvent ActionEvent) -> {
            if (titleVbox.getChildren().size() == 1) {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
            } else {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }

                titleVbox.getChildren().addAll(titleGroup1);
            }

        };
        titleGroup1.setOnMouseClicked(evTitle1);

        EventHandler<MouseEvent> evTitle2 = (MouseEvent ActionEvent) -> {
            if (titleVbox.getChildren().size() == 1) {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
            } else {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                selectText.setText("Eletronic");
                titleVbox.getChildren().addAll(titleGroup1);
            }

        };
        titleGroup2.setOnMouseClicked(evTitle2);

        EventHandler<MouseEvent> evTitle3 = (MouseEvent ActionEvent) -> {
            if (titleVbox.getChildren().size() == 1) {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
            } else {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                selectText.setText("Health & Beauty");
                titleVbox.getChildren().addAll(titleGroup1);
            }

        };
        titleGroup3.setOnMouseClicked(evTitle3);

        EventHandler<MouseEvent> evTitle4 = (MouseEvent ActionEvent) -> {
            if (titleVbox.getChildren().size() == 1) {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
            } else {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                selectText.setText("Home & Lifestyle");
                titleVbox.getChildren().addAll(titleGroup1);
            }

        };
        titleGroup4.setOnMouseClicked(evTitle4);

        EventHandler<MouseEvent> evTitle5 = (MouseEvent ActionEvent) -> {
            if (titleVbox.getChildren().size() == 1) {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
            } else {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                selectText.setText("Automotive");
                titleVbox.getChildren().addAll(titleGroup1);
            }

        };
        titleGroup5.setOnMouseClicked(evTitle5);
    }

    static private void title1() {
        Rectangle rect = new Rectangle(220, 40);
        rect.setFill(Color.web("rgba( 125, 125, 125, 1.0)"));
        rect.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        selectText = new Text("Select Categorise");
        selectText.setLayoutX(0);
        selectText.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(220, 40);
        pane.getChildren().add(selectText);
        pane.setLayoutX(0);
        //pane.setLayoutX(1920 - 400 - 150);
        selectText.applyCss();
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

    static private void makeAllTextField() {

        productName = new TextField();
        productName.setPromptText("Name");
        productName.setMinHeight(40);
        productName.setMinWidth(220);
        productName.setLayoutX(500);
        productName.setLayoutY(50);
        productName.applyCss();
        productName.setPromptText("Product's Name");

        //productName.setStyle("-fx-text-inner-color: red; -fx-background-radius:10; -fx-background-color:rgba( 125, 125, 125, 1.0); ");
        startBid = new TextField();
        startBid.setPromptText("Start Bid");
        startBid.setMinHeight(40);
        startBid.setMinWidth(220);
        startBid.setLayoutX(800);
        startBid.setLayoutY(50);

        minimumBid = new TextField();
        minimumBid.setPromptText("Minimun Bid");
        minimumBid.setMinHeight(40);
        minimumBid.setMinWidth(220);
        minimumBid.setLayoutX(500);
        minimumBid.setLayoutY(130);

        productDescription = new TextArea();
        productDescription.setPromptText("Description");
        productDescription.setLayoutX(0);
        productDescription.setLayoutY(500);
        productDescription.setScrollTop(0);
        productDescription.setScrollLeft(0);
        productDescription.setPrefRowCount(5);
        //productDescription

        pic = new Rectangle(150, 150);

    }
}
