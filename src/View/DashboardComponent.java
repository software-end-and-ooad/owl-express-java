/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Utt
 */
public class DashboardComponent implements Initializable {

    @FXML
    private ImageView  btn_user, btn_noti, btn_oder, exitlogin_button;
    @FXML
    private AnchorPane scene_area;
    @FXML
    private JFXButton order_button, refresh_button, login_button, signup_button;
    
    
    @FXML
    private void orderButton(MouseEvent event) throws IOException {
        AnchorPane screen_page = FXMLLoader.load(this.getClass().getResource("LoginComponent.fxml"));
        this.scene_area.getChildren().setAll(screen_page);
    }
    
    @FXML
    private void exitApplication() {
            System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}