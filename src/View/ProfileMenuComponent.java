/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ProfileMenuController;
import Controller.UserDataService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author 58011424
 */
public class ProfileMenuComponent implements Initializable {
    @FXML
    private AnchorPane profilePane, editPane;
    @FXML
    private Text name, tel, email, address;
    @FXML
    private Text fullnameValidate, telValidate, emailValidate, addressValidate, districValidate, areaValidate,  provinceValidate, zipCodeValidate;
    @FXML
    private JFXButton editButton, confirmButton;
    @FXML
    private JFXTextField fullnameField, emailField, telField, addressField, districField, areaField, provinceField, zipCodeField, otherField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String addressString;
        this.name.setText(UserDataService.getFullname());
        this.email.setText(UserDataService.getEmail());
        this.tel.setText(UserDataService.getTel());
        if(UserDataService.getAddress() != null)
            addressString = UserDataService.getAddress() +" "+ UserDataService.getDistric()+" "+ UserDataService.getArea()+" "+ UserDataService.getProvince()+" "+ UserDataService.getZipCode()+"\n"+ UserDataService.getOtherAddress();
        else
            addressString = "Address";
        this.address.setText(addressString);
    }    
    @FXML
    public void clickEdit(){
        //Init old data to field
        this.fullnameField.setText(UserDataService.getFullname());
        this.emailField.setText(UserDataService.getEmail());
        this.telField.setText(UserDataService.getTel());
        this.addressField.setText(UserDataService.getAddress());
        this.districField.setText(UserDataService.getDistric());
        this.areaField.setText(UserDataService.getArea());
        this.provinceField.setText(UserDataService.getProvince());
        this.zipCodeField.setText(UserDataService.getZipCode());
        this.otherField.setText(UserDataService.getOtherAddress());
                
        this.profilePane.setVisible(false);
        this.editPane.setVisible(true);
    }
    @FXML
    public void clickComfirm(){
        ProfileMenuController profileMenuController = 
                new ProfileMenuController(
                    this.fullnameField.getText(),
                    this.emailField.getText(),
                    this.telField.getText(),
                    this.addressField.getText(),
                    this.districField.getText(),
                    this.areaField.getText(),
                    this.provinceField.getText(),
                    this.zipCodeField.getText(),
                    this.otherField.getText()
                );
        // INITIAL ERROR MESSAGE VISIBLE
        this.fullnameValidate.setVisible(false);
        this.emailValidate.setVisible(false);
        this.telValidate.setVisible(false);
        this.addressValidate.setVisible(false);
        this.districValidate.setVisible(false);
        this.areaValidate.setVisible(false);
        this.provinceValidate.setVisible(false);
        this.zipCodeValidate.setVisible(false);
        
        ArrayList<ArrayList<String>> errList = profileMenuController.validateProfile(); // Validate error list
        //If no error
        if(errList.size() <= 0){
            profileMenuController.editProfile();
            //Change to profile pane
            this.profilePane.setVisible(true);
            this.editPane.setVisible(false);
            //Display on profile menu
            this.name.setText(UserDataService.getFullname());
            this.email.setText(UserDataService.getEmail());
            this.tel.setText(UserDataService.getTel());
            String addressString = UserDataService.getAddress() +" "+ UserDataService.getDistric()+" "+ UserDataService.getArea()+" "+ UserDataService.getProvince()+" "+ UserDataService.getZipCode()+"\n"+ UserDataService.getOtherAddress();
            this.address.setText(addressString);
        }
        else{
            // IF THERE IS SOME ERROR VALIDATE IN LIST
            for (int i = 0; i < errList.size(); i++) {
                // ============== FULLNAME ============
                if (errList.get(i).get(0).equals("fullname")) {
                    this.fullnameValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("maxLength"))
                        this.fullnameValidate.setText("fullname must no more than 20 characters");
                    else if (errList.get(i).get(1).equals("isRequired"))
                        this.fullnameValidate.setText("fullname is required");
                }
                // ============== EMAIL ============
                if (errList.get(i).get(0).equals("email")) {
                    this.emailValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("isEmail"))
                        this.emailValidate.setText("Email is invalid");
                    else if (errList.get(i).get(1).equals("isRequired"))
                        this.emailValidate.setText("Email is required");
                }
                // ============== TEL ============
                if (errList.get(i).get(0).equals("tel")) {
                    this.telValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("isNumeric"))
                        this.telValidate.setText("Tel must be numberic");
                    else if (errList.get(i).get(1).equals("maxLength"))
                        this.telValidate.setText("Tel must have 10 digits");
                    else if (errList.get(i).get(1).equals("minLength"))
                        this.telValidate.setText("Tel must have 10 digits");
                    else if (errList.get(i).get(1).equals("isRequired"))
                        this.telValidate.setText("Tel is required");
                }
                // ============== ADDRESS ============
                if (errList.get(i).get(0).equals("address")) {
                    this.addressValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("isRequired"))
                        this.addressValidate.setText("Address is required");
                }
                // ============== DISTRIC ============
                if (errList.get(i).get(0).equals("distric")) {
                    this.districValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("isRequired"))
                        this.districValidate.setText("Distric is required");
                }
                // ============== AREA ============
                if (errList.get(i).get(0).equals("area")) {
                    this.areaValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("isRequired"))
                        this.areaValidate.setText("Area is required");
                }
                // ============== PROVINCE ============
                if (errList.get(i).get(0).equals("province")) {
                    this.provinceValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("isRequired"))
                        this.provinceValidate.setText("Province is required");
                }
                // ============== ZIPCODE ============
                if (errList.get(i).get(0).equals("zipCode")) {
                    this.zipCodeValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("isRequired"))
                        this.zipCodeValidate.setText("Zip code is required");
                    else if (errList.get(i).get(1).equals("isNumeric"))
                        this.zipCodeValidate.setText("Invalid zip code");
                    else if (errList.get(i).get(1).equals("maxLength"))
                        this.zipCodeValidate.setText("Invalid zip code");
                    else if (errList.get(i).get(1).equals("minLength"))
                        this.zipCodeValidate.setText("Invalid zip code");
                }
            }
        }
    }
}
