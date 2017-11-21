/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Order;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Perth
 */
public class HistoryController {
    
    private long userID;
    private long price;
    private String size;
    private String trackID;
    private String senderName;
    private String receiverName;
    
    public HistoryController(long userID){
        this.userID = userID;
    }
    
    public long getPrice(){
        return price;
    }
    
    public String getSize(){
        return size;
    }
    
    public String getTrackID() {
        return trackID;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }
    
    public List HistoryFinder() {
        
      
        Database db = new Database("Order");
       
        Query orderQuery = db.getEM().createQuery("SELECT o FROM Order o  WHERE o.userID=" + this.userID , Order.class);
        List<Order> results = orderQuery.getResultList();
        
        System.out.println(this.userID);
        
        try { // try, if can find user
           
            return results;
        } catch (Exception e) {
            System.out.println("false");
            db.getEM().close();
            return null;
        }
       
       
    }
}


