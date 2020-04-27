/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene.Home;

import Scene.CategorisePane;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import uauction.NewClient;

/**
 *
 * @author Sitth
 */
public class Welcome {
    static public StackPane stp = new StackPane();
    
    static public void setup(){
        Font font = new Font(48);
        VBox vbox = new VBox();
        Text text = new Text("Welcome");
        Text text2 = new Text("Click To Continue");
        vbox.getChildren().addAll(text, text2);
        text.setFont(font);
        text2.setFont(font);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinSize(1920, 1080);
        vbox.setSpacing(50);
        Rectangle r = new Rectangle(1920,1080);
        r.setFill(new ImagePattern(new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/welcome2.png")));
        stp.getChildren().addAll(r);
        EventHandler<MouseEvent> eh = (MouseEvent ActionEvent) -> {
            System.out.println("Close Welcome");
            SceneHomeUnLogIn.getStackPane().getChildren().remove(Welcome.stp);
            NewClient.myViewSelected = 0;
        try {
            NewClient.reqMarket();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Fail reqMarket before login");
        }
        NewClient.showMarket(NewClient.myViewSelected);

            int i = 0;
            if (CategorisePane.vboxArray.get(i).getChildren().isEmpty()) {
                CategorisePane.vboxArray.get(i).getChildren().add(CategorisePane.pane1);
            }
            if (CategorisePane.vboxArray.get(i).getChildren().size() > 1) {
                if (CategorisePane.vboxArray.get(i).getChildren().get(0).equals(CategorisePane.pane1)) {
                    CategorisePane.vboxArray.get(i).getChildren().remove(CategorisePane.pane1);
                }
            }
            
        };        
                
        stp.setOnMouseClicked(eh);
        
        
    }
    
}
