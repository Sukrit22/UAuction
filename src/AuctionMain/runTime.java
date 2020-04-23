/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionMain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javafx.application.Platform;
import javafx.scene.control.Label;
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
    static public ArrayList<Label> textArrayforCal = new ArrayList<Label>();
    static public ArrayList<Label> textArray = new ArrayList<Label>();

    static Thread timer = new Thread(new Runnable() {
        @Override
        public void run() {
            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a XXX");
            while (!enough) {
                try {
                    // running "long" operation not on UI thread
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
                final String time = dt.format(new Date());
                Platform.runLater(() -> {
                    count++;
                    if (count == 5) {
                        System.out.println(time);
                        count = 0;
                    }

                    for (int i = 0; i < textArrayforCal.size(); i++) {
                        long ssss = Long.parseLong(textArrayforCal.get(i).getText());
                        ssss--;
                        textArrayforCal.get(i).setText(ssss + "");

                        long minI = Long.parseLong(textArrayforCal.get(i).getText());

                        int s = (int) (minI % 100);
                        int m = ((int) (minI % 10000) - (int) (s % 100)) / 100;
                        int h = ((int) (minI % 100000) - (int) (minI % 10000)) / 10000;

                        int ms = m * 60;
                        int hs = h * 60 * 60;

                        //int ssssi = hs + ms + s;
                        int res = (int)minI % 60;
                        int rem = (int) (minI / 60) % 60;
                        int reh = (int) ((int) (minI / 60) / 60);

                        textArray.get(i).setText("    " + reh + " Hr " + rem + " Min " + res + " Sec ");
                    }
                    // updating live UI object requires JavaFX App Thread
                    //SetTextShape.setTextShape(runTime.txtTime.getText(), 20);
                    txtTime.setText(time);
                    CreateButton.timeText.setText(time);
                    CreateButton.timeText2.setText(time);
                    //MyButton.btnTime1.setText(time);
                    //MyButton.btnTime2.setText(time);

                    //timeShape.setStyle("-fx-padding: 10; -fx-border-style: solid inside; -fx-border-width: 2; -fx-border-insets: 5; -fx-border-radius: 5; -fx-border-color: black;");
                });
            }
        }

    });
}
