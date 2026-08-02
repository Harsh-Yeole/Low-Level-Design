package ParkingLot.ParkingSpot;

import ParkingLot.Vehicle.Vehicle;

public class ParkingSpot {
    private int x,y,z;
    private int type;
    private boolean isempty;
    Vehicle vehicle;
    public ParkingSpot(int id,int x,int y,int floor,int type){
        this.x=x;
        this.y=y;
        this.z=floor;
        this.type=type;
        isempty=true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public boolean isEmpty() {
        return isempty;
    }

    public void park(Vehicle vehicle){
        this.vehicle=vehicle;
        this.isempty=false;
    }
    public void remove(){
        this.vehicle=null;
        this.isempty=true;
    }
}
