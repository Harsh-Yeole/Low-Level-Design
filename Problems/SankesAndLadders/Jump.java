package SankesAndLadders;

public class Jump {
    int sx;
    int sy;
    int ex;
    int ey;
    boolean isLadder;
    int id;

    Jump(int sx,int sy,int ex,int ey, boolean isLadder, int id){
        this.sx=sx;
        this.sy=sy;
        this.ex=ex;
        this.ey=ey;
        this.isLadder=isLadder;
        this.id=id;
    }

    public boolean isLadder(){
        return isLadder;
    }

    public int getId(){
        return id;
    }

    public int next(int n){
        return (n*ex+ey);
    }
}
