/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Sitth
 */
public class Product {

    static private Rectangle a;
    static private Label label;
    static private Label labelID;
    static private Pane pane;
    static private Pane pane2;
    static private Pane pane3;
    static private Button delete;
    static public int x = 0;
    static public ArrayList<Product> productArray = new ArrayList<Product>();
    public static int y = 0;
    private int position = 0;
    public int id = 0;

    static public Pane product(String productName, String userName) {

        return pane;
    }

    public Product(String productName, String userName, boolean bool) {
        labelID = new Label("" + x);
        id = x;
        position = id;
        delete = new Button("Delete");
        delete.setLayoutX(350);
        EventHandler<ActionEvent> eh = (ActionEvent ActionEvent) -> {
            System.out.println("Delete " + id);
            //UserData.vboxArray.get(UserData.ID_UserThatLogIn).getChildren().remove(position - 1);
            //UserData.vboxArray.get(UserData.ID_UserThatLogIn).getChildren().get(id - 1).setDisable(true);
            CategorisePane.vbox1.getChildren().get(id-1).setDisable(true);
            //CategorisePane.vbox1.getChildren().remove(id-1);
            /*if(id-1>0)
            for(int i = id - 1 ; i<productArray.size(); i++){
            productArray.get(i).position -= 1;
            }*/
        };
        delete.setOnAction(eh);

        a = new Rectangle(150, 150);
        label = new Label(productName + x);

        label.setLayoutX(200);
        Label label2 = new Label(userName);
        label2.setLayoutX(200);
        label2.setLayoutY(100);
        pane = new Pane();
        pane.setMinHeight(200);
        if (bool) {
            pane.getChildren().addAll(a, label, label2, delete);
        } else {
            pane.getChildren().addAll(a, label, label2);
        }

    }

    public Pane getPane() {
        return pane;
    }

}
