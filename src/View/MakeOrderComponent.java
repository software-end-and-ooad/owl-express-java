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
public class MakeOrderComponent implements Initializable {

    
    
    @FXML
    private Text headText;
    @FXML
    private JFXTextField sourceText;
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
    @FXML
    private JFXTextField destinationText;
    @FXML
    private JFXTextField sourceDistrictText;
    @FXML
    private Text sourceDistrictError;
    @FXML
    private Text sourceAreaError;
    @FXML
    private JFXTextField sourceProvinceText;
    @FXML
    private JFXTextField sourceZipcodeText;
    @FXML
    private Text sourceZipcodeError;
    @FXML
    private Text sourceOtherError;
    @FXML
    private JFXTextField destinationDistrictText;
    @FXML
    private JFXTextField destinationAreaText;
    @FXML
    private JFXTextField destinationProvinceText;
    @FXML
    private JFXTextField destinationZipcodeText;
    @FXML
    private JFXTextField destinationOtherText;
    @FXML
    private JFXButton enterAddressBTN;
    @FXML
    private Text destinationDistrictError;
    @FXML
    private Text destinationAreaError;
    @FXML
    private Text destinationProvinceError;
    @FXML
    private Text destinationZipcodeError;
    @FXML
    private Text destinationOtherError;
    @FXML
    private JFXTextField sourceAreaText;
    @FXML
    private JFXTextField sourceOtherText;
    @FXML
    private Text sourceProvinceError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboSize.getItems().removeAll(comboSize.getItems());
        comboSize.getItems().addAll("S","M","L","XL");
        sizeError.setVisible(false);
        sourceError.setVisible(false);
        sourceAreaError.setVisible(false);
        sourceDistrictError.setVisible(false);
        sourceProvinceError.setVisible(false);
        sourceZipcodeError.setVisible(false);
        sourceOtherError.setVisible(false);
        //
        destinationError.setVisible(false);
        destinationAreaError.setVisible(false);
        destinationDistrictError.setVisible(false);
        destinationProvinceError.setVisible(false);
        destinationZipcodeError.setVisible(false);
        destinationOtherError.setVisible(false);
    }    

    @FXML
    private void submitOrder(MouseEvent event) {
        sourceError.setVisible(false);
        destinationError.setVisible(false);
        sizeError.setVisible(false);
        MakeOrderController makeOrderController = new MakeOrderController(UserDataService.getAccountID(), comboSize.getValue(), sourceText.getText(), sourceDistrictText.getText(), sourceAreaText.getText(), sourceProvinceText.getText(), sourceZipcodeText.getText(), sourceOtherText.getText(), destinationText.getText(), destinationDistrictText.getText(), destinationAreaText.getText(), destinationProvinceText.getText(), destinationZipcodeText.getText(), destinationOtherText.getText());
         ArrayList<ArrayList<String>> errList = makeOrderController.validateOrder();
         if( errList.size() <= 0) {
           boolean submitstatus = makeOrderController.checkMakeOrder();
           while(submitstatus == false)
           {
               submitstatus = makeOrderController.checkMakeOrder();
           }
           
           submitBTN.setVisible(false);
           enterAddressBTN.setVisible(false);
           comboSize.setVisible(false);
           
           sourceText.setVisible(false);
           sourceAreaText.setVisible(false);
           sourceDistrictText.setVisible(false);
           sourceProvinceText.setVisible(false);
           sourceZipcodeText.setVisible(false);
           sourceOtherText.setVisible(false);
           //
           destinationText.setVisible(false);
           destinationAreaText.setVisible(false);
           destinationDistrictText.setVisible(false);
           destinationProvinceText.setVisible(false);
           destinationZipcodeText.setVisible(false);
           destinationOtherText.setVisible(false);
           
           sizeError.setVisible(false);
           sourceError.setVisible(false);
           sourceAreaError.setVisible(false);
           sourceDistrictError.setVisible(false);
           sourceProvinceError.setVisible(false);
           sourceZipcodeError.setVisible(false);
           sourceOtherError.setVisible(false);
           //
           destinationError.setVisible(false);
           destinationAreaError.setVisible(false);
           destinationDistrictError.setVisible(false);
           destinationProvinceError.setVisible(false);
           destinationZipcodeError.setVisible(false);
           destinationOtherError.setVisible(false);
           
           
           
            
           
           headText.setText("Your trackID is " +makeOrderController.getTrackID());
            
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
                if (errList.get(i).get(0).equals("sourcearea")) {
                    this.sourceAreaError.setVisible(true);
                    if (errList.get(i).get(1).equals("isRequired"))
                        this.sourceAreaError.setText("Source area is required");
                }
                if (errList.get(i).get(0).equals("sourcedistric")) {
                    this.sourceDistrictError.setVisible(true);
                    if (errList.get(i).get(1).equals("isRequired"))
                        this.sourceDistrictError.setText("Source district is required");
                }
                if (errList.get(i).get(0).equals("sourceprovince")) {
                    this.sourceProvinceError.setVisible(true);
                    if (errList.get(i).get(1).equals("isRequired"))
                        this.sourceProvinceError.setText("Source province is required");
                }
                if (errList.get(i).get(0).equals("sourcezipCode")) {
                    this.sourceZipcodeError.setVisible(true);
                    if (errList.get(i).get(1).equals("isRequired"))
                        this.sourceZipcodeError.setText("Source zipcode is required");
                }
                
                if (errList.get(i).get(0).equals("destinationarea")) {
                    this.destinationAreaError.setVisible(true);
                    if (errList.get(i).get(1).equals("isRequired"))
                        this.destinationAreaError.setText("Destination area is required");
                }
                if (errList.get(i).get(0).equals("destinationdistric")) {
                    this.destinationDistrictError.setVisible(true);
                    if (errList.get(i).get(1).equals("isRequired"))
                        this.destinationDistrictError.setText("Destination district is required");
                }
                if (errList.get(i).get(0).equals("destinationprovince")) {
                    this.destinationProvinceError.setVisible(true);
                    if (errList.get(i).get(1).equals("isRequired"))
                        this.destinationProvinceError.setText("Destination province is required");
                }
                if (errList.get(i).get(0).equals("destinationzipCode")) {
                    this.destinationZipcodeError.setVisible(true);
                    if (errList.get(i).get(1).equals("isRequired"))
                        this.destinationProvinceError.setText("Destination zipcode is required");
                }
                if (errList.get(i).get(0).equals("size")) {
                    this.sizeError.setVisible(true);
                    if (errList.get(i).get(1).equals("isRequired"))
                        this.sizeError.setText("Source address is required");
                }
  
            }
        }
    }

    @FXML
    private void submitAddress(MouseEvent event) {
        if(UserDataService.getAddress() != null)
        {
            sourceText.setText(UserDataService.getAddress());
        }
        if(UserDataService.getDistric()!= null)
        {
            sourceDistrictText.setText(UserDataService.getDistric());
        }
        if(UserDataService.getArea()!= null)
        {
            sourceAreaText.setText(UserDataService.getArea());
        }
        if(UserDataService.getProvince()!= null)
        {
            sourceProvinceText.setText(UserDataService.getProvince());
        }
        if(UserDataService.getZipCode()!= null)
        {
            sourceZipcodeText.setText(UserDataService.getZipCode());
        }
        if(UserDataService.getOtherAddress()!= null)
        {
            sourceOtherText.setText(UserDataService.getOtherAddress());
        }
    }
}
