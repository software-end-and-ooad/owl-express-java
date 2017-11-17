/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Order;
import java.util.ArrayList;
import javax.persistence.Query;

/**
 *
 * @author babyjazz
 */
public class MakeOrderController extends Validation{
    private long userID;
    private long postmanID;
    private long price;
    private String size;
    private String sourceAddress;
    private String destinationAddress;
    private String status;
    private String trackID;
    private boolean uniqueTrackID;
    
    
//    private Validation validator = new Validation();

    public MakeOrderController(long userID, String size, String sourceAddress, String destinationAddress) {
        this.userID = userID;
        this.postmanID = 0;
        this.price = 0;
        this.size = size;
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        this.status = "Not yet picked";
        this.trackID = getRandomWord();
        this.uniqueTrackID = false;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isUniqueTrackID() {
        return uniqueTrackID;
    }


    
    
    
    private String getRandomWord() {
    String r = "";
    for(int i = 0; i < 4; i++) {
        r += (char)(Math.random() * 26 + 97);
    }
    return r;
    }
    public ArrayList<ArrayList<String>> validateOrder(){
        Validation checkValidate = new Validation();
        ArrayList<String> validate = new ArrayList<String>();
        
        validate.clear();
        // ADD VALIDATION HERE
        if (!checkValidate.maxLength(this.sourceAddress, 30))
            validate.add("sourceAddress|maxLength");
        if (!checkValidate.minLength(this.sourceAddress, 10))
            validate.add("sourceAddress|minLength");
        if (!checkValidate.isRequired(this.sourceAddress))
            validate.add("sourceAddress|isRequired");
        if (!checkValidate.maxLength(this.destinationAddress, 30))
            validate.add("destinationAddress|maxLength");
        if (!checkValidate.minLength(this.destinationAddress, 10))
            validate.add("destinationAddress|minLength");
        if (!checkValidate.isRequired(this.destinationAddress))
            validate.add("destinationAddress|isRequired");
        if (!checkValidate.isRequired(this.size))
            validate.add("size|isRequired");
       

        ArrayList<ArrayList<String>> errList = splitListofValidateError(validate);
        return errList;
    }
    
    
    
    public boolean checkMakeOrder() {
        this.uniqueTrackID = false;
        
        
        Database db = new Database("Order");
        
        // FIND OR CREATE     // UNIQUE TrackID
        Query uniqueTrack = db.getEM().createQuery("SELECT trackID FROM Order WHERE trackID='" + this.trackID + "'", Order.class);
       
            if (uniqueTrack.getResultList().size() <= 0) {
                try {
                    // Create user
                    db.getEM().getTransaction().begin();
                    Order order = new Order(this.userID, this.postmanID, this.price, this.size, this.trackID, this.sourceAddress, this.destinationAddress, this.status);
                    db.getEM().persist(order);
                    db.getEM().getTransaction().commit();
                    db.getEM().close();
                    return true;
                } catch(Throwable error) {
                    System.out.println("CANNOT CREATE Order, PLEASE CHECK SERVER ");
                    db.getEM().close();
                    return false;
                }
            } else { // EMAIL HAS ALREADY TAKEN
                this.uniqueTrackID = true;
                return false;
            }
       
       
    }
    
}
