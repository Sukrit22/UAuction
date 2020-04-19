/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Effect;

import AuctionMain.CreateButton;
import AuctionMain.CreateTextField;
import Scene.SceneHomeUnLogIn;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Sitth
 */
public class PopUp {

    static private StackPane stackPane;
    static private StackPane stackPane2;
    static private StackPane stackPane3;
    static private Pane pane1;
    static private Rectangle popUpBackground;
    static private Rectangle fade;
    static public Pane worng = new Pane();
    static public Pane worng1 = new Pane();
    static public Pane worng2 = new Pane();
    private static final Label incorrecypass = new Label("*Maybe your Email or Password is incorrect*");
    private static final Label emailUsed = new Label("*This Email*");
    private static final Label passwordNotSame = new Label("*Paswwdfl fjkldsfjdslk*");

    static public StackPane popUp() {        
        createpopUpBackground();
        createStackPaneUpBackground();
        stackPane = new StackPane(stackPane2);
        return stackPane;

    }

    static public void incorrectPasswrod() {

        Font font = new Font(16);
        incorrecypass.setFont(font);
        incorrecypass.setStyle("-fx-focus-color:rgba( 2, 2, 2, 1.0); -fx-text-fill:rgba( 255, 0, 0, 1.0); -fx-faint-focus-color:rgba( 0, 255, 0, 0.0) ; -fx-inner-border:rgba( 255, 0, 0, 1.0); -fx-body-color:rgba( 255, 255, 255, 1.0); -fx-font-size: 20px;");
        worng.setLayoutX(80);
        worng.setLayoutY(160 + 48 + 48 + 48 + 48 + 12);
        incorrecypass.setMinWidth(600 - 160);
        worng.getChildren().add(incorrecypass);
        worng.setVisible(false);
    }
    
    static public void emailNotAvailable() {
        Font font = new Font(16);
        emailUsed.setFont(font);
        emailUsed.setStyle("-fx-focus-color:rgba( 2, 2, 2, 1.0); -fx-text-fill:rgba( 255, 0, 0, 1.0); -fx-faint-focus-color:rgba( 0, 255, 0, 0.0) ; -fx-inner-border:rgba( 255, 0, 0, 1.0); -fx-body-color:rgba( 255, 255, 255, 1.0); -fx-font-size: 20px;");
        worng1.setLayoutX(80);
        worng1.setLayoutY(160 + 48 + 48 + 48 + 48 + 12);
        emailUsed.setMinWidth(600 - 160);
        worng1.getChildren().add(emailUsed);
        worng1.setVisible(false);
    }
    
    static public void passwordNotSame() {
        Font font = new Font(16);
        passwordNotSame.setFont(font);
        passwordNotSame.setStyle("-fx-focus-color:rgba( 2, 2, 2, 1.0); -fx-text-fill:rgba( 255, 0, 0, 1.0); -fx-faint-focus-color:rgba( 0, 255, 0, 0.0) ; -fx-inner-border:rgba( 255, 0, 0, 1.0); -fx-body-color:rgba( 255, 255, 255, 1.0); -fx-font-size: 20px;");
        worng2.setLayoutX(80);
        worng2.setLayoutY(160 + 48 + 48 + 48 + 48 + 12);
        passwordNotSame.setMinWidth(600 - 160);
        worng2.getChildren().add(passwordNotSame);
        worng2.setVisible(false);
    }


    static public void createpopUpBackground() {
        popUpBackground = new Rectangle();
        popUpBackground.setWidth(600);
        popUpBackground.setHeight(460);
        popUpBackground.setFill(Color.web("rgba( 200, 200, 200,1.0)"));
        popUpBackground.setArcWidth(140);
        popUpBackground.setArcHeight(140);

        fade = new Rectangle();
        fade.setWidth(1920);
        fade.setHeight(1080);
        fade.setFill(Color.web("rgba( 0, 0, 0,0.5)"));

        EventHandler<MouseEvent> mcc = (MouseEvent ActionEvent) -> {
            //Do code here
            //CreateButton.buttonPopUpLogIn.setVisible(true);
            //CreateButton.buttonPopUpCreateAccount.setVisible(false);
            //CreateTextField.email.setVisible(false);
            //CreateTextField.password.setVisible(false);
            //CreateTextField.passwordC.setVisible(true);
            //CreateButton.buttonPopUpLogIn2.setVisible(false);
            //CreateButton.buttonPopUpSignUp.setVisible(true);
            SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUp.getStackPane());
            //setSceneForStage.stageSetHomeAlreadyLogIn();
            System.out.println("Click");

        };
        fade.setOnMouseClicked(mcc);

        Font font = new Font(32);

        Text logIn = new Text("LOG IN");
        logIn.setFont(font);
        StackPane paneLogIn = new StackPane();
        paneLogIn.setMinSize(300, 140);
        paneLogIn.getChildren().add(logIn);

        Text createAccount = new Text("SIGN UP");
        createAccount.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(300, 140);
        pane.setLayoutX(300);
        pane.setLayoutY(0);
        pane.getChildren().add(createAccount);

        Font font2 = new Font(24);

        CreateTextField.email.setFont(font2);
        CreateTextField.email.setLayoutX(80);
        CreateTextField.email.setLayoutY(160);
        CreateTextField.email.setMinWidth(600 - 160);

        CreateTextField.password.setFont(font2);
        CreateTextField.password.setLayoutX(80);
        CreateTextField.password.setLayoutY(160 + 48 + 24);
        CreateTextField.password.setMinWidth(600 - 160);

        CreateTextField.passwordC.setFont(font2);
        CreateTextField.passwordC.setLayoutX(80);
        CreateTextField.passwordC.setLayoutY(160 + 48 + 48 + 48);
        CreateTextField.passwordC.setMinWidth(600 - 160);

        pane1 = new Pane(popUpBackground, CreateTextField.email, CreateTextField.password, CreateTextField.passwordC, paneLogIn, CreateButton.buttonPopUpLogIn, pane, CreateButton.buttonPopSwitchToSignUp, CreateButton.buttonPopUpSwitchToLogIn, worng, CreateButton.buttonPopUpRegister , worng1, worng2);
        pane1.setMaxWidth(600);
        pane1.setMaxHeight(460);
        //pane1.setMinWidth(600);
        //pane1.setMinHeight(1000);
        //pane1.setLayoutY(540);

    }

    static public void createStackPaneUpBackground() {
        stackPane2 = new StackPane(fade);
        stackPane2.getChildren().addAll(pane1);
    }

    public static StackPane getStackPane() {
        return stackPane;
    }
}
