/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uauction;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**Server is a class that ..
 *
 * @author Sukrit22
 */
public class Server extends Application{
//======================= data field =============================
    
    ServerSocket ss;

//======================= Constructor ============================
public void openServer()
{
        try {
            ss = new ServerSocket(5555);
            Socket server = ss.accept();
            
        } catch (IOException ex) {
            
        }
}
   
public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5555) ;
        Socket server = ss.accept();
          
        
                
                
        
        
        System.out.println("Client coming....");
        
        
        InputStreamReader in = new InputStreamReader (server.getInputStream());
        BufferedReader reader = new BufferedReader(in);
        
        String client = reader.readLine();
        System.out.println("Client Said : " + client); 
        
        PrintStream writer = new PrintStream(server.getOutputStream(),true);
        writer.println("Server : "+  client+ "YOUR ASS!!!!");
        
        
    }

//======================= method =================================

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
