package View;
import Controller.PostmanDataService;
import Controller.LocalStorage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
 * FXML Controller class
 * @author kaogi
 */
public class PostmanDashboardComponent implements Initializable {
    @FXML
    private Text username, textAllUser, textAddAdmin;
    @FXML
    private ImageView orderMenu, imgAllUser, imgAddAdmin;
    @FXML
    private AnchorPane scene_area;
    @FXML
    private AnchorPane selAllOrder, selAllUserDetail, selAddAdmin, selProfile;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.username.setText(PostmanDataService.getUsername());
        //Highlight transparent
        this.selAllOrder.setVisible(false);
        this.selAddAdmin.setVisible(false);
        this.selAllUserDetail.setVisible(false);
        this.selProfile.setVisible(false);
        if (PostmanDataService.getRole().compareTo("Postman") == 0) {
            this.imgAddAdmin.setVisible(false);
            this.textAddAdmin.setVisible(false);
        }
       
    }    
    @FXML
    private void orderClick(MouseEvent event) throws IOException {
        AnchorPane screen_page = FXMLLoader.load(this.getClass().
                getResource("PostmanAllOrderComponent.fxml"));
        this.scene_area.getChildren().setAll(screen_page);
        //Highlight selected menu
        this.selAllOrder.setVisible(true);
        this.selAddAdmin.setVisible(false);
        this.selAllUserDetail.setVisible(false);
        this.selProfile.setVisible(false);
    }
    @FXML
    private void userDetail(MouseEvent event) throws IOException {
        AnchorPane screen_page = FXMLLoader.load(this.getClass().
                getResource("PostmanAllUserComponent.fxml"));
        this.scene_area.getChildren().setAll(screen_page);
        //Highlight selected menu
        this.selAllOrder.setVisible(false);
        this.selAddAdmin.setVisible(false);
        this.selAllUserDetail.setVisible(true);
        this.selProfile.setVisible(false);
    }
    @FXML
    private void adminManage(MouseEvent event) throws IOException {
        AnchorPane screen_page = FXMLLoader.load(this.getClass().
                getResource("PostmanProfileComponent.fxml"));
        this.scene_area.getChildren().setAll(screen_page);
        //Highlight selected menu
        this.selAllOrder.setVisible(false);
        this.selAddAdmin.setVisible(false);
        this.selAllUserDetail.setVisible(false);
        this.selProfile.setVisible(true);
    }
    @FXML
    private void addAdmin(MouseEvent event) throws IOException {
        AnchorPane screen_page = FXMLLoader.load(this.getClass().
                getResource("NewPostmanComponent.fxml"));
        this.scene_area.getChildren().setAll(screen_page);
        //Highlight selected menu
        this.selAllOrder.setVisible(false);
        this.selAddAdmin.setVisible(true);
        this.selAllUserDetail.setVisible(false);
        this.selProfile.setVisible(false);
    }
    @FXML
    private void signOut(MouseEvent event) throws IOException {
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
