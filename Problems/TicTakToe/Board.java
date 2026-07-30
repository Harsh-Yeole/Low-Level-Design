package TicTakToe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class Board {
    private int size;
    record Pair(int x,int y){};
    Set<Pair>s=new HashSet<>();
    private playingpeice[][] board;
    int n;
    Map<playingpeice,Integer>m=new HashMap<>();
    int[][]checkrow;
    int [][]checkcol;
    int [][]checkdiagonal;
    Board(int size,ArrayList<playingpeice>list){
        this.n=list.size();
        this.size=size;
        this.board=new playingpeice[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                s.add(new Pair(i,j));
            }
        }
        int i=0;
        for(playingpeice it:list){
            m.put(it,i);
            i++;
        }
        checkrow=new int[n][size];
        checkcol=new int[n][size];
        checkdiagonal=new int[n][2];
    }
    public boolean setpeice(int i,int j,playingpeice pp){
        if(board[i][j]!=null){
            return false;
        }
        else{
            board[i][j]=pp;
            s.remove(new Pair(i,j));
            checkrow[m.get(pp)][j]++;
            checkcol[m.get(pp)][i]++;
            if(i==j)
                checkdiagonal[m.get(pp)][0]++;
            if(j+i==size)
                checkdiagonal[m.get(pp)][1]++;
            return true;
        }
    }
    public boolean isempty(){
        if(s.size()==0)
            return true;
        else
        return false;
    }
    public boolean isWinner(int i,int j,playingpeice pp){
        if(checkrow[m.get(pp)][j]==size)
            return true;
        if(checkcol[m.get(pp)][i]==size)
            return true;
        if(i==j && checkdiagonal[m.get(pp)][0]==size)
            return true;
        if(j+i==size-1 && checkdiagonal[m.get(pp)][1]==size)
            return true;
        return false;
    }
    public void print(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null){
                    System.out.print("NULL");
                }
                else
                board[i][j].getpeice();
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
