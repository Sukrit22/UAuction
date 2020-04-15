/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicfx1;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Sitth
 */
public class JavaBasicFX1 extends Application {

    /**
     * @param args the command line arguments
     */
    
    static public SceneStorage sceneStorage;
    static public Stage stage = new Stage();
    
    public static void main(String[] args) {
        // TODO code application logic here
        runTime.timer.start();
        launch(args);
        System.exit(0);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        /*final FlowPane container = new FlowPane();
        final FlowPane bG = new FlowPane();

        ScrollPane scrollPane = new ScrollPane();

        HBox hbox = new HBox();
        VBox vbox = new VBox();
        
        Button button = new Button("My Button");
        button.requestFocus();
        button.setPrefSize(400, 300);
        scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        //Text txtTime = new Text("HelloWorld");
        Label labelime = new Label("Hi");
        //MyButton btn1 = new MyButton("_Yooooo", 20, 20, 20);
        //MyButton btn2 = new MyButton("_Button 2", 16, 100, 100);
        //MyButton btn3 = new MyButton("_Button 3", 16, 0, 0);
        
        
        //hbox.getChildren().add(btn3.getButton());
        //container.getChildren().addAll(button, runTime.txtTime, btn1.getButton(), labelime, SetTextShape.setTextShape("HI", 60), btn2.getButton());
        //btn1.debugSize();        
        scrollPane.setContent(container);
        scrollPane.setMinSize(100, 1080);
        vbox.getChildren().addAll(hbox, scrollPane);
        bG.getChildren().add(vbox);*/

        
        System.out.println("----1-javabasicfx1");
        //scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        sceneStorage = new SceneStorage();
        System.out.println("----2-javabasicfx1");
        sceneStorage.createScene();
        //System.out.println("working");
        JavaBasicFX1.stage.setScene(sceneStorage.getHomeSceneUnLogInFromSS());
        System.out.println("----3-javabasicfx1");
        //JavaBasicFX1.stage.setScene(HomeSceneLogin.HomeSceneLogin());
        JavaBasicFX1.stage.setTitle("Auction");
        JavaBasicFX1.stage.setMaximized(true);
        JavaBasicFX1.stage.setResizable(true);
        JavaBasicFX1.stage.setMinWidth(1920);
        JavaBasicFX1.stage.initStyle(StageStyle.UTILITY);
        //stage.initStyle(StageStyle.DECORATED);
        //stage.initStyle(StageStyle.UNDECORATED);
        //stage.initStyle(StageStyle.TRANSPARENT);
        //stage.initStyle(StageStyle.UNIFIED);
        //stage.initStyle(StageStyle.UTILITY);
        //stage.initStyle(StageStyle.UTILITY);
        JavaBasicFX1.stage.show();

    }

}
