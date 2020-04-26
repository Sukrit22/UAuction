/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Effect;

import AuctionMain.CreateButton;
import AuctionMain.CreateTextField;
import Scene.Home.SceneHomeUnLogIn;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import uauction.NewClient;

/**
 *
 * @author Sitth
 */
public class PopUp {

    static private StackPane stackPane;
    static private StackPane containAllStackPane;
    static private Pane pane1;
    static private Rectangle popUpRectangleShape;
    static private Rectangle popUpFadeBackgroundRectangle;
    static public Pane incorrecypassPane = new Pane();
    static public Pane emailUsedPane = new Pane();
    static public Pane passwordNotSamePane = new Pane();
    static public Pane chooseNewPicPane = new Pane();
    private static final Label incorrecypass = new Label("*Maybe your Username or Password is incorrect*");
    private static final Label emailUsed = new Label("*This Username Alread Used*");
    private static final Label passwordNotSame = new Label("*Your Passwords are not match*");
    private static final Label chooseNewPic = new Label("*Please choose only .jpg image*");

    static public void setUpPopUp(){
        popUp();
        incorrectPasswrod();
        emailNotAvailable();
        passwordNotSame();
        chooseNewPic();
    }
    
    static private void popUp() {        
        createpopUpBackground();
        createStackPaneUpBackground();
        //stackPane = new StackPane(containAllStackPane);

    }

    static private void chooseNewPic() {
        Font font = new Font(16);
        chooseNewPic.setFont(font);
        chooseNewPic.setStyle("-fx-focus-color:rgba( 2, 2, 2, 1.0); -fx-text-fill:rgba( 255, 0, 0, 1.0); -fx-faint-focus-color:rgba( 0, 255, 0, 0.0) ; -fx-inner-border:rgba( 255, 0, 0, 1.0); -fx-body-color:rgba( 255, 255, 255, 1.0); -fx-font-size: 20px;");
        chooseNewPicPane.setLayoutX(80);
        chooseNewPicPane.setLayoutY(160 + 48 + 48 + 48 + 48 + 12);
        chooseNewPic.setMinWidth(600 - 160);
        chooseNewPicPane.getChildren().add(chooseNewPic);
        chooseNewPicPane.setVisible(false);
    }
    
    static private void incorrectPasswrod() {

        Font font = new Font(16);
        incorrecypass.setFont(font);
        incorrecypass.setStyle("-fx-focus-color:rgba( 2, 2, 2, 1.0); -fx-text-fill:rgba( 255, 0, 0, 1.0); -fx-faint-focus-color:rgba( 0, 255, 0, 0.0) ; -fx-inner-border:rgba( 255, 0, 0, 1.0); -fx-body-color:rgba( 255, 255, 255, 1.0); -fx-font-size: 20px;");
        incorrecypassPane.setLayoutX(80);
        incorrecypassPane.setLayoutY(160 + 48 + 48 + 48 + 48 + 12);
        incorrecypass.setMinWidth(600 - 160);
        incorrecypassPane.getChildren().add(incorrecypass);
        incorrecypassPane.setVisible(false);
    }
    
    static private void emailNotAvailable() {
        Font font = new Font(16);
        emailUsed.setFont(font);
        emailUsed.setStyle("-fx-focus-color:rgba( 2, 2, 2, 1.0); -fx-text-fill:rgba( 255, 0, 0, 1.0); -fx-faint-focus-color:rgba( 0, 255, 0, 0.0) ; -fx-inner-border:rgba( 255, 0, 0, 1.0); -fx-body-color:rgba( 255, 255, 255, 1.0); -fx-font-size: 20px;");
        emailUsedPane.setLayoutX(80);
        emailUsedPane.setLayoutY(160+48);
        emailUsed.setMinWidth(600 - 160);
        emailUsedPane.getChildren().add(emailUsed);
        emailUsedPane.setVisible(false);
    }
    
    static private void passwordNotSame() {
        Font font = new Font(16);
        passwordNotSame.setFont(font);
        passwordNotSame.setStyle("-fx-focus-color:rgba( 2, 2, 2, 1.0); -fx-text-fill:rgba( 255, 0, 0, 1.0); -fx-faint-focus-color:rgba( 0, 255, 0, 0.0) ; -fx-inner-border:rgba( 255, 0, 0, 1.0); -fx-body-color:rgba( 255, 255, 255, 1.0); -fx-font-size: 20px;");
        passwordNotSamePane.setLayoutX(80);
        passwordNotSamePane.setLayoutY(160 + 48 + 48 + 48 + 48);
        passwordNotSame.setMinWidth(600 - 160);
        passwordNotSamePane.getChildren().add(passwordNotSame);
        passwordNotSamePane.setVisible(false);
    }


    static private void createpopUpBackground() {
        popUpRectangleShape = new Rectangle();
        popUpRectangleShape.setWidth(600);
        popUpRectangleShape.setHeight(460);
        popUpRectangleShape.setFill(Color.web("rgba( 200, 200, 200,1.0)"));
        popUpRectangleShape.setArcWidth(140);
        popUpRectangleShape.setArcHeight(140);

        popUpFadeBackgroundRectangle = new Rectangle();
        popUpFadeBackgroundRectangle.setWidth(1920);
        popUpFadeBackgroundRectangle.setHeight(1080);
        popUpFadeBackgroundRectangle.setFill(Color.web("rgba( 0, 0, 0,0.5)"));

        EventHandler<MouseEvent> mcc = (MouseEvent ActionEvent) -> {
            //Do code here
            PopUp.incorrecypassPane.setVisible(false);
            PopUp.passwordNotSamePane.setVisible(false);
            PopUp.emailUsedPane.setVisible(false);
            SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUp.getStackPane());
            if(SceneHomeUnLogIn.getStackPane().getChildren().get(SceneHomeUnLogIn.getStackPane().getChildren().size()-1).equals(PopUpProduct.getStackPane())){
                if (!NewClient.user.canBuy()){
                    SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUpProduct.getStackPane());
                }
            }
            System.out.println("Click");

        };
        popUpFadeBackgroundRectangle.setOnMouseClicked(mcc);

        Font font = new Font(32);

        Text logInText = new Text("LOG IN");
        logInText.setFont(font);
        StackPane paneLogIn = new StackPane();
        paneLogIn.setMinSize(300, 140);
        paneLogIn.getChildren().add(logInText);

        Text signUpText = new Text("SIGN UP");
        signUpText.setFont(font);
        StackPane paneSignUp = new StackPane();
        paneSignUp.setMinSize(300, 140);
        paneSignUp.setLayoutX(300);
        paneSignUp.setLayoutY(0);
        paneSignUp.getChildren().add(signUpText);

        Font font2 = new Font(24);

        CreateTextField.userName.setFont(font2);
        CreateTextField.userName.setLayoutX(80);
        CreateTextField.userName.setLayoutY(160);
        CreateTextField.userName.setMinWidth(600 - 160);

        CreateTextField.password.setFont(font2);
        CreateTextField.password.setLayoutX(80);
        CreateTextField.password.setLayoutY(160 + 48 + 24);
        CreateTextField.password.setMinWidth(600 - 160);

        CreateTextField.passwordC.setFont(font2);
        CreateTextField.passwordC.setLayoutX(80);
        CreateTextField.passwordC.setLayoutY(160 + 48 + 48 + 48);
        CreateTextField.passwordC.setMinWidth(600 - 160);

        pane1 = new Pane(popUpRectangleShape, CreateTextField.userName, CreateTextField.password, CreateTextField.passwordC, paneLogIn, CreateButton.buttonPopUpLogIn, paneSignUp, CreateButton.buttonPopSwitchToSignUp, CreateButton.buttonPopUpSwitchToLogIn, incorrecypassPane, CreateButton.buttonPopUpRegister , emailUsedPane, passwordNotSamePane,chooseNewPicPane);
        pane1.setMaxWidth(600);
        pane1.setMaxHeight(460);

    }

    static private void createStackPaneUpBackground() {
        containAllStackPane = new StackPane();
        containAllStackPane.getChildren().addAll(popUpFadeBackgroundRectangle, pane1);
    }

    public static StackPane getStackPane() {
        return containAllStackPane;
    }
}
