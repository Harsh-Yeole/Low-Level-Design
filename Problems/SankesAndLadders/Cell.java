package SankesAndLadders;

public class Cell {
    Jump jump;
    Cell(){
        this.jump=null;
    }
    public void intialise(Jump jump){
        this.jump=jump;
    }
    public int next(int n){
        return jump.next(n);
    }
}
