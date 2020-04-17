/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uauction;

import javafx.scene.image.Image;

/**LoadImage is a class that ..
 *
 * @author Sukrit22
 */
public class LoadImage {
//=========================== data field =======================
    
    
    
//=========================== method =======================
    
    public static Image load(String imageName){
        return new Image("file:///"+System.getProperty("user.dir")+"/AuctionDataBase/Image/"+imageName+".png");
    }
    
}
