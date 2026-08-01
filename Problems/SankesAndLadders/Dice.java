package SankesAndLadders;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    // 1. Make the instance static and private
    private static Dice dice;
    
    // 2. Keep the private constructor
    private Dice(){
        
    }
    
    // 3. Make the getter method static
    public static Dice getInstance(){
        if(dice == null){
            dice = new Dice();
        }
        return dice;
    }
    public int roll(){
        int min = 1;
        int max = 6;
        // Note: upper bound is exclusive, so use max + 1
        int randomNumber = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNumber;
    } 
}