/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.User;
import javax.persistence.Query;

/**
 *
 * @author 58011424
 */
public class ForgotPassController extends SendEmailController{
    private User user;
    public ForgotPassController(String to) {
        super(to);
    }
    public boolean hasUser(){
        Database db = new Database("User");
        try {
            Query userQuery = db.getEM().createQuery("SELECT u FROM User u WHERE email='"+ super.to +"'");
            user = (User)userQuery.getSingleResult();
            return true;
        } catch (Exception e) {
            System.out.println("We don't this email in database.");
            return false;
        }
    }
    public User getUser(){
        return this.user;
    }
}
