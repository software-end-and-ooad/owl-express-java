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
    private long price;
    private String size;
    private String trackID;
    private String sourceAddress;
    private String destinationAddress;
    private String status;

    public Order(long userID, String size, String sourceAddress, String destinationAddress) {
        this.userID = userID;
        this.postmanID = 0;
        this.size = size;
        this.trackID = getRandomWord();
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        this.status = "Not yet picked";
    }
    
    private String getRandomWord() {
    String r = "";
    for(int i = 0; i < 4; i++) {
        r += (char)(Math.random() * 26 + 97);
    }
    return r;
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

    public String getTrackID() {
        return trackID;
    }

    public void setTrackID(String trackID) {
        this.trackID = trackID;
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
