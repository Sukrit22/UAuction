/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Greet;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**main is a class that ..
 *
 * @author Sukrit22
 */
public class main {
//======================= data field =============================



//======================= Constructor ============================

    public static void main(String[] args) {
        try {
            System.out.println("start");
            Scanner scn = new Scanner(System.in);
            System.out.println("what do you want to say?");
            String scnIn = scn.nextLine();
            System.out.println("ok, we're going to tell server \" "+scnIn+"\"");
            System.out.println("going to connect in 5");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("going to connect in 4");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("going to connect in 3");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("going to connect in 2");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("going to connect in 1");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("starting connection");
            try {
                GreetClient client = new GreetClient();
                client.startConnection("127.0.0.1", 6666);
                String response = client.sendMessage(scnIn);
                System.out.println(response);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("end connection");
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
            //ทำการเซฟข้อมูลซะ หรือสร้างthreadมาเซฟข้อมูลด้วยความเร็วแสง
            System.out.println("saving data");
        }
    }


//======================= method =================================


}
