package algorithm.programmers.level0;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class FactorizationProgrammers implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int[] solution = solution(12);
        System.out.println(solution);
    }

    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList();
        for(int i=2;i<=n;i++){
            if(n%i==0){
                list.add(i);
            }
            while(n%i==0){
                n=n/i;
            }
            if(n<=1) break;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
