package StratergyPattern;
import StratergyPattern.DrivingStratergy.DriveStratergy;
public class Vehicle {
    DriveStratergy driveStratergy;
    Vehicle(DriveStratergy driveStratergy){
        this.driveStratergy = driveStratergy;
    }
    public void drive(){
        driveStratergy.drive();
    }
}
