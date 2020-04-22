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
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GreetingServer extends Thread
{
       private ServerSocket serverSocket;
       Socket server;

       public GreetingServer(int port) throws IOException, SQLException, ClassNotFoundException, Exception
       {
          serverSocket = new ServerSocket(port);
          serverSocket.setSoTimeout(180000);
       }

       public void run()
       {
           while(true)
          { 
               try
               {
                  server = serverSocket.accept();
                  //BufferedImage img = ImageIO.read(ImageIO.createImageInputStream(server.getInputStream()));
                  BufferedImage pic = ImageIO.read(server.getInputStream());
                  InputStreamReader reader = new InputStreamReader(server.getInputStream()) ;
                  BufferedReader br = new BufferedReader(reader);
                  
                  File file = new File("C:/TestPic3.jpg");
                  
        try {
            
            ImageIO.write(pic,"jpg",file);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
              }
             catch(SocketTimeoutException st)
             {
                   System.out.println("Socket timed out!");
                  break;
             }
             catch(IOException e)
             {
                  e.printStackTrace();
                  break;
             }
             catch(Exception ex)
            {
                  System.out.println(ex);
            }
          }
       }

       public static void main(String [] args) throws IOException, SQLException, ClassNotFoundException, Exception
       {
              Thread t = new GreetingServer(6066);
              t.start();
       }
}
