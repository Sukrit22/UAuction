/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionMain;

import Effect.PopUp;
import Scene.PaneCenter;
import Scene.PaneLeft;
import Scene.PaneTop;
import Scene.SceneHomeUnLogIn;
import Stage.setSceneForStage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import Scene.CategorisePane;
import Scene.Product;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Sitth
 */
public class ButtonEvent {

    static public void buttonEventForSceneAuctionHouse() {

    }

    static public void buttonEventForSceneHomeAlreadyLogIn() {
        EventHandler<ActionEvent> logIn = (ActionEvent ActionEvent) -> {
            //Do code here
            System.out.println("Test 2");
            //JavaBasicFX1.stage.setScene(JavaBasicFX1.sceneStorage.getHomeSceneAlreadyLogInFromSS());
            setSceneForStage.stageSetHomeUnLogIn();
        };
        CreateButton.button1.setOnAction(logIn);
    }

    static public void buttonEventForSceneHomeUnLogIn() {
        EventHandler<ActionEvent> logIn = (ActionEvent ActionEvent) -> {
            //Do code here
            System.out.println("Test 1");
            CreateButton.buttonPopUpLogIn.setVisible(false);
            CreateButton.buttonPopUpCreateAccount.setVisible(true);
            CreateTextField.email.setVisible(true);
            CreateTextField.password.setVisible(true);
            CreateTextField.passwordC.setVisible(false);
            CreateButton.buttonPopUpLogIn2.setVisible(true);
            CreateButton.buttonPopUpSignUp.setVisible(false);
            CreateTextField.email.setText("");
            CreateTextField.password.setText("");
            CreateTextField.passwordC.setText("");
            //JavaBasicFX1.stage.setScene(JavaBasicFX1.sceneStorage.getHomeSceneAlreadyLogInFromSS());
            //setSceneForStage.stageSetHomeAlreadyLogIn();
            SceneHomeUnLogIn.getStackPane().getChildren().add(PopUp.popUp());
        };
        CreateButton.button.setOnAction(logIn);

        EventHandler<ActionEvent> Back = (ActionEvent ActionEvent) -> {
            //Do code here
            System.out.println("Test 1");
            //JavaBasicFX1.stage.setScene(JavaBasicFX1.sceneStorage.getHomeSceneAlreadyLogInFromSS());
            //setSceneForStage.stageSetHomeAlreadyLogIn();
            SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUp.getStackPane());
        };
        CreateButton.button3.setOnAction(Back);

        EventHandler<MouseEvent> mcc = (MouseEvent ActionEvent) -> {
            //Do code here
            CreateButton.buttonPopUpLogIn.setVisible(true);
            CreateButton.buttonPopUpCreateAccount.setVisible(false);
            //CreateTextField.email.setVisible(false);
            //CreateTextField.password.setVisible(false);
            CreateTextField.passwordC.setVisible(true);
            CreateButton.buttonPopUpLogIn2.setVisible(false);
            CreateButton.buttonPopUpSignUp.setVisible(true);
            //SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUp.getStackPane());
            //setSceneForStage.stageSetHomeAlreadyLogIn();
            System.out.println("Click");

        };
        CreateButton.buttonPopUpCreateAccount.setOnMouseClicked(mcc);

        EventHandler<MouseEvent> mec = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("MouseEntered");
            //CreateButton.group.setScaleX(0.5);

        };
        CreateButton.buttonPopUpCreateAccount.setOnMouseEntered(mec);

        EventHandler<MouseEvent> mxc = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("MousExited");
            //CreateButton.group.setScaleX(0.5);

        };
        CreateButton.buttonPopUpCreateAccount.setOnMouseExited(mxc);

        EventHandler<MouseEvent> mci = (MouseEvent ActionEvent) -> {
            //Do code here
            //SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUp.getStackPane());
            //setSceneForStage.stageSetHomeAlreadyLogIn();
            CreateButton.buttonPopUpCreateAccount.setVisible(true);
            CreateButton.buttonPopUpLogIn.setVisible(false);
            CreateTextField.email.setVisible(true);
            CreateTextField.password.setVisible(true);
            CreateTextField.passwordC.setVisible(false);
            CreateButton.buttonPopUpLogIn2.setVisible(true);
            CreateButton.buttonPopUpSignUp.setVisible(false);
            System.out.println("Click");

        };
        CreateButton.buttonPopUpLogIn.setOnMouseClicked(mci);

        EventHandler<MouseEvent> mei = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("MouseEntered");
            //CreateButton.group.setScaleX(0.5);

        };
        CreateButton.buttonPopUpLogIn.setOnMouseEntered(mei);

        EventHandler<MouseEvent> mxi = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("MousExited");
            //CreateButton.group.setScaleX(0.5);

        };
        CreateButton.buttonPopUpLogIn.setOnMouseEntered(mxi);

        EventHandler<MouseEvent> logInJa = (MouseEvent ActionEvent) -> {
            //Do code here
            //System.out.println("MousExited");
            //CreateButton.group.setScaleX(0.5);
            //setSceneForStage.stageSetHomeAlreadyLogIn();
            PaneTop.getPane().getChildren().addAll(CreateButton.buttonMyAccount, CreateButton.buttonSignOut);
            PaneTop.getPane().getChildren().remove(CreateButton.buttonLogIn);
            SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUp.getStackPane());

        };

        CreateButton.buttonPopUpLogIn2.setOnMouseClicked(logInJa);

        EventHandler<MouseEvent> registorJa = (MouseEvent ActionEvent) -> {
            //Do code here
            //System.out.println("MousExited");
            //CreateButton.group.setScaleX(0.5);

        };

        CreateButton.buttonPopUpSignUp.setOnMouseClicked(registorJa);

        EventHandler<MouseEvent> logInJaJA = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("Test 1");
            CreateButton.buttonPopUpLogIn.setVisible(false);
            CreateButton.buttonPopUpCreateAccount.setVisible(true);
            CreateTextField.email.setVisible(true);
            CreateTextField.password.setVisible(true);
            CreateTextField.passwordC.setVisible(false);
            CreateButton.buttonPopUpLogIn2.setVisible(true);
            CreateButton.buttonPopUpSignUp.setVisible(false);
            CreateTextField.email.setText("");
            CreateTextField.password.setText("");
            CreateTextField.passwordC.setText("");
            //JavaBasicFX1.stage.setScene(JavaBasicFX1.sceneStorage.getHomeSceneAlreadyLogInFromSS());
            //setSceneForStage.stageSetHomeAlreadyLogIn();
            SceneHomeUnLogIn.getStackPane().getChildren().add(PopUp.popUp());

        };

        CreateButton.buttonLogIn.setOnMouseClicked(logInJaJA);

        EventHandler<MouseEvent> signOut = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("Test 1");
            CreateButton.buttonPopUpLogIn.setVisible(false);
            CreateButton.buttonPopUpCreateAccount.setVisible(true);
            CreateTextField.email.setVisible(true);
            CreateTextField.password.setVisible(true);
            CreateTextField.passwordC.setVisible(false);
            CreateButton.buttonPopUpLogIn2.setVisible(true);
            CreateButton.buttonPopUpSignUp.setVisible(false);
            CreateTextField.email.setText("");
            CreateTextField.password.setText("");
            CreateTextField.passwordC.setText("");
            //JavaBasicFX1.stage.setScene(JavaBasicFX1.sceneStorage.getHomeSceneAlreadyLogInFromSS());
            //setSceneForStage.stageSetHomeAlreadyLogIn();
            PaneTop.getPane().getChildren().remove(CreateButton.buttonMyAccount);
            PaneTop.getPane().getChildren().remove(CreateButton.buttonSignOut);
            PaneTop.getPane().getChildren().add(CreateButton.buttonLogIn);
            //PaneCenter.getPane().setMinSize(0, 800);
            //PaneCenter.getPane().setVisible(false);

        };

        CreateButton.buttonSignOut.setOnMouseClicked(signOut);

        EventHandler<MouseEvent> myAcc = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("My Account");
            PaneTop.getPane().getChildren().remove(CreateButton.buttonMyAccount);
            //PaneCenter.getPane().setVisible(true);
            //
            //PaneCenter.getPane().setMinSize(1920, 800);
            SceneHomeUnLogIn.getStackPane().getChildren().add(PaneCenter.getPane());
        };

        CreateButton.buttonMyAccount.setOnMouseClicked(myAcc);

        EventHandler<ActionEvent> add = (ActionEvent ActionEvent) -> {
            Product.x += 2;
            CategorisePane.vbox1.getChildren().addAll(new Rectangle(150, 150), new Label("_________________________" + Product.x/2));
            
            //System.out.println(CategorisePane.vbox1);
        };
        PaneCenter.b1.setOnAction(add);

        EventHandler<ActionEvent> delete = (ActionEvent ActionEvent) -> {
            System.out.println("Delete");
            if (Product.x > 0) {
                CategorisePane.vbox1.getChildren().remove(--Product.x);
                CategorisePane.vbox1.getChildren().remove(--Product.x);
            }
        };
        PaneCenter.b2.setOnAction(delete);

        EventHandler<ActionEvent> back = (ActionEvent ActionEvent) -> {
            //SceneHomeUnLogIn.getStackPane().getChildren().remove(PaneCenter.getPane());
            PaneTop.getPane().getChildren().add(CreateButton.buttonMyAccount);
            SceneHomeUnLogIn.getStackPane().getChildren().remove(PaneCenter.getPane());
            //PaneCenter.getPane().setVisible(false);
        };
        PaneCenter.b3.setOnAction(back);

    }
}
