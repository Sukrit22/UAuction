/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author USER
 */
import java.awt.AWTException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.ImageIcon;
import uauction.ManageProduct;
import uauction.Product;
import uauction.SaveAndLoad;
import uauction.User;

public class GreetingClient
{
    
    

    public static void main(String [] args)
    {
        String serverName = "localhost";
        int port = 6066;
        try
        {
            Socket client = new Socket(serverName, port);
            //OutputStream os = client.getOutputStream();
             //ObjectOutputStream toServer = new ObjectOutputStream(client.getOutputStream());
            
            
            Product p = new Product("bean1","nothing","bomb",20.0,10.0,new Date());
            Product p2 = new Product("bean2","nothing","bomb",20.0,10.0,new Date());
            Product p3 = new Product("bean3","nothing","bomb",20.0,10.0,new Date());
           // ManageProduct.registerProduct(p, ImageIO.read(new File("C:/TestPic7.jpg")));
           // SaveAndLoad.saveProduct(p);
           
          ArrayList<Product> alp = new ArrayList<>();
          alp.add(p);
          alp.add(p2);
          alp.add(p3);
           //ImageOutputStream os = new ImageOutputStream(client.getOutputStream());
           ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
           oos.writeObject(alp); 
           oos.flush();
           oos.close();
           
           
//           OutputStream os = client.getOutputStream();
//           ImageIO.write(ImageIO.read(new File("C:/TestPic7.jpg")), "jpg", os);
//           BufferedImage image = ImageIO.read(new File("C:/TestPic4.jpg"));
//           ImageIO.write(image,"jpg", os);
//             
//           os.flush();
           //ObjectOutputStream os2 = new ObjectOutputStream(client.getOutputStream());
           //os2.writeObject(new String("Hi")); 
          // os2.flush();
           
           //os.close();
           
            
        } catch(Exception w) {
            w.printStackTrace();
        }
        
    }
}
