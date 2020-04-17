/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction.Stage;

import uauction.Scene.SceneHomeAlreadyLogIn;
import uauction.Scene.SceneHomeUnLogIn;

/**
 *
 * @author Sitth
 */
public class setSceneForStage {
    static public void stageSetHomeUnLogIn(){
        SetUpStage.getStage().setScene(SceneHomeUnLogIn.getScene());
    }
    
    static public void stageSetHomeAlreadyLogIn(){
        SetUpStage.getStage().setScene(SceneHomeAlreadyLogIn.getScene());
    }
    
    static public void stageSetAuctionHouse(){
        //SetUptStage.getStage().setScene(SceneAuctionHouse.sceneAuctionHouse());
    }
}
