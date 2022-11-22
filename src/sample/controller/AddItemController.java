package sample.controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import sample.animation.Shaker;

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
    void initialize() {
        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED,event -> {
            System.out.println("added click");
            Shaker buttonShaker = new Shaker(addButton);
            buttonShaker.shake();

            FadeTransition fade = new FadeTransition(Duration.millis(2000),addButton);
            FadeTransition fadeLAbel = new FadeTransition(Duration.millis(2000),noTaskLabel);
            addButton.relocate(0,20);
            noTaskLabel.relocate(0,45);

            addButton.setOpacity(0);
            noTaskLabel.setOpacity(0);

            fade.setFromValue(1f);
            fade.setToValue(0f);
            fade.setCycleCount(1);
            fade.setAutoReverse(false);
            fade.play();

            fadeLAbel.setFromValue(1f);
            fadeLAbel.setToValue(0f);
            fadeLAbel.setCycleCount(1);
            fadeLAbel.setAutoReverse(false);
            fadeLAbel.play();

        });
    }
}