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

    public Order(long userID, long postmanID, long price, String size, String trackID, String sourceAddress, 
                String sourcedistric,
                String sourcearea,
                String sourceprovince,
                String sourcezipCode,
                String sourceotherAddress,
                String destinationAddress, 
                String destinationdistric,
                String destinationarea,
                String destinationprovince,
                String destinationzipCode,
                String destinationotherAddress,
                String status) {
        this.userID = userID;
        this.postmanID = postmanID;
        this.price = price;
        this.size = size;
        this.trackID = trackID;
        this.sourceAddress = sourceAddress;
        this.sourcedistric = sourcedistric;
        this.sourcearea = sourcearea;
        this.sourceprovince = sourceprovince;
        this.sourcezipCode = sourcezipCode;
        this.sourceotherAddress = sourceotherAddress;
        this.destinationAddress = destinationAddress;
        this.destinationdistric = destinationdistric;
        this.destinationarea = destinationarea;
        this.destinationprovince = destinationprovince;
        this.destinationzipCode = destinationzipCode;
        this.destinationotherAddress = destinationotherAddress;
        this.status = status;
    }

    public String getSourcedistric() {
        return sourcedistric;
    }

    public void setSourcedistric(String sourcedistric) {
        this.sourcedistric = sourcedistric;
    }

    public String getSourcearea() {
        return sourcearea;
    }

    public void setSourcearea(String sourcearea) {
        this.sourcearea = sourcearea;
    }

    public String getSourceprovince() {
        return sourceprovince;
    }

    public void setSourceprovince(String sourceprovince) {
        this.sourceprovince = sourceprovince;
    }

    public String getSourcezipCode() {
        return sourcezipCode;
    }

    public void setSourcezipCode(String sourcezipCode) {
        this.sourcezipCode = sourcezipCode;
    }

    public String getSourceotherAddress() {
        return sourceotherAddress;
    }

    public void setSourceotherAddress(String sourceotherAddress) {
        this.sourceotherAddress = sourceotherAddress;
    }

    public String getDestinationdistric() {
        return destinationdistric;
    }

    public void setDestinationdistric(String destinationdistric) {
        this.destinationdistric = destinationdistric;
    }

    public String getDestinationarea() {
        return destinationarea;
    }

    public void setDestinationarea(String destinationarea) {
        this.destinationarea = destinationarea;
    }

    public String getDestinationprovince() {
        return destinationprovince;
    }

    public void setDestinationprovince(String destinationprovince) {
        this.destinationprovince = destinationprovince;
    }

    public String getDestinationzipCode() {
        return destinationzipCode;
    }

    public void setDestinationzipCode(String destinationzipCode) {
        this.destinationzipCode = destinationzipCode;
    }

    public String getDestinationotherAddress() {
        return destinationotherAddress;
    }

    public void setDestinationotherAddress(String destinationotherAddress) {
        this.destinationotherAddress = destinationotherAddress;
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
