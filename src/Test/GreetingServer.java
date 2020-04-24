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
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import uauction.ManageProduct;
import uauction.Product;
import uauction.SaveAndLoad;

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
       //  while(true)
       //{ 
               try
               { server = serverSocket.accept();

                  //-------------------------------------------------------------------
                  //BufferedImage pic = ImageIO.read(server.getInputStream());
                  //File file = new File("C:/TestPic25.jpg");
                  //--------------------------------------------------------------------
                  //InputStreamReader isr = new InputStreamReader(server.getInputStream());
                  //BufferedReader reader = new BufferedReader(isr);
                   //System.out.println(reader.readLine());
                  
                  
                   ObjectInputStream gg = new ObjectInputStream(server.getInputStream());
                   
                    ArrayList<Product> p = (ArrayList<Product>)gg.readObject();
                    
                    gg.close();
                    System.out.println("recieved arrayList...");
                    
                    for(Product a : p)
                    {
                        System.out.println(a.getName());
                    }
//                   InputStream is = server.getInputStream();
//                   BufferedImage bi = ImageIO.read(is);
//
//                   ManageProduct.registerProduct(p, bi);
//                   SaveAndLoad.saveProduct(p);
              //String clientInput = fromClient.readLine();
//              String[] keyword = clientInput.split("\\s+");
//              for (int i = 0; i < keyword.length; i++) {
//            keyword[i] = keyword[i].replaceAll("[^\\w]", ""); //replace " " with ""
//        }
//               System.out.println("Client : "+clientInput);
//                   //System.out.println("Client : " + (String)os.readObject() );
//                   
//                   
//                   
//                   System.out.println(keyword[0]);
//                   System.out.println(keyword[1]);
//                   System.out.println(keyword[2]);
//                   
//                   if(keyword[0].matches("Register"))
//                   {
//                       System.out.println("wtf");
//                   }
                   //BufferedImage bf =  ImageIO.read(new File("C:/TestPic9.jpg"));
                       
      /*            try {
            
                           //ImageIO.write(pic,"jpg",file);
                         //ImageIO.write(bf,"jpg", os);
                         //os.flush();
                } catch (IOException ex) {
            System.out.println(ex.toString());
        }*/
                  
                  /*BufferedImage image;
                  ImageInputStream os = (ImageInputStream) server.getInputStream();
                  image = ImageIO.read(os);*/
                  
                 
                 
                  
                  
                  
                  
        
              }
             catch(SocketTimeoutException st)
             {
                   System.out.println("Socket timed out!");
                 
             }
             catch(IOException e)
             {
                  e.printStackTrace();
                 
             }
             catch(Exception ex)
            {
                  System.out.println(ex);
            }
          //}
       }

       public static void main(String [] args) throws IOException, SQLException, ClassNotFoundException, Exception
       {
              Thread t = new GreetingServer(6066);
              t.start();
       }
}
