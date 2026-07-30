package TicTakToe;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Game {
    ArrayList<playingpeice>list;
    Map<playingpeice,Boolean>m;
    int size;
    Deque<player>dq;
    Game(int size){
        this.size=size;
        dq=new LinkedList<>();
        list=new ArrayList<>();
        m=new HashMap<>();
    }
    boolean addplayer(player p){
        playingpeice pp=p.getpeice();
        if(m.containsKey(pp)){
            System.out.println("Used Symbol,try again");
            return false;
        }
        m.put(pp,true);
        list.add(pp);
        dq.addLast(p);
        System.out.println("Successfull");
        return true;
    }
    void start(){
        Scanner scanner = new Scanner(System.in);
        Board board=new Board(size , list);
        boolean winner=false;
        while(!winner){
            if(board.isempty()){
                System.out.println("This game ended up in a tie");
                winner=true;
                continue;
            }
            player p=dq.removeFirst();
            playingpeice pp=p.getpeice();
            board.print();
            System.out.print("Enter the block:");
            int x= scanner.nextInt();
            int y= scanner.nextInt();
            boolean flag=board.setpeice(x,y,pp);
            if(flag==false){
                System.out.println("Invalid Move,try again");
                dq.addFirst(p);
                continue;
            }
            else{
                boolean temp=board.isWinner(x, y, pp);
                if(temp){
                    System.out.println("The Winner is:" + p.getName());
                    winner=true;
                }
                else{
                    dq.addLast(p);
                }
            }
        }
    }
}
