package sample.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

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
    void initialize() {

    }
}
