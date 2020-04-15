/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicfx1;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Sitth
 */
public class HomeSceneUnLogIn {

    private static final int MAX_SCREEN_WIDHT = 1920;
    
    private static BorderPane borderPaneLayor1;
    private static Pane topPaneOnBorderPaneLayer1;
    private static Pane bottomPaneOnBorderPaneLayer1;
    private static Pane leftPaneOnBorderPaneLayer1;
    private static ScrollPane RightscrollPaneOnBorderPaneLayor1;
    private static StackPane stackPaneOnScrollPaneLayer1;

    public HomeSceneUnLogIn() {
        System.out.println("-----1-HomeSceneLogOut");
        homeSceneLogOut();
    }

    static public void homeSceneLogOut() {

        //Set Button Event In This Scene
        ButtonEvent.buttonEvenOnSceneAlreadyLogIn();
        
        StackPane pane = new StackPane();
        Image image = new Image("file:///" + System.getProperty("user.dir") + "/src/javabasicfx1/Resuorce/backGround.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(60);
        //imageView.setClip(SetTextShape.setTextShape("LOGO", 50));
        pane.getChildren().add(imageView);

        System.out.println("-----3-HomeSceneLogOut");
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Color.web("0x0000FF",1.0));
        rectangle.setWidth(1800);
        rectangle.setHeight(1080);
        //scrollPaneBorderPaneLayor1.setMinWidth(1920);
        //scrollPaneBorderPaneLayor1.setMinHeight(1080);
        
        

        //-----Main Top Pane Elements----- 
        topPaneOnBorderPaneLayer1 = new Pane();
        topPaneOnBorderPaneLayer1.setMaxWidth(MAX_SCREEN_WIDHT);
        topPaneOnBorderPaneLayer1.setMinHeight(220);
        //++++
        topPaneOnBorderPaneLayer1.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: red;");        
        
        //paneBorderPaneLayor1.getChildren().add(vboxForHboXBorderPane);

        //-----Main Left Pane Elements-----
        leftPaneOnBorderPaneLayer1 = new Pane();
        leftPaneOnBorderPaneLayer1.setMinWidth(250);
        leftPaneOnBorderPaneLayer1.setMaxWidth(250);
        
        //-----Main Bottom Pane Elements-----
        bottomPaneOnBorderPaneLayer1 = new Pane();
        bottomPaneOnBorderPaneLayer1.setMinSize(MAX_SCREEN_WIDHT, 200);
        bottomPaneOnBorderPaneLayer1.setStyle("-fx-background-color:POWDERBLUE");
                
        //-----Main Right Pane Elements----- 
        stackPaneOnScrollPaneLayer1 = new StackPane();
        stackPaneOnScrollPaneLayer1.setMinWidth(MAX_SCREEN_WIDHT - 250);
        stackPaneOnScrollPaneLayer1.setMaxWidth(MAX_SCREEN_WIDHT - 250);
        
        RightscrollPaneOnBorderPaneLayor1 = new ScrollPane();
        RightscrollPaneOnBorderPaneLayor1.setHbarPolicy(ScrollBarPolicy.NEVER);
        RightscrollPaneOnBorderPaneLayor1.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        RightscrollPaneOnBorderPaneLayor1.setMinWidth(MAX_SCREEN_WIDHT - 250);
        RightscrollPaneOnBorderPaneLayor1.setMaxWidth(MAX_SCREEN_WIDHT - 250);
        RightscrollPaneOnBorderPaneLayor1.setMinHeight(780);
        RightscrollPaneOnBorderPaneLayor1.setMaxHeight(780);
        //++++
        RightscrollPaneOnBorderPaneLayor1.setContent(stackPaneOnScrollPaneLayer1);
                
        //-----Main Scene Pane Elements-----    
        borderPaneLayor1 = new BorderPane();
        borderPaneLayor1.setMaxWidth(MAX_SCREEN_WIDHT);
        borderPaneLayor1.setMaxHeight(1080);
        
        //----Important----\\
        borderPaneLayor1.setTop(topPaneOnBorderPaneLayer1);
        borderPaneLayor1.setRight(RightscrollPaneOnBorderPaneLayor1);
        borderPaneLayor1.setBottom(bottomPaneOnBorderPaneLayer1);
        borderPaneLayor1.setLeft(leftPaneOnBorderPaneLayer1);
        //----Important----\\
        System.out.println("-----5-HomeSceneLogOut");
    }

    public static BorderPane getBorderPaneLayor1() {
        return borderPaneLayor1;
    }
    

}
