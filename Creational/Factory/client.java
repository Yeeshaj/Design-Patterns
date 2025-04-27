package Creational.Factory;

public class client {
    

    public static void main(String[] args) {

        /* 
         *  We cannot create interface objects if no classes is implementing it.
         *  but if classes are implementing the interface it can create there objects.
         *  and we can call only those methods which are there in interface.
         * 
        */
        
        VehicleFactory factory = new VehicleFactory();
        Vehicle vehicle =  factory.getVehicle("car");
        vehicle.start();
        //Down casting to acces the few methods added in car class
        if(vehicle instanceof Car)
            {
                Car car = (Car) vehicle;
                car.stop();
            }
    
    }
}
