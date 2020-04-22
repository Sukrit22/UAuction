/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

/**
 *
 * @author USER
 */
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class NewClient 
{
    
    static Socket server;
    
    
    public static void main(String[] args) throws Exception {
        server = new Socket("171.6.209.126",1233);
        while(true)
    {
       
        Scanner input = new Scanner(System.in);
        PrintWriter toServer = new PrintWriter(server.getOutputStream(),true);
        InputStreamReader isr = new InputStreamReader(server.getInputStream());
        BufferedReader fromServer = new BufferedReader(isr);
        
        toServer.println(input.nextLine());
        
        String rtnFromServer = fromServer.readLine();
        System.out.println("Server : "+rtnFromServer);
    }
    }
    
    public static Object reqLogin(String username,String password) throws IOException, ClassNotFoundException
    {
        ObjectOutputStream toServer = new ObjectOutputStream(server.getOutputStream());
        toServer.writeObject(new String("Login" + " " + username + " " + password));
        //PrintWriter toServer = new PrintWriter(server.getOutputStream(),true);
        //toServer.println("Login"+" "+username+" "+password);
        
        ObjectInputStream fromServer = new ObjectInputStream(server.getInputStream());
        User user = (User)fromServer.readObject();
        return user;
    }
    
    public static Object reqRegister(String username,String password) throws IOException, ClassNotFoundException
    {
        ObjectOutputStream toServer = new ObjectOutputStream(server.getOutputStream());
        toServer.writeObject(new String("Register" + " " + username + " " + password));
        toServer.flush();
        toServer.close();
        
        ObjectInputStream fromServer = new ObjectInputStream(server.getInputStream());
        User user = (User)fromServer.readObject();
        return user;
    }
    public static void reqRegisterProduct (Product product,BufferedImage image) throws IOException
    {
        ImPr impr = new ImPr(product,image);
        
        ObjectOutputStream toServer = new ObjectOutputStream(server.getOutputStream());
        toServer.writeObject(new String("RegisterProduct"+" "));
        toServer.flush();
        toServer.writeObject(impr);
        toServer.flush();
        toServer.close();
    }
}
/*public class NewClient extends Application
{
    OutputStreamWriter osw = null;
    
    InputStreamReader isr = null;
   


    @Override
    public void start(Stage stage) throws Exception {
       BorderPane paneForText = new BorderPane();
       paneForText.setPadding(new Insets(5,5,5,5));
       paneForText.setLeft(new Label("Enter somthing : "));
        
       TextField tf = new TextField();
       tf.setAlignment(Pos.BOTTOM_RIGHT);
       paneForText.setCenter(tf);
       
       BorderPane mainPane = new BorderPane();
       TextArea ta = new TextArea();
       mainPane.setCenter(new ScrollPane(ta));
       mainPane.setTop(paneForText);
        
       
       Scene scene = new Scene(mainPane,450,200);
       Stage primaryStage = new Stage();
       primaryStage.setTitle("Client");
       primaryStage.setScene(scene);
       primaryStage.show();
       
       Socket server = new Socket("localhost",1234);
       osw = new OutputStreamWriter(server.getOutputStream());
       isr = new InputStreamReader(server.getInputStream());
       BufferedWriter toServer = new BufferedWriter(osw);
        BufferedReader fromServer = new BufferedReader(isr);
       tf.setOnAction(e->{
           
           try {
               String output = tf.getText().trim();
               toServer.write(output);
               toServer.flush();
               
               String input = fromServer.readLine();
               ta.appendText("Server : " + input);
               
           } catch (IOException ex) {
              
           }
       });
       
    }
    public static void main(String arg[])
{
    launch(arg);

}
}
*/



