/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ForgotPassController;
import Controller.LocalStorage;
import Controller.LoginController;
import Controller.UserDataService;
import Model.Database;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
public class LoginComponent extends UserDataService implements Initializable {

    double xOffset;
    double yOffset;
    ForgotPassController forgotPassController;
    @FXML
    private TextField username_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private AnchorPane login, popUp;
    @FXML
    private JFXButton login_button;
    @FXML
    private JFXButton forgotPass;
    @FXML
    private JFXButton signup_button;
    @FXML
    private ImageView exitlogin_button;
    @FXML
    private Text loginValidate;
    @FXML
    private JFXCheckBox adminCheckbox;
    @FXML
    private TextField emailField;
    @FXML
    private JFXTextField verifyField;
    @FXML
    private Text usernameText, passwordText, verifyText;
    @FXML
    private Text emailValidate;
    @FXML
    private JFXButton emailButton, verifyButton, closeButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.loginValidate.setVisible(false);
    }

    @FXML
    public void submitLogin() throws IOException {
        LoginController loginController = new LoginController(this.username_field.getText(), this.password_field.getText());
        if (!adminCheckbox.selectedProperty().get()) {
            userLogin(loginController);
        } else {
            adminLogin(loginController);
        }
    }

    private void userLogin(LoginController loginController) throws IOException {
        if (loginController.userCheckLogin() == true) {
            this.loginValidate.setVisible(false);
            new LocalStorage().setAuthen(this.username_field.getText(), this.password_field.getText(), "User");
            // Navigate to dashboard
            Stage stage;
            Parent root;
            stage = (Stage) this.username_field.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("DashboardComponent.fxml"));
            root = MoveWindow.moveWindow(root, stage);
            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            this.loginValidate.setVisible(true);
        }
    }

    private void adminLogin(LoginController loginController) throws IOException {
        if (loginController.adminCheckLogin() == true) {
            this.loginValidate.setVisible(false);
            new LocalStorage().setAuthen(this.username_field.getText(), this.password_field.getText(), "Admin");
            // Navigate to dashboard
            Stage stage;
            Parent root;
            stage = (Stage) this.username_field.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("AdminDashboardComponent.fxml"));
            root = MoveWindow.moveWindow(root, stage);
            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            this.loginValidate.setVisible(true);
        }
    }

    @FXML
    private void clickSignUp(MouseEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) this.signup_button.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("RegisterComponent.fxml"));
        root = MoveWindow.moveWindow(root, stage);
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void clickForgotPass() {
        //Show E-mail field pop up
        this.popUp.setVisible(true);
        this.emailField.setVisible(true);
        this.emailButton.setVisible(true);
    }

    @FXML
    private void submitEmail() {
        forgotPassController = new ForgotPassController(this.emailField.getText());
        //If we have this email in database
        if (forgotPassController.hasUser()) {
            //Send verification code to email
            String verifyCode = forgotPassController.getRandomWord();
            String subject = "Recover your account";
            String message = "Dear Customer,\n" + "\n" + "We received a request from you about your lost account. Please enter this code to your application to recover your account\n <br /> <h1>" + verifyCode + "</h1>";
            forgotPassController.sendEmail(subject, message, verifyCode);
            //Show verify pop up
            this.verifyText.setVisible(true);
            this.verifyField.setVisible(true);
            this.verifyButton.setVisible(true);
            //Invisible previous component
            this.emailField.setVisible(false);
            this.emailField.clear();
            this.emailButton.setVisible(false);
            this.emailValidate.setVisible(false);
        } else {
            this.emailValidate.setVisible(true);
        }
    }

    @FXML
    private void submitVerify() {
        //If verification code was corrected
        if (this.verifyField.getText().compareTo(this.forgotPassController.getVerify()) == 0) {
            //Show user Username and Password and close button
            this.usernameText.setText(this.forgotPassController.getUser().getUsername());
            this.passwordText.setText(this.forgotPassController.getUser().getPassword());
            this.usernameText.setVisible(true);
            this.passwordText.setVisible(true);
            this.closeButton.setVisible(true);
            //Invisible previous component
            this.verifyText.setVisible(false);
            this.verifyField.setVisible(false);
            this.verifyField.clear();
            this.verifyButton.setVisible(false);
        }
    }

    @FXML
    private void close() {
        //Close pop up
        //Invisible all component
        this.emailField.setVisible(false);
        this.emailField.clear();
        this.emailButton.setVisible(false);
        this.emailValidate.setVisible(false);
        
        this.verifyText.setVisible(false);
        this.verifyField.setVisible(false);
        this.verifyField.clear();
        this.verifyButton.setVisible(false);
        
        this.usernameText.setVisible(false);
        this.passwordText.setVisible(false);
        this.closeButton.setVisible(false);
        this.popUp.setVisible(false);
    }

    @FXML
    private void exitApplication() {
        System.exit(0);
    }
}
