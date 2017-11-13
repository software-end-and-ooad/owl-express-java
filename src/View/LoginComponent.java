/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.LoginController;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author babyjazz
 */
public class LoginComponent implements Initializable {

    @FXML
    private TextField username_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private AnchorPane login;
    @FXML
    private JFXButton login_button;
    @FXML
    private JFXButton forgotPass;
    @FXML
    private JFXButton signup_button;
    @FXML
    private ImageView exitlogin_button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void submitLogin() throws IOException {
        LoginController loginController = new LoginController(this.username_field.getText(), this.password_field.getText());
        
        if ( loginController.checkLogin() == true ) {
            // Navigate to dashboard
            Stage stage;
            Parent root;
            stage = (Stage) this.username_field.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("DashboardComponent.fxml"));
            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            System.out.println("Authentication Invalid!");
        }
    }

    @FXML
    private void clickSignUp(MouseEvent event) throws IOException {
                 Stage stage;
                Parent root;
                stage = (Stage) this.signup_button.getScene().getWindow();
                //load up OTHER FXML document
                root = FXMLLoader.load(getClass().getResource("RegisterComponent.fxml"));
                //create a new scene with root and set the stage
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
    }
}
