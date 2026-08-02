package ParkingLot.Vehicle;

public class VehicleFactory {
    public Vehicle getVehicle(int type){
        if(type==2)
            return new twowheeler();
        if(type==4)
            return new fourwheeler();
        return null;
    }
}
