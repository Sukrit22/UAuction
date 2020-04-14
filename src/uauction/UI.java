/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 *
 * @author poomy
 */
public class UI extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        initUI(stage);
    }
    
    private void initUI(Stage primaryStage){
        
        primaryStage.setTitle("U Auction");
        
        //init Grid
        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setPadding(new Insets(15, 15, 15, 15));
        
        ColumnConstraints cons1 = new ColumnConstraints();
        cons1.setHgrow(Priority.NEVER);
        grid.getColumnConstraints().add(cons1);

        ColumnConstraints cons2 = new ColumnConstraints();
        cons2.setHgrow(Priority.ALWAYS);
        
        grid.getColumnConstraints().addAll(cons1, cons2);
        
        RowConstraints rcons1 = new RowConstraints();
        rcons1.setVgrow(Priority.NEVER);
        
        RowConstraints rcons2 = new RowConstraints();
        rcons2.setVgrow(Priority.NEVER);
        
        grid.getRowConstraints().addAll(rcons1, rcons2);
        
        //DataField
        //Label uAuctionBtn = new Label("LOGO");
        Button uAuctionBtn = new Button();
        Image logo = new Image("file:///"+System.getProperty("user.dir")+"/src/uauction/res/logo.png");
        ImageView viewLogo = new ImageView(logo);
        viewLogo.setFitHeight(60);
        viewLogo.setFitWidth(90);
        uAuctionBtn.setGraphic(viewLogo);
        
        Button feedBackBtn = new Button("feedBack");
        Button faqBtn = new Button("FAQ");
        Button loginBtn = new Button("Login & Register");
        Label loginStatus = new Label();
        
        TextField search = new TextField();
        
        search.setPromptText("Search here");
        
        ChoiceBox<String> catagorie = new ChoiceBox<>();
        catagorie.getItems().addAll("Car", "Computer", "Clothes", "Housing");
        catagorie.setValue("Car");
        
        CheckBox priceRange1 = new CheckBox("1000 below");
        CheckBox priceRange2 = new CheckBox("1000-1500");
        CheckBox priceRange3 = new CheckBox("1500-2000");
        CheckBox priceRange4 = new CheckBox("2000-2500");
        CheckBox priceRange5 = new CheckBox("2500-3000");
        
        TableView table = new TableView();
        table.setEditable(true);
        TableColumn name = new TableColumn("Product Name");
        TableColumn tag = new TableColumn("Catagories");
        TableColumn price = new TableColumn("Price");
        name.setMinWidth(100);
        name.setMaxWidth(100);
        tag.setMinWidth(100);
        tag.setMaxWidth(100);
        TableColumn nowBidding = new TableColumn("Now Bidding");
        TableColumn minBid = new TableColumn("Minimum Bid");
        price.getColumns().addAll(nowBidding, minBid);
        table.getColumns().addAll(name, tag, price);
        
        //Pos grid
        //GridPane.setHalignment(loginBtn, HPos.LEFT);
        
        grid.add(uAuctionBtn, 0, 0);
        grid.add(feedBackBtn, 4, 0);
        grid.add(faqBtn, 5, 0);
        grid.add(loginBtn, 6, 0);
        grid.add(search, 2, 0, 2, 1);
        grid.add(catagorie, 0, 1, 1, 1);
        grid.add(priceRange1, 0, 2);
        grid.add(priceRange2, 0, 3);
        grid.add(priceRange3, 0, 4);
        grid.add(priceRange4, 0, 5);
        grid.add(priceRange5, 0, 6);
        grid.add(table, 1, 1, 6, 7);
        
        /////////////////////////////////Handle Event///////////////////////////////////////
        
        loginBtn.setOnAction( e -> LoginPage.display());
        
        //init Scene
        Scene homePage = new Scene(grid, 650, 500);
        //Scene loginPage = new Scene();
        
        primaryStage.setScene(homePage);
        primaryStage.show();
    }
    
}
