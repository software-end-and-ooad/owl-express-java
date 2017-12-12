package View;

import Controller.PostmanDataService;
import Controller.LocalStorage;
import Controller.LoginController;
import Controller.UserDataService;
import Model.Postman;
import Model.Entitymanager;
import Model.Customer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.persistence.Query;

/**
 *
 * @author Utt
 */
public class OwlExpress extends Application {

    double xOffset;
    double yOffset;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root;
        LocalStorage loginfile = new LocalStorage();
        //IF loginfile does not exist go to loginComponent
        if(!loginfile.checkAuthen()){
            root = FXMLLoader.load(getClass().
                    getResource("LoginComponent.fxml"));
            stage.initStyle(StageStyle.TRANSPARENT);
            root = MoveWindow.moveWindow(root, stage);
            Scene scene = new Scene(root);
            scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        //IF loginfile does exist go to dashboardComponent
        }else{
            System.out.println(loginfile.getUsername());
            System.out.println(loginfile.getPassword());
            System.out.println(loginfile.getRole());
            Entitymanager db;
            if (loginfile.getRole().compareTo("Customer") != 0) {
                Entitymanager admindb = new Entitymanager("Postman");

                // Depart Admin between [admin, postman]
                 Query adminFind = admindb.getEM().
                            createQuery("SELECT a FROM Postman a WHERE a.username='" 
                                    + loginfile.getUsername() + 
                                    "' AND a.password='" + 
                                    loginfile.getPassword() + "'");
                    Postman adminResult = (Postman)adminFind.getSingleResult();
                    
                if (adminResult.getRole().compareTo("Postman") == 0) {
                    db = new Entitymanager("Postman");
                } else if (adminResult.getRole().compareTo("Customer") == 0) {
                    db = new Entitymanager("Customer");
                } else
                    db = new Entitymanager("Postman");
            }else{
                db = new Entitymanager("Customer");
            }
            
            if(loginfile.getRole().compareTo("Customer") == 0){
                Query userQuery = db.getEM().
                        createQuery("SELECT u FROM Customer u WHERE u.username='" 
                                + loginfile.getUsername() + 
                                "' AND u.password='" + 
                                loginfile.getPassword() + "'");
                Customer user = (Customer)userQuery.getSingleResult();
                //LOAD data to UserDataService
                UserDataService.setDataService(
                        user.getId(), 
                        user.getName(), 
                        user.getEmail(), 
                        user.getTel(), 
                        user.getAddress(), 
                        user.getDistric(), 
                        user.getArea(), 
                        user.getProvince(), 
                        user.getZipCode(), 
                        user.getOtherAddress(), 
                        user.getUsername(), 
                        user.getPassword()
                );
                db.getEM().close();
                //load up OTHER FXML document
                root = FXMLLoader.load(getClass().
                        getResource("DashboardComponent.fxml"));
                stage.initStyle(StageStyle.TRANSPARENT);
                root = MoveWindow.moveWindow(root, stage);
                //create a new scene with root and set the stage
                Scene scene = new Scene(root);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
            }else if(loginfile.getRole().compareTo("Admin") == 0){
                Query adminQuery = db.getEM().
                        createQuery("SELECT a FROM Postman a WHERE a.username='"
                                + loginfile.getUsername() + 
                                "' AND a.password='" + 
                                loginfile.getPassword() + "'");
                Postman admin = (Postman)adminQuery.getSingleResult();
                //ADD data to PostmanDataService
                PostmanDataService.setAdminDataService(
                        admin.getId(),
                        admin.getNationID(),
                        admin.getFullname(), 
                        admin.getEmail(), 
                        admin.getTel(), 
                        admin.getZipCode(),  
                        admin.getUsername(), 
                        admin.getPassword(),
                        admin.getRole()
                );
                db.getEM().close();
                //load up OTHER FXML document
                root = FXMLLoader.load(getClass().
                        getResource("PostmanDashboardComponent.fxml"));
                stage.initStyle(StageStyle.TRANSPARENT);
                root = MoveWindow.moveWindow(root, stage);
                //create a new scene with root and set the stage
                Scene scene = new Scene(root);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
