package ViewPackage.GameViewBackgrounds;

import LogicPackage.Commands.Invoker;
import LogicPackage.Commands.PauseGame;
import LogicPackage.Misc.ImportImage;
import LogicPackage.Misc.ClassicTimer;
import LogicPackage.PlayerSingleton;
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

public class ClassicScreen {

    Font labelFont = new Font("verdana",16);

    static Label currentScoreLabel = new Label();
    static Label bestScoreLabel = new Label( );;
    static Label livesLabel = new Label();


    public static void setCurrentScoreLabel( ){
       currentScoreLabel.setText("Score: "+ PlayerSingleton.getInstance().getCurrentScore());

    }
    public static void setBestScoreLabel(){
        bestScoreLabel.setText("Best: "+ PlayerSingleton.getInstance().getBestScore());
    }
    public static void loseLifeLabel(int livesLeft){
        livesLabel.setText(String.valueOf(livesLeft));
    }

    public HBox classicOverlay(Stage stage)
    {
        VBox scoreBox = new VBox();
        VBox timerLivesBox = new VBox();
        HBox allBox = new HBox();


        currentScoreLabel.setText("Score: "+ PlayerSingleton.getInstance().getCurrentScore());
        bestScoreLabel.setText("Best: " +PlayerSingleton.getInstance().getBestScore());
        currentScoreLabel.setFont(labelFont);
        currentScoreLabel.setTextFill(Color.WHITE);
        bestScoreLabel.setFont(labelFont);
        bestScoreLabel.setTextFill(Color.WHITE);
        livesLabel.setText(String.valueOf(PlayerSingleton.getInstance().getLivesLeft()));
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

        pauseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Invoker invoker = new Invoker();
                invoker.setCommands(new PauseGame());
                invoker.execute();
            }
        });


        livesLabel.setFont(labelFont);
        livesLabel.setTextFill(Color.WHITE);
        Label timerLabel;
        timerLabel = ClassicTimer.getInstance().getTimeLabel();
        timerLivesBox.setAlignment(Pos.TOP_RIGHT);
        timerLivesBox.setSpacing(10);
        timerLivesBox.getChildren().addAll(livesLabel,timerLabel);

        allBox.setSpacing(545);
        allBox.getChildren().addAll(scoreBox,pauseButton,timerLivesBox);

        return allBox;

    }
}
