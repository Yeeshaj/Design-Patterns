package Creational.Factory.vehicleSystem;

public class VehicleFactory {
    public Vehicle getVehicle(String type)
    {
        switch (type) {
            case "car":
                return new Car();

            case "bike":
                return new Bike();
                
            default:
                return null;
                
        }
    }
}
