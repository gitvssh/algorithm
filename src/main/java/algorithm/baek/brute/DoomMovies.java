package algorithm.baek.brute;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoomMovies implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cur = 0;
        int idx = 665;
        boolean search;
        for (int i = 1; i < 10001; i++) {
            search = true;
            while (search) {
                idx++;
                if (String.valueOf(idx).contains("666")) {
                    search = false;
                    cur++;
                }
            }
            if (cur == n) {
                break;
            }
        }
        bw.write(idx + "\n");
        bw.close();
    }
}
