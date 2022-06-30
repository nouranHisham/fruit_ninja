package LogicPackage;

import LogicPackage.Commands.Invoker;
import LogicPackage.Commands.SaveGame;
import ViewPackage.GameViewBackgrounds.ClassicScreen;

import static java.lang.Math.max;


public class PlayerSingleton {
    private static PlayerSingleton instance;
    private  int currentScore = 0;
    private  int bestScore ;
    private  int livesLeft = 3 ;
    private Boolean paused = false;

    public Boolean getPaused() {
        return paused;
    }

    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    public int getLivesLeft() {
        return livesLeft;
    }

    private PlayerSingleton() {

    }

    public void setLivesLeft(int livesLeft) {
        this.livesLeft = livesLeft;
    }

    public static PlayerSingleton getInstance() {
        if (instance == null)
            instance = new PlayerSingleton();
        return instance;
    }
    public void destruct(){

        currentScore = 0;
        livesLeft = 3;

    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public  void calculateCurrentScore(int Multiplier){
        currentScore +=Multiplier;
        ClassicScreen.setCurrentScoreLabel();
    }

    public  void calculateBestScore(int Multiplier){

        if(bestScore==currentScore)
        {bestScore +=Multiplier;}

        bestScore = max(bestScore, currentScore);
        ClassicScreen.setBestScoreLabel();
        if (currentScore%20 == 0){
            Invoker invoker = new Invoker();
            invoker.setCommands(new SaveGame());
            invoker.execute();
        }
    }

    public void loseLife(){
        System.out.println("Life lost");
        livesLeft--;
    }

    public  int getCurrentScore(){
        return currentScore;
    }

    public  int getBestScore(){
        return bestScore;
    }

}
