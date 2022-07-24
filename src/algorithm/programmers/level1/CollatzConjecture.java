package algorithm.programmers.level1;

import algorithm.TestCase;

public class CollatzConjecture implements TestCase {
    public int solution(int num) {
        if (num == 1) return 0;
        int answer = 0;
        double arg = num;
        for (int i = 0; i < 500; i++) {
            arg = arg % 2 == 0 ? arg / 2 : arg * 3 + 1;
            answer++;
            if (arg == 1) break;
        }
        if (answer == 500) return -1;
        return answer;
    }

    @Override
    public void test() {
        solution(8000000);
    }
}
