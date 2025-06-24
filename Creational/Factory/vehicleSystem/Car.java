package Creational.Factory.vehicleSystem;

// public class Car implements Vehicle {

public class Car extends Vehicle{
    @Override
    public void start() {
        // TODO Auto-generated method stub
        System.out.println("Car is started");
    }
    public void stop()
    {
        System.out.println("car is stopped");
    }
}
