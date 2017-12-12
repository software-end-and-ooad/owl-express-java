/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entitymanager;
import Model.Customer;
import javax.persistence.Query;

/**
 *
 * @author 58011424
 */
public class ForgotPassController extends SendEmailController{
    private Customer user;
    public ForgotPassController(String to) {
        super(to);
    }
    public boolean hasUser(){
        Entitymanager db = new Entitymanager("Customer");
        try {
            Query userQuery = db.getEM().createQuery("SELECT u FROM Customer u WHERE email='"+ super.to +"'");
            user = (Customer)userQuery.getSingleResult();
            return true;
        } catch (Exception e) {
            System.out.println("We don't have this email in database.");
            return false;
        }
    }
    public Customer getUser(){
        return this.user;
    }
}
