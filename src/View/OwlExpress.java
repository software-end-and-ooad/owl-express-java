/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.LocalStorage;
import Controller.LoginController;
import Controller.UserDataService;
import Model.Admin;
import Model.Database;
import Model.User;
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
            root = FXMLLoader.load(getClass().getResource("LoginComponent.fxml"));
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
            Database db = new Database(loginfile.getRole());
            if(loginfile.getRole().compareTo("User") == 0){
                Query userQuery = db.getEM().createQuery("SELECT u FROM User u WHERE u.username='" + loginfile.getUsername() + "' AND u.password='" + loginfile.getPassword() + "'");
                User user = (User)userQuery.getSingleResult();
                //LOAD data to UserDataService
                UserDataService.setAccountID(user.getId());
                UserDataService.setEmail(user.getEmail());
                UserDataService.setFullname(user.getName());
                UserDataService.setUsername(user.getUsername());
                UserDataService.setPassword(user.getPassword());
                UserDataService.setTel(user.getTel());
                UserDataService.setAddress(user.getAddress());
                UserDataService.setDistric(user.getDistric());
                UserDataService.setArea(user.getArea());
                UserDataService.setProvince(user.getProvince());
                UserDataService.setZipCode(user.getZipCode());
                UserDataService.setOtherAddress(user.getOtherAddress());
                db.getEM().close();
                //load up OTHER FXML document
                root = FXMLLoader.load(getClass().getResource("DashboardComponent.fxml"));
                stage.initStyle(StageStyle.TRANSPARENT);
                root = MoveWindow.moveWindow(root, stage);
                //create a new scene with root and set the stage
                Scene scene = new Scene(root);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
            }else if(loginfile.getRole().compareTo("Admin") == 0){
                Query adminQuery = db.getEM().createQuery("SELECT a FROM Admin a WHERE a.username='" + loginfile.getUsername() + "' AND a.password='" + loginfile.getPassword() + "'");
                Admin user = (Admin)adminQuery.getSingleResult();
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
