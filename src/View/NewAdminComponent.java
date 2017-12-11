/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import Controller.NewAdminController;
import java.util.ArrayList;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author kaogi
 */
public class NewAdminComponent implements Initializable {

    @FXML
    private Text usernameValidate;
    @FXML
    private Text nameValidate;
    @FXML
    private Text emailValidate;
    @FXML
    private Text telValidate;
    @FXML
    private Text confirmPassValidate;
    @FXML
    private Text passwordValidate;   
    @FXML
    private JFXTextField zipCode;
    @FXML
    private Text zipcodeValidate;
    @FXML
    private JFXTextField nationID;
    @FXML
    private Text narionIDValidate;
    @FXML
    private JFXPasswordField confirmPass;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField tel;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXButton register_button;
    @FXML
    private Text adminText;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.usernameValidate.setVisible(false);
        this.nameValidate.setVisible(false);
        this.emailValidate.setVisible(false);
        this.telValidate.setVisible(false);
        this.passwordValidate.setVisible(false);
        this.narionIDValidate.setVisible(false);
        this.zipcodeValidate.setVisible(false);
        this.confirmPassValidate.setVisible(false);
    }    

    @FXML
    private void submitRegister(MouseEvent event) {
        this.usernameValidate.setVisible(false);
                this.nameValidate.setVisible(false);
                this.emailValidate.setVisible(false);
                this.telValidate.setVisible(false);
                this.passwordValidate.setVisible(false);
                this.narionIDValidate.setVisible(false);
                this.zipcodeValidate.setVisible(false);
                this.confirmPassValidate.setVisible(false);
        NewAdminController newAdminController = 
                new NewAdminController(
                         nationID.getText(), name.getText(), email.getText(), tel.getText(), username.getText(), password.getText(), confirmPass.getText(),zipCode.getText()
                );
        ArrayList<ArrayList<String>> errList = newAdminController.validateResgister(); // Validate error list
        if( errList.size() <= 0) {
           
            if( newAdminController.checkRegister() == true ) { // if success all
                this.nationID.setVisible(false);
                this.name.setVisible(false);
                this.email.setVisible(false);
                this.tel.setVisible(false);
                this.username.setVisible(false);
                this.password.setVisible(false);
                this.confirmPass.setVisible(false);
                this.zipCode.setVisible(false);
                this.register_button.setVisible(false);
                this.adminText.setText("New admin added");
               
            } else {  
                // CANNOT CREATE MAY BE UNIQUE USERNAME OR EMAIL
                if (newAdminController.getUniqueUsername()== true) {
                    this.usernameValidate.setVisible(true);
                    this.usernameValidate.setText("This USERNAME is already taken");
                }
                if (newAdminController.getUniqueEmail()== true) {
                    this.emailValidate.setVisible(true);
                    this.emailValidate.setText("This EMAIL is already taken");
                }
            }
            
        }  
        else 
        { 
              // IF THERE IS SOME ERROR VALIDATE IN LIST
            for (int i = 0; i < errList.size(); i++) {
                // ============== USERNAME ============
                if (errList.get(i).get(0).equals("username")) {
                    this.usernameValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("maxLength"))
                        this.usernameValidate.setText("Username must no more than 8 characters");
                    else if (errList.get(i).get(1).equals("minLength"))
                        this.usernameValidate.setText("Username must have at least 4 characters");
                    else if (errList.get(i).get(1).equals("isRequired"))
                        this.usernameValidate.setText("Username is required");
                }
                if (errList.get(i).get(0).equals("name")) {
                    this.nameValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("maxLength"))
                        this.nameValidate.setText("Fullname must no more than 20 characters");
                    if (errList.get(i).get(1).equals("isRequired"))
                        this.nameValidate.setText("Fullname is required");
                }
                // ============== EMAIL ============
                if (errList.get(i).get(0).equals("email")) {
                    this.emailValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("isEmail"))
                        this.emailValidate.setText("Email is invalid");
                    else if (errList.get(i).get(1).equals("isRequired"))
                        this.emailValidate.setText("Email is required");
                }
                // ============== TELL ============
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
                
                 // ============== Nation ID ============
                if (errList.get(i).get(0).equals("nationID")) {
                    this.narionIDValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("isNumeric"))
                        this.narionIDValidate.setText("nationID must be numberic");
                    else if (errList.get(i).get(1).equals("maxLength"))
                        this.narionIDValidate.setText("nationID must have 13 digits");
                    else if (errList.get(i).get(1).equals("minLength"))
                        this.narionIDValidate.setText("nationID must have 13 digits");
                    else if (errList.get(i).get(1).equals("isRequired"))
                        this.narionIDValidate.setText("nationID is required");
                }
                
                // ============== Zipcode ============
                if (errList.get(i).get(0).equals("zipcode")) {
                    this.zipcodeValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("isNumeric"))
                        this.zipcodeValidate.setText("zipcode must be numberic");
                    else if (errList.get(i).get(1).equals("maxLength"))
                        this.zipcodeValidate.setText("zipcode must have 5 digits");
                    else if (errList.get(i).get(1).equals("minLength"))
                        this.zipcodeValidate.setText("zipcode must have 5 digits");
                    else if (errList.get(i).get(1).equals("isRequired"))
                        this.zipcodeValidate.setText("zipcode is required");
                }
                
                // ============== PASSWORD ============
                if (errList.get(i).get(0).equals("password")) {
                    this.passwordValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("minLength"))
                        this.passwordValidate.setText("Password must have at least 2 characters");
                }
                // ============== CONFIRM PASSWORD ============
                if(errList.get(i).get(0).equals("confirmPass")) {
                    this.confirmPassValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("isSame"))
                        this.confirmPassValidate.setText("Password is not match");
                }
          
            }
    
        }
    }
    
    }
