/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionMain;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Platform;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Sitth
 */
public class runTime {

    static public final Text txtTime = new Text();
    static private volatile boolean enough = false;
    static private int count = 0;

    static Thread timer = new Thread(new Runnable() {
        @Override
        public void run() {
            SimpleDateFormat dt = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss a XXX");
            while (!enough) {
                try {
                    // running "long" operation not on UI thread
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                }
                final String time = dt.format(new Date());
                Platform.runLater(() -> {
                    count++;
                    if (count == 50) {
                        System.out.println(time);
                        count = 0;
                    }
                    // updating live UI object requires JavaFX App Thread
                    //SetTextShape.setTextShape(runTime.txtTime.getText(), 20);
                    txtTime.setText(time);
                    CreateButton.timeText.setText(time);
                    //MyButton.btnTime1.setText(time);
                    //MyButton.btnTime2.setText(time);

                    //timeShape.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: black;");
                });
            }
        }
    });
}
