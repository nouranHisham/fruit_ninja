package ViewPackage.GameViewBackgrounds;

import LogicPackage.Misc.ImportImage;

import LogicPackage.PlayerSingleton;
import ViewPackage.GameEngine;
import ViewPackage.Menus.PauseScreen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ArcadeScreen  {
    Font labelFont = new Font("verdana",24);
    static Label currentScoreLabel;
    static Label bestScoreLabel;

    public static Label getCurrentScoreLabel() {
        return currentScoreLabel;
    }

    public static Label getBestScoreLabel() {
        return bestScoreLabel;
    }

    public HBox ArcadeOverlay(Stage stage)
    {
        VBox scoreBox = new VBox();
        HBox allBox = new HBox();

        currentScoreLabel = new Label("Score: " + String.valueOf(PlayerSingleton.getInstance().getCurrentScore()));
        currentScoreLabel.setFont(labelFont);
        currentScoreLabel.setTextFill(Color.WHITE);
        bestScoreLabel = new Label("Best: " + String.valueOf(PlayerSingleton.getInstance().getBestScore()));
        bestScoreLabel.setFont(labelFont);
        bestScoreLabel.setTextFill(Color.WHITE);
        scoreBox.setSpacing(10);
        scoreBox.setAlignment(Pos.TOP_LEFT);
        scoreBox.getChildren().addAll(currentScoreLabel,bestScoreLabel);

        Button pauseButton = new Button();

        try{
            BackgroundImage newPausePic = new BackgroundImage(new ImportImage().getImage("NewPausePic.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background newPause = new Background(newPausePic);
            pauseButton.setBackground(newPause);
            pauseButton.setPrefSize(28, 32);
        }catch(Exception e){
            pauseButton.setText("Pause");
        }
        HBox pauseButtonBox = new HBox(10,pauseButton);
        pauseButtonBox.setAlignment(Pos.TOP_CENTER);

        pauseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PauseScreen.getInstance().prepareScene(stage);
            }
        });

        Label timerLabel = new Label("Add Timer");
        timerLabel.setTextFill(Color.WHITE);
        timerLabel.setFont(labelFont);
        HBox timerLabelBox = new HBox(20,timerLabel);
        timerLabelBox.setAlignment(Pos.TOP_RIGHT);

        allBox.setSpacing(520);
        allBox.getChildren().addAll(scoreBox,pauseButtonBox,timerLabelBox);

        return allBox;

    }
}


