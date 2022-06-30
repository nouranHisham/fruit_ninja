package LogicPackage.StateDifficulties;

import LogicPackage.Misc.MyRandom;

public class ExtremelyHard implements Level {
    int speedUp = 0 ;
    @Override
    public int getNumberofFruitsWave() {
        int numberofFruitsWave = 0;
        numberofFruitsWave = new MyRandom().getRand(6,10);
        return numberofFruitsWave;
    }

    @Override
    public int getNumberofBombsWave() {
        int  numberofBombsWave = 0;
        numberofBombsWave = new MyRandom().getRand(2,5);
        return numberofBombsWave ;
    }

    @Override
    public int getSpeed() {
        speedUp = 1000;
        return speedUp;    }
}
