/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owlexpress;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author babyjazz
 */
public class LoginController implements Initializable {
    @FXML
    private TextField username_field;
    @FXML
    private PasswordField password_field;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void submitLogin() {
         if(username_field.getText().compareTo("root") == 0 && password_field.getText().compareTo("root") == 0)
            System.out.println("Authentication Passed! :D");
         else
             System.out.println("Authentication Invalid!");
    }
    
}
