package programmers.sort;

import programmers.recursive.LeetCode329;
import programmers.recursive.LeetCode329M;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 문제 설명
 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
 *
 * 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
 *
 * array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
 * 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
 * 2에서 나온 배열의 3번째 숫자는 5입니다.
 * 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
 * commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
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

    ArrayList<int[]> arrayC = new ArrayList<int[]>();


    public void test() {
        arrayC.add(testCase);
//        System.out.println("commandsCase = " + commandsCase[0].length);
        
        //테스트케이스 조건별 로직
        for (int[] unitcases : commandsCase) {
//            System.out.println("called cases" + cases.length);
//            System.out.println("cases[0] = " + cases[0]);
//            System.out.println("cases[0] = " + cases[1]);

            //1. 배열 추출
            int[] ints = IntStream.range(unitcases[0], unitcases[1])
                    .toArray();

            //2. 배열 정렬

            //3. 목표값 적재

            //4. 결과값 반환
            for (int anInt : ints) {
                System.out.println("ints = " + ints);
                System.out.println("anInt = " + anInt);
            }
//                    .mapToObj(i -> arr[i])
//                    .toArray(String[]::new);
//            전체 배열, 단위 배열

            Arrays.stream(testCase).toArray();
        }
    }

    public static void main(String[] args) {
//        NumberK numberK = new NumberK();
//        numberK.test();
        LeetCode329 leetCode329 = new LeetCode329();
        LeetCode329M leetCode322 = new LeetCode329M();
        int[][] testcase = {{7,7,5},{2,4,6},{8,2,0}};
//        int[][] testcase = {{1,2}};

//        int result = leetCode322.longestIncreasingPath(testcase);
        int result = leetCode329.longestIncreasingPath(testcase);
        System.out.println("result = " + result);

    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        return answer;
    }

}
