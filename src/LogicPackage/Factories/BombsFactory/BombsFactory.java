package LogicPackage.Factories.BombsFactory;

import LogicPackage.GameObject;

public class BombsFactory {

    public GameObject getBombType( ){
        int i  = (int )(Math.random() * 2 + 1);

        if(i == 1)
            return (GameObject) new BlueDangerousBomb();
        else
        if (i==2)
            return (GameObject) new RedFatalBomb();

        return null;
    }
}
