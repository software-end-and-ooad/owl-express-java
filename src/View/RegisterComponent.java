/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.RegisterController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void submitRegister() throws IOException {
        RegisterController registerController = 
                new RegisterController(
                        this.username.getText(),
                        this.email.getText(),
                        this.name.getText(),
                        this.tell.getText(),
                        this.password.getText(),
                        this.confirmPass.getText()
                );
    }
    
}
