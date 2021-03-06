package View;

import Controller.LocalStorage;
import Controller.SendEmailController;
import Controller.UserDataService;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Utt
 */
public class DashboardComponent implements Initializable {

    @FXML
    private AnchorPane scene_area;
    @FXML
    private JFXButton checkPackageBTN;
    @FXML
    private Text usernameText;
    @FXML
    private AnchorPane selOrder, selCheckPack, selHistory, selProfile;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usernameText.setText(UserDataService.getUsername());
        //Highlight transparent
        this.selOrder.setVisible(false);
        this.selCheckPack.setVisible(false);
        this.selHistory.setVisible(false);
        this.selProfile.setVisible(false);
    }
    @FXML
    private void orderButton(MouseEvent event) throws IOException {
        AnchorPane screen_page = FXMLLoader.load(this.getClass().
                getResource("MakeOrderComponent.fxml"));
        this.scene_area.getChildren().setAll(screen_page);
        //Highlight selected menu
        this.selOrder.setVisible(true);
        this.selCheckPack.setVisible(false);
        this.selHistory.setVisible(false);
        this.selProfile.setVisible(false);
    }
    @FXML
    private void checkPackage(MouseEvent event)throws IOException {
        AnchorPane screen_page = FXMLLoader.load(this.getClass().
                getResource("CheckOrderComponent.fxml"));
        this.scene_area.getChildren().setAll(screen_page);
        //Highlight selected menu
        this.selOrder.setVisible(false);
        this.selCheckPack.setVisible(true);
        this.selHistory.setVisible(false);
        this.selProfile.setVisible(false);
    }
    @FXML
    private void historyButton(MouseEvent event) throws IOException {
        AnchorPane screen_page = FXMLLoader.load(this.getClass().
                getResource("HistoryComponent.fxml"));
        this.scene_area.getChildren().setAll(screen_page);
        //Highlight selected menu
        this.selOrder.setVisible(false);
        this.selCheckPack.setVisible(false);
        this.selHistory.setVisible(true);
        this.selProfile.setVisible(false);
    }
    @FXML
    private void profileButton(MouseEvent event) throws IOException {
        AnchorPane screen_page = FXMLLoader.load(this.getClass().
                getResource("ProfileMenuComponent.fxml"));
        this.scene_area.getChildren().setAll(screen_page);
        //Highlight selected menu
        this.selOrder.setVisible(false);
        this.selCheckPack.setVisible(false);
        this.selHistory.setVisible(false);
        this.selProfile.setVisible(true);
    }
    @FXML
    private void logoutButton(MouseEvent event) throws IOException {
        
        new LocalStorage().resetAuthen();
        
        Stage stage;
        Parent root;
        stage = (Stage) this.scene_area.getScene().getWindow();
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
