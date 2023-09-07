package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * https://www.acmicpc.net/problem/1431
 * 시리얼 번호
 * 자료구조
 */
public class SerialNumber implements TestCase {
    static int N;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();
                if (len1 != len2) return len1 - len2;
                else {
                    int sum1 = 0;
                    int sum2 = 0;
                    for (int i = 0; i < len1; i++) {
                        char c1 = o1.charAt(i);
                        char c2 = o2.charAt(i);
                        if (Character.isDigit(c1)) sum1 += c1 - '0';
                        if (Character.isDigit(c2)) sum2 += c2 - '0';
                    }
                    if (sum1 != sum2) return sum1 - sum2;
                    else return o1.compareTo(o2);
                }
            }
        });
        for (String s : list) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }
}
