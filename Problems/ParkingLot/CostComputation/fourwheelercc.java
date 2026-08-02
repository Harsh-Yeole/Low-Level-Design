package ParkingLot.CostComputation;

import ParkingLot.Ticket;
import ParkingLot.PricingStratergy.HourlyPricingStratergy;

public class fourwheelercc extends CostComputation {
    public fourwheelercc(){
        super(HourlyPricingStratergy.getInstance());
    }
}
