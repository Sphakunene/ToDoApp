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

        DatabaseHandler handler = new DatabaseHandler();

        signUpButton.setOnAction(event -> {

            try {
                handler.signUpUser(signUpFirstName.getText(),signUpLastName.getText(),signUpUsername.getText(),
                        signUpPassword.getText(),signUpLocation.getText(),"Female");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

    }
}
