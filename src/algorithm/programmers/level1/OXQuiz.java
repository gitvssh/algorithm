package algorithm.programmers.level1;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.StringTokenizer;

public class OXQuiz implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        String[] input = {"3 - 4 = -3", "5 + 6 = 11"};
        int tc = input.length;
        String[] answer = new String[tc];
        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(input[i]);
            int n = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int m = Integer.parseInt(st.nextToken());
            st.nextToken();
            int ans = Integer.parseInt(st.nextToken());
            switch (op) {
                case "+":
                    answer[i] = n + m == ans ? "O" : "X";
                    break;
                case "-":
                    answer[i] = n - m == ans ? "O" : "X";
                    break;
            }
        }
    }
}
