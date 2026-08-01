package SankesAndLadders;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Game {
    int size;
    int ndice;
    Deque<player>dq;
    Map<player,Integer>m;
    Board board;
    Dice dice;
    Game(int size,int ndice){
        this.size=size;
        this.ndice=ndice;
        dq=new ArrayDeque<>();
        m=new HashMap<>();
        board=new Board(size);
        board.construct();
        dice=Dice.getInstance();
    }
    public void addplayer(player player){
        dq.addLast(player);
        m.put(player, 0);
    }

    public void start(){
        board.printBoard(m);
        boolean winner=false;
        while(!winner){
            player p=dq.getFirst();
            dq.removeFirst();
            int pos=m.get(p);
            int sum=0;
            for(int i=0;i<ndice;i++){
                sum+=dice.roll();
            }
            int next=board.next(pos, sum);
            if(next>=(size*size)){
                System.out.println("Retry:");
                dq.addFirst(p);
                continue;
            }
            m.remove(p);
            m.put(p, next);
            board.printBoard(m);
            if(m.get(p)==(size*size-1)){
                System.out.println("Winner is:"+p.getname());
                winner=true;
            }
            else
            dq.addLast(p);
        }
    }
}
