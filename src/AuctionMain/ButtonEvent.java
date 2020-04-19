/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionMain;

import Effect.PopUp;
import Scene.PaneMyAccount;
import Scene.PaneTop;
import Scene.SceneHomeUnLogIn;
import Stage.setSceneForStage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import Scene.CategorisePane;
import Scene.Product;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import Function.MyFunction;
import static Scene.PaneMyAccount.paneMyObject;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 *
 * @author Sitth
 */
public class ButtonEvent {

    static public void buttonEventForSceneHomeUnLogIn() {
        EventHandler<ActionEvent> logIn = (ActionEvent ActionEvent) -> {
            //Do code here
            System.out.println("button");
            CreateButton.buttonPopUpSwitchToLogIn.setVisible(false);
            CreateButton.buttonPopSwitchToSignUp.setVisible(true);
            CreateTextField.email.setVisible(true);
            CreateTextField.password.setVisible(true);
            CreateTextField.passwordC.setVisible(false);
            CreateButton.buttonPopUpLogIn.setVisible(true);
            CreateButton.buttonPopUpRegister.setVisible(false);
            CreateTextField.email.setText("");
            CreateTextField.password.setText("");
            CreateTextField.passwordC.setText("");
            PopUp.worng.setVisible(false);
            SceneHomeUnLogIn.getStackPane().getChildren().add(PopUp.popUp());
        };
        CreateButton.button.setOnAction(logIn);

        EventHandler<ActionEvent> Back = (ActionEvent ActionEvent) -> {
            //Do code here
            System.out.println("Test 1");
            SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUp.getStackPane());
        };
        CreateButton.button3.setOnAction(Back);

        EventHandler<MouseEvent> mcc = (MouseEvent ActionEvent) -> {
            //Do code here
            CreateButton.buttonPopUpSwitchToLogIn.setVisible(true);
            CreateButton.buttonPopSwitchToSignUp.setVisible(false);
            //CreateTextField.email.setVisible(false);
            //CreateTextField.password.setVisible(false);
            CreateTextField.passwordC.setVisible(true);
            CreateButton.buttonPopUpLogIn.setVisible(false);
            CreateButton.buttonPopUpRegister.setVisible(true);
            //SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUp.getStackPane());
            PopUp.worng.setVisible(false);
            //setSceneForStage.stageSetHomeAlreadyLogIn();
            System.out.println("buttonPopSwitchToSignUp");

        };
        CreateButton.buttonPopSwitchToSignUp.setOnMouseClicked(mcc);

        EventHandler<MouseEvent> mci = (MouseEvent ActionEvent) -> {
            //Do code here
            CreateButton.buttonPopSwitchToSignUp.setVisible(true);
            CreateButton.buttonPopUpSwitchToLogIn.setVisible(false);
            CreateTextField.email.setVisible(true);
            CreateTextField.password.setVisible(true);
            CreateTextField.passwordC.setVisible(false);
            CreateButton.buttonPopUpLogIn.setVisible(true);
            CreateButton.buttonPopUpRegister.setVisible(false);
            PopUp.worng.setVisible(false);
            System.out.println("buttonPopUpSwitchToLogIn");

        };
        CreateButton.buttonPopUpSwitchToLogIn.setOnMouseClicked(mci);

        EventHandler<MouseEvent> logInOnPopUp = (MouseEvent ActionEvent) -> {
            //Do code here         
            System.out.println("buttonPopUpLogIn");
            MyFunction.checkLogIn();
        };
        CreateButton.buttonPopUpLogIn.setOnMouseClicked(logInOnPopUp);

        EventHandler<MouseEvent> register = (MouseEvent ActionEvent) -> {
            System.out.println("Register");
            MyFunction.register();
        };
        CreateButton.buttonPopUpRegister.setOnMouseClicked(register);

        EventHandler<MouseEvent> logInJaJA = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("buttonLogInPaneTop");
            CreateButton.buttonPopUpSwitchToLogIn.setVisible(false);
            CreateButton.buttonPopSwitchToSignUp.setVisible(true);
            CreateTextField.email.setVisible(true);
            CreateTextField.password.setVisible(true);
            CreateTextField.passwordC.setVisible(false);
            CreateButton.buttonPopUpLogIn.setVisible(true);
            CreateButton.buttonPopUpRegister.setVisible(false);
            CreateTextField.email.setText("");
            CreateTextField.password.setText("");
            CreateTextField.passwordC.setText("");
            PopUp.worng.setVisible(false);
            SceneHomeUnLogIn.getStackPane().getChildren().add(PopUp.popUp());

        };
        CreateButton.buttonLogInPaneTop.setOnMouseClicked(logInJaJA);

        EventHandler<MouseEvent> signOut = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("buttonSignOutTopPane");
            CreateButton.buttonPopUpSwitchToLogIn.setVisible(false);
            CreateButton.buttonPopSwitchToSignUp.setVisible(true);
            CreateTextField.email.setVisible(true);
            CreateTextField.password.setVisible(true);
            CreateTextField.passwordC.setVisible(false);
            CreateButton.buttonPopUpLogIn.setVisible(true);
            CreateButton.buttonPopUpRegister.setVisible(false);
            CreateTextField.email.setText("");
            CreateTextField.password.setText("");
            CreateTextField.passwordC.setText("");
            PopUp.worng.setVisible(false);
            PaneTop.getPane().getChildren().remove(CreateButton.buttonMyAccount);
            PaneTop.getPane().getChildren().remove(CreateButton.buttonSignOutTopPane);
            PaneTop.getPane().getChildren().add(CreateButton.buttonLogInPaneTop);
            paneMyObject.getChildren().remove(UserData.userPaneArray.get(UserData.ID_UserThatLogIn));

        };
        CreateButton.buttonSignOutTopPane.setOnMouseClicked(signOut);

        EventHandler<MouseEvent> myAcc = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("My Account");
            PaneTop.getPane().getChildren().remove(CreateButton.buttonMyAccount);
            SceneHomeUnLogIn.getStackPane().getChildren().add(PaneMyAccount.getPaneMyAcclayer1());
        };

        CreateButton.buttonMyAccount.setOnMouseClicked(myAcc);

        EventHandler<ActionEvent> add = (ActionEvent ActionEvent) -> {
            Product.productArray.add(new Product("Product", UserData.user.get(UserData.ID_UserThatLogIn).getEmail(), false));
            CategorisePane.vbox1.getChildren().add(Product.productArray.get(Product.x++).getPane());
            Product.productArray.add(new Product("Product", UserData.user.get(UserData.ID_UserThatLogIn).getEmail(), true));
            UserData.vboxArray.get(UserData.ID_UserThatLogIn).getChildren().add(Product.productArray.get(Product.y++).getPane());

        };
        PaneMyAccount.btnAdd.setOnAction(add);

        EventHandler<ActionEvent> delete = (ActionEvent ActionEvent) -> {
            System.out.println("Delete");
            if (UserData.vboxArray.get(UserData.ID_UserThatLogIn).getChildren().size() > 0) {
                UserData.vboxArray.get(UserData.ID_UserThatLogIn).getChildren().remove(UserData.vboxArray.get(UserData.ID_UserThatLogIn).getChildren().size() - 1);
            }
        };
        PaneMyAccount.btnDelete.setOnAction(delete);

        EventHandler<ActionEvent> back = (ActionEvent ActionEvent) -> {
            PaneTop.getPane().getChildren().add(CreateButton.buttonMyAccount);
            SceneHomeUnLogIn.getStackPane().getChildren().remove(PaneMyAccount.getPaneMyAcclayer1());
        };
        PaneMyAccount.btnBack.setOnAction(back);

    }
}
