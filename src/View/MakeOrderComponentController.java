/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.MakeOrderController;
import Controller.UserDataService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kaogi
 */
public class MakeOrderComponentController implements Initializable {

    
    
    @FXML
    private Text headText;
    @FXML
    private JFXTextField sourceText;
    @FXML
    private JFXTextField destinationBox;
    @FXML
    private Text sourceError;
    @FXML
    private Text destinationError;
    @FXML
    private JFXComboBox<String> comboSize;
    @FXML
    private JFXButton submitBTN;
    @FXML
    private Text sizeError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboSize.getItems().removeAll(comboSize.getItems());
        comboSize.getItems().addAll("S","M","L","XL");
        sourceError.setVisible(false);
        destinationError.setVisible(false);
        sizeError.setVisible(false);
    }    

    @FXML
    private void submitOrder(MouseEvent event) {
        sourceError.setVisible(false);
        destinationError.setVisible(false);
        sizeError.setVisible(false);
        MakeOrderController makeOrderController = new MakeOrderController(UserDataService.getAccountID(), comboSize.getValue(), sourceText.getText(), destinationBox.getText());
         ArrayList<ArrayList<String>> errList = makeOrderController.validateOrder();
         if( errList.size() <= 0) {
           boolean submitstatus = makeOrderController.checkMakeOrder();
           while(submitstatus == false)
           {
               submitstatus = makeOrderController.checkMakeOrder();
           }
           
           submitBTN.setVisible(false);
           comboSize.setVisible(false);
           sourceText.setVisible(false);
           destinationBox.setVisible(false);
           headText.setText("Order success!!");
            
         }
         else
         {
             for (int i = 0; i < errList.size(); i++) {
                
                if (errList.get(i).get(0).equals("destinationAddress")) {
                    this.destinationError.setVisible(true);
                    if (errList.get(i).get(1).equals("maxLength"))
                        this.destinationError.setText("Destination address must no more than 30 characters");
                    else if (errList.get(i).get(1).equals("minLength"))
                        this.destinationError.setText("Destination address must have at least 10 characters");
                    else if (errList.get(i).get(1).equals("isRequired"))
                        this.destinationError.setText("Destination address is required");
                }
                
                if (errList.get(i).get(0).equals("sourceAddress")) {
                    this.sourceError.setVisible(true);
                    if (errList.get(i).get(1).equals("maxLength"))
                        this.destinationError.setText("Source address must no more than 30 characters");
                    else if (errList.get(i).get(1).equals("minLength"))
                        this.destinationError.setText("Source address must have at least 10 characters");
                    else if (errList.get(i).get(1).equals("isRequired"))
                        this.destinationError.setText("Source address is required");
                }
                
                if (errList.get(i).get(0).equals("size")) {
                    this.sizeError.setVisible(true);
                    if (errList.get(i).get(1).equals("isRequired"))
                        this.sizeError.setText("Source address is required");
                }
                
                
            }
            
        }
    }

    
    
}
