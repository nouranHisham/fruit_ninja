package LogicPackage.Factories.BombsFactory;

import LogicPackage.Commands.EndGame;
import LogicPackage.Commands.Invoker;
import LogicPackage.GameObject;
import LogicPackage.Misc.AudioHandling;
import LogicPackage.Misc.ImportImage;
import MainPackage.Main;
import javafx.scene.layout.*;

public class RedFatalBomb implements GameObject {

    boolean sliced = false;

    @Override
    public String getObjectType() {
        return null;
    }

    @Override
    public int getXlocation() {
        return (int)((Math.random() *1200 + 0));    }

    @Override
    public int getYlocation() {
        return 0;
    }

    @Override
    public int getMaxHeight() {
        return 600;
    }

    @Override
    public int getInitialVelocity() {
        return 0;
    }

    @Override
    public int getFallingVelocity() {
        return 0;
    }

    @Override
    public Boolean isSliced() {
        return sliced;
    }

    @Override
    public Boolean hasMovedOffScreen() {
        return null;
    }

    @Override
    public void slice() {

        AudioHandling.getInstance().playExplodingSound();
        sliced = true;
        Invoker invoker = new Invoker();
        invoker.setCommands(new EndGame());
        invoker.execute();

    }

    @Override
    public void move(double time) {

    }

    @Override
    public Background getImages() {
        Background returnBackground = null;

     try {
         BackgroundImage redBombImage = new BackgroundImage(new ImportImage().getImage("FatalBomb.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

         BackgroundImage redBombSlicedImage = new BackgroundImage(new ImportImage().getImage("FatalBombSliced.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
         if(isSliced() == false)
         {
             returnBackground = new Background(redBombImage);
         }

         if(isSliced() == true)
         {
             returnBackground = new Background(redBombSlicedImage);
         }
     }
     catch (Exception e) {
         System.out.println("Boomb image error");
     }

        return returnBackground;
    }

    @Override
    public int getScoreMultiplier(){
        return 0;
    }
    @Override
    public void setSliced() {
        sliced = true ;
    }
}
