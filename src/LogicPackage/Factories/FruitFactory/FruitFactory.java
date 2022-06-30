package LogicPackage.Factories.FruitFactory;


import LogicPackage.GameObject;

public class FruitFactory {

    public GameObject getFruitType(){
        int i  = (int )(Math.random() * 7 + 1);

        if (i==1)
            return new Watermelon();

        else
        if (i==2)
            return new Apple();

        else
        if (i==3)
            return new Orange();

        else
        if (i==4)
            return new Lemon();

        else
        if (i==5)
            return new Strawberry();

        else
        if (i==6)
            return new Pineapple();

        else
        if (i==7)
            return new Coconut();

        return null;
    }
}
