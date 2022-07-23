package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/*
 * 실패율 계산(소수점)
 * 실패율 정렬
 * */
public class FailRate implements TestCase {
    public int[] solution(int N, int[] stages) {
        /*
        실패율 계산
        현재 멈춰있는 스테이지 번호가 담긴 배열
        stages의 길이는 사용자의 수
        안의 수는 멈춰있는 스테이지(이전 것이 클리어 스테이지)
        위에서부터 실패율 / 도달 수를 쌓아가면 됨
        도달수 = 스테이지번호 이상인 수
        실패율 = 도달수 - 이전스테이지 클리어 수

        -- 1. 정렬
        2. 전체순회 하면서 해당 스테이지별 카운트 세기
        3. 공식에 따라 실패율 구하기
        4. 실패율 정렬 반환
        * */
        //실패율을 기준으로 정렬된 스테이지 번호 반환 배열
        int[] answer = new int[N+1];
        double[] failRate = new double[N];
        //스테이지 번호와 실패율 저장
        ConcurrentHashMap<Integer, Double> map = new ConcurrentHashMap<>();
        //1 정렬
        Arrays.sort(stages);

        int stage = 0;
        int cnt = 0;
        for (int i = 0; i < stages.length; i++) {
            answer[stages[i]-1]++;
        }
        
        //소스트리 깃 커밋 테스트222
        double total = answer[N];
        for (int i = N; i > 0; i--) {
            total += answer[i];
            map.put(answer[i],total);
        }
        for (Integer integer : map.keySet()) {

        }

        int a = 0;
        return answer;
    }

    @Override
    public void test() {
        int[] solution = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
//        for (int s : solution) {
//            System.out.println("s = " + s);
//        }
//        System.out.println(1/8d);
    }
}
