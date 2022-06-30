package LogicPackage.Mementos;

import LogicPackage.Misc.SaveTimer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name= "Mementos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Memento {
    @XmlElement(name = "currentScore")
    private int currentScore;

    @XmlElement(name = "lives")
    private int lives;

    @XmlElement(name = "Timer")
    private SaveTimer saveTimer;

    @XmlElement(name = "bestScore")
    private int bestScore;

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public SaveTimer getSaveTimer() {
        return saveTimer;
    }

    public void setSaveTimer(SaveTimer saveTimer) {
        this.saveTimer = saveTimer;
    }

    public int getCurrentScore(){
        return currentScore;
    }
    public int getLives(){return lives;}

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }


}
