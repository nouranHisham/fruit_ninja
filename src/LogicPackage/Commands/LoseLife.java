package LogicPackage.Commands;

import LogicPackage.PlayerSingleton;
import ViewPackage.GameViewBackgrounds.ClassicScreen;
import ViewPackage.GameViewBackgrounds.GameScreen;

import javax.xml.bind.JAXBException;

public class LoseLife implements GameCommands {
    @Override
    public void execute()   {
        PlayerSingleton.getInstance().loseLife();
        if (PlayerSingleton.getInstance().getLivesLeft()<1)
        {
            GameScreen.getGameScreen().stopGame();
            Invoker invoker = new Invoker();
            invoker.setCommands(new EndGame());
            invoker.execute();
        }
        ClassicScreen.loseLifeLabel(PlayerSingleton.getInstance().getLivesLeft());
    }
}
