/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testSendImageTodisplay;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;

/**WorkerThread is a class that ..
 *
 * @author Sukrit22
 */
public class WorkerThread implements Runnable {
    WorkerThread(){
        
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            serverSocket.setSoTimeout(180000);
            while(true) {
                Socket server = serverSocket.accept();
                BufferedImage pic = ImageIO.read(server.getInputStream());
                Image image = SwingFXUtils.toFXImage(pic, null);
                //Image im = new Image("file:///"+System.getProperty("user.dir")+"/AuctionDataBase/Image/bed_double.jpg");
                ServerReceiveAndDisplay.iv.setImage(image);
                System.out.println("update image from client");
            }
        } catch (SocketException ex) {
            Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//======================= data field =============================



//======================= Constructor ============================



//======================= method =================================



}
