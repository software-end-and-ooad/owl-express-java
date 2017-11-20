/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Database;
import Model.Order;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * FXML Controller class
 *
 * @author 58011424
 */
public class AdminAllOrderComponent implements Initializable {
    ArrayList<String> orderString = new ArrayList<String>();
    @FXML
    private JFXListView listOrder;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Database db = new Database("Order");
        TypedQuery<Order> orderQuery = db.getEM().createQuery("SELECT o FROM Order o",Order.class);
        List<Order> objectList = orderQuery.getResultList();
        db.getEM().close();
        for(Order o: objectList){
            orderString.add(o.toString());
//            System.out.println(orderString.get(0));
        }
        ObservableList<String> obOrderString = FXCollections.observableArrayList(orderString);
        listOrder.setItems(obOrderString);
    }    
    
}
