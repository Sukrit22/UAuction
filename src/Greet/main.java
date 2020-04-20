/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Greet;

import java.io.IOException;
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
            GreetClient client = new GreetClient();
            client.startConnection("127.0.0.1", 6666);
            String response = client.sendMessage("hello server");
            System.out.println(response);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


//======================= method =================================

public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() throws IOException {
        GreetClient client = new GreetClient();
        client.startConnection("127.0.0.1", 6666);
        String response = client.sendMessage("hello server");
        System.out.println(response);
    }

}
