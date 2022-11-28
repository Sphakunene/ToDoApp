package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import sample.model.Task;

public class ListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXListView<Task> listView;

    @FXML
    private JFXTextField listtaskField;

    @FXML
    private JFXTextField listdescriptionField;

    @FXML
    private JFXButton listsaveTaskButton;

    private ObservableList<Task> tasks;


    @FXML
    void initialize() {

    Task task = new Task();
    task.setTask("Clean a car");
    task.setDescription("You have to clean it before it is too late");
    task.setDatecreated(Timestamp.valueOf(LocalDateTime.now()));
    tasks = FXCollections.observableArrayList();
    tasks.add(task);
    listView.setItems(tasks);
    listView.setCellFactory(CellController -> new CellController());


    }

}
