/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction.AuctionMain;

import uauction.Scene.SceneHomeAlreadyLogIn;
import uauction.Scene.SceneHomeUnLogIn;
import uauction.Stage.SetUpStage;
import uauction.Stage.StageStorage;
import uauction.Stage.setSceneForStage;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Sitth
 */
public class AuctionMain extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        runTime.timer.start();
        launch(args);
        System.exit(0);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        SceneHomeAlreadyLogIn.sceneHomeAlreadyLogIn();
        SceneHomeUnLogIn.sceneHomeUnLogIn();
        setSceneForStage.stageSetHomeUnLogIn();
        SetUpStage.setUpStage().show();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

}
