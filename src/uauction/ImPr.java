/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author USER
 */
public class ImPr {
    
    Product  product;
    BufferedImage image;
    public ImPr(Product product,BufferedImage image/*ImportImageFile(String initPath)*/)
    {
        this.product = product;
        this.image = image;
        
    }
    public Product getProduct()
    {
        return this.product;
    }
    public BufferedImage getImage()
    {
        return this.image;
    }
    
     public static void writeImportedImageFile(String initPath,String imageName){
        
        File initImage = new File(initPath);
        BufferedImage image = null;
        try {
            image = ImageIO.read(initImage);
            ImageIO.write(image,"jpg",new File(System.getProperty("user.dir")+"/AuctionDataBase/Image/"+imageName+ ".jpg"));
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
