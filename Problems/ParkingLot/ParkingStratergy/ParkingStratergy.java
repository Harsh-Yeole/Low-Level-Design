package ParkingLot.ParkingStratergy;

import java.util.List;

import ParkingLot.Gate;
import ParkingLot.ParkingSpot.ParkingSpot;

abstract public class ParkingStratergy {
    public abstract ParkingSpot getSpot(Gate g);
    public abstract void addParkingSpotToAllGates(ParkingSpot parkingSpot);
    public abstract void addGate(Gate g,List<ParkingSpot> parkingSpots);
}