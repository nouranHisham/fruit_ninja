package LogicPackage.Commands;

import LogicPackage.Mementos.CareTaker;
import LogicPackage.Mementos.Memento;
import LogicPackage.Mementos.Originator;
import LogicPackage.PlayerSingleton;
import ViewPackage.Menus.WelcomeScreen;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.jar.JarException;

public class SaveGame implements GameCommands {
    @Override
    public void execute() {
        System.out.println("Saving...");
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setCurrentScore();
        originator.setLives();
        originator.setBestScore();
        careTaker.add(originator.createMemento());

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CareTaker.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(careTaker, new File("Memento.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

