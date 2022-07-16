package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.ArrayList;

public class NumberXtoN implements TestCase {
    public long[] solution(int x, int n) {
        ArrayList<Long> temp = new ArrayList<>();
        long start = 0L;
        for (int i = 0; i < n; i++) {
            start += x;
            temp.add(start);
        }
        return temp.stream().mapToLong(s->s).toArray();
    }

    @Override
    public void test() {
        int x = 2, n = 5;
        long[] solution = solution(x, n);
        System.out.println("solution = " + solution.toString());
    }
}
