package algorithm.programmers.level1;

import algorithm.TestCase;

public class PrimeNumber implements TestCase {
    public int solution(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            answer += isPrimeNumber(i);
        }
        return answer;
    }

    private int isPrimeNumber(int n){
        for (int i = 2; i*i <= n; i++) {
            if(n%i==0) return 0;
        }
        System.out.println("n = " + n);
        return 1;
    }

    @Override
    public void test() {
        int solution = solution(5);
        System.out.println("solution = " + solution);
    }
}
