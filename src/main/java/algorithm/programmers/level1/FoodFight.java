package algorithm.programmers.level1;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.Stack;

public class FoodFight implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
//        String solution = solution(new int[]{1, 3, 4, 6});
        String solution = solution(new int[]{1,7,1,2});
        System.out.println(solution);
    }

    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack();
        for(int i=1;i<food.length;i++){
            int divSize = food[i]/2;
            while(divSize-- > 0){
                sb.append(i);
                st.push(String.valueOf(i));
            }
        }
        sb.append(0);
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }
}
