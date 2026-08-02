package ParkingLot.CostComputation;

import ParkingLot.Vehicle.Vehicle;

public class CostComputationFactory {
    public CostComputation getCC(Vehicle vehicle){
        if(vehicle.gettype()==2){
            return new twowheelercc();
        }
        else
            return new fourwheelercc();
    }
}
