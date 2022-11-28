package sample.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListCell;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.model.Task;

public class CellController extends JFXListCell<Task> {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootAnchorPane;

    @FXML
    private ImageView iconImageView;

    @FXML
    private Label taskLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private ImageView deleteButton;

    private FXMLLoader loader;

    @FXML
    void initialize() {

    }

    @Override
    public void updateItem(Task myTask, boolean empty) {
        super.updateItem(myTask, empty);
        if (empty|| myTask == null){
            setText(null);
            setGraphic(null);
        }else if (loader == null) {

            loader = new FXMLLoader(getClass().getResource("/sample/view/cell.fxml"));

            loader.setController(this);
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();

            }
            taskLabel.setText(myTask.getTask());
            descriptionLabel.setText(myTask.getDescription());
            dateLabel.setText(myTask.getDatecreated().toString());

            setText(null);
            setGraphic(rootAnchorPane);
        }
    }
}