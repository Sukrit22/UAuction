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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
public class HomeSceneUnLogIn {

    private static final int MAX_SCREEN_WIDHT = 1920;
    
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
    

    public HomeSceneUnLogIn() {
        System.out.println("-----1-HomeSceneLogOut");
        homeSceneLogOut();
    }

    static public void homeSceneLogOut() {

        //Set Button Event In This Scene
        System.out.println("-----2-HomeSceneLogOut");
        ButtonEvent.buttonEvenOnSceneAlreadyLogIn();
        System.out.println("-----3-HomeSceneLogOut");
        
        StackPane pane = new StackPane();
        Image image = new Image("file:///" + System.getProperty("user.dir") + "/src/javabasicfx1/Resuorce/backGround.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(60);
        //imageView.setClip(SetTextShape.setTextShape("LOGO", 50));
        pane.getChildren().add(imageView);

        

        //-----------------------------
        
//-----Top Border Elements-----
       btnLogIn = new MyButton("Log In", 20, 1, 40);
        btnCreateAccount = new MyButton("Create Account", 20, 1, 40);
        btnHelp = new MyButton("Help", 20, 1, 40);
        vboxForHboXBorderPane = new VBox();
        hboxForLogo = new HBox(pane);
        hboxForBtn = new HBox();
        timePane = new StackPane();
        searchTextField = new TextField();
        hboxborderTopPane = new HBox();

        //hboxForSearchTextField = new HBox(/*searchTextField*/);
        
        stackPaneLoGoLayor1 = new StackPane(hboxForLogo);
        stackPaneTextFieldPaneLayor1 = new StackPane(searchTextField);
        stackPaneButtonPaneLayor1 = new StackPane(hboxForBtn);
        
        //BorderPane Top

        //setTextShape( String text, int fontSize)        
        //MyButton(String text, int font, double sizeWidth, double sizeHeight)
/*        hboxForBtn.setSpacing(5);
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
        System.out.println("-----Log Out");
        HBox.setHgrow(btnHelp.getButton(), Priority.ALWAYS);
        System.out.println("-----Log Out");
        HBox.setHgrow(timePane, Priority.ALWAYS);
        timePane.setVisible(false);
        hboxForBtn.setMaxWidth(1920);
        System.out.println("-----Log Out");
        hboxForBtn.getChildren().addAll(btnLogIn.getButton(), btnCreateAccount.getButton(), btnHelp.getButton(), MyButton.setAndGetBtnTime(MyButton.btnTime1));
        //hboxForBtn.getChildren().addAll(btnMyAccount.getButton(), btnLogOut.getButton(), btnHelp.getButton());
        //hboxForBtn.getChildren().addAll(btnMyAccount.getButton(), btnLogOut.getButton());
        System.out.println("-----Log Out YO");

        searchTextField.setMinSize(500, 40);
        searchTextField.setPromptText("I'm looking for...");

        hboxForSearchTextField.setPadding(new Insets(50, 10, 10, 10));
        hboxForSearchTextField.setAlignment(Pos.CENTER);
        hboxForSearchTextField.setMaxWidth(1920);
        //Debug
        hboxForSearchTextField.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: blue;");

        hboxborderTopPane.setSpacing(20);
        hboxborderTopPane.setPadding(new Insets(10, 10, 10, 10));
        hboxborderTopPane.setAlignment(Pos.CENTER);
        hboxborderTopPane.setMaxWidth(1920);
        hboxborderTopPane.setPrefWidth(1920);

        HBox.setHgrow(stackPaneButtonPaneLayor1, Priority.ALWAYS);
        HBox.setHgrow(stackPaneTextFieldPaneLayor1, Priority.ALWAYS);
        HBox.setHgrow(stackPaneLoGoLayor1, Priority.ALWAYS);

        hboxborderTopPane.getChildren().addAll(stackPaneLoGoLayor1, stackPaneTextFieldPaneLayor1, stackPaneButtonPaneLayor1);

        vboxForHboXBorderPane.setMaxWidth(1920);
        vboxForHboXBorderPane.setMinWidth(1920);
        vboxForHboXBorderPane.setPrefWidth(1920);
        vboxForHboXBorderPane.setAlignment(Pos.CENTER);
        vboxForHboXBorderPane.getChildren().addAll(hboxborderTopPane);
        //Debug
        stackPaneLoGoLayor1.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: Green;");
        hboxborderTopPane.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: orange;");
        stackPaneTextFieldPaneLayor1.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: pink;");
        vboxForHboXBorderPane.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: black;");
        //Debug
        
        //BorderPane Top
        //BorderPane Center
        //BorderPane Top
        //BorderPane Top
*/
        System.out.println("-----3-HomeSceneLogOut");
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(1920);
        rectangle.setHeight(1080);
        //scrollPaneBorderPaneLayor1.setMinWidth(1920);
        //scrollPaneBorderPaneLayor1.setMinHeight(1080);
        
        

        //-----Main Top Pane Elements----- 
        paneBorderPaneLayor1 = new Pane();
        paneBorderPaneLayor1.setMaxWidth(MAX_SCREEN_WIDHT);
        //++++
        paneBorderPaneLayor1.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: red;");        
        
        //paneBorderPaneLayor1.getChildren().add(vboxForHboXBorderPane);

        //-----Main Center Pane Elements----- 
        scrollPaneBorderPaneLayor1 = new ScrollPane();
        scrollPaneBorderPaneLayor1.setMaxWidth(MAX_SCREEN_WIDHT);
        //++++
        scrollPaneBorderPaneLayor1.setContent(rectangle);

        
        //-----Main Scene Pane Elements-----    
        borderPaneLayor1 = new BorderPane();
        borderPaneLayor1.setMaxWidth(MAX_SCREEN_WIDHT);
        
        //----Important----\\
        borderPaneLayor1.setTop(paneBorderPaneLayor1);
        borderPaneLayor1.setRight(scrollPaneBorderPaneLayor1);
        //----Important----\\
        System.out.println("-----5-HomeSceneLogOut");
    }

    public static MyButton getBtnLogIn() {
        return btnLogIn;
    }

    public static MyButton getLogOut() {
        return btnCreateAccount;
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
