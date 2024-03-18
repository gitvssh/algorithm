package algorithm.programmers.level0;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class ParseStringNumber implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int solution = solution("g0en2T0s8eSoft");
        System.out.println(solution);
    }

    public int solution(String my_string) {
        String[] arr = my_string.split("[^0-9]+");
        int answer = 0;
        for(int i=0;i<arr.length;i++){
            answer += Integer.parseInt(arr[i]);
        }
        return answer;
    }
}
