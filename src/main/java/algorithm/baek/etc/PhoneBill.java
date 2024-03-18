package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class PhoneBill implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            m+=(arr[i]/30+1)*10;
            y+=(arr[i]/60+1)*15;
        }
        if(m==y) {
            bw.write("Y M " + m);
        }else if(m<y) {
            bw.write("Y " + m);
        } else {
            bw.write("M " + y);
        }
        bw.close();
    }
}
