package LogicPackage.Commands;

import LogicPackage.Misc.AudioHandling;
import LogicPackage.PlayerSingleton;
import MainPackage.Main;
import ViewPackage.GameViewBackgrounds.GameScreen;

public class ResumeGame implements GameCommands {
    @Override
    public void execute() {
        AudioHandling.getInstance().stopAll();
        AudioHandling.getInstance().playStartGame();
        PlayerSingleton.getInstance().setPaused(false);
        new GameScreen("Classic", Main.stage);
    }
}
