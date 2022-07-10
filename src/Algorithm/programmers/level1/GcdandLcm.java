package Algorithm.programmers.level1;

import Algorithm.TestCase;

public class GcdandLcm implements TestCase {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(Math.max(n, m), Math.min(n, m));
        answer[1] = lcm(Math.max(n, m), Math.min(n, m));
        return answer;
    }

    private int gcd(int p, int q) {
        if(q == 0 ) return p;
        return gcd(q, p % q);
    }

    private int lcm(int p, int q) {
        return p * q / gcd(p, q);
    }

    @Override
    public void test() {
        int[] solution = solution(3, 12);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
