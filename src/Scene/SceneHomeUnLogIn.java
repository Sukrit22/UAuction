/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import static AuctionMain.ButtonEvent.buttonEventForSceneHomeUnLogIn;
import ScrollPaneFolder.PaneDefault;
import AuctionMain.CreateButton;
import AuctionMain.CreateTextField;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Sitth
 */
public class SceneHomeUnLogIn {

    static private StackPane stackPane = new StackPane();
    static private Scene scene = new Scene(stackPane);

    static public void sceneHomeUnLogIn() {
        CreateTextField.searchField();
        CreateButton.buttonSearch();
        CreateButton.buttonCreateAccount();
        CreateButton.buttonLogIn();
        CreateButton.buttonPopUpLogIn2();
        CreateButton.buttonPopUpSignUp();
        CreateButton.buttonLogIn3();
        CreateButton.buttonMyAccount();
        CreateButton.buttonSignOut();
        CreateTextField.createEmailField();
        CreateTextField.createPasswordField();
        CreateTextField.createPasswordCField();
        PaneMyAccount.makePane();
        CategorisePane.setUp();
        //PaneRight.setUp();
        CategorisePane.setUp();
        
        buttonEventForSceneHomeUnLogIn();
        stackPane.getChildren().add(createBorderPane());
    }

    public static Scene getScene() {
        return scene;
    }

    static private Pane createPaneTop() {
        PaneTop.createPane();
        Pane pane = new Pane(PaneTop.getPane());
        pane.setMinSize(1920, 200);
        
        return pane;
    }

    static private ScrollPane createPaneRight() {
        Pane bha = new Pane();
        PaneDefault.array();
        //PaneRight
        //CategorisePane.pane.get(0).getChildren().get(0).
        bha.getChildren().addAll(CategorisePane.pane.get(0));
        ScrollPane pane = new ScrollPane(bha);
        pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        pane.setMinSize(1700, 1000 - 200);
        pane.setStyle("-fx-focus-color:rgba( 2, 2, 2, 1.0); -fx-text-fill:rgba( 255, 0, 0, 1.0); -fx-faint-focus-color:rgba( 0, 255, 0, 0.0) ; -fx-inner-border:rgba( 255, 0, 0, 1.0); -fx-body-color:rgba( 255, 255, 255, 1.0); -fx-font-size: 20px;");
        return pane;
    }

    static private Pane createPaneLeft() {
        /*
        ArrayList<Button> button = new ArrayList<Button>();
        //Button One1 = new Button();
        Button One1 = new Button();
        Button One2 = new Button();
        Button One3 = new Button();
        Button One4 = new Button();
        Button One5 = new Button();
        Button One6 = new Button();

        button.add(One1);
        button.add(One2);
        button.add(One3);
        button.add(One4);
        button.add(One5);
        button.add(One6);

        //button.setText("yooo");
        for (int i = 0; i < button.size(); i++) {
            button.get(i).setText("BTN" + (i+1));
        }

        EventHandler<ActionEvent> btn1 = (ActionEvent ActionEvent) -> {
            //Do code here
            System.out.println("MouseEntered");
            for (int i = 0; i < PaneDefault.pane.size(); i++) {
                PaneDefault.pane.get(i).setVisible(false);
            }
            PaneDefault.pane.get(0).setVisible(true);
            //CreateButton.group.setScaleX(0.5);

        };
        button.get(0).setOnAction(btn1);

        EventHandler<ActionEvent> btn2 = (ActionEvent ActionEvent) -> {
            //Do code here
            System.out.println("MouseEntered");
            for (int i = 0; i < PaneDefault.pane.size(); i++) {
                PaneDefault.pane.get(i).setVisible(false);
            }
            PaneDefault.pane.get(1).setVisible(true);
            //CreateButton.group.setScaleX(0.5);

        };
        button.get(1).setOnAction(btn2);

        EventHandler<ActionEvent> btn3 = (ActionEvent ActionEvent) -> {
            //Do code here
            System.out.println("MouseEntered");
            for (int i = 0; i < PaneDefault.pane.size(); i++) {
                PaneDefault.pane.get(i).setVisible(false);
            }
            PaneDefault.pane.get(2).setVisible(true);
            //CreateButton.group.setScaleX(0.5);

        };
        button.get(2).setOnAction(btn3);

        EventHandler<ActionEvent> btn4 = (ActionEvent ActionEvent) -> {
            //Do code here
            System.out.println("MouseEntered");
            for (int i = 0; i < PaneDefault.pane.size(); i++) {
                PaneDefault.pane.get(i).setVisible(false);
            }
            PaneDefault.pane.get(3).setVisible(true);
            //CreateButton.group.setScaleX(0.5);

        };
        button.get(3).setOnAction(btn4);

        EventHandler<ActionEvent> btn5 = (ActionEvent ActionEvent) -> {
            //Do code here
            System.out.println("MouseEntered");
            for (int i = 0; i < PaneDefault.pane.size(); i++) {
                PaneDefault.pane.get(i).setVisible(false);
            }
            //PaneDefault.pane.get(4).setVisible(true);
            //CreateButton.group.setScaleX(0.5);

        };
        button.get(4).setOnAction(btn5);

        One1.setOnAction(btn1);
        VBox vbox1 = new VBox();
        VBox vbox2 = new VBox();
        VBox vbox3 = new VBox();
        VBox vbox4 = new VBox();

        vbox1.getChildren().addAll(One1);
        vbox2.getChildren().addAll(button.get(1), button.get(2));
        vbox3.getChildren().addAll(button.get(3));
        vbox4.getChildren().addAll(button.get(4));

        TitledPane pane1 = new TitledPane("VBOX 1", vbox1);
        TitledPane pane2 = new TitledPane("VBOX 2", vbox2);
        TitledPane pane3 = new TitledPane("VBOX 3", vbox3);
        TitledPane pane4 = new TitledPane("VBOX 4", vbox4);
        Accordion accordion = new Accordion();

        accordion.getPanes().add(pane1);
        accordion.getPanes().add(pane2);
        accordion.getPanes().add(pane3);
        accordion.getPanes().add(pane4);

        accordion.setMinWidth(220);
        accordion.setLayoutX(0);
        
        
        
        */
        
        
        
        
        //----------------------------------------------------------------------
        Pane pane = new Pane(PaneLeft.getPane());
        pane.setMinSize(220, 1000 - 200);
        //pane.setMaxSize(220, 1000 - 200);
        pane.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: red;");
        return pane;
    }
    
    static private Pane createPaneCenter() {
        Pane pane = new Pane();
        //pane.setMaxSize(220, 1000 - 200);
        pane.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: red;");
        return pane;
        
    }

    static private BorderPane createBorderPane() {
        BorderPane borderPane = new BorderPane();
        borderPane.setMinSize(1920, 1080);
        borderPane.setTop(createPaneTop());
        borderPane.setRight(createPaneRight());
        borderPane.setLeft(createPaneLeft());
        borderPane.setCenter(createPaneCenter());

        return borderPane;
    }

    public static StackPane getStackPane() {
        return stackPane;
    }
}
