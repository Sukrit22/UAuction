/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testSendImageTodisplay;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**ServerReceiveAndDisplay is a class that ..
 *
 * @author Sukrit22
 */
public class ServerReceiveAndDisplay extends Application {
//======================= data field =============================
private static ServerSocket serverSocket;
private static Socket server;
public static ImageView iv;
public static WorkerThread wt;

//======================= Constructor ============================

    public static void main(String[] args) throws IOException {
        
        launch(args);
        System.exit(0);
    }
//======================= method =================================

    @Override
    public void start(Stage stage) {
        //Image a = new Image(new File(""));
        iv = new ImageView(new Image("file:///"+System.getProperty("user.dir")+"/AuctionDataBase/Image/bed_double.jpg"));
        iv.setFitHeight(300);
        iv.setPreserveRatio(true);
        //iv.setSmooth(true);
        //iv.setCache(true);
        Group g = new Group();
        Pane p = new Pane(g);
        Scene s = new Scene(p);
        //s.setFill(Color.WHITE);
        g.getChildren().add(iv);
        stage.setResizable(true);
        stage.setScene(s);
        stage.show();
        
        wt = new WorkerThread();
        wt.run();
        
    }
}
