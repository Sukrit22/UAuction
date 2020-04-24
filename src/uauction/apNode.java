package uauction;


import javafx.scene.Node;
import uauction.ActiveProduct;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**apNode is a class that ..
 *
 * @author Sukrit22
 */
public class apNode extends Node{
    public ActiveProduct ap;
    public apNode(ActiveProduct ap) {
        this.ap = ap;
    }
    
}