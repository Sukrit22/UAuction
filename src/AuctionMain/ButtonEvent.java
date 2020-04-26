/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionMain;

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
import uauction.User;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import Effect.Notifications;
import Scene.Home.MyAccount.AddProduct;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.imageio.ImageIO;
import uauction.ActiveProduct;
import uauction.Database;
import uauction.Product;

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
            Object obj = new Object();
            if (CreateTextField.userName.getText().isEmpty() || CreateTextField.password.getText().isEmpty()) {
                PopUp.incorrecypassPane.setVisible(true);
            } else {
                try {
                    obj = NewClient.reqLogin(CreateTextField.userName.getText(), CreateTextField.password.getText());
                    System.out.println("login done");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("IOEvnBt");
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("ClassNot EvnBt");
                }

                if (obj.getClass().equals((new User()).getClass())) {
                    NewClient.user = (User) obj;
                    loginPop = true;
                } else if (obj.getClass().equals("".getClass())) {
                    System.out.println("login get String");
                    loginPop = false;
                } else {
                    System.out.println("อะไรกันแน่วะไอสัส");
                    loginPop = false;
                }
                if (loginPop) {
                    CreateButton.buttonHelpPaneTop.setLayoutX(1920 - 400 - 150 - 150);
                    PaneTop.getPane().getChildren().addAll(CreateButton.buttonMyAccount, CreateButton.buttonSignOutTopPane);
                    PaneTop.getPane().getChildren().remove(CreateButton.buttonLogInPaneTop);
                    NewClient.user.setToBoth();
                    SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUp.getStackPane());

                } else {
                    //Wrong Password
                    PopUp.incorrecypassPane.setVisible(true);
                }
            }

        };
        CreateButton.buttonPopUpLogIn.setOnMouseClicked(logInOnPopUp);

        CreateTextField.password.setOnKeyPressed(logInOnPopUpEnter -> {
            if (CreateButton.buttonPopSwitchToSignUp.isVisible()) {
                if (logInOnPopUpEnter.getCode() == KeyCode.ENTER) {
                    boolean loginPop = false;
                    // TextField CreateTextField.userName + CreateTextField.password

                    System.out.println("buttonPopUpLogIn");
                    Object obj = new Object();
                    if (CreateTextField.userName.getText().isEmpty() || CreateTextField.password.getText().isEmpty()) {
                        PopUp.incorrecypassPane.setVisible(true);
                    } else {
                        try {
                            obj = NewClient.reqLogin(CreateTextField.userName.getText(), CreateTextField.password.getText());
                        } catch (IOException ex) {
                            Logger.getLogger(ButtonEvent.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(ButtonEvent.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        if (obj.getClass().equals((new User()).getClass())) {
                            NewClient.user = (User) obj;
                            loginPop = true;
                        } else if (obj.getClass().equals("".getClass())) {
                            loginPop = false;
                        } else {
                            System.out.println("อะไรกันแน่วะไอสัส");
                            loginPop = false;
                        }
                        if (loginPop) {
                            CreateButton.buttonHelpPaneTop.setLayoutX(1920 - 400 - 150 - 150);
                            PaneTop.getPane().getChildren().addAll(CreateButton.buttonMyAccount, CreateButton.buttonSignOutTopPane);
                            PaneTop.getPane().getChildren().remove(CreateButton.buttonLogInPaneTop);
                            SceneHomeUnLogIn.getStackPane().getChildren().remove(PopUp.getStackPane());
                            NewClient.user.setToBoth();
                        } else {
                            //Wrong Password
                            PopUp.incorrecypassPane.setVisible(true);
                        }
                    }
                }
            }
        });

//=========================== done =======================
        EventHandler<MouseEvent> registerOnPopUpEV = (MouseEvent ActionEvent) -> {
            // TextField CreateTextField.userName + CreateTextField.password + CreateTextField.passwordC
            System.out.println("Register");
            //System.out.println(" GG");
            Object obj = new Object();
            PopUp.passwordNotSamePane.setVisible(false);
            PopUp.emailUsedPane.setVisible(false);
            if (CreateTextField.userName.getText().isEmpty() || CreateTextField.password.getText().isEmpty() || CreateTextField.passwordC.getText().isEmpty()) {
                PopUp.passwordNotSamePane.setVisible(true);
            } else {
                if (CreateTextField.password.getText().equals(CreateTextField.passwordC.getText())) {
                    boolean panHa = false;
                    try {
                        obj = NewClient.reqRegister(CreateTextField.userName.getText(), CreateTextField.password.getText());
                    } catch (IOException ex) {
                        Logger.getLogger(ButtonEvent.class.getName()).log(Level.SEVERE, null, ex);
                        panHa = true;
                        System.out.println("IO");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ButtonEvent.class.getName()).log(Level.SEVERE, null, ex);
                        panHa = true;
                        System.out.println("ClassNoFound");
                    }
                    if (panHa) {
                        System.out.println("panHa");
                        PopUp.emailUsedPane.setVisible(true);
                    } else if (obj.getClass().equals("".getClass())) {
                        PopUp.emailUsedPane.setVisible(true);
                    } else if (obj.getClass().equals((new User()).getClass())) {
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
            }
        };
        CreateButton.buttonPopUpRegister.setOnMouseClicked(registerOnPopUpEV);

        CreateTextField.passwordC.setOnKeyPressed(logInOnPopUpEnter -> {
            if (logInOnPopUpEnter.getCode() == KeyCode.ENTER) {
                System.out.println("Register");
                //System.out.println(" GG");
                Object obj = new Object();
                PopUp.passwordNotSamePane.setVisible(false);
                PopUp.emailUsedPane.setVisible(false);
                if (!CreateTextField.userName.getText().isEmpty() || !CreateTextField.password.getText().isEmpty() || !CreateTextField.passwordC.getText().isEmpty()) {
                    PopUp.passwordNotSamePane.setVisible(true);
                } else {
                    if (CreateTextField.password.getText().equals(CreateTextField.passwordC.getText())) {
                        boolean panHa = false;
                        try {
                            obj = NewClient.reqRegister(CreateTextField.userName.getText(), CreateTextField.password.getText());
                        } catch (IOException ex) {
                            Logger.getLogger(ButtonEvent.class.getName()).log(Level.SEVERE, null, ex);
                            panHa = true;
                            System.out.println("IO");
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(ButtonEvent.class.getName()).log(Level.SEVERE, null, ex);
                            panHa = true;
                            System.out.println("ClassNoFound");
                        }
                        if (panHa) {
                            System.out.println("panHa");
                            PopUp.emailUsedPane.setVisible(true);
                        } else if (obj.getClass().equals("".getClass())) {
                            PopUp.emailUsedPane.setVisible(true);
                        } else if (obj.getClass().equals((new User()).getClass())) {
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
                }
            }
        });
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
            if (!AddProduct.pathAdded && !(AddProduct.filePath == null)) {
                System.out.println("mee pic path");
                AddProduct.pathAdded = true;
                Date end = Date.from((AddProduct.datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                long hour = Long.parseLong((String) AddProduct.comboBoxHour.getValue());
                if (hour == 12) {
                    hour = 0;
                }
                hour = hour * 60 * 60 * 1000; //milliseconds
                if (AddProduct.comboBoxAmPm.getItems().indexOf(AddProduct.comboBoxAmPm.getValue()) == 1) {
                    hour += (long) (43200000);
                }
                end.setTime((long) (end.getTime() + hour));
                String name = AddProduct.productName.getText();
                //miniBid and StartBid is number
                Product product = new Product(name, AddProduct.productDescription.getText(), AddProduct.getSelectText().getText(), Double.parseDouble(AddProduct.startBid.getText()), Double.parseDouble(AddProduct.minimumBid.getText()), end);
                product.setMyOwnerName(NewClient.user.getUsername());
                BufferedImage image = SwingFXUtils.fromFXImage(new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/noimg.jpg"), null);
                try {
                    image = ImageIO.read(AddProduct.filePath);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("อ่านรูปก่อนรีจิสโพรดักไม่ได้ว่ะ");
                }
                NewClient.reqRegisterProduct(product, image);
            } else {
                PopUp.chooseNewPicPane.setVisible(true);
            }

//            CategorisePane.vboxArray.get(0).getChildren().add(ProductPaneInVbox.Pane1(new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/TopPane.png"), "productName", "dis", 125.00, ProductPaneInVbox.countIDAllProduct));
        };
        PaneMyAccount.btnAdd.setOnAction(add);

        EventHandler<ActionEvent> delete = (ActionEvent ActionEvent) -> {
            if (!CategorisePane.vboxArray.get(0).getChildren().isEmpty()) {
                CategorisePane.vboxArray.get(0).getChildren().remove(CategorisePane.vboxArray.get(0).getChildren().size() - 1);
            }
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

        EventHandler<MouseEvent> myAcc = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("My Account");
            PaneTop.getPane().getChildren().remove(CreateButton.buttonMyAccount);
            SceneHomeUnLogIn.getStackPane().getChildren().add(PaneMyAccount.getPaneMyAcclayer1());
        };

        CreateButton.buttonMyAccount.setOnMouseClicked(myAcc);

        EventHandler<ActionEvent> back = (ActionEvent ActionEvent) -> {

            boolean addAble1 = true;

            for (int i = 0; i < PaneTop.getPane().getChildren().size(); i++) {
                if (PaneTop.getPane().getChildren().get(i) == CreateButton.buttonMyAccount) {
                    addAble1 = false;
                }
            }
            if (addAble1) {
                PaneTop.getPane().getChildren().add(CreateButton.buttonMyAccount);
            }

            boolean removeAble1 = false;
            for (int i = 0; i < SceneHomeUnLogIn.getStackPane().getChildren().size(); i++) {
                if (SceneHomeUnLogIn.getStackPane().getChildren().get(i) == PaneMyAccount.getPaneMyAcclayer1()) {
                    removeAble1 = true;
                }
            }
            if (removeAble1) {
                SceneHomeUnLogIn.getStackPane().getChildren().remove(PaneMyAccount.getPaneMyAcclayer1());
            }

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

        EventHandler<MouseEvent> backMVE = (MouseEvent ActionEvent) -> {

            boolean addAble1 = true;

            for (int i = 0; i < PaneTop.getPane().getChildren().size(); i++) {
                if (PaneTop.getPane().getChildren().get(i) == CreateButton.buttonMyAccount) {
                    addAble1 = false;
                }
            }
            if (addAble1) {
                PaneTop.getPane().getChildren().add(CreateButton.buttonMyAccount);
            }

            boolean removeAble1 = false;
            for (int i = 0; i < SceneHomeUnLogIn.getStackPane().getChildren().size(); i++) {
                if (SceneHomeUnLogIn.getStackPane().getChildren().get(i) == PaneMyAccount.getPaneMyAcclayer1()) {
                    removeAble1 = true;
                }
            }
            if (removeAble1) {
                SceneHomeUnLogIn.getStackPane().getChildren().remove(PaneMyAccount.getPaneMyAcclayer1());
            }
            //NewClient.reqMarket();
            //NewClient.showMarket(NewClient.unfilteredProduct, vbox);            

            System.out.println(CategorisePane.vboxArray.get(0).getChildren().size());

            int i = 0;
//            CategorisePane.vboxArray.get(i).getChildren().removeAll();
            try {
                NewClient.reqMarket(0);
            } catch (Exception ex) {
                System.out.println("unsuccessfully request data of market from server");
                System.out.println(ex.getMessage());
            }
            NewClient.showMarket(0);
//            NewClient.filteredProduct.forEach(j -> {
//                CategorisePane.vboxArray.get(i).getChildren().add(ProductPaneInVbox.Pane1(j.getProduct().getName(), j.getProduct().getDescription(), j.getCurrentBid(), j.getProduct().getItemId()));
//            });
//            CategorisePane.vboxArray.get(i).getChildren().add(ProductPaneInVbox.Pane1(NewClient.filteredProduct.get(i).getProduct().getName(), "", 20.d, 1));
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

        EventHandler<MouseEvent> notifi = (MouseEvent ActionEvent) -> {
            System.out.println("Notifi");
            SceneHomeUnLogIn.getStackPane().getChildren().add(Notifications.pane);
        };

        CreateButton.buttonBellHomeEff.setOnMouseClicked(notifi);
        CreateButton.buttonBellHome.setOnMouseClicked(notifi);

        EventHandler<MouseEvent> notifi2 = (MouseEvent ActionEvent) -> {
            System.out.println("Notifi");
            boolean check = false;
            for (int i = 0; i < SceneHomeUnLogIn.getStackPane().getChildren().size(); i++) {
                if (SceneHomeUnLogIn.getStackPane().getChildren().get(i) != Notifications.pane) {
                    check = true;

                }
                if (check) {
                    SceneHomeUnLogIn.getStackPane().getChildren().add(Notifications.pane);
                    Notifications.pane.setOpacity(0.2);
                }
            }

        };

        //CreateButton.buttonBellHomeEff.setOnMouseEntered(notifi2);
        //CreateButton.buttonBellHome.setOnMouseEntered(notifi2);

        EventHandler<MouseEvent> notifi3 = (MouseEvent ActionEvent) -> {
            System.out.println("Notifi");
            boolean check = false;
            for (int i = 0; i < SceneHomeUnLogIn.getStackPane().getChildren().size(); i++) {
                if (SceneHomeUnLogIn.getStackPane().getChildren().get(i) == Notifications.pane) {
                    check = true;
                }
                if (check) {
                    SceneHomeUnLogIn.getStackPane().getChildren().remove(Notifications.pane);
                    Notifications.pane.setOpacity(1.0);
                }
            }
        };

        //CreateButton.buttonBellHomeEff.setOnMouseExited(notifi3);
        //CreateButton.buttonBellHome.setOnMouseExited(notifi3);

        EventHandler<MouseEvent> notifiBack = (MouseEvent ActionEvent) -> {
            System.out.println("Notifi");
            SceneHomeUnLogIn.getStackPane().getChildren().remove(Notifications.pane);
            CreateButton.buttonBellHomeEff.setVisible(false);
        };

        Notifications.pane.setOnMouseClicked(notifiBack);

        CreateButton.buttonSearch.setOnMouseClicked(
                (t) -> {
                    System.out.println("Search");
                    ArrayList<ActiveProduct> obj1 = NewClient.unfilteredProduct;
                    ArrayList<ActiveProduct> obj2 = new ArrayList<ActiveProduct>();
                    for (ActiveProduct activeProduct : obj1) {
                        if (activeProduct.getProduct().getName().matches(".*" + CreateTextField.search + ".*")) {
                            obj2.add(activeProduct);
                        }
                    }
                    NewClient.filteredProduct = obj2;

                }
        );

        EventHandler<MouseEvent> home = (MouseEvent ActionEvent) -> {
            //Do code here
            System.out.println("buttonHelpPaneTop");
            try {
                int r = getRandomNumberInRange(0, 3);
                switch (r) {
                    case 0:
                        Desktop.getDesktop().browse(new URI("https://www.instagram.com/loukgolf_maj7/"));
                        break;
                    case 1:
                        Desktop.getDesktop().browse(new URI("https://www.instagram.com/real_sukrit22/"));
                        break;
                    case 3:
                        Desktop.getDesktop().browse(new URI("https://www.instagram.com/supakit6199/"));
                        break;
                    case 4:
                        Desktop.getDesktop().browse(new URI("https://www.instagram.com/be_an_ttl/"));
                        break;
                    default:
                    // code block
                }

            } catch (URISyntaxException ex) {
                Logger.getLogger(ButtonEvent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ButtonEvent.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        CreateButton.buttonBackOnACC.setOnMouseClicked(home);

    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
