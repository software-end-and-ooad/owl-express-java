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
        System.out.println(this.username);
        Database db = new Database("user");

        Query user = db.getEM().createQuery("SELECT username, password FROM User where username='" + this.username + "' and password='" + this.password + "'");
        
        try { // try, if can print method in user
            System.out.println(user.getSingleResult());
            db.getEM().close();
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
