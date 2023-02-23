package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/25206
 * 너의 평점은
 */
public class Score implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        double count = 0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double score = Double.parseDouble(st.nextToken().charAt(0) + "");
            String grade = st.nextToken();
            if (!grade.equals("P")) {
                count+=score;
                if(grade.equals("A+"))
                    score *= 4.5;
                else if(grade.equals("A0"))
                    score *= 4.0;
                else if(grade.equals("B+"))
                    score *= 3.5;
                else if(grade.equals("B0"))
                    score *= 3.0;
                else if(grade.equals("C+"))
                    score *= 2.5;
                else if(grade.equals("C0"))
                    score *= 2.0;
                else if(grade.equals("D+"))
                    score *= 1.5;
                else if(grade.equals("D0"))
                    score *= 1.0;
                else if (grade.equals("F")) {
                    score *= 0;
                }
                sum += score;

            }
        }
        System.out.println(sum / count);
    }
}
