/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AdminAllOrderController;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
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
    private String trackID;
    private AdminAllOrderController adminAllOrderController;
    @FXML
    private JFXListView listOrder;
    @FXML
    private AnchorPane editPane, allOrderPane;
    @FXML
    private Text srcName, srcAddress, srcDistrict, srcArea, srcProvince, srcZipCode, srcOther, desName, desAddress, desDistrict, desArea, desProvince, desZipCode, desOther;
    @FXML
    private JFXTextField priceField;
    @FXML
    private ChoiceBox<String> statusMenu;
    @FXML
    private Text priceValidate;
    String selected;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.adminAllOrderController = new AdminAllOrderController();
        listOrder.setItems(this.adminAllOrderController.getObOrderString());
    }    
    @FXML
    public void editButton() throws IOException{
        
        try {
            //Get a user ID from selected row 
            this.trackID = listOrder.getSelectionModel().getSelectedItem().toString().substring(0, listOrder.getSelectionModel().getSelectedItem().toString().indexOf(' '));
            this.adminAllOrderController.findOrder(this.trackID);
            //Set current price to pricefield and set current status
            Long priceInt = new Long(this.adminAllOrderController.getOrder().getPrice());
            if(this.adminAllOrderController.getOrder().getPrice() != 0)
                this.priceField.setText(priceInt.toString());
            if(this.adminAllOrderController.getOrder().getStatus() != null)
                statusMenu.setValue(this.adminAllOrderController.getOrder().getStatus());
            else
                statusMenu.setValue("Waiting for collection");
            //Show sender info
            srcName.setText(this.adminAllOrderController.getOrder().getSenderName());
            srcAddress.setText(this.adminAllOrderController.getOrder().getSourceAddress());
            srcDistrict.setText(this.adminAllOrderController.getOrder().getSourcedistric());
            srcArea.setText(this.adminAllOrderController.getOrder().getSourcearea());
            srcProvince.setText(this.adminAllOrderController.getOrder().getSourceprovince());
            srcZipCode.setText(this.adminAllOrderController.getOrder().getSourcezipCode());
            srcOther.setText(this.adminAllOrderController.getOrder().getSourceotherAddress());
            //Show receiver info
            desName.setText(this.adminAllOrderController.getOrder().getReceiverName());
            desAddress.setText(this.adminAllOrderController.getOrder().getDestinationAddress());
            desDistrict.setText(this.adminAllOrderController.getOrder().getDestinationdistric());
            desArea.setText(this.adminAllOrderController.getOrder().getDestinationarea());
            desProvince.setText(this.adminAllOrderController.getOrder().getDestinationprovince());
            desZipCode.setText(this.adminAllOrderController.getOrder().getDestinationzipCode());
            desOther.setText(this.adminAllOrderController.getOrder().getDestinationotherAddress());
            //Set status option
            statusMenu.getItems().addAll("Waiting for collection", "Collected", "Arrived at sorting center", "Despatched from sorting center", "Arrived at local office", "Out for delivery", "Delivered", "Invalid address");
            //Toggle pane
            allOrderPane.setVisible(false);
            editPane.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void doneButton() throws IOException{
        this.selected = this.statusMenu.getValue();//Get value from ChoiceBox
        System.out.println(this.selected);
        try {
            if( !this.selected.isEmpty() && Integer.parseInt(priceField.getText()) > 0){
                this.priceValidate.setVisible(false);
                //Change status and add price
                this.adminAllOrderController.updateOrder(this.selected, Integer.parseInt(priceField.getText()));
                priceField.clear();
                //Toggle pane
                allOrderPane.setVisible(true);
                editPane.setVisible(false);
                
                this.statusMenu.getItems().clear();
                this.adminAllOrderController = new AdminAllOrderController();
                listOrder.setItems(this.adminAllOrderController.getObOrderString());
            }
        } catch (Exception e) {
            this.priceValidate.setVisible(true);
        }
    }
}
