package algorithm.baek.string;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashSet;

public class StudentNumber implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] student = new String[n];
        for (int i = 0; i < n; i++) {
            student[i] = br.readLine();
        }
        int k = 1;
        boolean check = true;
        while (check) {
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String tmp = student[i].substring(student[i].length() - k);
                set.add(tmp);
            }
            if (set.size() == n) {
                System.out.println(k);
                check = false;
            }
            k++;
        }
    }
}
