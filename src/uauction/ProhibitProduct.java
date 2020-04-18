/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author poomy
 */
public class ProhibitProduct {
    
    //DataField
    ActiveProduct ap;
    Date deleteDate;
    
    //Constructor
    public ProhibitProduct(ActiveProduct ap, Date deleteDate) {
        this.ap = ap;
        this.deleteDate = deleteDate;
    }
    
    //Accessor
    public Date getDeleteDate() {
        return deleteDate;
    }
    public ActiveProduct getActiveProduct() {
        return ap;
    }
}
