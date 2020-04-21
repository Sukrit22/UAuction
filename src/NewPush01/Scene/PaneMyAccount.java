/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import AuctionMain.CreateTextField;
import AuctionMain.UserData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
public class PaneMyAccount {

    static private Pane paneMyAccLayer1 = new Pane();
    static private Pane paneRight = new Pane();
    static private Pane paneLeft = new Pane();
    static private Pane paneTop = new Pane();
    static private Pane addItem = new Pane();
    static private Pane paneMyProfile = new Pane();
    static public Pane paneMyObject = new Pane();
    static public ScrollPane scrollPaneMyObject = new ScrollPane();
    static private Pane paneAddProduct = new Pane();
    //static private Pane r = new Pane();
    static public Label name = new Label("Name");
    static public Button btnAdd = new Button("ADD");
    static public Button btnDelete = new Button("DELETE");
    static public Button btnBack = new Button("Back");
    static public Button btnBack2 = new Button("Back");
    static public Button btnMyProfile = new Button("My Profile");
    static public Button btnMyProduct = new Button("My Product");
    static public Button btnAddProduct = new Button("Add Product");
    static private VBox v1 = new VBox();
    static private VBox vboxPaneMyProfile = new VBox();

    static private Text selectText = new Text();
    static private VBox titleVbox = new VBox();
    static private Group titleGroup1;
    static private Group titleGroup2;
    static private Group titleGroup3;
    static private Group titleGroup4;
    static private Group titleGroup5;

    static private TextField productName;
    static private TextField startBid;
    static private TextField minimumBid;
    static private TextArea productDescription;
    static private DatePicker datePicker;
    static private ComboBox comboBoxHour;
    static private ComboBox comboBoxAmPm;

    static private Rectangle pic;

    static public Pane setUpPane() {

        makeAddProductPane();
        makeAllTextField();

        EventHandler<ActionEvent> my1 = (ActionEvent ActionEvent) -> {
            System.out.println("btnMyProfile");
            paneMyProfile.setVisible(true);
            /*System.out.println(vbox1.getChildren().size());
            if (vbox1.getChildren().size() == 3) {
                System.out.println("btnMyProfile2");
                vbox1.getChildren().remove(2);
            }
            if (vbox1.getChildren().size() == 2) {
                System.out.println("btnMyProfile2");
                vbox1.getChildren().add(UserData.userPaneArray.get(UserData.ID_UserThatLogIn));
            }*/
            scrollPaneMyObject.setVisible(false);
            paneAddProduct.setVisible(false);
        };
        PaneMyAccount.btnMyProfile.setOnAction(my1);

        EventHandler<ActionEvent> my2 = (ActionEvent ActionEvent) -> {
            System.out.println("btnMyProduct");
            paneMyProfile.setVisible(false);
            /*System.out.println(paneMyObject.getChildren().size());
            if (paneMyObject.getChildren().isEmpty()) {
                System.out.println("Hello2");
                paneMyObject.getChildren().add(UserData.userPaneArray.get(UserData.ID_UserThatLogIn));
            }*/
            scrollPaneMyObject.setVisible(true);
            paneAddProduct.setVisible(false);
        };
        PaneMyAccount.btnMyProduct.setOnAction(my2);

        EventHandler<ActionEvent> my3 = (ActionEvent ActionEvent) -> {
            System.out.println("btnAddProduct");
            paneMyProfile.setVisible(false);
            scrollPaneMyObject.setVisible(false);
            paneAddProduct.setVisible(true);
        };
        PaneMyAccount.btnAddProduct.setOnAction(my3);

        scrollPaneMyObject.setContent(paneMyObject);
        scrollPaneMyObject.setMinSize(1700, 1080 - 200);
        scrollPaneMyObject.setMaxSize(1700, 1080 - 200);
        scrollPaneMyObject.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        vboxPaneMyProfile.getChildren().addAll(new Label("My Profile Pane"), btnBack2);
        paneMyProfile.getChildren().addAll(vboxPaneMyProfile);

        paneMyProfile.setVisible(true);
        scrollPaneMyObject.setVisible(false);
        paneAddProduct.setVisible(false);

        VBox vbox0 = new VBox();
        //TextField productName = new TextField();
        productName.setPromptText("Product's Name");

        ObservableList<String> cat = FXCollections.observableArrayList("Categorise 1", "Categorise 2", "Categorise 3", "Categorise 4");
        ChoiceBox productCategorise = new ChoiceBox();
        Rectangle shape = new Rectangle(500, 40);
        //productCategorise.setStyle();
        shape.setFill(Color.web("rgba( 255, 0, 0, 1.0)"));
        productCategorise.setStyle("-fx-backgroud-color:rgba( 10, 10, 10, 0.2)");
        //productCategorise.setShape(shape);
        productCategorise.setItems(cat);
        productCategorise.setValue(cat);
        EventHandler<ActionEvent> check = (ActionEvent ActionEvent) -> {
            System.out.println("btncheck");
            System.out.println(productCategorise.getValue().toString());
        };
        Button btncheck = new Button("Check");
        btncheck.setOnAction(check);

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
        comboBoxHour.getItems().addAll("01","02","03","04","05","06","07","08","09","10","11","12");
        comboBoxHour.setMinSize(50, 40);
        comboBoxHour.setLayoutX(0);
        comboBoxHour.setLayoutY(200);
        comboBoxHour.applyCss();
        
        comboBoxAmPm = new ComboBox();
        comboBoxAmPm.getItems().addAll("A.M.","P.M.");
        comboBoxAmPm.setValue("A.M");
        comboBoxAmPm.setMinSize(50, 40);
        comboBoxAmPm.setLayoutX(70);
        comboBoxAmPm.setLayoutY(200);
        comboBoxAmPm.applyCss();

        paneAddProduct.getChildren().addAll(productName, titleVbox, productDescription, minimumBid, startBid, pic, btnAdd, datePicker, comboBoxHour, comboBoxAmPm);

        paneRight.setMinWidth(1700);
        paneRight.setMinHeight(1080 - 200);
        paneRight.setLayoutX(220);
        paneRight.setLayoutY(200);
        paneRight.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:yellow ; ");

        paneTop.setMinWidth(1920);
        paneTop.setMinHeight(200);
        paneTop.setLayoutX(0);
        paneTop.setLayoutY(0);
        paneTop.setStyle("-fx-background-color:yellow ; ");
        paneTop.getChildren().add(name);
        Font font = new Font(32);
        name.setFont(font);

        paneLeft.setMinWidth(220);
        paneLeft.setMinHeight(1080 - 200);
        paneLeft.setLayoutX(0);
        paneLeft.setLayoutY(200);
        paneLeft.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:yellow ; ");
        VBox vbox = new VBox();
        paneLeft.getChildren().add(vbox);
        vbox.getChildren().addAll(btnMyProfile, btnMyProduct, btnAddProduct);
        paneMyAccLayer1.setMinSize(1920, 1080);
        paneMyAccLayer1.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:black ;");

        return paneMyAccLayer1;
    }

    public static Pane getPaneMyAcclayer1() {
        return paneMyAccLayer1;
    }

    static public void makePane() {
        System.out.println("makePane");
        Rectangle bg = new Rectangle();
        bg.setFill(Color.rgb(155, 155, 255, 1.0));
        bg.setWidth(1700);
        bg.setHeight(880);
        addItem.getChildren().add(bg);
        paneRight.getChildren().addAll(addItem, paneAddProduct, paneMyProfile, scrollPaneMyObject);
        paneMyAccLayer1.getChildren().addAll(paneRight, paneTop, paneLeft);

    }

    static private void makeAddProductPane() {
        title1();
        title2();
        title3();
        title4();
        title5();

        Button btnCheck = new Button("Check!");
        titleVbox.setLayoutX(500);
        titleVbox.setLayoutY(200);
        titleVbox.getChildren().addAll(titleGroup1);

        EventHandler<ActionEvent> btnCheckEV = (ActionEvent ActionEvent) -> {
            System.out.println("btnCheck " + selectText.getText());

        };
        btnCheck.setOnAction(btnCheckEV);

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

    public static TextField getProductName() {
        return productName;
    }

    public static TextField getMinimumBid() {
        return minimumBid;
    }

    public static TextArea getProductDescription() {
        return productDescription;
    }

    public static DatePicker getDatePicker() {
        return datePicker;
    }

    public static ComboBox getComboBoxHour() {
        return comboBoxHour;
    }

    public static ComboBox getComboBoxAmPm() {
        return comboBoxAmPm;
    }

    public static Text getSelectText() {
        return selectText;
    }
}
