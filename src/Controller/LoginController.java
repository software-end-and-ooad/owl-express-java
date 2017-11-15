package Controller;

import Model.User;
import Model.Database;
import java.util.ArrayList;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author babyjazz
 */
public class LoginController {

    private String username;
    private String password;
    private ArrayList<String> validation;

    public LoginController(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean checkLogin() {
        Database db = new Database("User");

        Query userQuery = db.getEM().createQuery("SELECT u FROM User u WHERE u.username='" + this.username + "' AND u.password='" + this.password + "'");
        
        try { // try, if can find user
            User user = (User)userQuery.getSingleResult();
            System.out.println(user.getUsername());
            db.getEM().close();
            //ADD data to UserDataService
            UserDataService.setEmail(user.getEmail());
            UserDataService.setFullname(user.getName());
            UserDataService.setUsername(user.getUsername());
            UserDataService.setPassword(user.getPassword());
            UserDataService.setTell(user.getTell());
            return true;
        } catch (Exception e) {
            System.out.println("false");
            db.getEM().close();
            return false;
        }
        
    }
    public ArrayList<ArrayList<String>> validateLogin() {
        Validation checkValidate = new Validation();
        ArrayList<String> validate = new ArrayList<String>();

        validate.clear();
        // ADD VALIDATION HERE
        if (!checkValidate.isRequired(this.username))
            validate.add("username|isRequired");
        if (!checkValidate.isRequired(this.password))
            validate.add("password|isRequired");
        
        ArrayList<ArrayList<String>> errList = splitListofValidateError(validate);
        return errList;
    }

    private ArrayList splitListofValidateError(ArrayList errList) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < errList.size(); i++) {
            String errValidate = (String) errList.get(i);
            String fieldError = errValidate.substring(0, errValidate.indexOf("|"));
            String ruleError = errValidate.substring(errValidate.indexOf("|") + 1);

            result.add(new ArrayList<String>());
            result.get(i).add(fieldError);
            result.get(i).add(ruleError);
        }
        return result;
    }

}
