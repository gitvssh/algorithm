package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 문제 설명
 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
 * <p>
 * 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
 * <p>
 * array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
 * 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
 * 2에서 나온 배열의 3번째 숫자는 5입니다.
 * 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
 * commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한사항
 * array의 길이는 1 이상 100 이하입니다.
 * array의 각 원소는 1 이상 100 이하입니다.
 * commands의 길이는 1 이상 50 이하입니다.
 * commands의 각 원소는 길이가 3입니다.
 */
public class NumberK {

    int[] testCase = {1, 5, 2, 6, 3, 7, 4};
    int[][] commandsCase = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
    int[] returnsCase = {5, 6, 3};

    ArrayList<Integer> arrayC = new ArrayList<>();


    public void test() {
        //테스트케이스 조건별 로직
        for (int[] unitcases : commandsCase) {

            int from = unitcases[0] - 1;
            int to = unitcases[1];
            int targetNum = unitcases[2] - 1;

            //1. 배열 추출
            int[] slicedArray = Arrays.copyOfRange(testCase, from, to);

            //2. 배열 정렬
            //3. 목표값 적재
            int[] sortedArray = Arrays.stream(slicedArray).sorted().toArray();

            int target = sortedArray[targetNum];
            arrayC.add(target);
        }
        int[] ints = arrayC.stream().mapToInt(y -> y).toArray();
        System.out.println("ints = " + ints);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
        //4. 결과값 반환
    }

    public static void main(String[] args) {
        NumberK numberK = new NumberK();
        numberK.test();

    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        return answer;
    }

}
