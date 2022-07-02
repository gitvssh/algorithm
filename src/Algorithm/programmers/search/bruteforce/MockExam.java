package Algorithm.programmers.search.bruteforce;

import Algorithm.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

public class MockExam implements TestCase {

    final int[] a = {1, 2, 3, 4, 5};//5
    final int[] b = {2, 1, 2, 3, 2, 4, 2, 5};//8
    final int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};//10

    private int aPos = 0;
    private int bPos = 0;
    private int cPos = 0;

    public int[] solution(int[] answers) {
        ArrayList<Integer> temp = new ArrayList<>();
        int[] res = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            int val = answers[i];
//            if (a[aPos] == val) res[0]++;
//            if (b[bPos] == val) res[1]++;
//            if (c[cPos] == val) res[2]++;
            if (a[i%5] == val) res[0]++;
            if (b[i%8] == val) res[1]++;
            if (c[i%10] == val) res[2]++;
//            updatePos();
        }
        int asInt = Arrays.stream(res)
                .max()
                .getAsInt();
        for (int i = 0; i < 3; i++) {
            if (res[i] == asInt) {
                temp.add(i);
            }
        }
        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i)+1;
        }
        return answer;
    }

    private void updatePos() {
        if (aPos++ == 5) aPos = 0;
        if (bPos++ == 8) bPos = 0;
        if (cPos++ == 10) cPos = 0;
    }

    @Override
    public void test() {
//        int[] answers = new int[]{1,2,3,4,5};
        int[] answers = new int[]{1, 3, 2, 4, 2};
        int[] solution = solution(answers);
        for (int i : solution) {
            System.out.println("i = " + i);
        }

    }
}
