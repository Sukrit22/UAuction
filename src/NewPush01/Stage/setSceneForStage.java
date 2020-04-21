/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stage;

import Scene.Home.SceneHomeUnLogIn;

/**
 *
 * @author Sitth
 */
public class setSceneForStage {
    static public void stageSetHomeUnLogIn(){
        SetUpStage.getStage().setScene(SceneHomeUnLogIn.getScene());
    }
}
