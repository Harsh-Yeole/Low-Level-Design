package ParkingLot.PricingStratergy;

import java.time.Duration;
import java.time.Instant;

import ParkingLot.Ticket;

public class MinutePricingStratergy extends PricingStratergy {
    private static PricingStratergy pricingStratergy;
    private MinutePricingStratergy(){};
    public static PricingStratergy  getInstance(){
        if(pricingStratergy==null)
            return pricingStratergy=new MinutePricingStratergy();
        else
            return pricingStratergy;
    }
    @Override
    public double Calculate(Ticket ticket){
        Instant now=Instant.now();
        Instant then=ticket.getTime();
        
        double cal=(Duration.between(then,now).toMinutes())*(1.50d);
        return cal;
    }
}
