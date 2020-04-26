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
import Function.MyFunction;
import Scene.CategorisePane;
import static Scene.CategorisePane.vboxArray;
import Scene.ProductPaneInVbox;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


public class NewClient {
    private static boolean renewMarketBecauseImageJustLoaded;
    public static final String destinationIp = "auctionoop.myddns.me";
    public static final String localhost = "127.0.0.1";
    public static Socket server = null;
    public static User user;
    public static ArrayList<ActiveProduct> unfilteredProduct = new ArrayList<>();
    public static ArrayList<ActiveProduct> filteredProduct = new ArrayList<>();
    public static Thread sendImage;
    public static boolean oldShowMarketDone;
    public static int myViewSelected;
    
    //=========================== main is here =======================
    public static void main(String[] args) throws Exception {
        renewMarketBecauseImageJustLoaded = false;
        user = new User();
        AuctionMain.AuctionMain.main(args);
//        while(true)
//    {
//       
//        Scanner input = new Scanner(System.in);
//        PrintWriter toServer = new PrintWriter(server.getOutputStream(),true);
//        InputStreamReader isr = new InputStreamReader(server.getInputStream());
//        BufferedReader fromServer = new BufferedReader(isr);
//        
//        toServer.println(input.nextLine());
//        
//        String rtnFromServer = fromServer.readLine();
//        System.out.println("Server : "+rtnFromServer);
//    }
    }

    public static Object reqLogin(String username, String password) throws IOException, ClassNotFoundException {
        //server = new Socket("171.6.209.126",1233);
        server = new Socket(localhost, 1234);
        ObjectOutputStream toServer = new ObjectOutputStream(server.getOutputStream());
        toServer.writeObject(new String("Login" + " " + username + " " + password));
        //PrintWriter toServer = new PrintWriter(server.getOutputStream(),true);
        // toServer.println("Login"+" "+username+" "+password);

        ObjectInputStream fromServer = new ObjectInputStream(server.getInputStream());
        Object a = fromServer.readObject();
        fromServer.close();
        server.close();
        // return null;
        return a;

    }

    public static Object reqRegister(String username, String password) throws IOException, ClassNotFoundException {
        server = new Socket(localhost, 1234);
        ObjectOutputStream toServer = new ObjectOutputStream(server.getOutputStream());
        toServer.writeObject(new String("Register" + " " + username + " " + password));
        toServer.flush();

        ObjectInputStream fromServer = new ObjectInputStream(server.getInputStream());
        Object a = fromServer.readObject();

        toServer.close();
        fromServer.close();
        server.close();
        return a;
    }

    public static void reqRegisterProduct(Product product, BufferedImage image){
        try {
            server = new Socket(localhost, 1234);
            
            ObjectOutputStream toServer = new ObjectOutputStream(server.getOutputStream());
            toServer.writeObject(new String("RegisterProduct"));
            toServer.flush();
            toServer.writeObject(product);
            toServer.flush();
            OutputStream outputStream = server.getOutputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", byteArrayOutputStream);

            byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
            outputStream.write(size);
            outputStream.write(byteArrayOutputStream.toByteArray());
            outputStream.flush();
            System.out.println("Flushed: " + System.currentTimeMillis());
            System.out.println("Closing: " + System.currentTimeMillis());

            server.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("เกิด error ในreq");
        }

    }

    public static Object reqProduct(String fileName/*product.getFilename()*/) throws Exception {
        server = new Socket(localhost, 1234);

        ObjectOutputStream toServer = new ObjectOutputStream(server.getOutputStream());
        toServer.writeObject(new String("LoadProduct" + " " + fileName));

        ObjectInputStream fromServer = new ObjectInputStream(server.getInputStream());
        Product product = (Product) fromServer.readObject();
        fromServer.close();
        server.close();
        return product;
    }

    public static void reqBid(String fileName/*product.getName*/, String cost, String bidderName/*User.getName*/) throws Exception {
        server = new Socket(localhost, 1234);
        ObjectOutputStream toServer = new ObjectOutputStream(server.getOutputStream());
        toServer.writeObject(new String("Bid" + " " + cost + " " + bidderName));
        toServer.close();
        server.close();
    }

    public static void reqMarket() throws Exception { //get unfilter and req Image
        server = new Socket(localhost, 1234);
        ObjectOutputStream toServer = new ObjectOutputStream(server.getOutputStream());
        toServer.writeObject(new String("Market"));
        toServer.flush();

        ObjectInputStream fromServer = new ObjectInputStream(server.getInputStream());
        ArrayList<ActiveProduct> a = (ArrayList<ActiveProduct>) fromServer.readObject();
        toServer.close();
        fromServer.close();

        unfilteredProduct = a;
        unfilteredProduct.forEach(b->
        {
            System.out.println(b.getProduct().getName());
        }
        );
//        filteredProduct = unfilteredProduct;
        server.close();
        Thread reqIm = new Thread(new Runnable() {
            @Override
            public void run() {
                for (ActiveProduct ap : a) {
                    try {
                        reqImage(ap.getProduct().getImageName());
                        System.out.println("getIm");
                    } catch (Exception ex) {
                        Logger.getLogger(NewClient.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                        System.out.println("interupt thread req image");
                    }

                }
                
//                if (renewMarketBecauseImageJustLoaded) { //กรณีที่รับImage มาครบทุกตัว จึงshowMarketใหม่
//                    while(!oldShowMarketDone);
//                    showMarket(NewClient.myViewSelected);
//                }
            }
        });
        reqIm.start();
        

    }

    public static void reqImage(String imageName) throws Exception {

        File file = new File(System.getProperty("user.dir") + "/AuctionDataBase/Image/" + imageName);
        if (!file.exists()) {
            if(!renewMarketBecauseImageJustLoaded)
                renewMarketBecauseImageJustLoaded = true;
            server = new Socket(localhost, 1234);
            ObjectOutputStream toServer = new ObjectOutputStream(server.getOutputStream());
            InputStream is = server.getInputStream();

            toServer.writeObject("Image" + " " + imageName);
            toServer.flush();
            BufferedImage image = ImageIO.read(is);
            ImageIO.write(image, imageName, file);
            server.close();
        }//เกิดปัญหาแน่ถ้าเกิดเป็นภาพ HD เพราะ สร้างThreadใหม่ขึ้นมาแล้ว ภาพHD ใช้เวลาส่งนาน ซึ่งให้เวลาก่อนสร้างThreadใหม่ไว้ 0.2 seconds
        
    }

    public static void showMarket(int i) {
        if(oldShowMarketDone)
            oldShowMarketDone = false;
        System.out.println("GG");
//=========================== needFixed =======================
        for(int gg = CategorisePane.vboxArray.get(i).getChildren().size()-1; gg>=0 ;gg--){
            CategorisePane.vboxArray.get(i).getChildren().remove(gg);
        }
        switch(NewClient.myViewSelected){
            case 0: filteredProduct = unfilteredProduct;
            break;
            case 1:filter("Electronic");
            break;
            case 2:filter("");
        }
        for (ActiveProduct a : NewClient.filteredProduct) { //สร้าง pane in vbox
            System.out.println(a.getProduct().getImageName());
            //CategorisePane.vboxArray.get(i).getChildren().remove(0);
            Image image;
            try {//พยายามโหลดภาพที่มาทัน
                image = new Image("file:///" + System.getProperty("user.dir") + "/AuctionDataBase/Image/" + a.getProduct().getImageName());
            } catch (Exception e) { //กรณีภาพมาไม่ทัน
                image = new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/" + "noimg.jpg");
            }
            String name = a.getProduct().getName();
            String description = a.getProduct().getDescription();
            Double currentBid = a.getCurrentBid();
            int itemId = a.getProduct().getItemId();
            //CategorisePane.vbo
//            Pane pane = new Pane(new ImageView(image), new Label(name), new Label(description), new Label(currentBid.toString()));
            CategorisePane.vboxArray.get(i)/*catalogไหน*/.getChildren().add(ProductPaneInVbox.Pane1(image, name, description, currentBid, itemId, a));
            //CategorisePane.vboxArray.get(i).getChildren()
        }
        CategorisePane.vboxArray.get(i).setVisible(true);
        CategorisePane.paneArray.get(i).setVisible(true);
        
        oldShowMarketDone = true;
    }

    public static void filter(String filter) {
        filteredProduct.clear();

        for (ActiveProduct a : unfilteredProduct) {
            if (a.getProduct().getCatagory().matches(filter)) {
                filteredProduct.add(a);
            }
        }
        System.out.println("Filtered : "+ filter);
    }
}