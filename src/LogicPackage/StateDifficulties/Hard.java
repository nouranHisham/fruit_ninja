package LogicPackage.StateDifficulties;

import LogicPackage.Misc.MyRandom;
import LogicPackage.PlayerSingleton;

public class Hard implements Level {

    int speedUp = 0;

    @Override
    public int getNumberofFruitsWave() {
        int numberofFruitsWave = 0;
        numberofFruitsWave = new MyRandom().getRand(3,6);
        return numberofFruitsWave;
    }

    @Override
    public int getNumberofBombsWave() {
        int  numberofBombsWave = 0;
        numberofBombsWave = new MyRandom().getRand(1,3);
        return numberofBombsWave ;
    }

    @Override
    public int getSpeed() {
        speedUp = 1400;
        return speedUp;
    }

}
