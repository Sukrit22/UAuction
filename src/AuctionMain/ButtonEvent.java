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
import javafx.scene.layout.Pane;

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
            PopUp.worng.setVisible(false);
            
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
            PopUp.worng.setVisible(false);
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
            PopUp.worng.setVisible(false);
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

        EventHandler<MouseEvent> logInOnPopUp = (MouseEvent ActionEvent) -> {
            //Do code here
            //System.out.println("MousExited");
            //CreateButton.group.setScaleX(0.5);
            //setSceneForStage.stageSetHomeAlreadyLogIn();
            //System.out.println(CreateTextField.email.getText() + " " + UserData.user.get(0).getEmail());
            /*PopUp.worng.setVisible(false);
            String x = CreateTextField.email.getText();
            System.out.println(x + " " + UserData.user.get(0).getEmail());
            System.out.println(x.equals(UserData.user.get(0).getEmail()));
            System.out.println(CreateTextField.password.getText().equals(UserData.user.get(0).getPassword()));
            //System.out.println(x);
            boolean check = true;
            boolean check2 = false;
            int i = 0;
            while (check) {
                System.out.println("Wow" + i + check);

                if (x.equals(UserData.user.get(i).getEmail())) {
                    System.out.println(x);
                    //System.out.println(" Stage 1" + CreateTextField.email.getText() + " " + UserData.user.get(0).getEmail());
                    System.out.println(" Stage 1");
                    check = false;
                    if (CreateTextField.password.getText().equals(UserData.user.get(i).getPassword())) {

                        check2 = true;
                    }
                }

                System.out.println("size " + UserData.user.size());
                i++;

                if (i == UserData.user.size()) {
                    check = false;
                }
            }
            if (check2) {
                System.out.println("Wow 2");
                PaneTop.getPane().getChildren().addAll(CreateButton.buttonMyAccount, CreateButton.buttonSignOut);
                PaneTop.getPane().getChildren().remove(CreateButton.buttonLogIn);
                SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUp.getStackPane());
            } else {
                System.out.println("Wow 3");
                System.out.println(SceneHomeUnLogIn.getStackPane().getChildren().size());
                //SceneHomeUnLogIn.getStackPane().getChildren().add(PopUp.worng);
                System.out.println("add");
                System.out.println(SceneHomeUnLogIn.getStackPane().getChildren().size());
                if (SceneHomeUnLogIn.getStackPane().getChildren().size() != 3) {
                    //SceneHomeUnLogIn.getStackPane().getChildren().add(PopUp.worng);
                    PopUp.worng.setVisible(true);
                }
            }*/
            MyFunction.checkLogIn();

        };

        CreateButton.buttonPopUpLogIn2.setOnMouseClicked(logInOnPopUp);
        
        EventHandler<MouseEvent> register = (MouseEvent ActionEvent) -> {
            System.out.println("Register");
            MyFunction.register();
        };
        
        CreateButton.buttonPopUpSignUp.setOnMouseClicked(register);
        //CreateButton.buttonPopUpLogIn2.setOnMouseClicked(register);
        
        EventHandler<MouseEvent> print = (MouseEvent ActionEvent) -> {
            System.out.println("Print");
            MyFunction.register();
        };
        
        //CreateButton.buttonPopUpSignUp.setOnMouseClicked(print);

        EventHandler<MouseEvent> registorJa = (MouseEvent ActionEvent) -> {
            //Do code here
            //System.out.println("MousExited");
            //CreateButton.group.setScaleX(0.5);

        };

        //CreateButton.buttonPopUpSignUp.setOnMouseClicked(registorJa);

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
            PopUp.worng.setVisible(false);
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
            PopUp.worng.setVisible(false);
            //JavaBasicFX1.stage.setScene(JavaBasicFX1.sceneStorage.getHomeSceneAlreadyLogInFromSS());
            //setSceneForStage.stageSetHomeAlreadyLogIn();
            PaneTop.getPane().getChildren().remove(CreateButton.buttonMyAccount);
            PaneTop.getPane().getChildren().remove(CreateButton.buttonSignOut);
            PaneTop.getPane().getChildren().add(CreateButton.buttonLogIn);
            //PaneCenter.getPane().setMinSize(0, 800);
            //PaneCenter.getPane().setVisible(false);
            paneMyObject.getChildren().remove(UserData.userPane.get(UserData.Usernumber));

        };

        CreateButton.buttonSignOut.setOnMouseClicked(signOut);

        EventHandler<MouseEvent> myAcc = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("My Account");
            PaneTop.getPane().getChildren().remove(CreateButton.buttonMyAccount);
            //PaneCenter.getPane().setVisible(true);
            //
            //PaneCenter.getPane().setMinSize(1920, 800);
            SceneHomeUnLogIn.getStackPane().getChildren().add(PaneMyAccount.getPaneMyAcclayer1());
        };

        CreateButton.buttonMyAccount.setOnMouseClicked(myAcc);

        EventHandler<ActionEvent> add = (ActionEvent ActionEvent) -> {
            
            //CategorisePane.vbox1.getChildren().addAll(new Rectangle(150, 150), new Label("_________________________" + Product.x / 2));
            CategorisePane.vbox1.getChildren().add(Product.product("Product", UserData.user.get(UserData.Usernumber).getEmail()));
            UserData.vbox.get(UserData.Usernumber).getChildren().add(Product.product("Product", UserData.user.get(UserData.Usernumber).getEmail()));
            Product.x++;
            //System.out.println(CategorisePane.vbox1);
        };
        PaneMyAccount.b1.setOnAction(add);

        EventHandler<ActionEvent> delete = (ActionEvent ActionEvent) -> {
            System.out.println("Delete");
            if (UserData.vbox.get(UserData.Usernumber).getChildren().size() > 0) {
                UserData.vbox.get(UserData.Usernumber).getChildren().remove(UserData.vbox.get(UserData.Usernumber).getChildren().size()-1);
            }
        };
        PaneMyAccount.b2.setOnAction(delete);

        EventHandler<ActionEvent> back = (ActionEvent ActionEvent) -> {
            //SceneHomeUnLogIn.getStackPane().getChildren().remove(PaneCenter.getPane());
            PaneTop.getPane().getChildren().add(CreateButton.buttonMyAccount);
            SceneHomeUnLogIn.getStackPane().getChildren().remove(PaneMyAccount.getPaneMyAcclayer1());
            //PaneCenter.getPane().setVisible(false);
        };
        PaneMyAccount.b3.setOnAction(back);

    }
}
