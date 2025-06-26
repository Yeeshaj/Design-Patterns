package Structural.Decorate;

public class CoffeeSystem {
    public static void main(String[] args) {
        Coffee coffee  = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new MochaDecorator(coffee);

        System.out.println(coffee.getDescription());
        System.out.println(coffee.getCost());
    }
}

interface Coffee {
    String getDescription();
    double getCost();
}



class SimpleCoffee implements Coffee {

    public String getDescription() {
            return "Simple Coffee";
        }

    public double getCost() 
    {
        return 10.00;
    }

}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription();
    }

    public double getCost() {
        return coffee.getCost();
    }
}

class MilkDecorator extends CoffeeDecorator {

    MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return coffee.getDescription() + " Milk";
    }

    public double getCost() {
        return coffee.getCost() + 2.00;
    }

}

class SugarDecorator extends CoffeeDecorator {

    SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return coffee.getDescription() + " Sugar";
    }

    public double getCost() {
        return coffee.getCost() + 2.50;
    }
}

class MochaDecorator extends CoffeeDecorator {
    
    MochaDecorator(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return coffee.getDescription() + " Mocha";
    }

    public double getCost() {
        return coffee.getCost() + 3.00;
    }
}

class WhipDecorator extends CoffeeDecorator {
    
    WhipDecorator(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return coffee.getDescription() + "Whip";
    }

    public double getCost() {
        return coffee.getCost() + 5.50;
    }
}