package LogicPackage.StateDifficulties;

import LogicPackage.Misc.MyRandom;

public class VeryHard implements Level {
    int speedUp = 0;

    @Override
    public int getNumberofFruitsWave() {
        int numberofFruitsWave = 0;
        numberofFruitsWave = new MyRandom().getRand(5,9);
        return numberofFruitsWave;
    }

    @Override
    public int getNumberofBombsWave() {
        int  numberofBombsWave = 0;
        numberofBombsWave = new MyRandom().getRand(2,4);
        return numberofBombsWave ;    }

    @Override
    public int getSpeed() {
        speedUp = 1200;
        return speedUp;
    }
}
