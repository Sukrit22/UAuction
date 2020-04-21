/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene.Home.MyAccount;

import AuctionMain.CreateTextField;
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




    static private Rectangle pic;

    static public void setUpPane() {

        Rectangle bg = new Rectangle();
        bg.setFill(Color.rgb(155, 155, 255, 1.0));
        bg.setWidth(1700);
        bg.setHeight(880);
        addItem.getChildren().add(bg);
        paneRight.getChildren().addAll(addItem, paneAddProduct, paneMyProfile, scrollPaneMyObject);
        paneMyAccLayer1.getChildren().addAll(paneRight, paneTop, paneLeft);
        
        AddProduct.makeAddProductPane();
        

        EventHandler<ActionEvent> my1 = (ActionEvent ActionEvent) -> {
            System.out.println("btnMyProfile");
            paneMyProfile.setVisible(true);
            scrollPaneMyObject.setVisible(false);
            paneAddProduct.setVisible(false);
        };
        PaneMyAccount.btnMyProfile.setOnAction(my1);

        EventHandler<ActionEvent> my2 = (ActionEvent ActionEvent) -> {
            System.out.println("btnMyProduct");
            paneMyProfile.setVisible(false);
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


        paneAddProduct.getChildren().addAll(AddProduct.productName, AddProduct.titleVbox, AddProduct.productDescription, AddProduct.minimumBid, AddProduct.startBid, AddProduct.pic, btnAdd, AddProduct.datePicker, AddProduct.comboBoxHour, AddProduct.comboBoxAmPm);

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

        //return paneMyAccLayer1;
    }

    public static Pane getPaneMyAcclayer1() {
        return paneMyAccLayer1;
    }

    static public void makePane() {
        System.out.println("makePane");
        

    }

    public static Text getSelectText() {
        return selectText;
    }
}

/*       ObservableList<String> cat = FXCollections.observableArrayList("Categorise 1", "Categorise 2", "Categorise 3", "Categorise 4");
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
*/