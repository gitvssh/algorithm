package algorithm.programmers.level1;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class Knight implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int solution = solution(10, 3, 2);
        System.out.println(solution);
    }
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            int myPower = getDivisorCnt(i);
            answer += (myPower<limit)? myPower:power;
            System.out.println(i + " : " + myPower);
        }
        return answer;
    }

    public int getDivisorCnt(int n){
        int cnt = 0;
        int sqrt = (int) Math.sqrt(n);

        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                cnt += 2;
                if (i * i == n) {
                    cnt--;
                }
            }
        }
        return cnt;
    }
}
