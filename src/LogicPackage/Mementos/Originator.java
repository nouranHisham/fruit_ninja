package LogicPackage.Mementos;

import LogicPackage.Misc.ClassicTimer;
import LogicPackage.Misc.SaveTimer;
import LogicPackage.PlayerSingleton;

public class Originator {

    private int currentScore;
    private int lives;
    private int bestScore;


    public void setCurrentScore( ){
        this.currentScore = PlayerSingleton.getInstance().getCurrentScore();
    }
    public void setLives( ){
        this.lives = PlayerSingleton.getInstance().getLivesLeft();
    }
    public void setBestScore( ){
        this.bestScore = PlayerSingleton.getInstance().getBestScore();
    }

    public int getCurrentScore(){
        return currentScore;
    }
    public int getLives(){return lives;}

    public Memento createMemento(){
        SaveTimer saveTimer = new SaveTimer();
            saveTimer.setMillis(ClassicTimer.getInstance().getMillis());
            saveTimer.setSecs(ClassicTimer.getInstance().getSecs());
            saveTimer.setMins(ClassicTimer.getInstance().getMins());

        Memento memento = new Memento();
        memento.setLives(lives);
        memento.setCurrentScore(currentScore);
        memento.setBestScore(bestScore);
        memento.setSaveTimer(saveTimer);
        return memento;
    }

}