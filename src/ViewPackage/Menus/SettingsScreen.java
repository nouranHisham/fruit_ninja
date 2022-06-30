package ViewPackage.Menus;

import LogicPackage.Misc.ImportImage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SettingsScreen {
    private  ChoiceBox<String> choiceBox = new ChoiceBox<>();
    private static SettingsScreen instance;
    private String difficulty = "Easy";
    private  Boolean flag = true ;
    private Scene scene = null;



    public static SettingsScreen getInstance(){
        if (instance == null)
            instance = new SettingsScreen();
        return instance;
    }

    private SettingsScreen() {
    }

    public String getDifficulty(){
        return this.difficulty;
    }
    private  void setChoicBox(){

    }

    public void getsSettingsScreen(Stage settingsStage){
        if (flag) {
            flag = false;
            settingsStage.setTitle("Settings");
            try {
                settingsStage.getIcons().add(new ImportImage().getImage("settingsPic.jpg"));
            } catch (Exception e) {
                System.out.println("Icon cannot be found");
            }
            VBox box = new VBox();
            box.setSpacing(20);

            Label difficultyLabel = new Label("Difficulty");
            difficultyLabel.setTextFill(Color.WHITE);
            difficultyLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
            Label settingsLabel = new Label("Settings");
            settingsLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
            settingsLabel.setTextFill(Color.WHITE);
            difficultyLabel.setStyle("-fx-background-color: TRANSPARENT");
            StackPane pane2 = new StackPane();
            HBox difficultyBox = new HBox(20, difficultyLabel, choiceBox);
            box.getChildren().addAll(settingsLabel, difficultyBox);
            difficultyBox.setAlignment(Pos.BASELINE_LEFT);

            choiceBox.getItems().add("Easy");
            choiceBox.getItems().add("Medium");
            choiceBox.getItems().add("Hard");
            choiceBox.setValue("Easy");

            choiceBox.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    difficulty = choiceBox.getValue();
                }
            });
            try {
                ImageView backGroundImage = new ImageView(new ImportImage().getImage("WoodBackground.jpg"));
                backGroundImage.setPreserveRatio(true);
                backGroundImage.setFitWidth(1280);
                backGroundImage.setFitHeight(720);
                pane2.getChildren().addAll(backGroundImage, box);
            } catch (Exception e) {
                System.out.println("Error");
            }

            scene = new Scene(pane2, 300, 200);
            //Closing stage on Esc------------------------------------------------------------------------------------------
            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (event.getCode().equals(KeyCode.ESCAPE)) {
                        settingsStage.close();
                    }
                }
            });
            //--------------------------------------------------------------------------------------------------------------
        }
        settingsStage.setScene(scene);
        settingsStage.show();
    }
}
