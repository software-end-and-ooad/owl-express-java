/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AdminDataService;
import Controller.AdminProfileController;
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
public class AdminProfileComponent implements Initializable {
    @FXML
    private AnchorPane profilePane, editPane;
    @FXML
    private Text name, tel, email, zipCode;
    @FXML
    private Text fullnameValidate, telValidate, emailValidate, zipCodeValidate, nationIDValidate;
    @FXML
    private JFXTextField fullnameField, emailField, telField, zipCodeField, nationIDField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.name.setText(AdminDataService.getFullname());
        this.email.setText(AdminDataService.getEmail());
        this.tel.setText(AdminDataService.getTel());
        this.zipCode.setText(AdminDataService.getZipCode());
    } 
    @FXML
    public void clickEdit(){
        //Init old data to field
        this.fullnameField.setText(AdminDataService.getFullname());
        this.emailField.setText(AdminDataService.getEmail());
        this.telField.setText(AdminDataService.getTel());
        this.nationIDField.setText(AdminDataService.getNationID());
        this.zipCodeField.setText(AdminDataService.getZipCode());
                
        this.profilePane.setVisible(false);
        this.editPane.setVisible(true);
    }
    @FXML
    public void clickComfirm(){
        AdminProfileController adminProfileController = 
                new AdminProfileController(
                    this.fullnameField.getText(),
                    this.emailField.getText(),
                    this.telField.getText(),
                    this.zipCodeField.getText(),
                    this.nationIDField.getText()
                );
        // INITIAL ERROR MESSAGE VISIBLE
        this.fullnameValidate.setVisible(false);
        this.emailValidate.setVisible(false);
        this.telValidate.setVisible(false);
        this.zipCodeValidate.setVisible(false);
        this.nationIDValidate.setVisible(false);
        
        ArrayList<ArrayList<String>> errList = adminProfileController.validateProfile(); // Validate error list
        //If no error
        if(errList.size() <= 0){
            adminProfileController.editProfile();
            //Change to profile pane
            this.profilePane.setVisible(true);
            this.editPane.setVisible(false);
            //Display on profile menu
            this.fullnameField.setText(AdminDataService.getFullname());
            this.emailField.setText(AdminDataService.getEmail());
            this.telField.setText(AdminDataService.getTel());
            this.nationIDField.setText(AdminDataService.getNationID());
            this.zipCodeField.setText(AdminDataService.getZipCode());
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
                 // ============== NATIONID ============
                if (errList.get(i).get(0).equals("nationID")) {
                    this.nationIDValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("isNumeric"))
                        this.nationIDValidate.setText("Nation No. must be numberic");
                    else if (errList.get(i).get(1).equals("maxLength"))
                        this.nationIDValidate.setText("Nation No. must have 13 digits");
                    else if (errList.get(i).get(1).equals("minLength"))
                        this.nationIDValidate.setText("Nation No. must have 13 digits");
                    else if (errList.get(i).get(1).equals("isRequired"))
                        this.nationIDValidate.setText("Nation No. is required");
                }
            }
        }
    }
}
