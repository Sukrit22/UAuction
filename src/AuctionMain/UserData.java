/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionMain;

import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Sitth
 */
public class UserData {
    private int id = 0;
    static public int numbersdf = 0;
    static public int number;
    static public int Usernumber;
    private String password;
    private String email;
    private boolean status = false;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    static public ArrayList<UserData> user = new ArrayList<UserData>();
    static public ArrayList<Pane> userPane = new ArrayList<Pane>();
    static public ArrayList<VBox> vbox = new ArrayList<VBox>();
    //static public ArrayList<int> numID = new ArrayList<int>();

    public UserData(String email, String password) {
        this.password = password;
        this.email = email;       
        number = id;
        vbox.add(new VBox());
        id = numbersdf;
        userPane.add(new Pane(new Label(email), vbox.get(id)));
        
        numbersdf++;
        
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    
    
}
