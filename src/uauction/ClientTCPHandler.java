/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uauction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**ClientTCP is a class that ..
 *
 * @author Sukrit22
 */
public class ClientTCPHandler {
//======================= data field =============================
private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
 
    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(ClientTCPHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public String sendMessage(String msg) {
        out.println(msg);
        String resp = null ;
        try {
            resp= in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ClientTCPHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }
 
    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientTCPHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


//======================= Constructor ============================



//======================= method =================================



}
