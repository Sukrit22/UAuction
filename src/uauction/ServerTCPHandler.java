/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uauction;

import java.io.*;
import java.net.*;
/**ServerTCP is a class that ..
 *
 * @author Sukrit22
 */
public class ServerTCPHandler {
//======================= data field =============================
private int port = 2238;
private ServerSocket serverSocket;
private Socket clientSocket;
private PrintWriter out;
private BufferedReader in;
    

//======================= Constructor ============================



//======================= method =================================
public void start(int port) {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String greeting = in.readLine();
            if ("hello server".equals(greeting)) {
                out.println("hello client");
            }
            else {
                out.println("unrecognised greeting");
            }
    }

public void stop() {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }


}
