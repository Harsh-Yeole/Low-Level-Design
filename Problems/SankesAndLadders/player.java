package SankesAndLadders;

public class player {
    private static int playerCount = 0;
    String name;
    String symbol;

    player(String name){
        this.name = name;
        playerCount++;
        this.symbol = "P" + playerCount;
    }

    public String getname(){
        return this.name;
    }

    public String getSymbol(){
        return symbol;
    }
}
