package LogicPackage.Commands;

import ViewPackage.Menus.WelcomeScreen;

public class HoldGame implements GameCommands {
    @Override
    public void execute() {
        //Todo: Memento save the game
        WelcomeScreen.getInstance().prepareScene();
    }
}
