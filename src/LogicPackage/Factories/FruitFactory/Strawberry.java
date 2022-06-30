package LogicPackage.Factories.FruitFactory;

import LogicPackage.GameObject;
import LogicPackage.Misc.AudioHandling;
import LogicPackage.Misc.ImportImage;
import LogicPackage.PlayerSingleton;
import javafx.scene.layout.*;

public class Strawberry implements GameObject {

    private boolean movingUp = true;
    private boolean movedOffScreen = false;
    boolean sliced = false;
    int x, y;


    @Override
    public String getObjectType() {
        return "Strawberry";
    }

    @Override
    public int getXlocation() {
        return (int)((Math.random() *1200 + 0));
    }

    @Override
    public int getYlocation() {
        return (int)((Math.random() * ((720 - 0) + 1)) + 0);
    }

    @Override
    public int getMaxHeight() {
        return 720;
    }

    @Override
    public int getInitialVelocity() {
        return 15;
    }

    @Override
    public int getFallingVelocity() {
        return 40;
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

        BackgroundImage strawberryImage = new BackgroundImage(new ImportImage().getImage("Strawberry.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        BackgroundImage strawberrySlicedImage = new BackgroundImage(new ImportImage().getImage("StrawberrySliced.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        if(isSliced() == false)
        {
            returnBackground = new Background(strawberryImage);
        }

        if(isSliced() == true)
        {
            returnBackground = new Background(strawberrySlicedImage);
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
