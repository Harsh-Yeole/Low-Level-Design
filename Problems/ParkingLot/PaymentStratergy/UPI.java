package ParkingLot.PaymentStratergy;

import java.util.Scanner;

public class UPI extends PaymentStratergy {
    @Override
    public boolean pay(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Paid?");
        int flag=sc.nextInt();
        if(flag==1)
        return true;
        else
        return false;
    }
}
