/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionMain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Sitth
 */
public class CountDown {

    public void countTime() {
        SimpleDateFormat minDT = new SimpleDateFormat("hhmmss");
        long minI = Long.parseLong(minDT.format(new Date()));
        System.out.println(minI);
        int s = (int)(minI % 100);
        int m = ((int)(minI % 10000) - (int)(s % 100))/100;
        int h = ((int)(minI % 100000) -(int)(minI % 10000))/10000;
        System.out.println(h + " " + m +" " + s );
        
        int ms = m * 60;
        int hs = h * 60 * 60;

        int ssss = hs + ms + s;
        ssss--;
        int res = ssss%60;
        int rem = (int)(ssss/60)%60;
        int reh = (int)((int)(ssss/60)/60);
    }
}
