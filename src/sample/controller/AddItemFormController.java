package sample.controller;



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import sample.Database.DatabaseHandler;
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
    void initialize() {
        databaseHandler = new DatabaseHandler();

        saveTaskButton.setOnAction(event -> {
            Task task = new Task();
            Calendar calendar = Calendar.getInstance();
            Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
            task.setTask(taskField.getText());
            task.setDatecreated(timestamp);
            task.setUserId(AddItemController.getUserId());
            task.setDescription(descriptionField.getText());

            try {
                databaseHandler.insertTask(task);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
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
