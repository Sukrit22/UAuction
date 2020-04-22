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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class GreetingClient
{
    
    

    public static void main(String [] args)
    {
        String serverName = "localhost";
        int port = 6066;
        try
        {
            Socket client = new Socket(serverName, port);
            
           BufferedImage image;
           OutputStream os = client.getOutputStream();
           image = ImageIO.read(new File("C:/TestPic4.png"));
           ImageIO.write(image,"png", os);
           os.flush();
           os.close();
           
        } catch(Exception w) {
            w.printStackTrace();
        }
    }
}
