package Creational.Builder;

import Creational.Builder.Pizza.PizzaBuilder;

public class PizzaSystem {

    public static void main(String[] args) {

        Pizza vegPizza = new Pizza.PizzaBuilder().setSize(SIZE.SMALL).setCheese(true).build();
        vegPizza.display();
        Pizza nonvPizza = new Pizza.PizzaBuilder().setSize(SIZE.BIG).setCheese(true).setBacon(true).setPepperoni(true).build();
        nonvPizza.display();
    }
}
// Pizza Sizes
enum SIZE {
    SMALL, MEDIUM, BIG
}

/*
    A Pizza can have:

    Size: SMALL, MEDIUM, LARGE (Required)

    Cheese: Yes/No

    Pepperoni: Yes/No

    Bacon: Yes/No

    ExtraToppings: List of Strings (Optional) 
*/

class Pizza {
    private SIZE size;
    private boolean isCheese,  isPepperoni, isBacon;

    private Pizza(PizzaBuilder pizzaBuilder) {
        this.size = pizzaBuilder.size;
        this.isBacon = pizzaBuilder.isBacon;
        this.isCheese = pizzaBuilder.isCheese;
        this.isPepperoni = pizzaBuilder.isPepperoni;
    }

    public void display(){
        System.out.println("SIZE : "+size.toString()+" Cheese : "+isCheese+" Bacon : "+isBacon+" Pepperoni : "+isPepperoni );
    }


    static class PizzaBuilder {
        private SIZE size;
        private boolean isCheese = false,  isPepperoni = false, isBacon = false;
        
        public PizzaBuilder setSize(SIZE size) {
            this.size = size;
            return this;
        }

        public PizzaBuilder setCheese(boolean isCheese){
            this.isCheese = isCheese;
            return this;
        }

        public PizzaBuilder setPepperoni(boolean isPepperoni){
            this.isPepperoni = isPepperoni;
            return this;
        }

        public PizzaBuilder setBacon(boolean isBacon){
            this.isBacon = isBacon;
            return this;
        }

        public Pizza build(){
            return new Pizza(this);
        }

    }
}
