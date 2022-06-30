package LogicPackage.Factories.BombsFactory;

import LogicPackage.GameObject;
import LogicPackage.Misc.ImportImage;
import javafx.scene.layout.*;

public class LuckyBlastBomb implements GameObject {
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
        System.out.println("Lucky Bomb sliced");
        sliced = true;

    }

    @Override
    public void move(double time) {

    }

    @Override
    public Background getImages() {
        Background returnBackground = null;
        try{

        BackgroundImage appleImage = new BackgroundImage(new ImportImage().getImage("LuckyBomb.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        BackgroundImage appleSlicedImage = new BackgroundImage(new ImportImage().getImage("LuckyBombSliced.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        if(isSliced() == false)
        {
            returnBackground = new Background(appleImage);
        }

        if(isSliced() == true)
        {
            returnBackground = new Background(appleSlicedImage);
        }}
        catch (Exception e)
        {
            System.out.println("Bomb image error ");
        }

        return returnBackground;
    }

    @Override
    public int getScoreMultiplier(){
        return 0;
    }
}
