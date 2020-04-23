/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene.Home;

import static AuctionMain.ButtonEvent.buttonEventForSceneHomeUnLogIn;
import AuctionMain.CreateTextField;
import Scene.CategorisePane;
import Scene.Home.PaneLeft;
import Scene.Home.MyAccount.PaneMyAccount;
import Scene.Home.PaneTop;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 *
 * @author Sitth
 */
public class SceneHomeUnLogIn {

    private static final StackPane stackPane = new StackPane();
    private static final Scene scene = new Scene(stackPane);
    public static ScrollPane scrollPane;

    static public void sceneHomeUnLogIn() {
        CreateTextField.searchField();
        CreateTextField.createEmailField();
        CreateTextField.createPasswordField();
        CreateTextField.createPasswordCField();
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
        pane.setStyle("-fx-background-color:rgba( 88, 88, 88, 1.0)");
        pane.setMinSize(1920, 200);

        return pane;
    }

    static private ScrollPane createPaneRight() {

        //PaneRight.setUp();
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color:rgba(100,100,100,1.0);");
        pane.setMinSize(1920 - 220, 1080 - 200);
        for (int i = 0; i < CategorisePane.paneArray.size(); i++) {
            pane.getChildren().add(CategorisePane.paneArray.get(i));
            CategorisePane.paneArray.get(i).setVisible(false);
        }
        CategorisePane.paneArray.get(0).setVisible(true);
        //CategorisePane.vboxArray.get(0).getChildren().addAll(itemText, titleText, priceText, timeLeftText);
        scrollPane = new ScrollPane(pane);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setMinSize(1700, 1000 - 200);
        //scrollPane.setStyle("-fx-focus-color:rgba( 2, 2, 2, 1.0); -fx-text-fill:rgba( 255, 0, 0, 1.0); -fx-faint-focus-color:rgba( 0, 255, 0, 0.0) ; -fx-inner-border:rgba( 255, 0, 0, 1.0); -fx-body-color:rgba( 255, 255, 255, 1.0); -fx-font-size: 20px;");
        //scrollPane.setStyle("-fx-focus-color:rgba( 2, 2, 2, 1.0); -fx-faint-focus-color:rgba( 2, 2, 2, 1.0); -fx-body-color:rgba(88,88,88,1.0);");
        scrollPane.setStyle("-fx-focus-color:rgba( 2, 2, 2, 1.0);"); 
        //-fx-stroke:rgba( 10, 10, 10, 0.2); -fx-inner-border:rgba( 0, 0, 0, 1.0); -fx-border:rgba( 255, 0, 0, 1.0);
        return scrollPane;
    }

    static private Pane createPaneLeft() {
        //----------------------------------------------------------------------
        PaneLeft.setUp();
        Pane pane = new Pane(PaneLeft.getPane());
        pane.setMinSize(220, 1000 - 200);
        //pane.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: red;");
        pane.setStyle("-fx-background-color:rgba(88,88,88,1.0);");
        return pane;
    }

    static private BorderPane createBorderPane() {
        BorderPane borderPane = new BorderPane();
        borderPane.setMinSize(1920, 1080);
        borderPane.setTop(createPaneTop());
        borderPane.setRight(createPaneRight());
        borderPane.setLeft(createPaneLeft());

        return borderPane;
    }

    public static StackPane getStackPane() {
        return stackPane;
    }
}
