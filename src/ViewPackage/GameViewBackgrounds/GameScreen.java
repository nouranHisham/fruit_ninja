package ViewPackage.GameViewBackgrounds;

import LogicPackage.Commands.Invoker;
import LogicPackage.Commands.PauseGame;
import LogicPackage.Misc.ImportImage;
import LogicPackage.Misc.ClassicTimer;
import ViewPackage.GameEngine;
import ViewPackage.Menus.PauseScreen;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public  class GameScreen {
    private static GameScreen gameScreen = null;
    public static GameScreen getGameScreen(){
        return gameScreen;
    }

    VBox mainBox = new VBox();
    HBox overlayBox ;
    Stage stage;
    Scene scene ;
    static Boolean gameRunning = true;
     HBox gameBox = new HBox();
    GameEngine gameEngine;

    public void clearGameBox(){
        gameEngine.pause();
        gameBox.getChildren().clear();
    }


    public  void stopGame(){ gameRunning=false;}



    public GameScreen(String mode , Stage stage) {
        if (mode.equalsIgnoreCase("Classic"))
            overlayBox = new ClassicScreen().classicOverlay(stage);
        this.stage = stage;
        gameScreen = GameScreen.this;
        prepareScreen();
    }

    public void prepareScreen(){
        gameRunning = true;

       mainBox.setPrefSize(1280,720);
        try{
            BackgroundImage gameBackgroundImage = new BackgroundImage(new ImportImage().getImage("WoodBackground.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background gameBackground = new Background(gameBackgroundImage);
            mainBox.setBackground(gameBackground);
        }catch (Exception e)
        {
            System.out.println("Image Error");
        }

        gameBox.setMinSize(1280,650);
        gameBox.setOnDragDetected(event -> gameBox.startFullDrag());
        gameEngine = new GameEngine();
        gameEngine.setGameScreen(GameScreen.this);

        gameBox.getChildren().add(gameEngine.getGame());



        mainBox.getChildren().add(overlayBox);
        mainBox.getChildren().add(gameBox);
        scene = new Scene(mainBox,1280,720);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ESCAPE))
                {
                    Invoker invoker = new Invoker();
                    invoker.setCommands(new PauseGame());
                    invoker.execute();
                }
            }
        });
        stage.setScene(scene);
        stage.show();
    }
    public void getWave(){
        if(gameRunning) {
            GameEngine gameEngine = new GameEngine();
            gameBox.getChildren().clear();
            gameEngine.setGameScreen(GameScreen.this);
            gameBox.getChildren().add(gameEngine.getGame());
        }
    }
}
