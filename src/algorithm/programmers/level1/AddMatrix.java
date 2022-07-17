package algorithm.programmers.level1;

import algorithm.TestCase;

public class AddMatrix implements TestCase {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }

    @Override
    public void test() {
        int[][] solution = solution(new int[][]{{1, 2}, {2, 3}}, new int[][]{{3, 4}, {5, 6}});
        for (int[] ints : solution) {
            for (int anInt : ints) {
                System.out.println("anInt = " + anInt);
            }
        }
    }
}
