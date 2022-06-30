package LogicPackage.Commands;

import LogicPackage.Mementos.CareTaker;
import LogicPackage.Misc.ClassicTimer;
import LogicPackage.PlayerSingleton;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class LoadOldGame implements GameCommands {
    @Override
    public void execute() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CareTaker.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            CareTaker careTaker = (CareTaker) unmarshaller.unmarshal(new File("Memento.xml"));

            PlayerSingleton.getInstance().setLivesLeft(careTaker.get(0).getLives());
            PlayerSingleton.getInstance().setCurrentScore(careTaker.get(0).getCurrentScore());
            PlayerSingleton.getInstance().setBestScore(careTaker.get(0).getBestScore());

            ClassicTimer.getInstance().setMillis(careTaker.get(0).getSaveTimer().getMillis());
            ClassicTimer.getInstance().setSecs(careTaker.get(0).getSaveTimer().getSecs());
            ClassicTimer.getInstance().setMins(careTaker.get(0).getSaveTimer().getMins());

        } catch (JAXBException e) {
            System.out.println("No previous saved file");
        }
    }
}
