package LogicPackage.StateDifficulties;

import LogicPackage.Misc.MyRandom;
import LogicPackage.PlayerSingleton;

public class Medium implements Level {

    int speedUp = 0;

    @Override
    public int getNumberofFruitsWave() {
        int numberofFruitsWave = 0;
        numberofFruitsWave = new MyRandom().getRand(2,4);
        return numberofFruitsWave;
    }

    @Override
    public int getNumberofBombsWave() {
        int  numberofBombsWave = 0;
        numberofBombsWave = new MyRandom().getRand(0,3);
        return numberofBombsWave ;
    }

    @Override
    public int getSpeed() {
        speedUp = 1200;
        return speedUp;
    }

}
