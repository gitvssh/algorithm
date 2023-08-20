package algorithm.programmers.codingtest.wello;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;

public class Q4 implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int[] grade = {3,2,1,2};
        //학생의 시험점수가 주어졌을 때, 학생의 등수를 구하는 로직
        //등수는 1등부터 시작
        //같은 점수가 있을 경우, 같은 등수를 부여
        //등수를 구하는 로직을 작성하시오.
        int[] rank = new int[grade.length];
        Integer[] indices = new Integer[grade.length];
        for (int i = 0; i < grade.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i, j) -> Integer.compare(grade[j], grade[i]));

        int currentRank = 1;
        for (int i = 0; i < grade.length; i++) {
            if (i > 0 && grade[indices[i]] != grade[indices[i - 1]]) {
                currentRank = i + 1;
            }
            rank[indices[i]] = currentRank;
        }
        System.out.println(Arrays.toString(rank));
    }
}
