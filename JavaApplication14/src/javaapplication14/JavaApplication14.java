/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;

/**
 *
 * @author USER
 */
public class JavaApplication14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("auctionoop.myddns.me",1234);
        
      /* ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject("Hello game");
        System.out.println("String send...");
        
        
        //ObjectOutputStream oos2 = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(new test("BEAN","20"));
        System.out.println("Object send...");
       oos.flush();
       oos.close();
        */
        
        OutputStream os = socket.getOutputStream();
        File file = new File("C:/TestPic7.jpg");
        BufferedImage image = ImageIO.read(file);
               
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", byteArrayOutputStream);

        byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
        os.write(size);
        os.write(byteArrayOutputStream.toByteArray());
        os.flush();
        //Thread.sleep(120000);
        os.close();
        
    }
    
}
class test implements Serializable
{
    String name = null;
    String age = null;
    test(String name ,String age)
    {
        this.name = name;
        this.age = age;
    }
}
