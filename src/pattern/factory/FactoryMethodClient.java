package pattern.factory;

/**
 * This class serves as a demonstration for Factory design pattern in java
 */
public class FactoryMethodClient {
    public static void main(String args[])  {
        Pizza pizza = PizzaFactory.createPizza(PizzaType.GREEK);
        System.out.println(pizza.pizzaType());
    }
}

enum PizzaType  {
    NEO("neo"), GREEK("greek"),
    NEW_YORK("newYork");

    String type;
    PizzaType(String s) {
        this.type = s;
    }

    public String getType() {
        return type;
    }
}

interface Pizza   {
    PizzaType pizzaType();
}


class NeoPizza implements Pizza {

    @Override
    public PizzaType pizzaType() {
        return PizzaType.NEO;
    }
}

class GreekPizza implements Pizza   {

    @Override
    public PizzaType pizzaType() {
        return PizzaType.GREEK;
    }
}

class NewYorkPizza implements Pizza {

    @Override
    public PizzaType pizzaType() {
        return PizzaType.NEW_YORK;
    }
}
class PizzaFactory  {
    public static Pizza createPizza(PizzaType pizzaType)    {
        switch (pizzaType)  {
            case NEO:
                return new NeoPizza();
            case GREEK:
                return new GreekPizza();
            case NEW_YORK:
                return new NewYorkPizza();
            default:
                throw new UnsupportedOperationException("Pizza type is invalid");
        }
    }
}
