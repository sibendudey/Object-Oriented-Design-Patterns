package pattern.decorator;

public class DecoratorClient {
    public static void main(String args[])  {
        Pizza pizza = new NewYorkPizza();
        PizzaTopping pizzaTopping = new ChickenTopping(new OnionTopping(pizza));
        System.out.println(pizzaTopping.name());
        System.out.println(pizzaTopping.cost());
    }
}

interface Pizza {
    String name();
    int cost();
}


class NewYorkPizza implements Pizza {

    @Override
    public String name() {
        return "New York";
    }

    @Override
    public int cost() {
        return 100;
    }
}

abstract class PizzaTopping implements Pizza    {
    Pizza pizza;

    PizzaTopping(Pizza pizza)   {
        this.pizza = pizza;
    }

    public String name()    {
        return pizza.name() + " with toppings ";
    }
    public int cost()   {
        return pizza.cost();
    }
}

class ChickenTopping extends PizzaTopping   {

    ChickenTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String name() {
        return super.name() + " chicken";
    }

    @Override
    public int cost()   {
        return super.cost() + 20;
    }
}

class OnionTopping extends PizzaTopping {

    OnionTopping(Pizza pizza) {
        super(pizza);
    }

    public String name()    {
        return super.name() + " onion";
    }

    @Override
    public int cost() {
        return super.cost() + 5;
    }
}