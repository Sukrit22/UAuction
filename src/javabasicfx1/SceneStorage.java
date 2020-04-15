/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicfx1;

import javabasicfx1.Scene.HomeScene.HomeScene.HomeSceneAlreadyLogIn;
import javabasicfx1.Scene.HomeScene.HomeScene.HomeSceneUnLogIn;
import javafx.scene.Scene;

/**
 *
 * @author Sitth
 */
public class SceneStorage {
    private Scene homeSceneUnLogInSS;
    private Scene homeSceneAlreadyLogInSS;

    public SceneStorage() {
        System.out.println("----1-SceneStorage");
    }

    public void createScene(){
        System.out.println("-----2-1-createScene - homeSceneLogOut");
        HomeSceneUnLogIn homeSceneUnLogIn = new HomeSceneUnLogIn();
        this.homeSceneUnLogInSS = new Scene(HomeSceneUnLogIn.getPaneLayor1());
        System.out.println("-----2-2-createScene - homeSceneLogIn");
        HomeSceneAlreadyLogIn homeSceneAlreadyLogIn = new HomeSceneAlreadyLogIn();
        this.homeSceneAlreadyLogInSS = new Scene(homeSceneAlreadyLogIn.getPaneLayor1());
    }
    
    public Scene getHomeSceneUnLogInFromSS() {
        return homeSceneUnLogInSS;
    }

    public Scene getHomeSceneAlreadyLogInFromSS() {
        return homeSceneAlreadyLogInSS;
    }

    
    
    
}
