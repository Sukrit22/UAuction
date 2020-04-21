/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uauction;

/**TemporaryServerDecision is a class that ..
 *
 * @author Sukrit22
 */
public class TemporaryServerDecision {
//======================= data field =============================



//======================= Constructor ============================



//======================= method =================================

    public void desion(){
        String input = null; //initial String as input, usually get from client
        
        //seperate String(sentence) into array of String(word) to use next in if else or switch case
        String[] words = input.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^\\w]", ""); //replace " " with ""
        }
        if(words[0].equals("login")){ //login
            Accountant.login(words[1], words[2]);
        }else if(words[0].equals("register")){ //register
            
        }else if(words[0].equals("market")){ //request market page from database
            
        }else if(words[0].equals("product")){ //get product by index from active
            
        }else if(words[0].equals("bid")){ //perform bid action
            
        }
    }

}
