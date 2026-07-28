package StratergyPattern;

import StratergyPattern.DrivingStratergy.SportDriving;

public class Main {
    public static void main(String[] args) {
        Vehicle sportsVehicle =new SportsVehicle(new SportDriving());
        sportsVehicle.drive();
    }   
}
