/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicfx1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Sitth
 */

public class OldHomeSceneAlreadyLogIn {

    static public Scene homeScene;
    private static BorderPane borderPaneLayor1;
    private static Pane paneBorderPaneLayor1;
    private static ScrollPane scrollPaneBorderPaneLayor1;
    private static MyButton btnMyAccount;
    private static MyButton btnLogOut;
    private static MyButton btnHelp;
    private static VBox vboxForHboXBorderPane;
    private static HBox hboxForLogo;
    private static HBox hboxForBtn;
    private static StackPane timePane;
    private static TextField searchTextField;
    private static HBox hboxborderTopPane;
    private static HBox hboxForSearchTextField;
    private static StackPane stackPaneLoGoLayor1;
    private static StackPane stackPaneTextFieldPaneLayor1;    
    private static StackPane stackPaneButtonPaneLayor1;   

    public OldHomeSceneAlreadyLogIn() {
        System.out.println("-----1-HomeSceneLogIn-Init");
        homeSceneLogIn();
    }
    
    static public void homeSceneLogIn() {

    borderPaneLayor1 = new BorderPane();
    paneBorderPaneLayor1 = new Pane();
    scrollPaneBorderPaneLayor1 = new ScrollPane();
    btnMyAccount = new MyButton("My Account", 20, 1, 40);
    btnLogOut = new MyButton("Log Out", 20, 1, 40);
    btnHelp = new MyButton("Help", 20, 1, 40);
    vboxForHboXBorderPane = new VBox();
    hboxForLogo = new HBox(SetTextShape.setTextShape("LOGO", 50));
    hboxForBtn = new HBox();
    timePane = new StackPane();
    searchTextField = new TextField();
    hboxborderTopPane = new HBox();
    hboxForSearchTextField = new HBox(searchTextField);
    stackPaneLoGoLayor1 = new StackPane(hboxForLogo);
    stackPaneTextFieldPaneLayor1 = new StackPane(hboxForSearchTextField);        
    stackPaneButtonPaneLayor1 = new StackPane(hboxForBtn); 
    ButtonEvent.buttonEventOnSceneUnLogIn();
        //BorderPane Top
        
        //setTextShape( String text, int fontSize)        
        
        //MyButton(String text, int font, double sizeWidth, double sizeHeight)
        
        
        
        
        hboxForBtn.setSpacing(5);
        //Debug
        hboxForBtn.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: blue;");
        hboxForBtn.setPadding(new Insets(10, 10, 10, 10));
        
        timePane.setMaxHeight(40);
        timePane = SetTextShape.setTextShape("                            ", 1 , 20 , 40);
        timePane.setAlignment(Pos.TOP_CENTER);
        timePane.setMaxHeight(40);
        timePane.setMaxWidth(200);
        timePane.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: blue;");
        hboxForBtn.setAlignment(Pos.TOP_RIGHT);
        HBox.setHgrow(btnMyAccount.getButton(), Priority.ALWAYS);
        HBox.setHgrow(btnLogOut.getButton(), Priority.ALWAYS);
        HBox.setHgrow(btnHelp.getButton(), Priority.ALWAYS);
        HBox.setHgrow(timePane, Priority.ALWAYS);         
        timePane.setVisible(false);
        hboxForBtn.setMaxWidth(1920);
        System.out.println("-----1-HomeSceneLogIn--hboxForBtn");
        hboxForBtn.getChildren().addAll(btnMyAccount.getButton(), btnLogOut.getButton(), btnHelp.getButton(), MyButton.setAndGetBtnTime(MyButton.btnTime2));
        System.out.println("-----1-HomeSceneLogIn---hboxForBtn-Success");
        
        searchTextField.setMinSize(500, 40);
        searchTextField.setPromptText("I'm looking for...");
        
        hboxForSearchTextField.setPadding(new Insets(50, 10, 10, 10));
        hboxForSearchTextField.setAlignment(Pos.CENTER);
        hboxForSearchTextField.setMaxWidth(1920);
        //Debug
        hboxForSearchTextField.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: blue;");
        
        hboxborderTopPane.setSpacing(200);
        hboxborderTopPane.setPadding(new Insets(10, 10, 10, 10));
        hboxborderTopPane.setAlignment(Pos.CENTER);
        hboxborderTopPane.setMaxWidth(1920);
        hboxborderTopPane.setPrefWidth(1920);
        
        
        
        
        HBox.setHgrow(stackPaneButtonPaneLayor1, Priority.ALWAYS);
        HBox.setHgrow(stackPaneTextFieldPaneLayor1, Priority.ALWAYS);
        HBox.setHgrow(stackPaneLoGoLayor1, Priority.ALWAYS);
        
        hboxborderTopPane.getChildren().addAll(stackPaneLoGoLayor1, stackPaneButtonPaneLayor1);
        
        vboxForHboXBorderPane.setMaxWidth(1920);
        vboxForHboXBorderPane.setMinWidth(1920);
        vboxForHboXBorderPane.setPrefWidth(1920);
        vboxForHboXBorderPane.setAlignment(Pos.CENTER);
        vboxForHboXBorderPane.getChildren().addAll(hboxborderTopPane, stackPaneTextFieldPaneLayor1);
        //Debug
        paneBorderPaneLayor1.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: red;");
        paneBorderPaneLayor1.setMaxWidth(1920);
        paneBorderPaneLayor1.getChildren().add(vboxForHboXBorderPane);
        //BorderPane Top
        //BorderPane Center
        //BorderPane Top
        //BorderPane Top
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(1920);
        rectangle.setHeight(1080);
        scrollPaneBorderPaneLayor1.setContent(rectangle);
        //scrollPaneBorderPaneLayor1.setMinWidth(1920);
        scrollPaneBorderPaneLayor1.setMaxWidth(1920);
        //scrollPaneBorderPaneLayor1.setMinHeight(1080);
        borderPaneLayor1.setTop(paneBorderPaneLayor1);
        borderPaneLayor1.setRight(scrollPaneBorderPaneLayor1);
        //homeScene = new Scene(borderPaneLayor1);
        //return homeScene;
        System.out.println("++++HomeSceneLogIn Success++++");
    }

    public static MyButton getBtnMyAccount() {
        return btnMyAccount;
    }

    public static MyButton getBntLogOut() {
        return btnLogOut;
    }

    public static Scene getHomeScene() {
        return homeScene;
    }

    public static BorderPane getBorderPaneLayor1() {
        return borderPaneLayor1;
    }

    public static Pane getPaneBorderPaneLayor1() {
        return paneBorderPaneLayor1;
    }

    public static ScrollPane getScrollPaneBorderPaneLayor1() {
        return scrollPaneBorderPaneLayor1;
    }

    public static VBox getVboxForHboXBorderPane() {
        return vboxForHboXBorderPane;
    }

    public static HBox getHboxForLogo() {
        return hboxForLogo;
    }

    public static HBox getHboxForBtn() {
        return hboxForBtn;
    }

    public static StackPane getTimePane() {
        return timePane;
    }

    public static TextField getSearchTextField() {
        return searchTextField;
    }

    public static HBox getHboxborderTopPane() {
        return hboxborderTopPane;
    }

    public static HBox getHboxForSearchTextField() {
        return hboxForSearchTextField;
    }

    public static StackPane getStackPaneLoGoLayor1() {
        return stackPaneLoGoLayor1;
    }

    public static StackPane getStackPaneTextFieldPaneLayor1() {
        return stackPaneTextFieldPaneLayor1;
    }

    public static StackPane getStackPaneButtonPaneLayor1() {
        return stackPaneButtonPaneLayor1;
    }
    
}
