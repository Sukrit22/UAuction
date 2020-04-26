/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testDataSharingBetweenThread;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**ServerThread is a class that ..
 *
 * @author Sukrit22
 */
public class WorkerThread extends Thread implements Runnable{


    
//======================= data field =============================

    public Server server;
    public boolean decision;

//======================= Constructor ============================

    WorkerThread(Server server,boolean decision){ //0 = update 1=print
        this.server = server;
        this.decision = decision;
    }

    public WorkerThread(boolean decision) {
        this.decision = decision;
    }
    

//======================= method =================================
    @Override
    public void run() {
        if (decision) {
            Server.print();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            server.update();
        }
    }

}
