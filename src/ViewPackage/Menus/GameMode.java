package ViewPackage.Menus;


import LogicPackage.Commands.HoldGame;
import LogicPackage.Commands.Invoker;
import LogicPackage.Misc.ImportImage;
import ViewPackage.GameViewBackgrounds.GameScreen;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;


public class GameMode {
    private static GameMode instance;
    private  Boolean flag = true ;
    private Scene scene = null;

    private GameMode(){
    }
    public static GameMode getInstance() {
        if (instance == null) {
            instance = new GameMode();
        }
        return instance;
    }

    public void prepareScene(Stage stage){
        if (flag) {
            flag = false;
            StackPane stackPane = new StackPane();
            stackPane.setPrefSize(1280, 720);
            Button arcadeButton = new Button();
            Button classicButton = new Button();

            try {
                ImageView backGroundImage = new ImageView(new ImportImage().getImage("MenuBackground.jpg"));
                backGroundImage.setPreserveRatio(true);
                backGroundImage.setFitWidth(1280);
                backGroundImage.setFitHeight(720);
                stackPane.getChildren().add(backGroundImage);

                BackgroundImage ClassicBackgroundImage = new BackgroundImage(new ImportImage().getImage("Classic.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background classicBackground = new Background(ClassicBackgroundImage);
                classicButton.setBackground(classicBackground);
                classicButton.setPrefSize(162, 159);

                RotateTransition rotateTransition = new RotateTransition(Duration.millis(8000), classicButton);
                rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
                rotateTransition.setByAngle(360);
                rotateTransition.play();

                BackgroundImage ArcadeBackgroundImage = new BackgroundImage(new ImportImage().getImage("Arcade.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background arcadeBackground = new Background(ArcadeBackgroundImage);
                arcadeButton.setBackground(arcadeBackground);
                arcadeButton.setPrefSize(162, 159);

                RotateTransition rotateTransition1 = new RotateTransition(Duration.millis(8000), arcadeButton);
                rotateTransition1.setCycleCount(RotateTransition.INDEFINITE);
                rotateTransition1.setByAngle(360);
                rotateTransition1.play();

            } catch (Exception e) {
                System.out.println("Images error");
                classicButton.setText("Classic Mode");
                arcadeButton.setText("Arcade Mode");

            }
            classicButton.setOnMouseDragEntered(event -> new GameScreen("Classic",stage));

            classicButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    new GameScreen("Classic",stage);
                }
            });

            arcadeButton.setOnMouseDragEntered(event -> new GameScreen("Arcade",stage));

            arcadeButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    new GameScreen("Arcade" , stage);
                }
            });

            Label transparentLabel = new Label();
            transparentLabel.setPrefWidth(100);

            HBox buttonsBox = new HBox();
            buttonsBox.getChildren().addAll(arcadeButton, classicButton, transparentLabel);
            buttonsBox.setSpacing(40);
            buttonsBox.setAlignment(Pos.CENTER_RIGHT);
            stackPane.getChildren().add(buttonsBox);
           // stackPane.setOnDragDetected(event -> buttonsBox.startFullDrag());

            scene = new Scene(stackPane, 1280, 720);
            //GoBack with Esc ----------------------------------------------------------------------------------------------
            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (event.getCode().equals(KeyCode.ESCAPE)) {
                        Invoker invoker = new Invoker();
                        invoker.setCommands(new HoldGame());
                        invoker.execute();
                    }
                }
            });
            //--------------------------------------------------------------------------------------------------------------
        }
        stage.setScene(scene);
        stage.show();
    }


}