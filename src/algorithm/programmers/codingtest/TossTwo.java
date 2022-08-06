package algorithm.programmers.codingtest;

import algorithm.TestCase;

import java.util.Arrays;

public class TossTwo implements TestCase {
    // 상위 25%이내 난이도를 가진 문제 중 가장 쉬운 문제
    // levels[N] 문제들의 난이도
    // 1. 정렬
    // 2. 상위 25% 걸러냄
    // 3. 가장 낮은 값 return
    public int solution(int[] levels) {
        if(levels.length<4) return -1;
        Arrays.sort(levels);
        return levels[levels.length - levels.length/4];
    }
    @Override
    public void test() {
        int solution = solution(new int[]{1, 2, 3, 4,5,6,7,8,9});
        System.out.println("solution = " + solution);
    }
}
