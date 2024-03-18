package algorithm.baek.sort;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * https://www.acmicpc.net/problem/1141
 * 접두사
 */
public class Prefix implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = br.readLine();
        int cnt = 0;
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) return o1.compareTo(o2);
                return o1.length() - o2.length();
            }
        });

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].startsWith(arr[i])) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        System.out.println(cnt);
    }
}
