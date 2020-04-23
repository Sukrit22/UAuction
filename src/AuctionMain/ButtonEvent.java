/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionMain;

import static AuctionMain.CreateButton.buttonHelpPaneTop;
import Effect.PopUp;
import Scene.Home.PaneTop;
import Scene.Home.SceneHomeUnLogIn;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import Scene.CategorisePane;
import Scene.Home.MyAccount.PaneMyAccount;
import Scene.ProductPaneInVbox;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uauction.NewClient;
import uauction.Product;
import uauction.User;
import Scene.Home.MyAccount.AddProduct;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import Effect.Notifications;

/**
 *
 * @author Sitth
 */
public class ButtonEvent {

    static public void buttonEventForSceneHomeUnLogIn() {

        EventHandler<MouseEvent> logInOnPopUp = (MouseEvent ActionEvent) -> {
            boolean loginPop = false;
            // TextField CreateTextField.userName + CreateTextField.password
            
            System.out.println("buttonPopUpLogIn");
            Object obj = null;
            
            try {
                obj =  NewClient.reqLogin(CreateTextField.userName.getText(), CreateTextField.password.getText());
                //obj =  NewClient.reqLogin("asdasdasdasd","asdasdasdasd");
            } catch (IOException ex) {
                Logger.getLogger(ButtonEvent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ButtonEvent.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
           
            if(obj.getClass().equals((new User()).getClass())){
                NewClient.user = (User)obj;
                loginPop = true;
            }else if(obj.getClass().equals("".getClass())){
                loginPop = false;
            }else{
                System.out.println("อะไรกันแน่วะไอสัส");
                loginPop = false;
            }
            
            if (loginPop) {
                CreateButton.buttonHelpPaneTop.setLayoutX(1920 - 400 - 150 - 150);
                PaneTop.getPane().getChildren().addAll(CreateButton.buttonMyAccount, CreateButton.buttonSignOutTopPane);
                PaneTop.getPane().getChildren().remove(CreateButton.buttonLogInPaneTop);
                SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUp.getStackPane());
            } else {
                //Wrong Password
                PopUp.incorrecypassPane.setVisible(true);
            }
        };
        CreateButton.buttonPopUpLogIn.setOnMouseClicked(logInOnPopUp);
//=========================== done =======================
        EventHandler<MouseEvent> registerOnPopUpEV = (MouseEvent ActionEvent) -> {
            // TextField CreateTextField.userName + CreateTextField.password + CreateTextField.passwordC
            System.out.println("Register");
            Object obj = null;
            if(CreateTextField.password.equals(CreateTextField.passwordC)){
                boolean panHa = false;
                try {
                    obj = NewClient.reqRegister(CreateTextField.userName.getText(), CreateTextField.password.getText());
                } catch (IOException ex) {
                    Logger.getLogger(ButtonEvent.class.getName()).log(Level.SEVERE, null, ex);
                    panHa = true;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ButtonEvent.class.getName()).log(Level.SEVERE, null, ex);
                    panHa = true;
                }
                 if (panHa){
                     PopUp.emailUsedPane.setVisible(true);
                 } else if(obj.getClass().equals("".getClass())){
                     PopUp.emailUsedPane.setVisible(true);
                 } else if(obj.getClass().equals((new User()).getClass())){
                     NewClient.user = (User) obj;
                     CreateButton.buttonHelpPaneTop.setLayoutX(1920 - 400 - 150 - 150);
                     PaneTop.getPane().getChildren().addAll(CreateButton.buttonMyAccount, CreateButton.buttonSignOutTopPane);
                     PaneTop.getPane().getChildren().remove(CreateButton.buttonLogInPaneTop);
                     SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUp.getStackPane());
                 }
            } else {
                //Password Not Same
                 PopUp.passwordNotSamePane.setVisible(true);
            }
        };
        CreateButton.buttonPopUpRegister.setOnMouseClicked(registerOnPopUpEV);
//=========================== done =======================
        EventHandler<MouseEvent> helpEV = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("buttonHelpPaneTop");
            try {
                Desktop.getDesktop().browse(new URI("https://google.com"));
            } catch (URISyntaxException ex) {
                Logger.getLogger(ButtonEvent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ButtonEvent.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        CreateButton.buttonHelpPaneTop.setOnMouseClicked(helpEV);
//=========================== done =======================
        EventHandler<ActionEvent> add = (ActionEvent ActionEvent) -> {
            System.out.println("Add from MyACC");
            Date end = Date.from((AddProduct.datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            long hour = (long) AddProduct.comboBoxHour.getItems().indexOf(AddProduct.comboBoxHour.getValue());
            hour = hour * 60 * 60 * 1000;
            if (AddProduct.comboBoxAmPm.getItems().indexOf(AddProduct.comboBoxAmPm.getValue()) == 1) {
                hour += (long) (43200000);
            }
            end.setTime((long) (end.getTime() + hour));
            String name = AddProduct.productName.getText();
            Product product = new Product(name, AddProduct.productDescription.getText(), AddProduct.getSelectText().getText(), Double.parseDouble(AddProduct.startBid.getText()), Double.parseDouble(AddProduct.minimumBid.getText()), end);

            //NewClient.reqRegisterProduct(product, image);
            //CategorisePane.vboxArray.get(0).getChildren().add(ProductPaneInVbox.Pane1());
        };
        PaneMyAccount.btnAdd.setOnAction(add);
//=========================== undone =======================
        EventHandler<ActionEvent> delete = (ActionEvent ActionEvent) -> {
            if(!CategorisePane.vboxArray.get(0).getChildren().isEmpty())
            CategorisePane.vboxArray.get(0).getChildren().remove(CategorisePane.vboxArray.get(0).getChildren().size()-1);
            System.out.println("Delete");
        };
        PaneMyAccount.btnDelete.setOnAction(delete);
//=========================== cancel =======================
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
//=========================== done =======================
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
            PopUp.passwordNotSamePane.setVisible(false);
            PopUp.emailUsedPane.setVisible(false);
            System.out.println("buttonPopUpSwitchToLogIn");
        };
        CreateButton.buttonPopUpSwitchToLogIn.setOnMouseClicked(buttonPopUpSwitchToLogInEV);
//=========================== done =======================
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
            PopUp.passwordNotSamePane.setVisible(false);
            PopUp.emailUsedPane.setVisible(false);
            SceneHomeUnLogIn.getStackPane().getChildren().add(PopUp.getStackPane());
        };
        CreateButton.buttonLogInPaneTop.setOnMouseClicked(buttonLogInPaneTopEV);
//=========================== done =======================
        EventHandler<MouseEvent> signOut = (MouseEvent ActionEvent) -> {
            //Do code here
            CreateButton.buttonHelpPaneTop.setLayoutX(1920 - 400 - 150);
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
            NewClient.user = new User();
        };
        CreateButton.buttonSignOutTopPane.setOnMouseClicked(signOut);
//=========================== done =======================
        EventHandler<MouseEvent> myAcc = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("My Account");
            PaneTop.getPane().getChildren().remove(CreateButton.buttonMyAccount);
            SceneHomeUnLogIn.getStackPane().getChildren().add(PaneMyAccount.getPaneMyAcclayer1());
        };
        CreateButton.buttonMyAccount.setOnMouseClicked(myAcc);
//=========================== done =======================
        EventHandler<ActionEvent> back = (ActionEvent ActionEvent) -> {
            PaneTop.getPane().getChildren().add(CreateButton.buttonMyAccount);
            SceneHomeUnLogIn.getStackPane().getChildren().remove(PaneMyAccount.getPaneMyAcclayer1());
            System.out.println(CategorisePane.vboxArray.get(0).getChildren().size());
            int i = 0;
            if (CategorisePane.vboxArray.get(i).getChildren().isEmpty()) {
                CategorisePane.vboxArray.get(i).getChildren().add(CategorisePane.pane1);
            }
            if (CategorisePane.vboxArray.get(i).getChildren().size() > 1) {
                //System.out.println("More Than 1" + CategorisePane.vboxArray.get(i).getChildren().get(0));
                if (CategorisePane.vboxArray.get(i).getChildren().get(0) == CategorisePane.pane1) {
                    //System.out.println("1 is No product");
                    CategorisePane.vboxArray.get(i).getChildren().remove(CategorisePane.pane1);
                }
            }

        };
        PaneMyAccount.btnBack.setOnAction(back);
        PaneMyAccount.btnBack2.setOnAction(back);
        //=========================== done =======================
        EventHandler<MouseEvent> backMVE = (MouseEvent ActionEvent) -> {
            PaneTop.getPane().getChildren().add(CreateButton.buttonMyAccount);
            SceneHomeUnLogIn.getStackPane().getChildren().remove(PaneMyAccount.getPaneMyAcclayer1());
            System.out.println(CategorisePane.vboxArray.get(0).getChildren().size());
            int i = 0;
            if (CategorisePane.vboxArray.get(i).getChildren().isEmpty()) {
                CategorisePane.vboxArray.get(i).getChildren().add(CategorisePane.pane1);
            }
            if (CategorisePane.vboxArray.get(i).getChildren().size() > 1) {
                //System.out.println("More Than 1" + CategorisePane.vboxArray.get(i).getChildren().get(0));
                if (CategorisePane.vboxArray.get(i).getChildren().get(0) == CategorisePane.pane1) {
                    //System.out.println("1 is No product");
                    CategorisePane.vboxArray.get(i).getChildren().remove(CategorisePane.pane1);
                }
            }
        };
        CreateButton.buttonBackOnACC.setOnMouseClicked(backMVE);
        CreateButton.buttonBackOnACC2.setOnMouseClicked(backMVE);
        //=========================== done =======================
        EventHandler<MouseEvent> notifi = (MouseEvent ActionEvent) -> {
            System.out.println("Notifi");
            SceneHomeUnLogIn.getStackPane().getChildren().add(Notifications.pane);
        };
        CreateButton.buttonBellHomeEff.setOnMouseClicked(notifi);
        CreateButton.buttonBellHome.setOnMouseClicked(notifi);
        
        EventHandler<MouseEvent> notifiBack = (MouseEvent ActionEvent) -> {
            System.out.println("Notifi");
            SceneHomeUnLogIn.getStackPane().getChildren().remove(Notifications.pane);
        };
        Notifications.pane.setOnMouseClicked(notifiBack);
        
        
        
    }//=========================== end of method =======================

        
}
