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
/**Client is a class that ..
 *
 * @author Sukrit22hello
 * 
 */
public class Client{

//======================= data field =============================



//======================= Constructor ============================
    
public static void main(String[] args)throws Exception {
    
     Socket client = new Socket("localhost",5555);
    
     String text;
     Scanner input = new Scanner(System.in);
     text = input.nextLine();
     
     PrintStream writer = new PrintStream(client.getOutputStream(),true);
     writer.println(text);
     
    
     InputStreamReader in = new InputStreamReader(client.getInputStream());
     BufferedReader reader = new BufferedReader(in);
     String server = reader.readLine();
     System.out.println(server);
     
    }

//======================= method =================================

   
}
