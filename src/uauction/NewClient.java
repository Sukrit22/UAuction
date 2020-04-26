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
            //ImPr impr = new ImPr(product, image);
            
            ObjectOutputStream toServer = new ObjectOutputStream(server.getOutputStream());
            toServer.writeObject(new String("RegisterProduct"));
            toServer.flush();
            toServer.writeObject(product);
            toServer.flush();
//            toServer.close();
            OutputStream outputStream = server.getOutputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", byteArrayOutputStream);

            byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
            outputStream.write(size);
            outputStream.write(byteArrayOutputStream.toByteArray());
            outputStream.flush();
            System.out.println("Flushed: " + System.currentTimeMillis());
//
//            Thread.sleep(120000);
            System.out.println("Closing: " + System.currentTimeMillis());

            server.close();
//            sendImage = new Thread( new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        server = new Socket(localhost, 1235);
//                        OutputStream os = server.getOutputStream();
//                        System.out.println(image == null);
//                        try {
//                            System.out.println(image == null);
//                            ImageIO.write(image, "jpg", os);
//                        } catch (IOException ex) {
//                            Logger.getLogger(NewClient.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        Thread.sleep(5000);
//                        os.flush();
//                        os.close();
//                        server.close();
//                        
//                    } catch (IOException ex) {
//                        Logger.getLogger(NewClient.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(NewClient.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    
//                }
//            });
//            System.out.println("start thread to send image");
//            sendImage.start();
            
            
            //ObjectOutputStream toServer2 = new ObjectOutputStream(server.getOutputStream());
            //toServer2.writeObject(impr);
            //toServer2.flush();
            //toServer2.close();
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

    public static void reqMarket(int i) throws Exception {
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
                        //ex.printStackTrace();
                    }
                    /*catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        System.out.println("inside Thread reqImage in reqMarket");
                    }*/
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                        System.out.println("interupt thread req image");
                    }

                }
                if (renewMarketBecauseImageJustLoaded) { //กรณีที่รับImage มาครบทุกตัว จึงshowMarketใหม่
                    showMarket(i);
                }
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
        }//เกิดปัญหาแน่ถ้าเกิดเป็นภาพ HD เพราะ สร้างThreadใหม่ขึ้นมาแล้ว ภาพHD ใช้เวลาส่งนาน ซึ่งให้เวลาก่อนสร้างThreadใหม่ไว้ 0.2 seconds
        server.close();
    }

    public static void showMarket(int i) {
        System.out.println("GG");
        //CategorisePane.vboxArray.get(i).getChildren().removeAll(); //ล้าง vbox
        
        //CategorisePane
        
        //CategorisePane.vboxArray.get(i).getChildren().add(new Text ("555 kam mai?"));
//        for (ActiveProduct a : filteredProduct) { //สร้าง pane in vbox
//            Image image;
//            try{//พยายามโหลดภาพที่มาทัน
//                image = new Image("file:///" + System.getProperty("user.dir") + "/AuctionDataBase/Image/" + a.getProduct().getImageName());
//            } catch (Exception e){ //กรณีภาพมาไม่ทัน
//                image = new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/" + "noimg.jpg");
//            }
//            String name = a.getProduct().getName();
//            String description = a.getProduct().getDescription();
//            Double currentBid = a.getCurrentBid();
//            int itemId = a.getProduct().getItemId();
//            //CategorisePane.vbo
////            Pane pane = new Pane(new ImageView(image), new Label(name), new Label(description), new Label(currentBid.toString()));
//            CategorisePane.vboxArray.get(i).getChildren().add( ProductPaneInVbox.Pane1(image, name, description, currentBid, itemId,a)); 
//            
//
//        }
//=========================== needFixed =======================
        //MyFunction.i = i;
        //MyFunction.damn(/*image, localhost, destinationIp, i, i, a*/i);
        for (ActiveProduct a : NewClient.filteredProduct) { //สร้าง pane in vbox
            System.out.println(a.getProduct().getImageName());
            CategorisePane.vboxArray.get(i).getChildren().remove(NewClient.filteredProduct.indexOf(a));
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
/*public class NewClient extends Application
{
    OutputStreamWriter osw = null;
    
    InputStreamReader isr = null;
   


    @Override
    public void start(Stage stage) throws Exception {
       BorderPane paneForText = new BorderPane();
       paneForText.setPadding(new Insets(5,5,5,5));
       paneForText.setLeft(new Label("Enter somthing : "));
        
       TextField tf = new TextField();
       tf.setAlignment(Pos.BOTTOM_RIGHT);
       paneForText.setCenter(tf);
       
       BorderPane mainPane = new BorderPane();
       TextArea ta = new TextArea();
       mainPane.setCenter(new ScrollPane(ta));
       mainPane.setTop(paneForText);
        
       
       Scene scene = new Scene(mainPane,450,200);
       Stage primaryStage = new Stage();
       primaryStage.setTitle("Client");
       primaryStage.setScene(scene);
       primaryStage.show();
       
       Socket server = new Socket("localhost",1234);
       osw = new OutputStreamWriter(server.getOutputStream());
       isr = new InputStreamReader(server.getInputStream());
       BufferedWriter toServer = new BufferedWriter(osw);
        BufferedReader fromServer = new BufferedReader(isr);
       tf.setOnAction(e->{
           
           try {
               String output = tf.getText().trim();
               toServer.write(output);
               toServer.flush();
               
               String input = fromServer.readLine();
               ta.appendText("Server : " + input);
               
           } catch (IOException ex) {
              
           }
       });
       
    }
    public static void main(String arg[])
{
    launch(arg);

}
}
 */
