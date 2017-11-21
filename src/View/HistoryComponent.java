/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DataService;
import Controller.HistoryController;
import Model.Order;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Perth
 */
public class HistoryComponent implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ListView orderList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        HistoryController checking = new HistoryController(DataService.getAccountID());
        List<Order> queriedList = checking.HistoryFinder();
        
        if(queriedList!=null){
            for(Order l:queriedList)
            {
                orderList.getItems().add("TrackID: " + l.getTrackID() + "\t\t Size: " + l.getSize() + "\t\t Price: " + l.getPrice() + "\t\t Sender's Name: " + l.getSenderName() + "\t\t Receiver's name: " + l.getReceiverName());
            }
            
        }
              
    }    
    
}
