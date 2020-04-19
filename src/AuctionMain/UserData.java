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
    private int id;
    static private int count = 0;
    static public int ID_UserThatLogIn;
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
    static public ArrayList<Pane> userPaneArray = new ArrayList<Pane>();
    static public ArrayList<VBox> vboxArray = new ArrayList<VBox>();

    public UserData(String email, String password) {
        this.password = password;
        this.email = email;       
        vboxArray.add(new VBox());
        id = count;
        userPaneArray.add(new Pane(new Label(email), vboxArray.get(id)));
        
        count++;
        
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
