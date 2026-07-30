package TicTakToe;

public class player {
    private String name;
    private playingpeice pp;
    player(String name,playingpeice pp){
        this.name=name;
        this.pp=pp;
    }
    public String getName(){
        return name;
    }
    public playingpeice getpeice(){
        return this.pp;
    }
}
