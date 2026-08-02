package ParkingLot.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

import ParkingLot.Gate;
import ParkingLot.Ticket;
import ParkingLot.ParkingStratergy.NeatestToEntrance;
import ParkingLot.ParkingStratergy.ParkingStratergy;
import ParkingLot.Vehicle.Vehicle;

public class fourwheelerpsm extends ParkingSpotManager {
    private final List<ParkingSpot> parkingSpots = new ArrayList<>();
    private final ParkingStratergy parkingStrategy;
    ParkingSpotManager parkingSpotManager;
    private fourwheelerpsm() {
        this.parkingStrategy = new NeatestToEntrance();
    }
    public ParkingSpotManager getInstance(){
        if(parkingSpotManager==null){
            return parkingSpotManager=new fourwheelerpsm();
        }
        else
            return parkingSpotManager;
    }
    @Override
    public ParkingSpot findParkingSpot(Gate g) {
        return this.parkingStrategy.getSpot(g);
    }

    @Override
    public void addParkingSpot(ParkingSpot p) {
            parkingSpots.add(p);
            parkingStrategy.addParkingSpotToAllGates(p);
    }

    @Override
    public Ticket Park(ParkingSpot p, Vehicle v) {
        if (p != null) {
            p.park(v);
            return generateTicket(p,v);
        }
        return null;
    }

    @Override
    public void addGate(Gate g) {
        parkingStrategy.addGate(g, parkingSpots);
    }

    @Override
    public void remove(ParkingSpot p) {
        if (p != null) {
            p.remove();
            parkingStrategy.addParkingSpotToAllGates(p);
        }
    }

    @Override
     public Ticket generateTicket(ParkingSpot p,Vehicle v){
        return new Ticket(p,v,parkingSpotManager);
     }
}
