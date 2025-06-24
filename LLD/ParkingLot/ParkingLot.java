package LLD.ParkingLot;
import java.util.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.time.LocalDateTime;
import java.time.Duration;

enum SpotType {
    COMPACT, LARGE, BIKE, ELECTRIC, HANDICAPPED
}
    
enum VehicleType {
    CAR, BIKE, TRUCK, ELECTRIC_CAR
}


class ParkingLot {
    String name;
    Map<Integer, Floor> floors;
    Map<String, Ticket> activeTickets; // ticketId -> Ticket

    ParkingLot(String name) {
        this.name = name;
        this.floors = new HashMap<>();
        this.activeTickets = new HashMap<>();
    }

    // Add floors and spots as before...

    public Ticket assignSpotAndGenerateTicket(Vehicle vehicle) {
        for (Floor floor : floors.values()) {
            Spot spot = floor.assignSpot(vehicle);
            if (spot != null) {
                Ticket ticket = new Ticket(vehicle, spot, floor.level);
                activeTickets.put(ticket.ticketId, ticket);
                System.out.println("Vehicle parked. Ticket ID: " + ticket.ticketId);
                return ticket;
            }
        }
        System.out.println("No available spot for vehicle.");
        return null;
    }

    public Bill exitAndGenerateBill(String ticketId) {
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null) {
            System.out.println("Invalid ticket ID");
            return null;
        }

        // Free the spot
        Floor floor = floors.get(ticket.floorNumber);
        if (floor != null) {
            floor.removeSpot(ticket.spot);
            ticket.spot.isAvailable = true;
            floor.addSpot(ticket.spot); // make it reusable
        }

        // Generate bill
        Bill bill = new Bill(ticket);
        bill.printBill();
        return bill;
    }
}



class Bill {
    String ticketId;
    long durationInMinutes;
    double totalFee;

    public Bill(Ticket ticket) {
        LocalDateTime exitTime = LocalDateTime.now();
        this.ticketId = ticket.ticketId;
        this.durationInMinutes = Duration.between(ticket.entryTime, exitTime).toMinutes();
        this.totalFee = calculateFee(ticket.spot, durationInMinutes);
    }

    private double calculateFee(Spot spot, long durationInMinutes) {
        // Simple logic: ₹2 per 15 minutes
        double ratePerHour = 8.0; // ₹8 per hour
        return Math.ceil(durationInMinutes / 60.0) * ratePerHour;
    }

    public void printBill() {
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Duration: " + durationInMinutes + " mins");
        System.out.println("Total Fee: ₹" + totalFee);
    }
}

// Creation of Ticket

class Ticket {
    String ticketId;
    Vehicle vehicle;
    Spot spot;
    int floorNumber;
    LocalDateTime entryTime;

    public Ticket(Vehicle vehicle, Spot spot, int floorNumber) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.spot = spot;
        this.floorNumber = floorNumber;
        this.entryTime = LocalDateTime.now();
    }
}

// Floor Logic
class Floor {
    int level;
    Map<Integer, Spot> spots;

    Floor(int level) {
        this.level = level;
        this.spots = new HashMap<>();
    }

    public void addSpot(Spot spot) {
        spots.put(spot.id, spot);
    }

    public boolean removeSpot(Spot spot) {
        return spots.remove(spot.id) != null;
    }

    public Spot assignSpot(Vehicle vehicle) {
        for (Spot spot : spots.values()) {
            if (spot.isAvailable && spot.canFitVehicle(vehicle)) {
                spot.isAvailable = false;
                return spot;
            }
        }
        return null;
    }
}



// Spot logic
abstract class Spot {
    int id;
    SpotType type;
    boolean isAvailable;

    Spot(int id, SpotType type) {
        this.id = id;
        this.type = type;
        this.isAvailable = true;
    }

    abstract boolean canFitVehicle(Vehicle vehicle);
}
// Createad for compact similar ways we can create it for diffferent other spots
class CompactSpot extends Spot {
    
    CompactSpot(int id) {
        super(id, SpotType.COMPACT);

    }

    @Override
    boolean canFitVehicle(Vehicle vehicle) {
        // TODO Auto-generated method stub
        return vehicle instanceof Car;
    }

}


// Created Vehicle using Factory Design Pattern
class VehicleFactory {

    static public Vehicle createVehicle(VehicleType type) {
        switch (type) {
            case CAR: return new Car();
            case BIKE: return new Bike();
            case TRUCK: return new Truck();
            case ELECTRIC_CAR: return new ElectricCar();
            default: throw new IllegalArgumentException("Unsupported vehicle type");
        }
    }
    
}

abstract class Vehicle {
    String licensePlate;
    int noOfWheels;
    void display(){
        System.out.println("liscense plate : "+licensePlate+" wheel : "+noOfWheels);
    }
}

class Car extends Vehicle {
    public Car() {
        this.noOfWheels = 4;
    }
}

class Bike extends Vehicle {
    public Bike() {
        this.noOfWheels = 2;
    }
}

class Truck extends Vehicle {
    public Truck() {
        this.noOfWheels = 6;
    }
}

class ElectricCar extends Vehicle {
    public ElectricCar() {
        this.noOfWheels = 4;
    }
}