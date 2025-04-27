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
        Vehicle car =  factory.getVehicle("car");
        car.start();
    
    
    }
}
