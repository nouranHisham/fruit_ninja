
import java.util.ArrayList;

import LogicPackage.Misc.ImportImage;
import LogicPackage.Misc.ScoreBoard;
import MainPackage.Main;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Testss extends Application {

    private int db = 10;
    private int dor = 10;
    private int ds = 10;
    private int dw = 10;
    ArrayList<ImageView> images = new ArrayList<>();
    ArrayList<Image> images2 = new ArrayList<>();


    public static void main(String[] args) {
        launch();

    }


    @Override
    public void start(Stage primaryStage) throws Exception {

       // Stage stage = Main.stage;

        StackPane stackPane = new StackPane();
        try{
            BackgroundImage gameBackgroundImage = new BackgroundImage(new ImportImage().getImage("WoodBackground.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background gameBackground = new Background(gameBackgroundImage);
            stackPane.setBackground(gameBackground);
        }catch (Exception e)
        {
            System.out.println("Image Error");
        }

        Label gameOverLabel = new Label("Game Over");
        gameOverLabel.setTextFill(Color.WHITE);
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(1000),gameOverLabel);
        scaleTransition.setByX(3);
        scaleTransition.setByY(3);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000), gameOverLabel);
        translateTransition.setByY(-200);
        translateTransition.setAutoReverse(false);

        SequentialTransition sequentialTransition = new SequentialTransition(scaleTransition,translateTransition);
        sequentialTransition.setCycleCount(1);
        sequentialTransition.play();

        stackPane.getChildren().add(gameOverLabel);

        ScoreBoard scoreBoard = new ScoreBoard();
        VBox scoreBox = scoreBoard.getScoreBoard();
        scoreBox.setAlignment(Pos.CENTER);

        ScaleTransition scaleTransition2 = new ScaleTransition(Duration.millis(1000),scoreBox);
        scaleTransition.setByX(2);
        scaleTransition.setByY(2);







        Scene scene = new Scene(stackPane,1280,720);
        primaryStage.setScene(scene);
        primaryStage.show();

        sequentialTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("5lst");
                stackPane.getChildren().add(scoreBox);



            }
        });

    }

    public int rand(int min, int max) {
        return (int) (Math.random() * max + min);
    }
}