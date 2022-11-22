package sample.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import sample.Database.DatabaseHandler;
import sample.model.User;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField signUpFirstName;

    @FXML
    private JFXTextField signUpLastName;

    @FXML
    private JFXTextField signUpUsername;

    @FXML
    private JFXCheckBox signUpCheckboxMale;

    @FXML
    private CheckBox signUpCheckboxfemale;

    @FXML
    private JFXPasswordField signUpPassword;

    @FXML
    private JFXButton signUpButton;

    @FXML
    private JFXTextField signUpLocation;

    @FXML
    void initialize() {



        signUpButton.setOnAction(event -> {
            createUser();
        });

    }

    private void createUser() {
        DatabaseHandler handler = new DatabaseHandler();
        String firstName = signUpFirstName.getText();
        String lastName = signUpLastName.getText();
        String username = signUpUsername.getText();
        String password = signUpPassword.getText();
        String location = signUpLocation.getText();
        String gender ="";

        if (signUpCheckboxfemale.isSelected())
        {
            gender = "Female";
        }else{

            gender = "Male";
        }

        User user = new User(firstName,lastName,username,password,location,gender);

        try {
            handler.signUpUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
