/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
    @FXML
    private JFXButton editButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Database db = new Database("User");
        ArrayList<String> userString = new ArrayList<String>();
        TypedQuery<User> userQuery = db.getEM().createQuery("SELECT u FROM User u", User.class);
        List<User> objectList = userQuery.getResultList();
        db.getEM().close();
        for(User u: objectList){
            userString.add(u.toString());
        }
        ObservableList<String> obUserString = FXCollections.observableArrayList(userString);
        listUser.setItems(obUserString);
    }    

    @FXML
    private void editButton(MouseEvent event) {
    }

    @FXML
    private void refreshButton(MouseEvent event) {
        Database db = new Database("User");
        ArrayList<String> userString = new ArrayList<String>();
        TypedQuery<User> userQuery = db.getEM().createQuery("SELECT u FROM User u",User.class);
        List<User> objectList = userQuery.getResultList();
        db.getEM().close();
        for(User u: objectList){
            userString.add(u.toString());
        }
        ObservableList<String> obUserString = FXCollections.observableArrayList(userString);
        listUser.setItems(obUserString);
    }
    
}
