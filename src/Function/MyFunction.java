/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import AuctionMain.CreateButton;
import Effect.PopUp;
import Effect.PopUpProduct;
import Effect.Notifications;
import Scene.CategorisePane;
import Scene.Home.MyAccount.PaneMyAccount;
import Scene.Home.PaneTop;
import Scene.Home.SceneHomeUnLogIn;
import Scene.ProductPaneInVbox;
import Stage.SetUpStage;
import Stage.setSceneForStage;
import java.util.logging.Level;
import java.util.logging.Logger;
import uauction.ActiveProduct;
import uauction.NewClient;
import javafx.scene.image.Image;
import static uauction.NewClient.filteredProduct;

/**
 *
 * @author Sitth
 */
public class MyFunction {

    static public void inti() {
        Notifications.setUp();
        SetUpStage.stageAuction();
        CreateButton.setUpAllButton();
        SceneHomeUnLogIn.sceneHomeUnLogIn();
        setSceneForStage.stageSetHomeUnLogIn();
        PaneTop.getPane().getChildren().add(CreateButton.buttonTime);
        PaneTop.getPane().getChildren().add(CreateButton.buttonHelpPaneTop);
        PopUp.setUpPopUp();
        PaneMyAccount.setUpPane();
        Scene.Home.MyAccount.PaneMyAccount.getPaneMyAcclayer1();
        NewClient.myViewSelected = 0;
        try {
            NewClient.reqMarket();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Fail reqMarket before login");
        }
        NewClient.showMarket(NewClient.myViewSelected);
    }

}
