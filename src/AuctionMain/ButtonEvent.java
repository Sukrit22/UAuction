/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionMain;

import Effect.PopUp;
import Scene.PaneMyAccount;
import Scene.Home.PaneTop;
import Scene.Home.SceneHomeUnLogIn;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import Scene.CategorisePane;
import Scene.ProductPaneInVbox;
import static Scene.PaneMyAccount.paneMyObject;

/**
 *
 * @author Sitth
 */
public class ButtonEvent {

    static public void buttonEventForSceneHomeUnLogIn() {

        EventHandler<MouseEvent> logInOnPopUp = (MouseEvent ActionEvent) -> {
            // TextField CreateTextField.email + CreateTextField.password
            System.out.println("buttonPopUpLogIn");
            if (true) {
                PaneTop.getPane().getChildren().addAll(CreateButton.buttonMyAccount, CreateButton.buttonSignOutTopPane);
                PaneTop.getPane().getChildren().remove(CreateButton.buttonLogInPaneTop);
                SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUp.getStackPane());
            } else {
                //Wrong Password
                PopUp.incorrecypassPane.setVisible(true);
            }

        };
        CreateButton.buttonPopUpLogIn.setOnMouseClicked(logInOnPopUp);

        EventHandler<MouseEvent> registerOnPopUpEV = (MouseEvent ActionEvent) -> {
            // TextField CreateTextField.email + CreateTextField.password + CreateTextField.passwordC
            System.out.println("Register");
            if (true) {
                PaneTop.getPane().getChildren().addAll(CreateButton.buttonMyAccount, CreateButton.buttonSignOutTopPane);
                PaneTop.getPane().getChildren().remove(CreateButton.buttonLogInPaneTop);
                SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUp.getStackPane());
            } else {
                if (true) {
                    // UserName Aldread Use
                    PopUp.emailUsedPane.setVisible(true);
                } else {
                    //Password Not Same
                    PopUp.passwordNotSamePane.setVisible(true);
                }
            }
        };
        CreateButton.buttonPopUpRegister.setOnMouseClicked(registerOnPopUpEV);

        EventHandler<MouseEvent> helpEV = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("buttonHelpPaneTop");

        };
        CreateButton.buttonHelpPaneTop.setOnMouseClicked(helpEV);

        EventHandler<ActionEvent> add = (ActionEvent ActionEvent) -> {
            System.out.println("Add from MyACC");
            CategorisePane.vboxArray.get(0).getChildren().add(ProductPaneInVbox.Pane1());

        };
        PaneMyAccount.btnAdd.setOnAction(add);

        EventHandler<ActionEvent> delete = (ActionEvent ActionEvent) -> {
            System.out.println("Delete");
        };
        PaneMyAccount.btnDelete.setOnAction(delete);

        //--------------------------------------------------\\
        EventHandler<MouseEvent> buttonPopSwitchToSignUpEV = (MouseEvent ActionEvent) -> {
            //Do code here
            CreateButton.buttonPopUpSwitchToLogIn.setVisible(true);
            CreateButton.buttonPopSwitchToSignUp.setVisible(false);
            CreateTextField.passwordC.setVisible(true);
            CreateButton.buttonPopUpLogIn.setVisible(false);
            CreateButton.buttonPopUpRegister.setVisible(true);
            PopUp.incorrecypassPane.setVisible(false);
            System.out.println("buttonPopSwitchToSignUp");

        };
        CreateButton.buttonPopSwitchToSignUp.setOnMouseClicked(buttonPopSwitchToSignUpEV);

        EventHandler<MouseEvent> buttonPopUpSwitchToLogInEV = (MouseEvent ActionEvent) -> {
            //Do code here
            CreateButton.buttonPopSwitchToSignUp.setVisible(true);
            CreateButton.buttonPopUpSwitchToLogIn.setVisible(false);
            CreateTextField.userName.setVisible(true);
            CreateTextField.password.setVisible(true);
            CreateTextField.passwordC.setVisible(false);
            CreateButton.buttonPopUpLogIn.setVisible(true);
            CreateButton.buttonPopUpRegister.setVisible(false);
            PopUp.incorrecypassPane.setVisible(false);
            System.out.println("buttonPopUpSwitchToLogIn");

        };
        CreateButton.buttonPopUpSwitchToLogIn.setOnMouseClicked(buttonPopUpSwitchToLogInEV);

        EventHandler<MouseEvent> buttonLogInPaneTopEV = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("buttonLogInPaneTop");
            CreateButton.buttonPopUpSwitchToLogIn.setVisible(false);
            CreateButton.buttonPopSwitchToSignUp.setVisible(true);
            CreateTextField.userName.setVisible(true);
            CreateTextField.password.setVisible(true);
            CreateTextField.passwordC.setVisible(false);
            CreateButton.buttonPopUpLogIn.setVisible(true);
            CreateButton.buttonPopUpRegister.setVisible(false);
            CreateTextField.userName.setText("");
            CreateTextField.password.setText("");
            CreateTextField.passwordC.setText("");
            PopUp.incorrecypassPane.setVisible(false);
            SceneHomeUnLogIn.getStackPane().getChildren().add(PopUp.getStackPane());

        };
        CreateButton.buttonLogInPaneTop.setOnMouseClicked(buttonLogInPaneTopEV);

        EventHandler<MouseEvent> signOut = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("buttonSignOutTopPane");
            CreateButton.buttonPopUpSwitchToLogIn.setVisible(false);
            CreateButton.buttonPopSwitchToSignUp.setVisible(true);
            CreateTextField.userName.setVisible(true);
            CreateTextField.password.setVisible(true);
            CreateTextField.passwordC.setVisible(false);
            CreateButton.buttonPopUpLogIn.setVisible(true);
            CreateButton.buttonPopUpRegister.setVisible(false);
            CreateTextField.userName.setText("");
            CreateTextField.password.setText("");
            CreateTextField.passwordC.setText("");
            PopUp.incorrecypassPane.setVisible(false);
            PaneTop.getPane().getChildren().remove(CreateButton.buttonMyAccount);
            PaneTop.getPane().getChildren().remove(CreateButton.buttonSignOutTopPane);
            PaneTop.getPane().getChildren().add(CreateButton.buttonLogInPaneTop);

        };
        CreateButton.buttonSignOutTopPane.setOnMouseClicked(signOut);

        EventHandler<MouseEvent> myAcc = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("My Account");
            PaneTop.getPane().getChildren().remove(CreateButton.buttonMyAccount);
            SceneHomeUnLogIn.getStackPane().getChildren().add(PaneMyAccount.getPaneMyAcclayer1());
        };

        CreateButton.buttonMyAccount.setOnMouseClicked(myAcc);

        EventHandler<ActionEvent> back = (ActionEvent ActionEvent) -> {
            PaneTop.getPane().getChildren().add(CreateButton.buttonMyAccount);
            SceneHomeUnLogIn.getStackPane().getChildren().remove(PaneMyAccount.getPaneMyAcclayer1());
        };
        PaneMyAccount.btnBack.setOnAction(back);
        PaneMyAccount.btnBack2.setOnAction(back);

    }

}
