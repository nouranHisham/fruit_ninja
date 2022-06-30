package LogicPackage.Factories.FruitFactory;

import LogicPackage.GameObject;
import LogicPackage.Misc.AudioHandling;
import LogicPackage.Misc.ImportImage;
import LogicPackage.PlayerSingleton;
import javafx.scene.layout.*;

public class Watermelon implements GameObject {

    private boolean movingUp = true;
    private boolean movedOffScreen = false;
    boolean sliced = false;
    int x, y;


    @Override
    public String getObjectType() {
        return "Watermelon";
    }

    @Override
    public int getXlocation() {

        return (int)((Math.random() *1200 + 0));
    }

    @Override
    public int getYlocation() {

        return y;
    }

    @Override
    public int getMaxHeight() {

        return 500;
    }

    @Override
    public int getInitialVelocity() {

        return 7;
    }

    @Override
    public int getFallingVelocity() {

        return 80;
    }

    @Override
    public Boolean isSliced() {

        return sliced;
    }

    @Override
    public Boolean hasMovedOffScreen() {

        return movedOffScreen;
    }

    @Override
    public void slice() {
        AudioHandling.getInstance().stopSliceSound();
        AudioHandling.getInstance().playSliceSound();
        sliced = true;
        PlayerSingleton.getInstance().calculateCurrentScore(getScoreMultiplier());
        PlayerSingleton.getInstance().calculateBestScore(getScoreMultiplier());

    }

    @Override
    public void move(double time) {

    }

    @Override
    public Background getImages() {

        Background returnBackground = null;

        BackgroundImage watermelonImage = new BackgroundImage(new ImportImage().getImage("Watermelon.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        BackgroundImage watermelonSlicedImage = new BackgroundImage(new ImportImage().getImage("WatermelonSliced.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        if(isSliced() == false)
        {
            returnBackground = new Background(watermelonImage);
        }

        if(isSliced() == true)
        {
            returnBackground = new Background(watermelonSlicedImage);
        }

        return returnBackground;

    }

    @Override
    public int getScoreMultiplier(){
        return 1;
    }
    @Override
    public void setSliced() {
        sliced = true ;
    }

}
