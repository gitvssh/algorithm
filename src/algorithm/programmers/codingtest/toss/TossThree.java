package algorithm.programmers.codingtest.toss;

import algorithm.TestCase;

import java.util.Arrays;

public class TossThree implements TestCase {
    //최대한 많이 탐험, 그리디
    public int solution(int k, int[][] dungeons) {
        int answer = 0;

        Arrays.sort(dungeons, (o1, o2) -> {
           return Integer.compare(o1[1],o2[1]);
        });
        System.out.println("d = " + dungeons.length);
        for (int i = 0; i < dungeons.length; i++) {
            if(k<dungeons[i][0]) continue;
            answer++;
            k -= dungeons[i][0];
        }
        return answer;
    }
    @Override
    public void test() {
        int solution = solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}});
        System.out.println("solution = " + solution);
    }
}
