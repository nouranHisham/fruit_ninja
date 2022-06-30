package LogicPackage.Factories.DifficultyFactory;

public class HardLevel implements Difficulty {
    @Override
    public void level() {
        DifficultyFactory d = new DifficultyFactory();
        d.setBombTimer(3);
        d.setFruitSpeed(3);
        d.setFruitTimer(3);
        d.setDif('H');

        System.out.println("Hard Level");
    }
}
