/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDataSharingBetweenThread;

/**
 * server is a class that ..
 *
 * @author Sukrit22
 */
public class Server {
//======================= data field =============================

    public static int data = 0;

//======================= Constructor ============================
    public Server() {

    }

//======================= method =================================
    public void update() {
        while (true) {
            data++;
        }
    }

    public static void print() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " : " + data);
        }
    }
}
