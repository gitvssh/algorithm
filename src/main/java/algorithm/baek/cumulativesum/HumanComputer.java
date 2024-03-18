package algorithm.baek.cumulativesum;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class HumanComputer implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[26][str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a'][i]++;
            for (int j = 0; j < 26; j++) {
                if (i > 0) {
                    arr[j][i] += arr[j][i - 1];
                }
            }
        }
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            char chr = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(arr[chr - 'a'][b] - (a > 0 ? arr[chr - 'a'][a - 1] : 0) + "\n");
        }
        bw.close();
    }
}
