package LogicPackage.StateDifficulties;

import LogicPackage.Misc.MyRandom;
import LogicPackage.PlayerSingleton;

public class Easy implements Level {

    int speedUp = 0;

    @Override
    public int getNumberofFruitsWave() {
        int numberofFruitsWave = 0;
        numberofFruitsWave = new MyRandom().getRand(1,3);
        return numberofFruitsWave;
    }

    @Override
    public int getNumberofBombsWave() {
        int  numberofBombsWave = 0;
        numberofBombsWave = new MyRandom().getRand(0,2);
        return numberofBombsWave ;
    }

    @Override
    public int getSpeed() {
        speedUp = 1600;
        return speedUp;
    }

}
