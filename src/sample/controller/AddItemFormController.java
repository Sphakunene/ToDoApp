package sample.controller;



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import sample.Database.DatabaseHandler;
import sample.animation.Shaker;
import sample.model.Task;

public class AddItemFormController {



    private int userid;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField taskField;

    @FXML
    private JFXTextField descriptionField;

    @FXML
    private JFXButton saveTaskButton;

    private DatabaseHandler databaseHandler;

    @FXML
    private Button todosButton;

    @FXML
    private Label suceessLabel;

    @FXML
    void initialize() {
        databaseHandler = new DatabaseHandler();

        saveTaskButton.setOnAction(event -> {
            Task task = new Task();
            Calendar calendar = Calendar.getInstance();
            Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
            if (!taskField.getText().equals("") && !descriptionField.getText().equals("")) {
                task.setTask(taskField.getText());
                task.setDatecreated(timestamp);
                task.setUserId(AddItemController.getUserId());
                task.setDescription(descriptionField.getText());

                try {
                    databaseHandler.insertTask(task);
                    suceessLabel.setVisible(true);
                    todosButton.setVisible(true);
                    int taskNumber = databaseHandler.getAllTask(task);
                    taskField.setText("");
                    descriptionField.setText("");
                    todosButton.setText("My 2Do's: "+taskNumber);
                    todosButton.setOnAction(event1 -> {


                    });
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }else{
                Shaker shaker = new Shaker(taskField);
                Shaker shaker1 = new Shaker(descriptionField);
                shaker.shake();
                shaker1.shake();

            }
        });

    }
//    public int getUserid() {
//        return userid;
//    }
//
//    public void setUserid(int userid) {
//        this.userid = userid;
//
//    }

}
