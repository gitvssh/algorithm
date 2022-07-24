package algorithm.leetcode.search.array;

import algorithm.TestCase;

import java.util.Arrays;

public class Search2DMatrix implements TestCase {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] ints = Arrays.stream(matrix).mapToInt(a -> a[0]).toArray();
        int start = 0;
        int end = ints.length - 1;
        if (matrix.length == 1) {
            end = matrix[0].length - 1;
            return binarySearch2(matrix[0], start, end, target);
        }
        if (end == 0) {
            return matrix[0][0] == target;
        }
        // 근접한 행 찾기
        int rowNum = binarySearch(ints, start, end, target);
        end = matrix[rowNum].length - 1;
        return binarySearch2(matrix[rowNum], start, end, target);
    }


    //행 찾기
    private int binarySearch(int[] matrix, int start, int end, int target) {
        if (start == end) {
            return start;
        }
        if (start + 1 == end) {
            if (matrix[end] > target) return start;
            return end;
        }
        // 이진탐색 위치
        int m = (start + end) / 2;
        // 한 번에 찾을 경우
        if (matrix[m] == target) {
            return m;
        } else if (matrix[m] > target) {
            return binarySearch(matrix, start, m, target);
        } else {
            return binarySearch(matrix, m, end, target);
        }
    }

    //열 찾기
    private boolean binarySearch2(int[] matrix, int start, int end, int target) {
        if (start == end && matrix[start] != target) {
            return false;
        }
        if (start + 1 == end) {
            if (matrix[end] == target) return true;
            return matrix[start] == target;
        }
        // 이진탐색 위치
        int m = (start + end) / 2;
        // 한 번에 찾을 경우
        if (matrix[m] == target) {
            return true;
        } else if (matrix[m] > target) {
            return binarySearch2(matrix, start, m, target);
        } else {
            return binarySearch2(matrix, m, end, target);
        }
    }

    @Override
    public void test() {
        searchMatrix(new int[][]{{1}, {3}}, 0);
    }
}
