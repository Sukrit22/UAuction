/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Sitth
 */
public class SetUpStage {
    
    static public Stage getStage() {
        return StageStorage.Auction;
    }

    static public void stageAuction() {
        StageStorage.Auction.setResizable(true);
        StageStorage.Auction.setMaxWidth(1920);
        StageStorage.Auction.setMaxHeight(1080);
        StageStorage.Auction.setMinWidth(1920);
        StageStorage.Auction.setMinHeight(1080);
        
        Image e = new Image("file:///" + System.getProperty("user.dir") + "/src/Picture/auction.png");
        
        
        StageStorage.Auction.getIcons().add(e);
        if(Boolean.FALSE){
            //StageStorage.Auction.setX(100);
            //StageStorage.Auction.setY(200);
            StageStorage.Auction.setMaximized(true);
            StageStorage.Auction.initStyle(StageStyle.UNDECORATED);
            StageStorage.Auction.setTitle("Auction");
            //StageStorage.Auction.setScene(SceneHomeUnLogIn.sceneHomeUnLogIn());
        }else{
            StageStorage.Auction.setX(0);
            StageStorage.Auction.setY(100);
            //StageStorage.Auction.setMaximized(true);
            //StageStorage.Auction.initStyle(StageStyle.UNDECORATED);
            StageStorage.Auction.setTitle("Auction");
            //StageStorage.Auction.setScene(SceneHomeUnLogIn.sceneHomeUnLogIn());
        }
        

    }
}
