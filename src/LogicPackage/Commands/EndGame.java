package LogicPackage.Commands;

import LogicPackage.Misc.AudioHandling;
import LogicPackage.Misc.ClassicTimer;
import LogicPackage.PlayerSingleton;
import ViewPackage.GameOverScreen;
import ViewPackage.GameViewBackgrounds.GameScreen;

import java.io.File;
import java.io.FileNotFoundException;

public class EndGame implements GameCommands {
    @Override
    public void execute() {
        PlayerSingleton.getInstance().destruct();

        Invoker invoker = new Invoker();
        invoker.setCommands(new SaveGame());
        invoker.execute();

        ClassicTimer.getInstance().resetTimer();

        GameScreen.getGameScreen().stopGame();

        AudioHandling.getInstance().stopAll();
        AudioHandling.getInstance().playGameOverSound();
        GameOverScreen gameOverScreen = new GameOverScreen();
        gameOverScreen.GameOver();
    }
}
