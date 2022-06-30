package MainPackage;

import LogicPackage.Mementos.CareTaker;
import LogicPackage.Misc.ImportImage;
import ViewPackage.Menus.WelcomeScreen;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Main extends Application {


    public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Fruit Ninja");
        try {
            stage.getIcons().add(new ImportImage().getImage("MainIcon.png"));
        }catch(Exception e)
        {
            System.out.println("Icon cannot be Found !");
        }
        this.stage = stage;
        WelcomeScreen welcomeScreen =  WelcomeScreen.getInstance();
        WelcomeScreen.setStage(stage);
        welcomeScreen.prepareScene();
    }

    public static void main(String[] args){

        launch(args);

    }



}



