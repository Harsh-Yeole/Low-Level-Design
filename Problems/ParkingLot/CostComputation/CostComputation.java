package ParkingLot.CostComputation;

import ParkingLot.Ticket;
import ParkingLot.PricingStratergy.PricingStratergy;

public abstract class CostComputation {
    PricingStratergy pricingStratergy;
    public CostComputation(PricingStratergy pricingStratergy){
        this.pricingStratergy=pricingStratergy;
    }
    public double charge(Ticket t){
        return this.pricingStratergy.Calculate(t);
    }
}
