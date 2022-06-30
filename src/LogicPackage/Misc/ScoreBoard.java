package LogicPackage.Misc;

import LogicPackage.PlayerSingleton;
import ViewPackage.GameViewBackgrounds.GameScreen;
import ViewPackage.Menus.WelcomeScreen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class ScoreBoard {
    Font labelFont = new Font("verdana",28);


    public VBox getScoreBoard(){
        VBox vBox = new VBox();
        vBox.setSpacing(50);
        Label currentScoreLabel = new Label("Score: " + PlayerSingleton.getInstance().getCurrentScore() );
        currentScoreLabel.setTextFill(Color.WHITE);
        currentScoreLabel.setAlignment(Pos.CENTER);
        currentScoreLabel.setFont(labelFont);
        vBox.getChildren().add(currentScoreLabel);

        Label bestScoreLabel = new Label("Best: " + PlayerSingleton.getInstance().getBestScore());
        bestScoreLabel.setTextFill(Color.WHITE);
        bestScoreLabel.setAlignment(Pos.CENTER);
        bestScoreLabel.setFont(labelFont);
        vBox.getChildren().add(bestScoreLabel);

        Button continueButton = new Button("Continue");
        continueButton.setFont(labelFont);
        continueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PlayerSingleton.getInstance().destruct();
                WelcomeScreen.getInstance().prepareScene();
            }
        });
        vBox.getChildren().add(continueButton);

        return vBox;
    }
}
