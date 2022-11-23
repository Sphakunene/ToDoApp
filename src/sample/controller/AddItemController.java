package sample.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import sample.animation.Shaker;
import sample.animation.Transition;


public class AddItemController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addButton;

    @FXML
    private Label noTaskLabel;

    @FXML
    private AnchorPane rootAnchorPane;

    @FXML
    void initialize() {
        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println("added click");
            Shaker buttonShaker = new Shaker(addButton);
            buttonShaker.shake();


            addButton.relocate(0,20);
            noTaskLabel.relocate(0,45);

             addButton.setOpacity(0);
             noTaskLabel.setOpacity(0);
//            Transition tran = new Transition(addButton);
//            Transition tran1 = new Transition(noTaskLabel);
//            tran.transit();
//            tran1.transit();


            try {
                AnchorPane formPane = FXMLLoader.load(getClass().getResource("/sample/view/addItemForm.fxml"));

                Transition tran2 = new Transition(formPane);
                tran2.transit();
                rootAnchorPane.getChildren().addAll(formPane);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}