/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.RegisterController;
import Controller.SendEmailController;
import Model.Entitymanager;
import Model.Customer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Utt
 */
public class RegisterComponent implements Initializable {
    double xOffset;
    double yOffset;
    SendEmailController sendEmail;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXPasswordField confirmPass;
    @FXML
    private JFXTextField tel;
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
    private Text telValidate;
    @FXML
    private Text confirmPassValidate;
    @FXML
    private Text passwordValidate;
    @FXML
    private Text verifyText;
    @FXML
    private JFXButton register_button, login_button;
    @FXML
    private AnchorPane verifyPane;
    @FXML
    private JFXTextField verifyField;
    @FXML 
    private JFXButton verifyButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.usernameValidate.setVisible(false);
        this.nameValidate.setVisible(false);
        this.emailValidate.setVisible(false);
        this.telValidate.setVisible(false);
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
                        this.tel.getText()
                );
        
        // INITIAL ERROR MESSAGE VISIBLE
        this.usernameValidate.setVisible(false);
        this.nameValidate.setVisible(false);
        this.emailValidate.setVisible(false);
        this.telValidate.setVisible(false);
        this.passwordValidate.setVisible(false);
        this.confirmPassValidate.setVisible(false);
        
        ArrayList<ArrayList<String>> errList = registerController.validateResgister(); // Validate error list
        String verifyCode = SendEmailController.getRandomWord();
        String subject = "Verify Email Address";
        String messageText = "Thank you for registering with Owl-Express!\n" +"\n" +"To complete the registration process, verify your email address by enter this code to your application\n <br /> <h1>" + verifyCode + "</h1>";
        
        if (errList.size() <= 0) {

            if (registerController.checkRegister() == true) { // if success all
                //Verify email
                sendEmail = new SendEmailController(this.email.getText());
                sendEmail.sendEmail(subject, messageText, verifyCode);
                this.verifyPane.setVisible(true);
                this.verifyField.setVisible(true);
                this.verifyButton.setVisible(true);
                this.verifyText.setVisible(true);
                
                this.register_button.setDisable(true);
                this.login_button.setDisable(true);
            } else {
                // CANNOT CREATE MAY BE UNIQUE USERNAME OR EMAIL
                if (registerController.getUniqueUsername() == true) {
                    this.usernameValidate.setVisible(true);
                    this.usernameValidate.setText("This USERNAME is already taken");
                }
                if (registerController.getUniqueEmail() == true) {
                    this.emailValidate.setVisible(true);
                    this.emailValidate.setText("This EMAIL is already taken");
                }
            }

        }  else { 
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
    @FXML
    public void submitVerify() throws IOException{ // Submit random word from email
        if (this.verifyField.getText().compareTo(this.sendEmail.getVerify()) == 0) {
            Entitymanager db = new Entitymanager("Customer");
            try {
                // Create user
                db.getEM().getTransaction().begin();
                Customer user = new Customer(this.username.getText(), this.password.getText(), this.email.getText(), this.name.getText(), this.tel.getText());
                db.getEM().persist(user);
                db.getEM().getTransaction().commit();
                db.getEM().close();
            } catch (Throwable error) {
                System.out.println("CANNOT CREATE USER, PLEASE CHECK SERVER ");
                db.getEM().close();
            }
            this.verifyPane.setVisible(false);
            this.verifyField.setVisible(false);
            this.verifyButton.setVisible(false);
            this.verifyText.setVisible(false);
            this.verifyField.clear();
            
            this.register_button.setDisable(false);
            this.login_button.setDisable(false);
            // SUCCESS REGISTER, THEN ROUTE TO DASHBOARD
            Stage stage;
            Parent root;
            stage = (Stage) this.register_button.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("LoginComponent.fxml"));
            root = MoveWindow.moveWindow(root, stage);
            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }
    @FXML
    public void submitLogin() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) this.register_button.getScene().getWindow();
                //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("LoginComponent.fxml"));
        root = MoveWindow.moveWindow(root, stage);
                //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void exitApplication() {
            System.exit(0);
    }
}
