package ViewPackage.Menus;

import LogicPackage.Commands.*;
import LogicPackage.Misc.AudioHandling;
import LogicPackage.Misc.ImportImage;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class WelcomeScreen {

    private static WelcomeScreen instance;
    private  Boolean flag = true ;
    private Scene scene = null;
    private static Stage stage;

    public static void setStage(Stage stage) {
        WelcomeScreen.stage = stage;
    }

    private WelcomeScreen(){
    }
    public static WelcomeScreen getInstance() {
        if (instance == null) {
            instance = new WelcomeScreen();
        }
        return instance;
    }

    public  void prepareScene() {

        Invoker invoker = new Invoker();
        invoker.setCommands(new PlayThemeMusic());
        invoker.execute();

       if (flag) {
           flag = false;

            StackPane stackPane = new StackPane();
            stackPane.setPrefSize(1280, 720);

            Button newGameButton = new Button();
            Button continueButton = new Button();
            Button settingsButton = new Button("Settings");

            try {
                ImageView backGroundImage = new ImageView(new ImportImage().getImage("MenuBackground.jpg"));
                backGroundImage.setPreserveRatio(true);
                backGroundImage.setFitWidth(1280);
                backGroundImage.setFitHeight(720);
                stackPane.getChildren().add(backGroundImage);

                BackgroundImage newGameBackgroundImage = new BackgroundImage(new ImportImage().getImage("NewGameButton.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background newGameBackground = new Background(newGameBackgroundImage);
                newGameButton.setBackground(newGameBackground);
                newGameButton.setPrefSize(162, 159);

                BackgroundImage continueGameBackgroundImage = new BackgroundImage(new ImportImage().getImage("ContinueGameButton.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background continueGameBackground = new Background(continueGameBackgroundImage);
                continueButton.setBackground(continueGameBackground);
                continueButton.setPrefSize(162, 156);


                RotateTransition rotateTransition = new RotateTransition(Duration.millis(8000), newGameButton);
                rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
                rotateTransition.setByAngle(360);
                rotateTransition.play();

                RotateTransition rotateTransition1 = new RotateTransition(Duration.millis(8000), continueButton);
                rotateTransition1.setCycleCount(RotateTransition.INDEFINITE);
                rotateTransition1.setByAngle(360);
                rotateTransition1.play();


                BackgroundImage newSettingsImage = new BackgroundImage(new ImportImage().getImage("settingsPic.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background newSettings = new Background(newSettingsImage);
                settingsButton.setBackground(newSettings);
                settingsButton.setPrefSize(28, 32);

            } catch (Exception e) {
                System.out.println("Images error");
                newGameButton.setText("New Game");
                continueButton.setText("Continue Game");
            }


            newGameButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    File oldMementos = new File("Memento.xml");
                    if (oldMementos.exists()){
                    Invoker invoker = new Invoker();
                    invoker.setCommands(new LoadNewGame());
                    invoker.execute();

                    invoker.setCommands(new StartNewGame());
                    invoker.execute();}
                    else{
                        Invoker invoker = new Invoker();
                        invoker.setCommands(new StartNewGame());
                        invoker.execute();
                    }

                }
            });

            continueButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    File oldMementos = new File("Memento.xml");
                    if (oldMementos.exists()){
                    Invoker invoker = new Invoker();
                    invoker.setCommands(new LoadOldGame());
                    invoker.execute();

                    invoker.setCommands(new ResumeGame());
                    invoker.execute();}
                }
            });


           //Transparent Label to adjust spacing ----------------------------------------------------------------------
           Label transparentLabel = new Label();
           transparentLabel.setPrefWidth(100);
           //----------------------------------------------------------------------------------------------------------
           HBox buttonsBox = new HBox(50, continueButton, newGameButton, transparentLabel);
           buttonsBox.setAlignment(Pos.CENTER_RIGHT);
           stackPane.getChildren().add(buttonsBox);
           stackPane.setOnDragDetected(event -> stackPane.startFullDrag());
           scene = new Scene(stackPane, 1280, 720);
       }
        stage.setScene(scene);
        stage.show();

    }
}
