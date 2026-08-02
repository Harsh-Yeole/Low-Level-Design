package ParkingLot;

import java.util.Scanner;

import ParkingLot.CostComputation.CostComputation;
import ParkingLot.CostComputation.CostComputationFactory;
import ParkingLot.ParkingSpot.ParkingSpotManager;
import ParkingLot.PaymentStratergy.PaymentStratergy;
import ParkingLot.PaymentStratergy.PaymentStratergyFactory;
import ParkingLot.Vehicle.Vehicle;

public class Exit {
    CostComputationFactory cf=new CostComputationFactory();
    PaymentStratergyFactory pf=new PaymentStratergyFactory();
    PaymentStratergy ps;
    Exit(Ticket ticket){
        Scanner sc=new Scanner(System.in);
        Vehicle v=ticket.getVehicle();
        int type=v.gettype();
        ParkingSpotManager parkingSpotManager=ticket.getParkingSpotManager();
        CostComputation cc=cf.getCC(v);
        double charge=cc.charge(ticket);
        boolean flag=false;
        System.out.println("Your total charge is:%d"+charge);
        while(!flag){
            System.out.println("What do you want to use to pay:\n1)UPI");
            int input=sc.nextInt();
            ps=pf.getpS(input);
            flag=ps.pay();
            if(!flag){
                System.out.println("PaymentFailed,Retry:");
            }
        }
        parkingSpotManager.remove(ticket.getParkingSpot());
    }
    boolean Payment(){
        return true;
    }
}
