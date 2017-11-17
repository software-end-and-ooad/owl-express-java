/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.UserDataService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
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
public class ProfileMenuComponent implements Initializable {
    @FXML
    private AnchorPane profilePane, editPane;
    @FXML
    private Text name, tel, email, address;
    @FXML
    private JFXButton editButton, confirmButton;
    @FXML
    private JFXTextField fullnameField, emailField, telField, districField, areaField, provinceField, zipCodeField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.name.setText(UserDataService.getFullname());
        this.email.setText(UserDataService.getEmail());
        this.tel.setText(UserDataService.getTel());
        String addressString = UserDataService.getAddress() +" "+ UserDataService.getDistric()+" "+ UserDataService.getArea()+"\n"+ UserDataService.getAddressDetail();
        this.address.setText(addressString);
    }    
    @FXML
    public void clickEdit(){
        this.profilePane.setVisible(false);
        this.editPane.setVisible(true);
    }
    @FXML
    public void clickComfirm(){
        this.profilePane.setVisible(true);
        this.editPane.setVisible(false);
    }
}
