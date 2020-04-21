/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import AuctionMain.CreateButton;
import AuctionMain.CreateTextField;
import AuctionMain.UserData;
import Effect.PopUp;
import Effect.PopUpProduct;
import Scene.ActionPane;
import Scene.PaneMyAccount;
import Scene.Home.PaneTop;
import Scene.Home.SceneHomeUnLogIn;
import Stage.SetUpStage;
import Stage.setSceneForStage;

/**
 *
 * @author Sitth
 */
public class MyFunction {

    static public void inti() {
        PopUpProduct.createpopUpBackground();
        SetUpStage.stageAuction();
        CreateButton.setUpAllButton();
        SceneHomeUnLogIn.sceneHomeUnLogIn();
        setSceneForStage.stageSetHomeUnLogIn();
        PaneTop.getPane().getChildren().add(CreateButton.buttonTime);
        PaneTop.getPane().getChildren().add(CreateButton.buttonHelpPaneTop);
        PopUp.setUpPopUp();
        PaneMyAccount.setUpPane();
        ActionPane.setUpPane();
    }

    static public void checkLogIn() {
        String x = CreateTextField.email.getText();
        boolean check = true;
        boolean logInSuccess = false;
        int i = 0;
        while (check) {
            if (x.equals(UserData.user.get(i).getEmail())) {
                System.out.println(x);
                check = false;
                if (CreateTextField.password.getText().equals(UserData.user.get(i).getPassword())) {
                    logInSuccess = true;
                    UserData.user.get(i).setStatus(true);
                    PaneMyAccount.name.setText(UserData.user.get(i).getEmail());
                    UserData.ID_UserThatLogIn = UserData.user.get(i).getId();
                    System.out.println("ID " + UserData.user.get(i).getId());
                }
            }
            i++;
            if (i == UserData.user.size()) {
                check = false;
            }
        }
        //Log In Success
        if (logInSuccess) {
            PaneTop.getPane().getChildren().addAll(CreateButton.buttonMyAccount, CreateButton.buttonSignOutTopPane);
            PaneTop.getPane().getChildren().remove(CreateButton.buttonLogInPaneTop);
            SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUp.getStackPane());
        } else {
            if (SceneHomeUnLogIn.getStackPane().getChildren().size() != 3) {
                PopUp.incorrecypassPane.setVisible(true);
            }
        }
    }

    static public void register() {

        PopUp.incorrecypassPane.setVisible(false);
        PopUp.emailUsedPane.setVisible(false);
        PopUp.passwordNotSamePane.setVisible(false);
        String x = CreateTextField.email.getText();
        boolean check = true;
        boolean emailIsAvailable = true;
        int i = 0;
        while (check) {
            if (x.equals(" ")) {
                System.out.println(x);
                check = false;
                emailIsAvailable = false;
            }
            
            if (x.equals(UserData.user.get(i).getEmail())) {
                System.out.println(x);
                check = false;
                emailIsAvailable = false;
            }
            i++;
            if (i == UserData.user.size()) {
                check = false;
            }
        }
        if (emailIsAvailable) {
            //Okay
            if (CreateTextField.password.getText().equals(CreateTextField.passwordC.getText())) {
                UserData.user.add(new UserData(CreateTextField.email.getText(), CreateTextField.password.getText()));
                PaneTop.getPane().getChildren().addAll(CreateButton.buttonMyAccount, CreateButton.buttonSignOutTopPane);
                PaneTop.getPane().getChildren().remove(CreateButton.buttonLogInPaneTop);
                SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUp.getStackPane());
                PaneMyAccount.name.setText(UserData.user.get(i).getEmail());
                UserData.ID_UserThatLogIn = UserData.user.get(i).getId();
            } else {
                //Password Not Same
                PopUp.passwordNotSamePane.setVisible(true);
            }
        } else {
            //User name already use
            PopUp.emailUsedPane.setVisible(true);
        }
    }

}
