package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/*
 * 실패율 계산(소수점)
 * 실패율 정렬
 * */
public class FailRate implements TestCase {
    public int[] solution(int n, int[] stages) {
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
        int[] stageClearCount = new int[n + 1];
        int[] finalResult = new int[n];
        //스테이지 번호와 실패율 저장
        ConcurrentHashMap<Integer, Double> map = new ConcurrentHashMap<>();
        //1 정렬
        Arrays.sort(stages);
        //2. 전체순회 하면서 해당 스테이지별 카운트 세기
        for (int stage : stages) {
            int stageNum = stage - 1;
            stageClearCount[stageNum]++;
        }

        double total = stageClearCount[n];
        //3. 공식에 따라 실패율 구하기
        for (int i = n; i > 0; i--) {
            total += stageClearCount[i - 1];
            map.put(i - 1, 1 - (total - stageClearCount[i - 1]) / total);
        }
        //4. 실패율 정렬 반환
        Map<Integer, Double> result = sortMapByValue(map);

        int count = n-1;
        for (Integer integer : result.keySet()) {
            finalResult[n-1-count] = integer + 1;
            count--;
        }
        return finalResult;
    }

    public static Map<Integer, Double> sortMapByValue(Map<Integer, Double> map) {
        List<Map.Entry<Integer, Double>> entries = new LinkedList<>(map.entrySet());
        entries.sort(((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())));

        LinkedHashMap<Integer, Double> result = new LinkedHashMap<>();
        for (Map.Entry<Integer, Double> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    @Override
    public void test() {
        solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
    }
}
