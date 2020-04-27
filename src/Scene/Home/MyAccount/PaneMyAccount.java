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
import Effect.PopUp;
import Stage.StageStorage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

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
        bg.setFill(Color.rgb(250, 250, 250, 1.0));
        bg.setWidth(1700);
        bg.setHeight(880);
        addItem.getChildren().add(bg);
        
        Rectangle r = new Rectangle(1920-220,1080-200);
        r.setFill(new ImagePattern(new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/auctiond.png")));
        paneMyAuction.getChildren().add(r);
        
        Rectangle r2 = new Rectangle(1920-220,1080-200);
        r2.setFill(new ImagePattern(new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/myProduct.png")));
        paneMyObject.getChildren().add(r2);
        
        paneRight.getChildren().addAll(addItem, paneAddProduct, paneMyAuction, scrollPaneMyObject);
        //Rectangle rectFill = new Rectangle(1920);
        Pane paneFill = new Pane();
        paneFill.setStyle("-fx-background-color:rgba(0,0,0,1.0); -fx-stroke:rgba( 10, 10, 10, 0.2);");
        paneFill.setMinSize(1920 - 220, 1080 - 200);
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
            PopUp.incorrecypassPane.setVisible(false);
        };
        //CreateButton.buttonMyProfileOnMyACC.setOnMouseClicked(my1);

        EventHandler<MouseEvent> my2 = (MouseEvent ActionEvent) -> {
            System.out.println("btnMyProduct");
            paneMyProfile.setVisible(false);
            scrollPaneMyObject.setVisible(true);
            paneAddProduct.setVisible(false);
            paneMyAuction.setVisible(false);
            PopUp.incorrecypassPane.setVisible(false);
        };
        CreateButton.buttonMyProductOnACC.setOnMouseClicked(my2);

        EventHandler<MouseEvent> my3 = (MouseEvent ActionEvent) -> {
            System.out.println("btnAddProduct");
            paneMyProfile.setVisible(false);
            scrollPaneMyObject.setVisible(false);
            paneAddProduct.setVisible(true);
            paneMyAuction.setVisible(false);
            PopUp.incorrecypassPane.setVisible(false);
        };
        CreateButton.buttonAddProductOnACC.setOnMouseClicked(my3);

        EventHandler<MouseEvent> my4 = (MouseEvent ActionEvent) -> {
            System.out.println("btnMyAuction");
            paneMyProfile.setVisible(false);
            scrollPaneMyObject.setVisible(false);
            paneAddProduct.setVisible(false);
            paneMyAuction.setVisible(true);
            PopUp.incorrecypassPane.setVisible(false);
        };
        CreateButton.buttonMyAuctionOnACC.setOnMouseClicked(my4);

        scrollPaneMyObject.setContent(paneMyObject);
        scrollPaneMyObject.setMinSize(1700, 1080 - 200);
        scrollPaneMyObject.setMaxSize(1700, 1080 - 200);
        scrollPaneMyObject.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        vboxPaneMyProfile.getChildren().addAll(new Label("My Profile Pane"), btnBack2);
        paneMyProfile.getChildren().addAll(MyProfliePane.getAndSetPane());
        paneMyProfile.setMinSize(1920-220, 1080-200);
        paneMyProfile.setStyle("-fx-background-color:rgba(88,88,88,1.0) ; ");

        paneMyProfile.setVisible(true);
        scrollPaneMyObject.setVisible(false);
        paneAddProduct.setVisible(false);
        paneMyAuction.setVisible(true);
        
        

        VBox vbox0 = new VBox();
        //TextField productName = new TextField();

        paneAddProduct.setStyle("-fx-background-color:rgba(88,88,88,1.0) ; ");
        paneAddProduct.setMinSize(1920 - 220, 1080 - 200);
        AddProduct.riri.setLayoutX(220);
        AddProduct.riri.setLayoutY(1080/2);
        AddProduct.riri.setVisible(false);
        paneAddProduct.getChildren().addAll(AddProduct.productName, AddProduct.productDescription, AddProduct.minimumBid, AddProduct.startBid, AddProduct.pic, btnAdd, AddProduct.datePicker, AddProduct.comboBoxHour, AddProduct.comboBoxAmPm, AddProduct.titleVbox, AddProduct.riri);

        paneRight.setMinWidth(1700);
        paneRight.setMinHeight(1080 - 200);
        paneRight.setLayoutX(220 + 5);
        paneRight.setLayoutY(200 + 5);
        //paneRight.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:yellow ; ");

        Image im2 = new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/exitRed255.png");
        ImageView iv2 = new ImageView(im2);
        iv2.setFitHeight(20);
        iv2.setLayoutX(2);
        iv2.setLayoutY(2);
        iv2.setPreserveRatio(true);
        
        EventHandler<MouseEvent> eh = (MouseEvent ActionEvent) -> {
            //Do code here
            StageStorage.Auction.close();
        };
        
        iv2.setOnMouseClicked(eh);
        
        Image im3 = new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/minimizeBlack.png");
        ImageView iv3 = new ImageView(im3);
        iv3.setFitHeight(20);
        iv3.setLayoutX(2+20+10);
        iv3.setLayoutY(2);
        iv3.setPreserveRatio(true);
        
        EventHandler<MouseEvent> eh3 = (MouseEvent ActionEvent) -> {
            //Do code here
            StageStorage.Auction.setIconified(true);
        };
        
        iv3.setOnMouseClicked(eh3);
        
        Rectangle rec = new Rectangle(1920,24);
        rec.setArcHeight(8);
        rec.setArcWidth(4);
        rec.setFill(Color.web("rgba( 200, 200, 200, 1.0)"));
        
        Image im5 = new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/topPane4.png");
        ImageView iv5 = new ImageView(im5);
        Image im = new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/topPane3.png");
        ImageView iv = new ImageView(im);
        iv.setFitHeight(200-50-24);
        //iv.setFitWidth(360);
        iv.setLayoutX(1920/2);
        iv.setLayoutY(50+15);
        iv.setPreserveRatio(true);
        paneTop.setMinWidth(1920);
        paneTop.setMinHeight(200);
        paneTop.setLayoutX(0);
        paneTop.setLayoutY(0);
        paneTop.setStyle("-fx-background-color:rgba(88,88,88,1.0) ; ");
        CreateButton.buttonBackOnACC2.setLayoutX(1920 - 400 - 150);
        paneTop.getChildren().addAll(iv5, iv, rec, iv2, iv3, CreateButton.buttonBackOnACC2, CreateButton.buttonTime2);
        Font font = new Font(32);
        name.setFont(font);

        Image im4 = new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/left.png");
        ImageView iv4 = new ImageView(im4);
        paneLeft.setMinWidth(220);
        paneLeft.setMinHeight(1080 - 200);
        paneLeft.setLayoutX(0);
        paneLeft.setLayoutY(200);
        paneLeft.setStyle("-fx-background-color:rgba(88,88,88,1.0) ; ");
        //paneLeft.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color:yellow ; ");
        VBox vbox = new VBox();
        Rectangle leftbg = new Rectangle(220, 1080 - 200);
        leftbg.setFill(Color.web("rgba( 80, 80, 80, 1.0)"));
        paneLeft.getChildren().addAll(iv4, vbox);
        //vbox.getChildren().addAll(CreateButton.buttonMyProfileOnMyACC, CreateButton.buttonMyAuctionOnACC, CreateButton.buttonMyProductOnACC, CreateButton.buttonAddProductOnACC, CreateButton.buttonBlankOnACC, CreateButton.buttonBackOnACC);
        vbox.getChildren().addAll( CreateButton.buttonMyAuctionOnACC, CreateButton.buttonMyProductOnACC, CreateButton.buttonAddProductOnACC, CreateButton.buttonBlankOnACC, CreateButton.buttonBackOnACC);
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
