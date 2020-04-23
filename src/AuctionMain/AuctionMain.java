/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionMain;

import Function.MyFunction;
import Stage.SetUpStage;
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

        MyFunction.inti();
        SetUpStage.getStage().show();
        
        

    }

}
