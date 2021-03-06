/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene.Home.MyAccount;

import Effect.PopUp;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author Sitth
 */
public class AddProduct {
    static public File filePath = null;
    static public boolean pathAdded;
    static private Text selectText = new Text();

    public static Text getSelectText() {
        return selectText;
    }
    static public VBox titleVbox = new VBox();
    static private Group titleGroup1;
    static private Group titleGroup2;
    static private Group titleGroup3;
    static private Group titleGroup4;
    static private Group titleGroup5;

    static public DatePicker datePicker;
    static public ComboBox comboBoxHour;
    static public ComboBox comboBoxAmPm;

    static public TextField productName;
    static public TextField startBid;
    static public TextField minimumBid;
    static public TextArea productDescription;
    static public Rectangle pic;
    
    static public Rectangle pic2;
    private static final Text fillText = new Text("Please check your information");
    public static Pane riri = new Pane(fillText);

    //static private Desktop desktop = Desktop.getDesktop();

    static public void makeAddProductPane() {
        title1();
        title2();
        title3();
        title4();
        title5();
        makeAllTextField();
        
        
        Font sad = new Font(48);
        fillText.setFont(sad);
        fillText.setFill(Color.web("rgba( 255, 0, 0, 1.0)"));
        datePicker = new DatePicker();
        datePicker.setLayoutX(900+300);
        datePicker.setLayoutY(50);
        datePicker.setMinSize(220, 40);
        datePicker.applyCss();
        datePicker.setValue(LocalDate.now());
        datePicker.setDayCellFactory(picker -> new DateCell() {
        public void updateItem(LocalDate date, boolean empty) {
            super.updateItem(date, empty);
            LocalDate today = LocalDate.now();

            setDisable(empty || date.compareTo(today) < 0 );
        }
    });
        datePicker.setOnAction(eh -> {
            if(datePicker.getValue().compareTo(LocalDate.now())<0){
                datePicker.setValue(LocalDate.now());
            }
        });
        //datePicker.setStyle("-fx-text-inner-color:black; -fx-background-radius:10; -fx-background-color:rgba( 125, 125, 125, 1.0); ");

        comboBoxHour = new ComboBox();
        comboBoxAmPm = new ComboBox();
        comboBoxHour.setPromptText("Hour");
        comboBoxHour.getItems().addAll("12", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11" );
        comboBoxHour.setMinSize(50, 40);
        comboBoxHour.setLayoutX(900+200+20+5+300);
        comboBoxHour.setLayoutY(50);
        comboBoxHour.applyCss();

        comboBoxAmPm = new ComboBox();
        comboBoxAmPm.getItems().addAll("A.M.", "P.M.");
        comboBoxAmPm.setValue("A.M");
        comboBoxAmPm.setMinSize(50, 40);
        comboBoxAmPm.setLayoutX(900+70+200+20+5+300);
        comboBoxAmPm.setLayoutY(50);
        comboBoxAmPm.applyCss();

        Button btnCheck = new Button("Check!");
        titleVbox.setLayoutX(900);
        titleVbox.setLayoutY(50);
        titleVbox.getChildren().addAll(titleGroup1);

        EventHandler<ActionEvent> btnCheckEV = (ActionEvent ActionEvent) -> {
            System.out.println("btnCheck " + selectText.getText());

        };
        btnCheck.setOnAction(btnCheckEV);

        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");

        EventHandler<MouseEvent> addpicEV = (MouseEvent ActionEvent) -> {
            System.out.println("btnCheck " + selectText.getText());
            Stage stage = new Stage();
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                if (file.getPath().substring(file.getPath().length()-4, file.getPath().length()).equals(".jpg")) {
                    if (file.exists() && !file.isDirectory()) {
                        filePath = file;
                        pathAdded = false;
                        PopUp.chooseNewPicPane.setVisible(false);
                        try {
                            pic.setFill(new ImagePattern(SwingFXUtils.toFXImage(ImageIO.read(file), null)));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                            System.out.println("fail from AddProduct pic.setFill");
                        }
                    }
                    System.out.println(file.toString());
                } else {
                    PopUp.chooseNewPicPane.setVisible(true);
                }
            }

        };
        pic.setLayoutX(40);
        pic.setLayoutY(40);
        pic.setOnMouseClicked(addpicEV);

        EventHandler<MouseEvent> evTitle1 = (MouseEvent ActionEvent) -> {
            if (titleVbox.getChildren().size() == 1) {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
            } else {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }

                titleVbox.getChildren().addAll(titleGroup1);
            }

        };
        titleGroup1.setOnMouseClicked(evTitle1);

        EventHandler<MouseEvent> evTitle2 = (MouseEvent ActionEvent) -> {
            if (titleVbox.getChildren().size() == 1) {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
            } else {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                selectText.setText("Electronic");
                titleVbox.getChildren().addAll(titleGroup1);
            }

        };
        titleGroup2.setOnMouseClicked(evTitle2);

        EventHandler<MouseEvent> evTitle3 = (MouseEvent ActionEvent) -> {
            if (titleVbox.getChildren().size() == 1) {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
            } else {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                selectText.setText("Health & Beauty");
                titleVbox.getChildren().addAll(titleGroup1);
            }

        };
        titleGroup3.setOnMouseClicked(evTitle3);

        EventHandler<MouseEvent> evTitle4 = (MouseEvent ActionEvent) -> {
            if (titleVbox.getChildren().size() == 1) {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
            } else {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                selectText.setText("Home & Lifestyle");
                titleVbox.getChildren().addAll(titleGroup1);
            }

        };
        titleGroup4.setOnMouseClicked(evTitle4);

        EventHandler<MouseEvent> evTitle5 = (MouseEvent ActionEvent) -> {
            if (titleVbox.getChildren().size() == 1) {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                titleVbox.getChildren().addAll(titleGroup1, titleGroup2, titleGroup3, titleGroup4, titleGroup5);
            } else {
                for (int i = titleVbox.getChildren().size() - 1; i > -1; i--) {
                    titleVbox.getChildren().remove(i);
                }
                selectText.setText("Others");
                titleVbox.getChildren().addAll(titleGroup1);
            }

        };
        titleGroup5.setOnMouseClicked(evTitle5);
    }

    static private void title1() {
        Rectangle rect = new Rectangle(220, 40);
        rect.setFill(Color.web("rgba( 255, 255, 255, 1.0)"));
        rect.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        selectText = new Text("Select Categorise");
        selectText.setLayoutX(0);
        selectText.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(220, 40);
        pane.getChildren().add(selectText);
        pane.setLayoutX(0);
        //pane.setLayoutX(1920 - 400 - 150);
        selectText.applyCss();
        titleGroup1 = new Group(rect, pane);
    }

    static private void title2() {
        Rectangle rect = new Rectangle(220, 40);
        rect.setFill(Color.web("rgba( 125, 125, 125, 1.0)"));
        rect.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        Text logIn = new Text("Electronic");
        logIn.setLayoutX(0);
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);
        pane.setLayoutX(0);
        //pane.setLayoutX(1920 - 400 - 150);
        logIn.applyCss();
        titleGroup2 = new Group(rect, pane);
    }

    static private void title3() {
        Rectangle rect = new Rectangle(220, 40);
        rect.setFill(Color.web("rgba( 125, 125, 125, 1.0)"));
        rect.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        Text logIn = new Text("Health & Beauty");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);
        pane.setLayoutX(0);
        logIn.applyCss();
        titleGroup3 = new Group(rect, pane);
    }

    static private void title4() {
        Rectangle rect = new Rectangle(220, 40);
        rect.setFill(Color.web("rgba( 125, 125, 125, 1.0)"));
        rect.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        Text logIn = new Text("Home & Lifestyle");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);
        pane.setLayoutX(0);
        logIn.applyCss();
        titleGroup4 = new Group(rect, pane);
    }

    static private void title5() {
        Rectangle rect = new Rectangle(220, 40);
        rect.setFill(Color.web("rgba( 125, 125, 125, 1.0)"));
        rect.setStyle("-fx-stroke:rgba( 10, 10, 10, 0.2)");
        Font font = new Font(18);
        Text logIn = new Text("Others");
        logIn.setFont(font);
        StackPane pane = new StackPane();
        pane.setMinSize(220, 40);
        pane.getChildren().add(logIn);
        pane.setLayoutX(0);
        logIn.applyCss();
        titleGroup5 = new Group(rect, pane);
    }

    static private void makeAllTextField() {

        productName = new TextField();
        productName.setPromptText("Name");
        productName.setMinHeight(40);
        productName.setMinWidth(220);
        productName.setLayoutX(600);
        productName.setLayoutY(50);
        productName.applyCss();
        productName.setPromptText("Product's Name");

        //productName.setStyle("-fx-text-inner-color: red; -fx-background-radius:10; -fx-background-color:rgba( 125, 125, 125, 1.0); ");
        startBid = new TextField();
        startBid.setPromptText("Start Bid");
        startBid.setMinHeight(40);
        startBid.setMinWidth(220);
        startBid.setLayoutX(600);
        startBid.setLayoutY(130);
        startBid.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            startBid.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }
}
);

        minimumBid = new TextField();
        minimumBid.setPromptText("Minimun Bid");
        minimumBid.setMinHeight(40);
        minimumBid.setMinWidth(220);
        minimumBid.setLayoutX(900);
        minimumBid.setLayoutY(130);
        minimumBid.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    minimumBid.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        }
        );

        productDescription = new TextArea();
        productDescription.setPromptText("Description");
        productDescription.setLayoutX(600);
        productDescription.setLayoutY(130+80);
        productDescription.setMinSize(550, 200);
        productDescription.setScrollTop(0);
        productDescription.setScrollLeft(0);
        productDescription.setPrefRowCount(5);
        //productDescription

        pic = new Rectangle(500, 375);
        pic.setFill(new ImagePattern(new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/upload2.png")));

    }
}
