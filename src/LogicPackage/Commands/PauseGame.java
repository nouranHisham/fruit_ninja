package LogicPackage.Commands;

import LogicPackage.Misc.ClassicTimer;
import LogicPackage.PlayerSingleton;
import MainPackage.Main;
import ViewPackage.GameEngine;
import ViewPackage.GameViewBackgrounds.ClassicScreen;
import ViewPackage.GameViewBackgrounds.GameScreen;
import ViewPackage.Menus.PauseScreen;


public class PauseGame implements GameCommands {
    @Override
    public void execute() {
        Invoker invoker = new Invoker();
        invoker.setCommands(new SaveGame());
        invoker.execute();

       // GameEngine.pause();
        PlayerSingleton.getInstance().setPaused(true);
        ClassicTimer.getInstance().pauseTimer();
        GameScreen.getGameScreen().stopGame();
        GameScreen.getGameScreen().clearGameBox();
        PauseScreen pauseScreen = PauseScreen.getInstance();
        pauseScreen.prepareScene(Main.stage);

        Invoker invoker2 = new Invoker();
        invoker2.setCommands(new SaveGame());
        invoker2.execute();

    }
}
