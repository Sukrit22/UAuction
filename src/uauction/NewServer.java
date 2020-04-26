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
import java.nio.ByteBuffer;
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
    public static Date previousDate;
    ServerSocket server;
    ServerSocket serverImage;
    Socket client;
    Socket imageClient;
    public static BufferedImage myImage;

    public NewServer() {

        try {
            //        try {
            server = new ServerSocket(1234);
        } catch (IOException ex) {
                System.out.println(ex.getMessage());
        }
            System.out.println("Server Started..........");
            while (true) {
            try {
                client = server.accept();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
                System.out.println("Client connected....");
//                go();
                new server(client);
                //client.close();
                //Date millis compare toupdate;
                if((new Date()).getTime()-previousDate.getTime()>=15000){
                    previousDate = new Date();
                    //do update Task
                    Database.save();
                    Database.activeProduct.forEach(a -> {
                        if (a.getProduct().getDateEndBid().getTime() - previousDate.getTime() < 0) {
                            Database.auctionedProduct.add(new AuctionedProduct(a));
                            Database.activeProduct.remove(a);
                        }

                    });
                    System.out.println("update Done");
                }
            }

//        } catch (Exception e) {
//            System.out.println("Exception4 " + e);
//        }
    }

    public static void main(String arg[]) throws InterruptedException {
        previousDate = new Date();
        if(Database.load()){
            Database.save();
            Database.load();
        }
        
        new NewServer();

        //Thread updateThread = new Thread(new Update());
        //updateThread.wait(3_600_000);
        //updateThread.notifyAll();
    }
}

class imageServer implements Runnable {

    Socket client;

    public imageServer(Socket client) {
        this.client = client;
        Thread trsend = new Thread(this);
        trsend.start();
    }

    @Override
    public void run() {
        //OutputStream os = client.getOutputStream();

    }
}

class server implements Runnable {

    Socket client;

    public server(Socket client1) {
        client = client1;
        Thread trsend = new Thread(this);
        System.out.println("newThread");
        trsend.start();
    }

    public void run() {
//    void go(){
//        try {
//            InputStreamReader isr = new InputStreamReader(client.getInputStream());
//            BufferedReader fromClient = new BufferedReader(isr);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println("outside");
//        }
        boolean isClose = false;
        //while (!isClose) {
        //try {
        ObjectInputStream reqFromClient = null;
        try {
            reqFromClient = new ObjectInputStream(client.getInputStream());
        } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.out.println("io before reqFromClient = getInputStream");
        }
        String clientInput = null;
        try {
            clientInput = (String) reqFromClient.readObject(); //ส่งมาเป็น null
        } /*catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.out.println("io readObject from reqFromClient to clientInput");
        } */catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
                System.out.println("classNotFound readObject from reqFromClient to clientInput");
        } catch (IOException ex) {
            System.out.println("IOExc");
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
        //String clientInput = fromClient.readLine();
        String[] keyword = clientInput.split("\\s+");
        for (int i = 0; i < keyword.length; i++) {
            keyword[i] = keyword[i].replaceAll("[^\\w]", ""); //replace " " with ""
        }
        System.out.println("Client : " + clientInput);
        if (keyword[0].matches("Login"))//done
        {
            ObjectOutputStream objectToClient = null;
            try {
                objectToClient = new ObjectOutputStream(client.getOutputStream());
                objectToClient.writeObject(Accountant.login(keyword[1], keyword[2])); //GGGG
                objectToClient.flush();
                objectToClient.close();
//                isClose = true;
                reqFromClient.close();
                client.close();
                System.out.println("");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.out.println("IOServerLogin");
            } finally {
                try {
                    objectToClient.close();
                } catch (IOException ex) {
                System.out.println(ex.getMessage());
                    System.out.println("IOServerLogin2");
                }
            }
        } else if (keyword[0].matches("Register"))//done
        {
            ObjectOutputStream objectToClient = null;
            try {
                objectToClient = new ObjectOutputStream(client.getOutputStream());
                objectToClient.writeObject(Accountant.register(keyword[1], keyword[2]));
                objectToClient.flush();
                objectToClient.close();
                isClose = true;
                reqFromClient.close();
                client.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } finally {
                try {
                    objectToClient.close();
                } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
            }
        } else if (keyword[0].matches("Market"))//done
        {

            ObjectOutputStream objectToClient = null;
            try {
                objectToClient = new ObjectOutputStream(client.getOutputStream());
                objectToClient.writeObject(Database.activeProduct);
                objectToClient.flush();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.out.println("fail to return Object to client");
            } finally {
                try {
                    objectToClient.close();
                } catch (IOException ex) {
                System.out.println(ex.getMessage());
                    System.out.println("cant close the outputstream");
                }
            }
            try {
                client.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage()+"IO close market");
            }

        } else if (keyword[0].matches("Image"))//done
        {

            try {
                File file = new File(System.getProperty("user.dir") + "/AuctionDataBase/Image/" + keyword[1]);
                BufferedImage image = ImageIO.read(file);
                OutputStream os = client.getOutputStream();
                ImageIO.write(image, "jpg", os);
                os.flush();
                os.close();
                isClose = true;
                reqFromClient.close();
                client.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        } else if (keyword[0].matches("RegisterProduct"))//done
        {
            try {

                Object obj = reqFromClient.readObject();
                Product product = (Product) obj;
                
//                client.close();
//                ServerSocket forImage = new ServerSocket(1235);
//                System.out.println("close1 and about to accept 2");
//                Socket forImageSocket = forImage.accept();
//                System.out.println("accept 2");
//                BufferedImage bufIm = ImageIO.read(forImageSocket.getInputStream());
//                System.out.println("ImageIO read");
//                while(bufIm == null){
//                    System.out.println("still null");
//                }
                InputStream inputStream = client.getInputStream();
                System.out.println("Reading: " + System.currentTimeMillis());

                byte[] sizeAr = new byte[4];
                inputStream.read(sizeAr);
                int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

                byte[] imageAr = new byte[size];
                inputStream.read(imageAr);
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));
                System.out.println("DoneRead: " + System.currentTimeMillis());
                System.out.println(image == null);
//                while (image == null) {
//                    System.out.println("still null");
//                }
                reqFromClient.close();
                client.close();
                ManageProduct.registerProduct(product, image);
                //reqFromClient.close();
//                    ObjectInputStream objectFromClient = new ObjectInputStream(client.getInputStream());
//                    ImPr impr = (ImPr) objectFromClient.readObject();
//                    ManageProduct.registerProduct(impr.getProduct());
//                    ManageProduct.registerImage(impr.getImage(), impr.getProduct().getImageName());
//                    isClose = true;
//                    client.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (keyword[0].matches("LoadProduct")) {

            ObjectOutputStream objectToClient = null;
            try {
                objectToClient = new ObjectOutputStream(client.getOutputStream());
                OutputStream os = client.getOutputStream();
                Product product = SaveAndLoad.loadProduct(keyword[1]);
                objectToClient.writeObject(product);
                objectToClient.flush();
                objectToClient.close();
                isClose = true;
                reqFromClient.close();
                client.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } finally {
                try {
                    objectToClient.close();
                } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
            }

        } else if (keyword[0].matches("Bid")) {
            try {
                int indexOfActiveProduct = 0;
                for (ActiveProduct ap : Database.activeProduct) {
                    if (ap.getProduct().getFileName().equals(keyword[1])) {
                        indexOfActiveProduct = Database.activeProduct.indexOf(ap);
                    }
                }
                if (Double.parseDouble(keyword[2]) > Database.activeProduct.get(indexOfActiveProduct).getCurrentBid()) {//cost มากกว่า currentBid
                    Database.activeProduct.get(indexOfActiveProduct).setCurrentBid(Double.parseDouble(keyword[2]));
                    Database.activeProduct.get(indexOfActiveProduct).addBiddingHistory(keyword[3] + " " + keyword[2]);
                }
                reqFromClient.close();
                client.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
//            } catch (Exception e) {
//                System.out.println("Exception1 " + e.getMessage());
//            }
        //}

//    }
        System.out.println("Thread End");
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
                Database.auctionedProduct.add(new AuctionedProduct(object));
            }
        }
    }

}
