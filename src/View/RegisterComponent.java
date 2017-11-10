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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.usernameValidate.setVisible(false);
        this.nameValidate.setVisible(false);
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
        
        ArrayList<ArrayList<String>> errList = registerController.validateResgister();
        if( errList.size() <= 0) {
            this.usernameValidate.setVisible(false);
            this.nameValidate.setVisible(false);
            
            if( registerController.checkRegister() == true ) {
                
                System.out.println("ROUTE TO OTHER PAGE");
            }
        }  else {
            System.out.println(errList);
            for (int i = 0; i < errList.size(); i++) {
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
                }
            }
        }
       
        
    }
    
}
