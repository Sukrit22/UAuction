/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicfx1;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Sitth
 */
public class HomeSceneBorderPaneTemplate {
    
    private static final int MAX_SCREEN_WIDHT = 1920;
    
    private BorderPane borderPaneLayor1;
    private Pane topPaneOnBorderPaneLayer1;
    private Pane bottomPaneOnBorderPaneLayer1;
    private Pane leftPaneOnBorderPaneLayer1;
    private ScrollPane RightscrollPaneOnBorderPaneLayor1;
    private StackPane stackPaneOnScrollPaneLayer1;

    public HomeSceneBorderPaneTemplate() {
        //-----Main Top Pane Elements----- 
        topPaneOnBorderPaneLayer1 = new Pane();
        topPaneOnBorderPaneLayer1.setMaxWidth(MAX_SCREEN_WIDHT);
        topPaneOnBorderPaneLayer1.setMinHeight(220);
        //++++
        topPaneOnBorderPaneLayer1.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: red;");        
        

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
        RightscrollPaneOnBorderPaneLayor1.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        RightscrollPaneOnBorderPaneLayor1.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
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
    }

    public BorderPane getBorderPaneLayor1() {
        return borderPaneLayor1;
    }
    
    
    
}
