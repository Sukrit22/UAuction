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
import AuctionMain.CreateButton;
import static AuctionMain.CreateButton.buttonMyAuctionOnACC;

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
    static private Pane paneMyAuction = new Pane(new Label("My Action"));
    static private Pane paneAddProduct = new Pane(new Label("My Product"));
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
        bg.setFill(Color.rgb(250, 250, 250, 1.0));
        bg.setWidth(1700);
        bg.setHeight(880);
        addItem.getChildren().add(bg);
        paneRight.getChildren().addAll(addItem, paneAddProduct, paneMyProfile, scrollPaneMyObject);
        //Rectangle rectFill = new Rectangle(1920);
        Pane paneFill = new Pane();
        paneFill.setStyle("-fx-background-color:rgba(0,0,0,1.0); -fx-stroke:rgba( 10, 10, 10, 0.2);");
        paneFill.setMinSize(1920-220, 1080-200);
        paneFill.setLayoutX(220);
        paneFill.setLayoutY(200);
        paneMyAccLayer1.getChildren().addAll(paneFill, paneRight, paneTop, paneLeft);

        AddProduct.makeAddProductPane();

        EventHandler<MouseEvent> my1 = (MouseEvent ActionEvent) -> {
            System.out.println("btnMyProfile");
            paneMyProfile.setVisible(true);
            scrollPaneMyObject.setVisible(false);
            paneAddProduct.setVisible(false);
            paneMyAuction.setVisible(false);
        };
        CreateButton.buttonMyProfileOnMyACC.setOnMouseClicked(my1);

        EventHandler<MouseEvent> my2 = (MouseEvent ActionEvent) -> {
            System.out.println("btnMyProduct");
            paneMyProfile.setVisible(false);
            scrollPaneMyObject.setVisible(true);
            paneAddProduct.setVisible(false);
            paneMyAuction.setVisible(false);
        };
        CreateButton.buttonMyProductOnACC.setOnMouseClicked(my2);

        EventHandler<MouseEvent> my3 = (MouseEvent ActionEvent) -> {
            System.out.println("btnAddProduct");
            paneMyProfile.setVisible(false);
            scrollPaneMyObject.setVisible(false);
            paneAddProduct.setVisible(true);
            paneMyAuction.setVisible(false);
        };
        CreateButton.buttonAddProductOnACC.setOnMouseClicked(my3);
        
        EventHandler<MouseEvent> my4 = (MouseEvent ActionEvent) -> {
            System.out.println("btnMyAuction");
            paneMyProfile.setVisible(false);
            scrollPaneMyObject.setVisible(false);
            paneAddProduct.setVisible(false);
            paneMyAuction.setVisible(true);
        };
        CreateButton.buttonMyAuctionOnACC.setOnMouseClicked(my4);

        scrollPaneMyObject.setContent(paneMyObject);
        scrollPaneMyObject.setMinSize(1700, 1080 - 200);
        scrollPaneMyObject.setMaxSize(1700, 1080 - 200);
        scrollPaneMyObject.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        vboxPaneMyProfile.getChildren().addAll(new Label("My Profile Pane"), btnBack2);
        paneMyProfile.getChildren().addAll(vboxPaneMyProfile);

        paneMyProfile.setVisible(true);
        scrollPaneMyObject.setVisible(false);
        paneAddProduct.setVisible(false);
        paneMyAuction.setVisible(false);

        VBox vbox0 = new VBox();
        //TextField productName = new TextField();

        paneAddProduct.setStyle("-fx-background-color:rgba(88,88,88,1.0) ; ");
        paneAddProduct.setMinSize(1920-220, 1080-200);
        paneAddProduct.getChildren().addAll(AddProduct.productName, AddProduct.titleVbox, AddProduct.productDescription, AddProduct.minimumBid, AddProduct.startBid, AddProduct.pic, btnAdd, AddProduct.datePicker, AddProduct.comboBoxHour, AddProduct.comboBoxAmPm);

        paneRight.setMinWidth(1700);
        paneRight.setMinHeight(1080 - 200);
        paneRight.setLayoutX(220+5);
        paneRight.setLayoutY(200+5);
        //paneRight.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:yellow ; ");

        paneTop.setMinWidth(1920);
        paneTop.setMinHeight(200);
        paneTop.setLayoutX(0);
        paneTop.setLayoutY(0);
        paneTop.setStyle("-fx-background-color:rgba(88,88,88,1.0) ; ");
        CreateButton.buttonBackOnACC2.setLayoutX(1920 - 400 - 150);
        paneTop.getChildren().addAll( CreateButton.buttonBackOnACC2, CreateButton.buttonTime2);
        Font font = new Font(32);
        name.setFont(font);

        paneLeft.setMinWidth(220);
        paneLeft.setMinHeight(1080 - 200);
        paneLeft.setLayoutX(0);
        paneLeft.setLayoutY(200);
        paneLeft.setStyle("-fx-background-color:rgba(88,88,88,1.0) ; ");
        //paneLeft.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:yellow ; ");
        VBox vbox = new VBox();
        Rectangle leftbg = new Rectangle(220, 1080 - 200);
        leftbg.setFill(Color.web("rgba( 80, 80, 80, 1.0)"));
        paneLeft.getChildren().addAll(leftbg, vbox);
        vbox.getChildren().addAll(CreateButton.buttonMyProfileOnMyACC, CreateButton.buttonMyAuctionOnACC, CreateButton.buttonMyProductOnACC, CreateButton.buttonAddProductOnACC, CreateButton.buttonBlankOnACC, CreateButton.buttonBackOnACC);
        paneMyAccLayer1.setMinSize(1920, 1080);
        //paneMyAccLayer1.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:black ;");

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
