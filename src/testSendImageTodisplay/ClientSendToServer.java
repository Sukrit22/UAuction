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
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**ClientSendToServer is a class that ..
 *
 * @author Sukrit22
 */
public class ClientSendToServer {
//======================= data field =============================


//======================= Constructor ============================

    public static void main(String[] args){
        Socket client;
        Scanner scn = new Scanner(System.in);
        while(true){
        try {
            client = new Socket("auctionoop.myddns.me", 1234);
            String name = scn.nextLine();
            ObjectOutputStream o =new ObjectOutputStream(client.getOutputStream());
            Image image = new Image("file:///"+System.getProperty("user.dir")+"/AuctionDataBase/Image/"+name+".jpg");
            //Im im = new Im(image);
            //o.writeObject(im);
            o.flush();
            o.close();
            //if(name.equals("exit"))
                //break;
            //BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"/AuctionDataBase/Image/"+name+".jpg"));
            //OutputStream os = client.getOutputStream();
            //ImageIO.write(image,"jpg", os);
            //os.flush();
           //os.close();
            client.close();
            System.out.println("update new image to server");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        }
    }

//================d======= method =================================



}
