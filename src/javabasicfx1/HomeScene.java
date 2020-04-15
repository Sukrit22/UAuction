/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicfx1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Sitth
 */
public class HomeScene {

    static public Scene homeScene;
    private static BorderPane borderPaneLayor1;
    private static Pane paneBorderPaneLayor1;
    private static ScrollPane scrollPaneBorderPaneLayor1;
    private static MyButton btnLogIn;
    private static MyButton btnCreateAccount;
    private static MyButton btnHelp;
    private static VBox vboxForHboXBorderPane;
    private static HBox hboxForLogo;
    private static HBox hboxForBtn;
    private static StackPane timePane;
    private static TextField searchTextField;
    private static HBox hboxborderTopPane;
    private static HBox hboxForSearchTextField;
    private static StackPane stackPaneLoGoLayor1;
    private static StackPane stackPaneTextFieldPaneLayor1;
    private static StackPane stackPaneButtonPaneLayor1;

    public HomeScene() {
        System.out.println("HomeScene Init");
        homeScene();
        System.out.println("Yo Yo Yo");
    }

    public final void homeScene() {

        System.out.println("-----1-homeScene");
        borderPaneLayor1 = new BorderPane();
        paneBorderPaneLayor1 = new Pane();
        scrollPaneBorderPaneLayor1 = new ScrollPane();
        System.out.println("-----1-1-homeScene");
        btnLogIn = new MyButton("log In", 20, 1, 40);
        System.out.println("-----1-2-homeScene");
        btnCreateAccount = new MyButton("Create Account", 20, 1, 40);
        System.out.println("-----1-3-homeScene");
        btnHelp = new MyButton("Help", 20, 1, 40);
        System.out.println("-----1-4-homeScene");
        vboxForHboXBorderPane = new VBox();
        System.out.println("-----1-1-2-homeScene");
        hboxForLogo = new HBox(SetTextShape.setTextShape("LOGO", 50));
        hboxForBtn = new HBox();
        timePane = new StackPane();
        searchTextField = new TextField();
        hboxborderTopPane = new HBox();
        hboxForSearchTextField = new HBox(searchTextField);
        stackPaneLoGoLayor1 = new StackPane(hboxForLogo);
        stackPaneTextFieldPaneLayor1 = new StackPane(hboxForSearchTextField);
        stackPaneButtonPaneLayor1 = new StackPane(hboxForBtn);
        System.out.println("-----2-homeScene");
        ButtonEvent.buttonEventOnSceneUnLogIn();
        System.out.println("-----3-homeScene");
        //BorderPane Top

        //setTextShape( String text, int fontSize)        
        //MyButton(String text, int font, double sizeWidth, double sizeHeight)
        hboxForBtn.setSpacing(5);
        //Debug
        hboxForBtn.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: blue;");
        hboxForBtn.setPadding(new Insets(10, 10, 10, 10));

        timePane.setMaxHeight(40);
        timePane = SetTextShape.setTextShape("                            ", 1, 20, 40);
        timePane.setAlignment(Pos.TOP_CENTER);
        timePane.setMaxHeight(40);
        timePane.setMaxWidth(200);
        timePane.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: blue;");
        hboxForBtn.setAlignment(Pos.TOP_RIGHT);
        HBox.setHgrow(btnLogIn.getButton(), Priority.ALWAYS);
        HBox.setHgrow(btnCreateAccount.getButton(), Priority.ALWAYS);
        HBox.setHgrow(btnHelp.getButton(), Priority.ALWAYS);
        HBox.setHgrow(timePane, Priority.ALWAYS);
        timePane.setVisible(false);
        hboxForBtn.setMaxWidth(1920);
        //hboxForBtn.getChildren().addAll(btnLogIn.getButton(), MyButton.setAndGetBtnTime(MyButton.btnTime));
        //hboxForBtn.getChildren().addAll(btnLogIn.getButton(), btnCreateAccount.getButton(), btnHelp.getButton(), MyButton.setAndGetBtnTime(MyButton.btnTime));

        searchTextField.setMinSize(500, 40);
        searchTextField.setPromptText("I'm looking for...");

        hboxForSearchTextField.setPadding(new Insets(50, 10, 10, 10));
        hboxForSearchTextField.setAlignment(Pos.CENTER);
        hboxForSearchTextField.setMaxWidth(1920);
        //Debug
        hboxForSearchTextField.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: blue;");

        hboxborderTopPane.setSpacing(200);
        hboxborderTopPane.setPadding(new Insets(10, 10, 10, 10));
        hboxborderTopPane.setAlignment(Pos.CENTER);
        hboxborderTopPane.setMaxWidth(1920);
        hboxborderTopPane.setPrefWidth(1920);

        HBox.setHgrow(stackPaneButtonPaneLayor1, Priority.ALWAYS);
        HBox.setHgrow(stackPaneTextFieldPaneLayor1, Priority.ALWAYS);
        HBox.setHgrow(stackPaneLoGoLayor1, Priority.ALWAYS);

        hboxborderTopPane.getChildren().addAll(stackPaneLoGoLayor1, stackPaneButtonPaneLayor1);

        vboxForHboXBorderPane.setMaxWidth(1920);
        vboxForHboXBorderPane.setMinWidth(1920);
        vboxForHboXBorderPane.setPrefWidth(1920);
        vboxForHboXBorderPane.setAlignment(Pos.CENTER);
        vboxForHboXBorderPane.getChildren().addAll(hboxborderTopPane, stackPaneTextFieldPaneLayor1);
        //Debug
        paneBorderPaneLayor1.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: red;");
        paneBorderPaneLayor1.setMaxWidth(1920);
        paneBorderPaneLayor1.getChildren().add(vboxForHboXBorderPane);
        //BorderPane Top
        //BorderPane Center
        //BorderPane Top
        //BorderPane Top
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(1920);
        rectangle.setHeight(1080);
        scrollPaneBorderPaneLayor1.setContent(rectangle);
        //scrollPaneBorderPaneLayor1.setMinWidth(1920);
        scrollPaneBorderPaneLayor1.setMaxWidth(1920);
        //scrollPaneBorderPaneLayor1.setMinHeight(1080);
        borderPaneLayor1.setTop(paneBorderPaneLayor1);
        borderPaneLayor1.setRight(scrollPaneBorderPaneLayor1);
        System.out.println("-----4-homeScene");
        //homeScene = new Scene(borderPaneLayor1);

    }

    public static MyButton getBtnLogIn() {
        return btnLogIn;
    }

    public static MyButton getBtnCreateAccount() {
        return btnCreateAccount;
    }

    public static MyButton getBtnHelp() {
        return btnHelp;
    }

    public static Scene getHomeScene() {
        return homeScene;
    }

    public static BorderPane getBorderPaneLayor1() {
        return borderPaneLayor1;
    }

    public static Pane getPaneBorderPaneLayor1() {
        return paneBorderPaneLayor1;
    }

    public static ScrollPane getScrollPaneBorderPaneLayor1() {
        return scrollPaneBorderPaneLayor1;
    }

    public static VBox getVboxForHboXBorderPane() {
        return vboxForHboXBorderPane;
    }

    public static HBox getHboxForLogo() {
        return hboxForLogo;
    }

    public static HBox getHboxForBtn() {
        return hboxForBtn;
    }

    public static StackPane getTimePane() {
        return timePane;
    }

    public static TextField getSearchTextField() {
        return searchTextField;
    }

    public static HBox getHboxborderTopPane() {
        return hboxborderTopPane;
    }

    public static HBox getHboxForSearchTextField() {
        return hboxForSearchTextField;
    }

    public static StackPane getStackPaneLoGoLayor1() {
        return stackPaneLoGoLayor1;
    }

    public static StackPane getStackPaneTextFieldPaneLayor1() {
        return stackPaneTextFieldPaneLayor1;
    }

    public static StackPane getStackPaneButtonPaneLayor1() {
        return stackPaneButtonPaneLayor1;
    }

}
