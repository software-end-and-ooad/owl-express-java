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

import Model.Database;
import Model.User;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class AdminAllUserController {
    
    User user;
    private ObservableList<String> obUserString;//List of all user
    private Database db;
    public AdminAllUserController(){
        this.db = new Database("User");
        ArrayList<String> userString = new ArrayList<String>();
        TypedQuery<User> userQuery = this.db.getEM().createQuery("SELECT u FROM User u",User.class);
        List<User> objectList = userQuery.getResultList();

        for(User u: objectList){
            userString.add(u.toString());
        }
        this.obUserString = FXCollections.observableArrayList(userString);
    }
    
    public ObservableList<String> getObUserString() {
        return obUserString;
    }
    
    public ObservableList refresh()
    {
        this.db = new Database("User");
        ArrayList<String> userString = new ArrayList<String>();
        TypedQuery<User> userQuery = this.db.getEM().createQuery("SELECT u FROM User u",User.class);
        List<User> objectList = userQuery.getResultList();

        for(User u: objectList){
            userString.add(u.toString());
        }
        this.obUserString = FXCollections.observableArrayList(userString);
        
        return obUserString;
    }
    
    
}
