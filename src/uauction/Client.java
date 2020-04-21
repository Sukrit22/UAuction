/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uauction;
import javafx.application.Application;
import javafx.stage.Stage;
import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**Client is a class that ..
 *
 * @author Sukrit22
 */
public class Client extends Application {



    public static void main(String[] args) throws Exception {
        //start program here
        //in order of loading all local data and open the gui then request the data from server
        //that point on this program is gonna be event driven program, means we put action on ButtonEvent.java
        
       
        Socket s = new Socket("localhost", 1234 );
        String client = "";
        String server = null;
        //Request
        while(!client.matches("bye")){
        Scanner input = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(s.getOutputStream(),true);
        client = input.nextLine();
        writer.println(client);
        
        //Receive
        
        InputStreamReader reader = new InputStreamReader(s.getInputStream());
        BufferedReader bfReader = new BufferedReader(reader);
        server = bfReader.readLine();
            System.out.println("Server said : " +server);
        }
        //start gui
        
        
    }

//======================= method =================================

    @Override
    public void start(Stage stage) throws Exception {
        //start gui in here
    }



}
