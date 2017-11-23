/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CheckOrderController;
import Controller.Validation;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author kaogi
 */
public class CheckOrderComponent implements Initializable {

    @FXML
    private JFXTextField searchBox;
    @FXML
    private JFXButton searchBTN;
    @FXML
    private Text errorText;
    @FXML
    private Text headText;
    @FXML
    private Text resultText;
    @FXML
    private Text resultText2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        resultText.setVisible(false);
        resultText2.setVisible(false);
        errorText.setVisible(false);
    }    

    @FXML
    private void submitSearch(MouseEvent event) {
        Validation validator = new Validation();
        if(validator.isRequired(searchBox.getText())){
            if(validator.minLength(searchBox.getText(), 4)&&validator.maxLength(searchBox.getText(), 4)){
                CheckOrderController checking = new CheckOrderController(searchBox.getText());
                if(checking.checkOrderFinder())
                {
                    headText.setText("Order from " + checking.getSenderName());
                    resultText.setText("to " + checking.getReceiverName());
                    searchBox.setVisible(false);
                    resultText.setVisible(true);
                    resultText2.setVisible(true);
                    resultText2.setText("Status : " + checking.getStatus());
                    
                    errorText.setVisible(false);
                    searchBTN.setVisible(false);
                }
                else
                {
                    errorText.setText("Cannot found Order with this trackID");
                    errorText.setVisible(true);
                }
                
            }
            else
            {
                errorText.setText("TrackID has four charcter!!");
                errorText.setVisible(true);
            }
            
        }
        else
        {
            errorText.setText("TrackID is required!!");
            errorText.setVisible(true);
        }
        
    }

  
    
}
