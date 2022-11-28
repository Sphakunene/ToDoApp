package sample.animation;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Transition {

   private FadeTransition fade;

    public Transition(Node node) {

        fade = new FadeTransition(Duration.millis(1000),node);

        fade.setFromValue(0f);
        fade.setToValue(1f);
        fade.setCycleCount(1);
        fade.setAutoReverse(false);


    }

    public void transit(){
        fade.play();
    }
}
