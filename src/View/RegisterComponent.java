/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.RegisterController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Utt
 */
public class RegisterComponent implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPass;
    @FXML
    private TextField tell;
    @FXML
    private TextField email;
    @FXML
    private TextField name;
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
            if( registerController.checkRegister() == true ) {
                
                System.out.println("ROUTE TO OTHER PAGE");
            }
        }  else { // If there is some error
            for (int i = 0; i < errList.size(); i++) {
                // ============== USERNAME ============
                if (errList.get(i).get(0).equals("username")) {
                    this.usernameValidate.setVisible(true);
                    if (errList.get(i).get(1).equals("maxLength"))
                        this.usernameValidate.setText("USERNAME MUST NO MORE 4");
                    else if (errList.get(i).get(1).equals("minLength"))
                        this.usernameValidate.setText("USERNAME MUST NO LESS 2");
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
                    // NOT FINISH YET, OH SHIT!
            }
        }
       
        
    }
    
}
