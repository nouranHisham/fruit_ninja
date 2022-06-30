package LogicPackage.StateDifficulties;

public class PauseDifficulty implements Level {
    @Override
    public int getNumberofFruitsWave() {
        return 0;
    }

    @Override
    public int getNumberofBombsWave() {
        return 0;
    }

    @Override
    public int getSpeed() {
        return 5;
    }
}
