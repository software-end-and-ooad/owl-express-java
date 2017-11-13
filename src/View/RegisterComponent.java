/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.RegisterController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Utt
 */
public class RegisterComponent implements Initializable {
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXPasswordField confirmPass;
    @FXML
    private JFXTextField tell;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField name;
    // Validate Text Field
    @FXML
    private Text usernameValidate;
    @FXML
    private Text nameValidate;
    @FXML
    private Text emailValidate;
    @FXML
    private Text tellValidate;
    @FXML
    private Text confirmPassValidate;
    @FXML
    private Text passwordValidate;
    @FXML
    private JFXButton register_button;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.usernameValidate.setVisible(false);
        this.nameValidate.setVisible(false);
        this.emailValidate.setVisible(false);
        this.tellValidate.setVisible(false);
        this.passwordValidate.setVisible(false);
        this.confirmPassValidate.setVisible(false);
    }    
    
    @FXML
    public void submitRegister() throws IOException {
        RegisterController registerController = 
                new RegisterController(
                        this.username.getText(),
                        this.password.getText(),
                        this.confirmPass.getText(),
                        this.email.getText(),
                        this.name.getText(),
                        this.tell.getText()
                );
        
        // INITIAL ERROR MESSAGE VISIBLE
        this.usernameValidate.setVisible(false);
        this.nameValidate.setVisible(false);
        this.emailValidate.setVisible(false);
        this.tellValidate.setVisible(false);
        this.passwordValidate.setVisible(false);
        this.confirmPassValidate.setVisible(false);
        
        ArrayList<ArrayList<String>> errList = registerController.validateResgister(); // Validate error list
        if( errList.size() <= 0) {
           
            if( registerController.checkRegister() == true ) { // if success all
                // SUCCESS REGISTER, THEN ROUTE TO DASHBOARD
               
                Stage stage;
                Parent root;
                stage = (Stage) this.register_button.getScene().getWindow();
                //load up OTHER FXML document
                root = FXMLLoader.load(getClass().getResource("LoginComponent.fxml"));
                //create a new scene with root and set the stage
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {  
                // CANNOT CREATE MAY BE UNIQUE USERNAME OR EMAIL
                if (registerController.getUniqueUsername()== true) {
                    this.usernameValidate.setVisible(true);
                    this.usernameValidate.setText("USERNAME ALREADY TAKEN");
                }
                if (registerController.getUniqueEmail()== true) {
                    this.emailValidate.setVisible(true);
                    this.emailValidate.setText("EMAIL ALREADY TAKEN");
                }
            }
            
        }  else { 
            // IF THERE IS SOME ERROR VALIDATE IN LIST
            for (int i = 0; i < errList.size(); i++) {
                // ============== USERNAME ============
                if (errList.get(i).get(0).equals("username")) {
                    this.usernameValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("maxLength"))
                        this.usernameValidate.setText("USERNAME MUST NO MORE 4");
                    else if (errList.get(i).get(1).equals("minLength"))
                        this.usernameValidate.setText("USERNAME MUST NO LESS 2");
                    else if (errList.get(i).get(1).equals("isRequired"))
                        this.usernameValidate.setText("USERNAME IS REQUIRED");
                }
                if (errList.get(i).get(0).equals("name")) {
                    this.nameValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("maxLength"))
                        this.nameValidate.setText("FULLNAME MUST NO MORE 20");
                    if (errList.get(i).get(1).equals("isRequired"))
                        this.nameValidate.setText("FULLNAME IS REQUIRED");
                }
                // ============== EMAIL ============
                if (errList.get(i).get(0).equals("email")) {
                    this.emailValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("isEmail"))
                        this.emailValidate.setText("EMAIL IS INVALID");
                    else if (errList.get(i).get(1).equals("isRequired"))
                        this.emailValidate.setText("EMAIL IS REQUIRED");
                }
                // ============== TELL ============
                if (errList.get(i).get(0).equals("tell")) {
                    this.tellValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("isNumeric"))
                        this.tellValidate.setText("TELL IS NOT NUMERIC");
                    else if (errList.get(i).get(1).equals("maxLength"))
                        this.tellValidate.setText("TELL MUST NO MORE 4");
                    else if (errList.get(i).get(1).equals("minLength"))
                        this.tellValidate.setText("TELL MUST NO LESS 2");
                    else if (errList.get(i).get(1).equals("isRequired"))
                        this.tellValidate.setText("TELL IS REQUIRED");
                }
                // ============== PASSWORD ============
                if (errList.get(i).get(0).equals("password")) {
                    this.passwordValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("minLength"))
                        this.passwordValidate.setText("PASSWORD MUST NO LESS 2");
                }
                // ============== CONFIRM PASSWORD ============
                if(errList.get(i).get(0).equals("confirmPass")) {
                    this.confirmPassValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("isSame"))
                        this.confirmPassValidate.setText("PASSWORD IS NOT MATCH");
                }
                
            }
        }
       
        
    }
    
}
