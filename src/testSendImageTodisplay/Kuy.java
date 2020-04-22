/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testSendImageTodisplay;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**Kuy is a class that ..
 *
 * @author Sukrit22
 */
public class Kuy extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Image im = new Image("file:///"+System.getProperty("user.dir")+"/AuctionDataBase/Image/bed_double.jpg");
        ImageView iv = new ImageView(im);
        Pane p = new Pane(iv);
        Scene s = new Scene(p);
        stage.setScene(s);
        stage.show();
    }
//======================= data field =============================



//======================= Constructor ============================

    public static void main(String[] args) {
        launch(args);
    }

//======================= method =================================



}
