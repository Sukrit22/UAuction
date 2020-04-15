/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicfx1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 *
 * @author Sitth
 */
public class LogInStage {

    private static Rectangle r;
    private static Pane paneBlack;
    private static MyButton logIn;
    private static Pane paneloginStage;
    private static Scene black;
    private static Stage fade;
    private static Scene login;
    private static Stage loginStage;

    static public void runStage() {

        r = new Rectangle(2000, 1200);
        paneBlack = new Pane(r);
        logIn = new MyButton("Log In", 16 , 16 , 5);
        paneloginStage = new Pane(logIn.getButton());
        black = new Scene(paneBlack, 2000, 1200);
        fade = new Stage();
        login = new Scene(paneloginStage, 600, 400);
        loginStage = new Stage();

        fade.setScene(black);
        fade.setY(-50);
        fade.setX(-50);
        fade.setOpacity(0.9);
        fade.initStyle(StageStyle.UTILITY);
        fade.show();
        loginStage.setAlwaysOnTop(true);
        loginStage.initStyle(StageStyle.UTILITY);
        //loginStage.setForceIntegerRenderScale(true);
        loginStage.setScene(login);
        loginStage.show();
        loginStage.setOnCloseRequest((WindowEvent event1) -> {
            fade.close();
        });
        EventHandler<ActionEvent> logIn = (ActionEvent ActionEvent) -> {
            //Do code here
            System.out.println("Log In Button Click");
            JavaBasicFX1.stage.setScene(JavaBasicFX1.sceneStorage.getHomeSceneAlreadyLogInFromSS());
            //JavaBasicFX1.stage.setOpacity(1);
            fade.close();
            loginStage.close();
        };
        LogInStage.logIn.getButton().setOnAction(logIn);

    }
}
