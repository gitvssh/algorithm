package algorithm.programmers.level1;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

public class NearestString implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int[] bananas = solution("banana");
        for (int i : bananas) {
            System.out.println(i);
        }
    }
    public int[] solution(String s) {
        int len = s.length();
        int[] answer = new int[len];
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++){
            Character c = s.charAt(i);
            if(map.get(c)==null){
                answer[i] = -1;
                map.put(c, i);
            }else{
                answer[i] = i-map.get(c);
                map.put(c, i);
            }

        }
        return answer;
    }
}
