/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.UserDataService;
import Model.Database;
import Model.Order;
import Model.User;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * FXML Controller class
 *
 * @author 58011424
 */
public class AdminAllOrderComponent implements Initializable {
    Order currentOrder;
    String trackID;
    long id;
    @FXML
    private JFXListView listOrder;
    @FXML
    private AnchorPane editPane, allOrderPane;
    @FXML
    private Text srcName, srcAddress, srcDistrict, srcArea, srcProvince, srcZipCode, srcOther, desName, desAddress, desDistrict, desArea, desProvince, desZipCode, desOther;
    @FXML
    private JFXCheckBox invalidAddrCheck, deliveredCheck;
    @FXML
    private JFXTextField priceField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Database db = new Database("Order");
        ArrayList<String> orderString = new ArrayList<String>();
        TypedQuery<Order> orderQuery = db.getEM().createQuery("SELECT o FROM Order o",Order.class);
        List<Order> objectList = orderQuery.getResultList();
        db.getEM().close();
        for(Order o: objectList){
            orderString.add(o.toString());
        }
        ObservableList<String> obOrderString = FXCollections.observableArrayList(orderString);
        listOrder.setItems(obOrderString);
    }    
    @FXML
    public void editButton() throws IOException{
        
        Database db = new Database("Order");
        try {
            //Get a user ID from selected row 
            this.trackID = listOrder.getSelectionModel().getSelectedItem().toString().substring(0, listOrder.getSelectionModel().getSelectedItem().toString().indexOf('|'));
            Query orderQuery = db.getEM().createQuery("SELECT o FROM Order o WHERE trackID='"+this.trackID+"'");
            Order order = (Order)orderQuery.getSingleResult();
            this.id = order.getId();
            //Show sender info
            srcName.setText(order.getSenderName());
            srcAddress.setText(order.getSourceAddress());
            srcDistrict.setText(order.getSourcedistric());
            srcArea.setText(order.getSourcearea());
            srcProvince.setText(order.getSourceprovince());
            srcZipCode.setText(order.getSourcezipCode());
            srcOther.setText(order.getSourceotherAddress());
            //Show receiver inffo
            desName.setText(order.getReceiverName());
            desAddress.setText(order.getDestinationAddress());
            desDistrict.setText(order.getDestinationdistric());
            desArea.setText(order.getDestinationarea());
            desProvince.setText(order.getDestinationprovince());
            desZipCode.setText(order.getDestinationzipCode());
            desOther.setText(order.getDestinationotherAddress());
            //Toggle pane
            allOrderPane.setVisible(false);
            editPane.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void doneButton() throws IOException{
        Database db = new Database("Order");
        Order order = db.getEM().find(Order.class, this.id);
        try {
            if(deliveredCheck.selectedProperty().get() && Integer.parseInt(priceField.getText()) > 0){
                //Change status and add price
                db.getEM().getTransaction().begin();
                order.setStatus("Package was delivered");
                order.setPrice(Integer.parseInt(priceField.getText()));
                db.getEM().getTransaction().commit();
                priceField.clear();
                //Toggle pane
                allOrderPane.setVisible(true);
                editPane.setVisible(false);
                db.getEM().close();
            }
            else if(invalidAddrCheck.selectedProperty().get() && Integer.parseInt(priceField.getText()) > 0){
                //Change status and add price
                db.getEM().getTransaction().begin();
                order.setStatus("Invalid address");
                order.setPrice(Integer.parseInt(priceField.getText()));
                db.getEM().getTransaction().commit();
                priceField.clear();
                //Toggle pane
                allOrderPane.setVisible(true);
                editPane.setVisible(false);
                db.getEM().close();
            }
        } catch (Exception e) {
            
        }
    }
    @FXML
    public void refreshButton() throws IOException{
        ArrayList<String> orderString = new ArrayList<String>();
        listOrder.getItems().clear();
        Database db = new Database("Order");
        TypedQuery<Order> orderQuery = db.getEM().createQuery("SELECT o FROM Order o",Order.class);
        List<Order> objectList = orderQuery.getResultList();
        db.getEM().close();
        for(Order o: objectList){
            orderString.add(o.toString());
        }
        ObservableList<String> obOrderString = FXCollections.observableArrayList(orderString);
        listOrder.setItems(obOrderString);
    }
}
