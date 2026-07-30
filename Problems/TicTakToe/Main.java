package TicTakToe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What shoud be the size of the board:");
        int x= scanner.nextInt();
        Game game=new Game(x);
        Map<Integer,peiceenum>m=new HashMap<>();
        Set<Integer>s=new HashSet<>();
        s.add(1);
        m.put(1,peiceenum.X);
        s.add(2);
        m.put(2,peiceenum.Y);
        s.add(3);
        m.put(3,peiceenum.O);
        s.add(4);
        m.put(4,peiceenum.$);
        boolean choice=true;
        while(s.size()>0 && choice){
            System.out.println("End?");
            int ny=scanner.nextInt();
            if(ny==1){
                choice=false;
                continue;
            }
            for(int i=1;i<5;i++){
                System.out.println(i+")"+m.get(i));
            }
            int y= scanner.nextInt();
            playingpeice pp=new playingpeice(m.get(y));
            if(s.contains(y)){
                scanner.nextLine();
                System.out.println("your Name:");
                String name=scanner.nextLine();
                player p=new player(name,pp);
                game.addplayer(p);
                s.remove(y);
            }
            else{
                System.out.println("Retry");
            }
        }
        game.start();
    }
}
