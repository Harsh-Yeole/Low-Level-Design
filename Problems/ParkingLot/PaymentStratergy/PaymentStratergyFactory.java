package ParkingLot.PaymentStratergy;

public class PaymentStratergyFactory {
    public PaymentStratergy getpS(int input){
        if(input==1)
            return new UPI();
        return new UPI();
    }
}
