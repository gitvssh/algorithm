package algorithm.programmers.level0;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class Spiral implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int[][] solution = solution(4);
    }

    static int[][] answer;
    static int idx = 1;
    public static int[][] solution(int n) {
        answer = new int[n][n];
        int target = (int)Math.pow(n,2);
        int start = 0;
        int end = n;
        int minRow = 0;
        int maxRow = n;
        int minCol = 0;
        int maxCol = n;
        while(idx<=target){
            rowToRight(minCol, maxCol, minRow++);
            colToDown(minRow, maxRow, maxCol--);
            rowToleft(maxCol, minCol, maxRow--);
            colToUp(maxRow, minRow, minCol++);
        }
        return answer;
    }

    public static void rowToRight(int start, int end, int fixRow){
        for(int i=start;i<end;i++){
            answer[fixRow][i] = idx++;
        }
    }

    public static void colToDown(int start, int end, int fixCol){
        for(int i=start;i<end;i++){
            answer[i][fixCol-1] = idx++;
        }
    }

    public static void rowToleft(int start, int end, int fixRow){
        for(int i=start-1;i>=end;i--){
            answer[fixRow-1][i] = idx++;
        }
    }

    public static void colToUp(int start, int end, int fixCol){
        for(int i=start-1;i>=end;i--){
            answer[i][fixCol] = idx++;
        }
    }
}
