package ParkingLot.CostComputation;

import ParkingLot.PricingStratergy.MinutePricingStratergy;

public class twowheelercc extends CostComputation {
    public twowheelercc(){
        super(MinutePricingStratergy.getInstance());
    }
}
