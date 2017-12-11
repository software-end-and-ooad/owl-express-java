/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AdminAllUserController;
import Model.Database;
import Model.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.persistence.TypedQuery;

/**
 * FXML Controller class
 *
 * @author kaogi
 */
public class AdminAllUserComponent implements Initializable {

    @FXML
    private AnchorPane allOrderPane;
    @FXML
    private JFXListView listUser;
    
    private AdminAllUserController adminAllUserController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.adminAllUserController = new AdminAllUserController();
        listUser.setItems(this.adminAllUserController.getObUserString());
        
    }    


    @FXML
    private void refreshButton(MouseEvent event) {
        listUser.setItems(this.adminAllUserController.refresh());
    }
    
}
