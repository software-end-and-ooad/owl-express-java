/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Utt
 */
import java.io.Serializable;
import javax.persistence.*;
 
@Entity
public class Order implements Serializable{

    @Id @GeneratedValue
    private long id;
    private long userID;
    private long postmanID;
    private String sourceAddress;
    private String destinationAddress;
    private String status;

    public Order(long userID, long postmanID, String sourceAddress, String destinationAddress, String status) {
        this.userID = userID;
        this.postmanID = postmanID;
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        this.status = status;
    }

    public long getUserID() {
        return userID;
    }

    public long getPostmanID() {
        return postmanID;
    }

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getuserID() {
        return userID;
    }

    public void setuserID(long userID) {
        this.userID = userID;
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


    
}
