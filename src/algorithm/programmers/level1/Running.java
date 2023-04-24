package algorithm.programmers.level1;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;

public class Running implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        String[] solution = solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
        for (int i = 0; i < solution.length; i++) {
            System.out.print(solution[i] + " ");
        }
    }

    static String[] res;
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> nameRank = new HashMap<>();
        HashMap<Integer,String> rankName = new HashMap<>();
        for(int i=0;i<players.length;i++){
            nameRank.put(players[i], i+1);
            rankName.put(i+1, players[i]);
        }
        for(int i=0;i<callings.length;i++){
            String overTaker = callings[i];
            int overTakerRank = nameRank.get(overTaker);
            String overTaken = rankName.get(overTakerRank-1);
            nameRank.put(overTaker, overTakerRank-1);
            rankName.put(overTakerRank-1, overTaker);
            nameRank.put(overTaken, overTakerRank);
            rankName.put(overTakerRank, overTaken);
//            overtake(res, callings[i]);
        }
        res = new String[players.length];
        for(int i=0;i<players.length;i++){
            res[i] = rankName.get(i+1);
        }
        return res;
    }
    String tmp = "";
    public void overtake(String[] arr, String name){
        for(int i=1;i<arr.length;i++){
            if(name.equals(arr[i])){
                tmp = arr[i-1];
                arr[i-1] = name;
                arr[i] = tmp;
            }
        }
    }
}
