package OOPS;

public class AbstractExample {
    
    public static void main(String args[]) {
        Animal dog = new Dog();

        dog.makeSound();
        dog.sleep();
    }
}


abstract class Animal {
    abstract void makeSound();
    void sleep() {
        System.out.println("Animal is sleeping");
    }
}

class Dog extends Animal {

    @Override
    void makeSound() {
       System.out.println("Dog is barking");
    }

}