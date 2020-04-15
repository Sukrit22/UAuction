/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

/**
 *
 * @author Sukrit22
 */
public interface SaveAndLoadAbility extends java.io.Serializable {
    void saveProduct(AuctionProduct ap);
    AuctionProduct loadProduct();
    
    void saveUser(User user);
    User loadUser();
    
    void saveDatabase();
    void loadDatabase();
    
}
