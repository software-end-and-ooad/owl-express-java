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
 * @author babyjazz
 */
public class CheckOrderController{
    private long userID;
    private long postmanID;
    private long price;
    private String size;
    private String sourceAddress;
    private String sourcedistric;
    private String sourcearea;
    private String sourceprovince;
    private String sourcezipCode;
    private String sourceotherAddress;
    private String destinationAddress;
    private String destinationdistric;
    private String destinationarea;
    private String destinationprovince;
    private String destinationzipCode;
    private String destinationotherAddress;
    private String status;
    private String trackID;
    private boolean uniqueTrackID;

   
    
    
//   private Validation validator = new Validation();

    public CheckOrderController(String trackID){
               this.trackID = trackID;
    }

    public long getUserID() {
        return userID;
    }


    public long getPostmanID() {
        return postmanID;
    }

    public void setPostmanID(long postmanID) {
        this.postmanID = postmanID;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public String getSourcezipCode() {
        return sourcezipCode;
    }

    public String getDestinationzipCode() {
        return destinationzipCode;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getStatus() {
        return status;
    }

    


    
    
    
    
    
    public boolean checkOrderFinder() {
        
      
        Database db = new Database("Order");
       
        Query orderQuery = db.getEM().createQuery("SELECT o FROM Order o  WHERE o.trackID='" + this.trackID + "'", Order.class);
      
        
        try { // try, if can find user
            Order order = (Order)orderQuery.getSingleResult();
            this.destinationzipCode = order.getDestinationzipCode();
            this.sourcezipCode = order.getSourcezipCode();
            this.status = order.getStatus();
           
            return true;
        } catch (Exception e) {
            System.out.println("false");
            db.getEM().close();
            return false;
        }
       
       
    }
    
}
