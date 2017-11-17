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
public class OrderModel implements Serializable{

    @Id
    private long id;
    private long OrderedbyUserID;
    private String sourceAddress;
    private String destinationAddress;
    private String status;

    public OrderModel(long id, long OrderedbyUserID, String sourceAddress, String destinationAddress, String status) {
        this.id = id;
        this.OrderedbyUserID = OrderedbyUserID;
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderedbyUserID() {
        return OrderedbyUserID;
    }

    public void setOrderedbyUserID(long OrderedbyUserID) {
        this.OrderedbyUserID = OrderedbyUserID;
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
