package LogicPackage.Factories.DifficultyFactory;

public class MediumLevel implements Difficulty {
    @Override
    public void level() {
        DifficultyFactory d = new DifficultyFactory();
        d.setBombTimer(2);
        d.setFruitSpeed(2);
        d.setFruitTimer(2);
        d.setDif('M');

        System.out.println("Medium Level");
    }
}
