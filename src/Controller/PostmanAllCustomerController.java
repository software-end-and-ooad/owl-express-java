/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Korkao
 */

import Model.Entitymanager;
import Model.Customer;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class PostmanAllCustomerController {
    
    Customer user;
    private ObservableList<String> obUserString;//List of all user
    private Entitymanager db;
    public PostmanAllCustomerController(){
        this.db = new Entitymanager("Customer");
        ArrayList<String> userString = new ArrayList<String>();
        TypedQuery<Customer> userQuery = this.db.getEM().createQuery("SELECT u FROM Customer u",Customer.class);
        List<Customer> objectList = userQuery.getResultList();

        for(Customer u: objectList){
            userString.add(u.toString());
        }
        this.obUserString = FXCollections.observableArrayList(userString);
    }
    
    public ObservableList<String> getObUserString() {
        return obUserString;
    }
    
    public ObservableList refresh()
    {
        this.db = new Entitymanager("Customer");
        ArrayList<String> userString = new ArrayList<String>();
        TypedQuery<Customer> userQuery = this.db.getEM().createQuery("SELECT u FROM Customer u",Customer.class);
        List<Customer> objectList = userQuery.getResultList();

        for(Customer u: objectList){
            userString.add(u.toString());
        }
        this.obUserString = FXCollections.observableArrayList(userString);
        
        return obUserString;
    }
    
    
}
