package programmers.recursive;

import java.util.ArrayList;
import java.util.Collections;

public class LeetCode329 {


    int length = 0;

    int heightPos = 0;
    int widthPos = 0;

    int height = 0;
    int width = 0;
    ArrayList<Integer> testArray = new ArrayList<>();

    public int longestIncreasingPath(int[][] matrix) {

        int result = 0;

        height = matrix.length;
        width = matrix[0].length;

        for (int i = 0; i < height; i++) {
            heightPos = i;
            for (int j = 0; j < width; j++) {
                testArray.clear();
                widthPos = j;
                result = checkPath(matrix, -1, 1, i, j);
                length = (result > length) ? result : length;
            }
        }
        return (length > 0) ? length : 1;
    }

    private int checkPath(int[][] matrix, int value, int length, int tempHeight, int tempWidth) {
        if (height == heightPos && width == widthPos) {//마지막 탈출
            return length;
        }
        if (value < matrix[tempHeight][tempWidth]) { //값 비교, 재귀 호출 여부 판단

            testArray.add(length);
            if ((tempHeight - 1) > -1) {
                if (checkPath(matrix, matrix[tempHeight][tempWidth], length + 1, tempHeight - 1, tempWidth) > length) {
                    testArray.add(length + 1);

                }
            }
            if ((tempHeight + 1) < height) {
                if (checkPath(matrix, matrix[tempHeight][tempWidth], length + 1, tempHeight + 1, tempWidth) > length) {
                    testArray.add(length + 1);
                }
            }
            if ((tempWidth - 1) > -1) {
                if (checkPath(matrix, matrix[tempHeight][tempWidth], length + 1, tempHeight, tempWidth - 1) > length) {
                    testArray.add(length + 1);
                }
            }
            if ((tempWidth + 1) < width) {
                if (checkPath(matrix, matrix[tempHeight][tempWidth], length + 1, tempHeight, tempWidth + 1) > length) {
                    testArray.add(length + 1);
                }
            }
            return Collections.max(testArray);
        }
        return 0;
    }
}

