package algorithm.programmers.codingtest;

import algorithm.TestCase;

import java.util.ArrayList;
import java.util.Comparator;

public class TossOne implements TestCase {
    //길이가 3인 s의 substring을 10진수로 읽은 숫자
    //각 자리의 숫자가 모두 같다.
    //1. 연속하는 3자리 있는지 체크 -> 정규식 활용
    //2. max값 기록
    //3. 전체탐색
    public int solution(String s) {
        int answer = -1;
        ArrayList<Integer> rs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String pattern = ".+" + i + "{3}.+";
            if (s.matches(pattern)) rs.add(i);
        }
        rs.sort(Comparator.reverseOrder());
        return rs.size() == 0 ? -1 : rs.get(0) * 111;
    }

    @Override
    public void test() {
        int solution = solution("100063");
        System.out.println("solution = " + solution);
    }
}
