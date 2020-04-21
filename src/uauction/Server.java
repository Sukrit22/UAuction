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
public class Server {

    ServerSocket s;

    public void go() {

        try {
            s = new ServerSocket(1234);

            while (true) {

                Socket incoming = s.accept();
                Thread t = new Thread(new MyCon(incoming));
                t.start();
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    class MyCon implements Runnable {

        Socket incoming;

        public MyCon(Socket incoming) {

            this.incoming = incoming;
             System.out.println("Client conncted...");
        }

        @Override
        public void run() {
            try {
                
                InputStreamReader reader = new InputStreamReader(incoming.getInputStream());
                BufferedReader bfReader = new BufferedReader(reader);
                String clientReq = bfReader.readLine();
                
                if(clientReq.matches("Hello"))
                {
                    try{
                        
                        PrintWriter writer = new PrintWriter(incoming.getOutputStream(),true);
                        writer.println("Hello boy");
                    }catch(Exception e){}
                }
                
                
                
                
                
                
            } catch (IOException ex) {
                
            }
                

        }
    }
    public static void main(String[] args) {

        new Server().go();

    }
    }
        
 

