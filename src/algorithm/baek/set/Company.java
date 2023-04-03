package algorithm.baek.set;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7785
 * 회사에 있는 사람
 */
public class Company implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();
            if (status.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }
        set.stream().sorted(Collections.reverseOrder()).forEach(name -> {
            try {
                bw.write(name + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.close();
    }
}
