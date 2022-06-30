package LogicPackage.StateDifficulties;

import LogicPackage.PlayerSingleton;

public class Difficulty {

    private Level level;

    public Level setDifficultyLevel(){
        if (PlayerSingleton.getInstance().getPaused())
            level = new PauseDifficulty();

        if(PlayerSingleton.getInstance().getCurrentScore()<50){
            level = new Easy();
        }

        else if (PlayerSingleton.getInstance().getCurrentScore()<100){
            level = new Medium();
        }

        else if (PlayerSingleton.getInstance().getCurrentScore()<150){
            level = new Hard();
        }

        else if (PlayerSingleton.getInstance().getCurrentScore()<  250){
            level = new VeryHard();
        }
        else if (PlayerSingleton.getInstance().getCurrentScore()>  250){
            level = new ExtremelyHard();
        }
        return level;
    }
}
