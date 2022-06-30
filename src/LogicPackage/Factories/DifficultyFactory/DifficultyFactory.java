package LogicPackage.Factories.DifficultyFactory;

public class DifficultyFactory {
    float fruitSpeed, fruitTimer ,bombTimer;
    char dif;
    public Difficulty getDifficultyLevel(String level){
        if(level==null)
        return null;

        if(level.equalsIgnoreCase("Easy"))
        return new EasyLevel();
        else
            if (level.equalsIgnoreCase("Medium"))
                return new MediumLevel();
        else
            if (level.equalsIgnoreCase("Hard"))
                return new HardLevel();

            return null;
        }

    public float getFruitSpeed() {
        return fruitSpeed;
    }

    public void setFruitSpeed(float fruitSpeed) {
        this.fruitSpeed = fruitSpeed;
    }

    public float getFruitTimer() {
        return fruitTimer;
    }

    public void setFruitTimer(float fruitTimer) {
        this.fruitTimer = fruitTimer;
    }

    public float getBombTimer() {
        return bombTimer;
    }

    public void setBombTimer(float bombTimer) {
        this.bombTimer = bombTimer;
    }

    public char getDif() {
        return dif;
    }

    public void setDif(char dif) {
        this.dif = dif;
    }
}
