/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
/**
 *
 * @author USER
 */
public class NewServer
{
ServerSocket server;
Socket client;

public NewServer()
{
    try
    {
        server = new ServerSocket(1234);
        System.out.println("Server Started..........");
        
            client = server.accept();
            System.out.println("Client connected....");
            new server(client);
            //client.close();
        
    }
    catch (Exception e)
    {
        System.out.println("Exception4 " + e);
    }
}
    public static void main(String arg[])
    {
        new NewServer();
        
        Thread updateThread = new Thread(new Update());
        updateThread.wait(3_600_000);
    }
}



 class server implements Runnable
{
    
    Socket client;
    public server(Socket client1)
    {
        client=client1;
        Thread trsend=new Thread(this);
        trsend.start();
    }
   
    public void run()
    {
         try
        {
           InputStreamReader isr = new InputStreamReader(client.getInputStream());
           ObjectOutputStream objectToClient = new ObjectOutputStream(client.getOutputStream());
           ObjectInputStream objectFromClient = new ObjectInputStream(client.getInputStream());
           PrintWriter stringToClient = new PrintWriter(client.getOutputStream(),true);
           BufferedReader fromClient = new BufferedReader(isr);
           
           while(true){
              String clientInput = fromClient.readLine();
              String[] keyword = clientInput.split("\\s+");
              for (int i = 0; i < keyword.length; i++) {
            keyword[i] = keyword[i].replaceAll("[^\\w]", ""); //replace " " with ""
        }
               System.out.println("Client : "+clientInput);
              if(keyword[0].matches("Login"))
              {
                 objectToClient.writeObject(Accountant.login(keyword[1],keyword[2]));
                 objectToClient.flush();
              }
              else if(keyword[0].matches("Register"))
              {
                 objectToClient.writeObject(Accountant.register(keyword[1],keyword[2]));
                 objectToClient.flush();
              }
              else if(keyword[0].matches("Account")){
                  
              }
              else if(keyword[0].matches("Market")){
                  
              }
              else if(keyword[0].matches("RegisterProduct")){
                  ImPr impr = (ImPr)objectFromClient.readObject();
                  ManageProduct.registerProduct(impr.getProduct());
                  
                  BufferedImage pic = ImageIO.read(client.getInputStream());
                                 
                  File file = new File(System.getProperty("user.dir")+"/AuctionDataBase/UserDataBase/"+impr.getProduct().getFileName()+".txt");
                  
              }
              else if(keyword[0].matches("LoadProduct")){
                  
              }
             else if(keyword[0].matches("Bid")){
                  
              }
              
           }
        }
        catch (Exception e)
        {
            System.out.println("Exception1 " + e);
        }
    }
}    




class Send implements Runnable
{
    Socket client;
    public Send(Socket client1)
    {
        client=client1;
        Thread trrecive=new Thread(this);
        trrecive.start();
    }
    public void run()
    {
        try {
            PrintWriter pw = new PrintWriter(client.getOutputStream(),true);
            pw.println();
        } catch (IOException ex) { }
        /*InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);*/
        try
        {
            
        }
        catch (Exception e)
        {
            System.out.println("Exception " + e);
        }
    }
}


class Update implements Runnable{
    //Constructor
    public Update(){
        
    }

    @Override
    public void run() {
        Date now = new Date();
        //Update ActiveProduct to AuctionedProduct every hour
        for (ActiveProduct object : Database.activeProduct) {
            if(object.getProduct().getDateEndBid().getTime() - now.getTime() < 0){
                Database.activeProduct.remove(object);
                Database.auctionedProduct.add(new AuctionedProduct(object, object.getCurrentBid(), now));
            }
        }
    }
    
    
}