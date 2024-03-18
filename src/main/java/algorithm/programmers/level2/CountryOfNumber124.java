package algorithm.programmers.level2;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class CountryOfNumber124 implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int n = 10;
        System.out.println(solution(n));
    }

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int r = n % 3;
            n /= 3;
            if(r == 0){
                sb.append(4);
                n--;
            }else{
                sb.append(r);
            }
        }
        return sb.reverse().toString();
    }
}
