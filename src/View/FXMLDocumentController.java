/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 *
 * @author Utt
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ImageView  btn_user, btn_noti, btn_oder, btn_exit, exitlogin_button;
    @FXML
    private AnchorPane home, user, notification, oder, login, btn_home;
    @FXML
    private ListView notiList;
    @FXML
    private JFXTextField name_field;
    @FXML
    private Text forgotPass;
    @FXML
    private JFXButton order_button, refresh_button, login_button, signup_button;
    
    public String page;
    
    @FXML
    private void pageButton(MouseEvent event) {
        if(event.getTarget() == btn_home){
            home.setVisible(true);
            user.setVisible(false);
            notification.setVisible(false);
            oder.setVisible(false);
        }
        else if(event.getTarget() == btn_user){
            home.setVisible(false);
            user.setVisible(true);
            notification.setVisible(false);
            oder.setVisible(false);
        }
        else if(event.getTarget() == btn_noti){
            home.setVisible(false);
            user.setVisible(false);
            notification.setVisible(true);
            oder.setVisible(false);
        }
        else if(event.getTarget() == btn_oder){
            home.setVisible(false);
            user.setVisible(false);
            notification.setVisible(false);
            oder.setVisible(true);
        }
        else if(event.getTarget() == btn_exit){
            System.exit(0);
        }
    }
    @FXML
    private void orderButton(MouseEvent event) {
        //Store data
        System.out.print(name_field.getText());
        name_field.clear();
    }
    @FXML
    private void refresh(MouseEvent event){
        //Show updated status
        notiList.getItems().addAll("list");
    }
    @FXML
    private void loginButton(MouseEvent event){
       
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}
