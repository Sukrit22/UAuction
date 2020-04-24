
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class JavaApplication15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
        
        Socket client = new Socket("auctionoop.myddns.me",1234);
        
        
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        String serverMessage = ois.readObject().toString();
        
        System.out.println(serverMessage);
        
    }
    
}
