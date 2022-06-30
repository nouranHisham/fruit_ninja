package LogicPackage.Commands;

import LogicPackage.Mementos.CareTaker;
import LogicPackage.Misc.ClassicTimer;
import LogicPackage.PlayerSingleton;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class LoadNewGame implements GameCommands {
    @Override
    public void execute() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CareTaker.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            CareTaker careTaker = (CareTaker) unmarshaller.unmarshal(new File("Memento.xml"));

            PlayerSingleton.getInstance().setBestScore(careTaker.get(0).getBestScore());
            PlayerSingleton.getInstance().setCurrentScore(0);

        } catch (JAXBException e) {
            System.out.println("No previous saved file");
        }
    }
}
