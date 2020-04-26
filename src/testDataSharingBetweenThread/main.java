/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testDataSharingBetweenThread;

/**main is a class that ..
 *
 * @author Sukrit22
 */
public class main extends Thread{
//======================= data field =============================



//======================= Constructor ============================

    public static void main(String[] args) {
        Server server = new Server(); //Object ตัวเดียว ส่งreference เข้าไปในแต่ละThread
        WorkerThread a = new WorkerThread(true); //true = print
        WorkerThread b = new WorkerThread(true);
        WorkerThread update = new WorkerThread(server, false); //false = update
        
        a.start();
        b.start();
        update.start();
        a.setName("a");
        b.setName("b");
        
        
        
        
        
        
    }

//======================= method =================================



}
