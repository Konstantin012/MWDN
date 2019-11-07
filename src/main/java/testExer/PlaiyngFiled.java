package testExer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlaiyngFiled {
    public int countForTie;
    private Map<Integer, String > map = new HashMap<>();

    public PlaiyngFiled(){
        getMap().put(1,"1");
        getMap().put(2,"2");
        getMap().put(3,"3");
        getMap().put(4,"4");
        getMap().put(5,"5");
        getMap().put(6,"6");
        getMap().put(7,"7");
        getMap().put(8,"8");
        getMap().put(9,"9");

    }

    public int getCountForTie() {
        return countForTie=0;
    }

    public void setCountForTie(int countForTie) {
        this.countForTie = countForTie;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public void setCharToMap(Integer number, String value){
        getMap().put(number,value);
    }

    public void showCurrentfield(){
        int count =0;
        Set<Integer> keys = map.keySet();
        for (Integer key:keys) {
                System.out.print(map.get(key) + "   ");
                count++;
            if(count%3==0)
            System.out.println();
        }
    }

    public boolean reWriteMap(int num, String charac){
        if(map.get(num).equals("X")|map.get(num).equals("O")){
            System.out.println("This filed is filled. Choose the other");
            showCurrentfield();
            return false;
        }
        else {
            getMap().put(num,charac);
            return true;
        }
    }

    public boolean findTheWinner(){
        while (countForTie!=9){
            if(     map.get(1).equals(map.get(5)) & map.get(1).equals(map.get(9)) |
                    map.get(1).equals(map.get(4)) & map.get(4).equals(map.get(7)) |
                    map.get(1).equals(map.get(2)) & map.get(2).equals(map.get(3)) |
                    map.get(3).equals(map.get(6)) & map.get(6).equals(map.get(9)) |
                    map.get(2).equals(map.get(5)) & map.get(5).equals(map.get(8)) |
                    map.get(7).equals(map.get(8)) & map.get(8).equals(map.get(9)) |
                    map.get(4).equals(map.get(5)) & map.get(5).equals(map.get(6)) |
                    map.get(3).equals(map.get(5)) & map.get(5).equals(map.get(7)) ){
                if(     map.get(1).equals(map.get(4).equals(map.get(7).equals("X")))|
                        map.get(1).equals(map.get(2).equals(map.get(3).equals("X")))|
                        map.get(1).equals(map.get(5).equals(map.get(9).equals("X")))|
                        map.get(3).equals(map.get(6).equals(map.get(9).equals("X")))|
                        map.get(3).equals(map.get(5).equals(map.get(7).equals("X")))|
                        map.get(7).equals(map.get(8).equals(map.get(9).equals("X")))|
                        map.get(4).equals(map.get(5).equals(map.get(6).equals("X")))|
                        map.get(2).equals(map.get(5).equals(map.get(8).equals("X")))){
                    System.out.println("Game is over, “X” won");
                    return true;
                }
                else {
                    System.out.println("Game is over, “O” won");
                    return true;
                }
            }
            else {
                countForTie++;
                return false;
            }
        }
        System.out.println("Game is over, result is a tie");
        return true;

    }


}
