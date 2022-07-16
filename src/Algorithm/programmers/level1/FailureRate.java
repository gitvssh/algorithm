package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.Arrays;

/*
* 1. 스테이지별 실패율 구하기
*  - 도달한 유저가 없으면 0
* 2. 실패율 순으로 정렬하기
* 3. 실패율이 같으면 오름차순 정렬
*
* 실패율 = 도달, 클리어x / 도달한 수
* 한번 다 돌아야함,
* 1. 배열 내림차순 정렬
* 2. 같은숫자 세면서 내려가기
* 3. 지금카운트 / 이전 카운트+지금카운트(위)
*
* ** 알고리즘 발상 -> 시간복잡도 예측 -> 다른방법 찾기
* 케이스 몇번 써보면서 규칙 찾기
* 정리되었으면 구현
* */
public class FailureRate implements TestCase {
    public int[] solution(int N, int[] stages) {
        float[] failureRate = new float[N];
        Arrays.sort(stages);
        //지금 카운트
        int numerator = 0;
        //이전카운트 + 지금 카운트
        int denominator = 1;
        //해당 스테이지 클리어 수
        int beforeCnt = 0;
        //검사중인 스테이지
        int stage = N;
        int cnt = 0;
        for (int i = stages.length-1; i > -1 ; i--) {
            if(stages[i]>stage){
                cnt++;
            }else{
                failureRate[N-1] = beforeCnt/cnt;
            }
        }
        int[] answer = {};
        return stages;
    }
    @Override
    public void test() {
        int[] solution = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        for (int i : solution) {
            System.out.println("i = " + i);
            System.out.println((float)(1/5));
        }
    }
}
