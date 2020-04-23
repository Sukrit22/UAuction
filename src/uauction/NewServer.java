/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
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
public class NewServer {

    ServerSocket server;
    Socket client;

    public NewServer() {

        try {
            server = new ServerSocket(1234);
            System.out.println("Server Started..........");
            while (true) {
                client = server.accept();
                System.out.println("Client connected....");
                new server(client);
                //client.close();
            }

        } catch (Exception e) {
            System.out.println("Exception4 " + e);
        }
    }

    public static void main(String arg[]) throws InterruptedException {
        new NewServer();

        //Thread updateThread = new Thread(new Update());
        //updateThread.wait(3_600_000);
        //updateThread.notifyAll();
    }
}

class server implements Runnable {

    Socket client;

    public server(Socket client1) {
        client = client1;
        Thread trsend = new Thread(this);
        trsend.start();
    }

    public void run() {

        try {
            InputStreamReader isr = new InputStreamReader(client.getInputStream());
            BufferedReader fromClient = new BufferedReader(isr);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        boolean isClose = false;
        while (!isClose) {
            try {
                ObjectInputStream reqFromClient = new ObjectInputStream(client.getInputStream());
                String clientInput = (String) reqFromClient.readObject();
                //String clientInput = fromClient.readLine();
                String[] keyword = clientInput.split("\\s+");
                for (int i = 0; i < keyword.length; i++) {
                    keyword[i] = keyword[i].replaceAll("[^\\w]", ""); //replace " " with ""
                }
                System.out.println("Client : " + clientInput);
                if (keyword[0].matches("Login"))//done
                {
                    ObjectOutputStream objectToClient = new ObjectOutputStream(client.getOutputStream());
                    objectToClient.writeObject(Accountant.login(keyword[1], keyword[2])); //GGGG
                    objectToClient.flush();
                    objectToClient.close();
                    isClose = true;
                    reqFromClient.close();
                    client.close();
                    System.out.println("");
                } else if (keyword[0].matches("Register"))//done
                {
                    ObjectOutputStream objectToClient = new ObjectOutputStream(client.getOutputStream());
                    objectToClient.writeObject(Accountant.register(keyword[1], keyword[2]));
                    objectToClient.flush();
                    objectToClient.close();
                    isClose = true;
                    reqFromClient.close();
                    client.close();
                } else if (keyword[0].matches("Market"))//done
                {

                    ObjectOutputStream objectToClient = new ObjectOutputStream(client.getOutputStream());
                    objectToClient.writeObject(Database.activeProduct);
                    objectToClient.flush();
                    objectToClient.close();
                    isClose = true;
                    reqFromClient.close();
                    client.close();

                } else if (keyword[0].matches("Image"))//done
                {

                    File file = new File(System.getProperty("user.dir") + "/AuctionDataBase/Image/" + keyword[1]);
                    BufferedImage image = ImageIO.read(file);
                    OutputStream os = client.getOutputStream();
                    ImageIO.write(image, "jpg", os);
                    os.flush();
                    os.close();
                    isClose = true;
                    reqFromClient.close();
                    client.close();

                } else if (keyword[0].matches("RegisterProduct"))//done
                {
                    ServerSocket forImage = new ServerSocket(1235);
                    Object obj = reqFromClient.readObject();
                    Product product = (Product)obj;
                    reqFromClient.close();
                    client.close();
                    
                    Socket forImageSocket = forImage.accept();
                    BufferedImage bufIm = ImageIO.read(forImageSocket.getInputStream());
                    ManageProduct.registerProduct(product, bufIm);
                    

//                    ObjectInputStream objectFromClient = new ObjectInputStream(client.getInputStream());
//                    ImPr impr = (ImPr) objectFromClient.readObject();
//                    ManageProduct.registerProduct(impr.getProduct());
//                    ManageProduct.registerImage(impr.getImage(), impr.getProduct().getImageName());
//                    isClose = true;
//                    client.close();
                } else if (keyword[0].matches("LoadProduct")) {

                    ObjectOutputStream objectToClient = new ObjectOutputStream(client.getOutputStream());
                    OutputStream os = client.getOutputStream();
                    Product product = SaveAndLoad.loadProduct(keyword[1]);
                    objectToClient.writeObject(product);
                    objectToClient.flush();
                    objectToClient.close();
                    isClose = true;
                    reqFromClient.close();
                    client.close();

                } else if (keyword[0].matches("Bid")) {

                    int indexOfActiveProduct = Database.activeProduct.indexOf(keyword[1]);
                    Database.activeProduct.get(indexOfActiveProduct).setCurrentBid(Double.parseDouble(keyword[2]));
                    Database.activeProduct.get(indexOfActiveProduct).addBiddingHistory(keyword[3]);
                    //=========================== undone =======================
                    isClose = true;
                    reqFromClient.close();
                    client.close();
                }
            } catch (Exception e) {
                System.out.println("Exception1 " + e.getMessage());
            }
        }

    }
}

/*
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
        //InputStreamReader isr=new InputStreamReader(System.in);
        //BufferedReader br=new BufferedReader(isr);
        try
        {
            
        }
        catch (Exception e)
        {
            System.out.println("Exception " + e);
        }
    }
}
 */
class Update implements Runnable {

    //Constructor
    public Update() {

    }

    @Override
    public void run() {
        Date now = new Date();
        //Update ActiveProduct to AuctionedProduct every hour
        for (ActiveProduct object : Database.activeProduct) {
            if (object.getProduct().getDateEndBid().getTime() - now.getTime() < 0) {
                Database.activeProduct.remove(object);
                Database.auctionedProduct.add(new AuctionedProduct(object, object.getCurrentBid()));
            }
        }
    }

}
