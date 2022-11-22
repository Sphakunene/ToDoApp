package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Database.DatabaseHandler;
import sample.animation.Shaker;
import sample.model.User;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField loginUsername;

    @FXML
    private JFXPasswordField loginPassword;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXButton loginSignUpButton;

    private DatabaseHandler database;

    @FXML
    void initialize() {

        database = new DatabaseHandler();

        loginSignUpButton.setOnAction(event -> {
            loginSignUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/signup.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });


        loginButton.setOnAction(event -> {
        String username = loginUsername.getText().trim();
        String password = loginPassword.getText().trim();
        User user  = new User();
        user.setUserName(username);
        user.setPassword(password);

            try {
                ResultSet userRow = database.getUser(user);
                int count = 0;

                while (userRow.next()){
                    count++;
                }
                if (count == 1 ){
                    showItemScreen();
                }
                else{
                    Shaker usernameShaker = new Shaker(loginUsername);
                    Shaker passwordShaker = new Shaker(loginPassword);
                    usernameShaker.shake();
                    passwordShaker.shake();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        });

    }
    private void showItemScreen(){
        loginButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/view/additem.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }


}
