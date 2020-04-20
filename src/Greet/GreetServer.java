package Greet;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**GreetServer is a class that ..
 *
 * @author Sukrit22
 */
public class GreetServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
 
    public void start(int port) throws IOException {
        System.out.println("goint to open port");
        serverSocket = new ServerSocket(port);
        System.out.println("wait for client");
        clientSocket = serverSocket.accept();
        System.out.println("assign out and in");
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        String fromClient = in.readLine();
        System.out.println(fromClient);
            if ("hello server".equals(fromClient)) {
                out.println("hello client");
            }
            else {
                out.println("? what is this?.. why tell me \""+fromClient+"\"? I don't understand a thing");
            }
            
        System.out.println("end");
    }
 
    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    public static void main(String[] args) throws IOException {
        GreetServer server=new GreetServer();
        server.start(6666);
    }
}
