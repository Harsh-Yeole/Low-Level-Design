package ParkingLot.PricingStratergy;

import java.time.Duration;
import java.time.Instant;

import ParkingLot.Ticket;

public class HourlyPricingStratergy extends PricingStratergy {
    private static PricingStratergy pricingStratergy;
    private HourlyPricingStratergy(){};
    public static PricingStratergy  getInstance(){
        if(pricingStratergy==null)
            return pricingStratergy=new HourlyPricingStratergy();
        else
            return pricingStratergy;
    }
    @Override
    public double Calculate(Ticket ticket){
        Instant now=Instant.now();
        Instant then=ticket.getTime();
        
        double cal=(Duration.between(then,now).toHours())*(60.00d);
        return cal;
    }
}
