package View;

import Controller.DataService;
import Controller.HistoryController;
import Model.Order;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Perth
 */
public class HistoryComponent implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTextArea orderList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String text="\n";
        HistoryController checking = new HistoryController(DataService.
                getAccountID());
        List<Order> queriedList = checking.HistoryFinder();
        
        orderList.setBorder(null);
        
        if(queriedList!=null){
            for(Order l:queriedList)
            {
                text = text + "TrackID : " + l.getTrackID()  + "\t\t Size : " + 
                        l.getSize() + "\t\t Price : " + l.getPrice() + 
                        "\nSender's Name  :\t" + l.getSenderName() + 
                        "\nReceiver's name :\t" + l.getReceiverName()+"\n"+
                       "___________________________________________________"
                        + "________________________________________________"
                        + "_____________________________"+"\n\n";
            }
            orderList.setText(text);
        }           
    }       
}
