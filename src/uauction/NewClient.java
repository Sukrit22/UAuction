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
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
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
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class NewClient {

    public static final String destinationIp = "auctionoop.myddns.me";
    public static final String localhost = "127.0.0.1";
    static Socket server = null;
    public static User user;
    public static ArrayList<ActiveProduct> unfilteredProduct = new ArrayList<>();
    public static ArrayList<ActiveProduct> filteredProduct = new ArrayList<>();

    public static void main(String[] args) throws Exception {

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

    public static void reqRegisterProduct(Product product, BufferedImage image) throws IOException {
        server = new Socket(localhost, 1234);
        ImPr impr = new ImPr(product, image);

        ObjectOutputStream toServer = new ObjectOutputStream(server.getOutputStream());
        toServer.writeObject(new String("RegisterProduct" + " "));
        toServer.flush();
        ObjectOutputStream toServer2 = new ObjectOutputStream(server.getOutputStream());
        toServer2.writeObject(impr);
        toServer2.flush();
        toServer2.close();
        server.close();
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

    public static void reqBid(String productName/*product.getName*/, String cost, String bidderName/*User.getName*/) throws Exception {
        server = new Socket(localhost, 1234);
        ObjectOutputStream toServer = new ObjectOutputStream(server.getOutputStream());
        toServer.writeObject(new String("Bid" + " " + cost + " " + bidderName));
        toServer.close();
        server.close();
    }

    public static void reqMarket() throws Exception {
        server = new Socket(localhost, 1234);
        ObjectOutputStream toServer = new ObjectOutputStream(server.getOutputStream());
        toServer.writeObject(new String("Market" + " "));
        toServer.flush();
        toServer.close();

        ObjectInputStream fromServer = new ObjectInputStream(server.getInputStream());
        ArrayList<ActiveProduct> a = (ArrayList<ActiveProduct>) fromServer.readObject();
        fromServer.close();

        unfilteredProduct = a;
        filteredProduct = unfilteredProduct;
        server.close();
        for (ActiveProduct ap : a) {
            reqImage(ap.getProduct().getImageName());

        }

    }

    public static void reqImage(String imageName) throws Exception {
        server = new Socket(localhost, 1234);
        ObjectOutputStream toServer = new ObjectOutputStream(server.getOutputStream());
        toServer.writeObject(new String("Image" + " " + imageName));
        File file = new File(System.getProperty("user.dir") + "/AuctionDataBase/Image/" + imageName);
        InputStream is = server.getInputStream();
        if (!file.exists()) {
            BufferedImage image = ImageIO.read(is);
            ImageIO.write(image, imageName, file);
        }
        server.close();
    }

    public static void showMarket(ArrayList<ActiveProduct> product, VBox vbox) {
        for (ActiveProduct a : product) {
            Image image = new Image(System.getProperty("user.dir") + "/AuctionDataBase/Image/" + a.getProduct().getImageName());
            String name = a.getProduct().getName();
            String description = a.getProduct().getDescription();
            Double currentBid = a.getCurrentBid();
            Pane pane = new Pane(new ImageView(image), new Label(name), new Label(description), new Label(currentBid.toString()));

            vbox.getChildren().add(pane);

        }
    }

    public static void filter(String filter) {
        filteredProduct.clear();

        for (ActiveProduct a : unfilteredProduct) {
            if (a.getProduct().getCatagory().matches(filter)) {
                filteredProduct.add(a);
            }
        }

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
