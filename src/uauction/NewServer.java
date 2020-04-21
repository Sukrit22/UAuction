/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        server = new ServerSocket(1233);
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
           PrintWriter toClient = new PrintWriter(client.getOutputStream());
           BufferedReader fromClient = new BufferedReader(isr);
           
           while(true){
              String clientInput = fromClient.readLine();
               System.out.println("Client : "+clientInput);
              if(clientInput.matches("Login"))
              {
                  toClient.println("Loging in....");
              }
              if(clientInput.matches("Register"))
              {
                  toClient.println("Registering");
              }
              else{
                  toClient.println("Try again");
              }
              toClient.flush();
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
