package ParkingLot;

import java.time.Instant;

import ParkingLot.ParkingSpot.ParkingSpot;
import ParkingLot.Vehicle.Vehicle;
import ParkingLot.ParkingSpot.ParkingSpotManager;
public class Ticket {
    private ParkingSpot p;
    private Vehicle v;
    private Instant time;
    private ParkingSpotManager parkingSpotManager;
    public Ticket(ParkingSpot p,Vehicle v,ParkingSpotManager parkingSpotManager){
        this.p=p;
        this.v=v;
        this.time=Instant.now();
        this.parkingSpotManager=parkingSpotManager;
    }
    public Instant getTime(){
        return this.time;
    }
    public Vehicle getVehicle(){
        return this.v;
    }
    public ParkingSpotManager getParkingSpotManager(){
        return this.parkingSpotManager;
    }
    public ParkingSpot getParkingSpot(){
        return this.p;
    }
}
