package LogicPackage.Commands;

import LogicPackage.Misc.AudioHandling;

public class PlayThemeMusic implements GameCommands {
    @Override
    public void execute() {
        AudioHandling.getInstance().stopAll();
        AudioHandling.getInstance().playThemeSong();
    }
}
