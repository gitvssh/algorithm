package algorithm.programmers.level0;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;

public class ChangeOrderArray implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int[] solution = solution(new int[]{2, 1, 6}, 1);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int[] num_list, int n) {
        int len = num_list.length;
        int[] answer = new int[len];
        int[] start = Arrays.copyOfRange(num_list, n , len);
        int[] end = Arrays.copyOfRange(num_list, 0, n );
        for (int i = 0; i < start.length; i++) {
            answer[i] = start[i];
        }
        for (int i = len - end.length; i < len; i++) {
            answer[i] = end[i - len + end.length];
        }
        return answer;
    }
}
