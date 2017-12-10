/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Order;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author 58011424
 */
public class AdminAllOrderController {
    Order order;
    ObservableList<String> obOrderString;//List of all order
    Database db;
    public AdminAllOrderController(){
        this.db = new Database("Order");
        ArrayList<String> orderString = new ArrayList<String>();
        TypedQuery<Order> orderQuery = this.db.getEM().createQuery("SELECT o FROM Order o",Order.class);
        List<Order> objectList = orderQuery.getResultList();

        for(Order o: objectList){
            orderString.add(o.toString());
        }
        this.obOrderString = FXCollections.observableArrayList(orderString);
    }
    public void findOrder(String trackID){
        Query orderQuery = this.db.getEM().createQuery("SELECT o FROM Order o WHERE trackID='" + trackID + "'");
        Order order = (Order) orderQuery.getSingleResult();
        this.order = order;
    }
    public void updateOrder (String status, long price){
        this.db.getEM().getTransaction().begin();
        this.order.setStatus(status);
        this.order.setPrice(price);
        this.db.getEM().getTransaction().commit();
        this.db.getEM().close();
    }
    public Order getOrder() {
        return order;
    }

    public ObservableList<String> getObOrderString() {
        return obOrderString;
    }
}
