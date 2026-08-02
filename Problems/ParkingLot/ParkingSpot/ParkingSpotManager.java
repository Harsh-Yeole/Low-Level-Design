package ParkingLot.ParkingSpot;

import ParkingLot.Gate;
import ParkingLot.Ticket;
import ParkingLot.Vehicle.Vehicle;

abstract public class ParkingSpotManager {
    public abstract ParkingSpot findParkingSpot(Gate g);
    public abstract Ticket Park(ParkingSpot p,Vehicle v);
    public abstract void addGate(Gate g);
    public abstract void addParkingSpot(ParkingSpot p);
    public abstract void remove(ParkingSpot p);
    public abstract Ticket generateTicket(ParkingSpot p,Vehicle v);
}
