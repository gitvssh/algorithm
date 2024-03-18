package algorithm.programmers.level1;

import algorithm.TestCase;

public class Year2016 implements TestCase {

    final int[] cal = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    final String[] dayName = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    //1월 1일은 금요일
    public String solution(int a, int b) {
        int day = 0;
        for (int i = 0; i < a - 1; i++) {
            day += cal[i];
        }
        return dayName[(day + 5 + b - 1) % 7];
    }

    @Override
    public void test() {
        solution(5, 24);
    }
}
