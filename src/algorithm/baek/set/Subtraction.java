package algorithm.baek.set;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Subtraction implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer,Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map.put(Integer.parseInt(st.nextToken()),1);
        }
        st = new StringTokenizer(br.readLine());
        int subtract = 0;
        for (int i = 0; i < m; i++) {
            if(map.get(Integer.parseInt(st.nextToken()))!=null)
                subtract++;
        }
        bw.write(n+m-2*subtract+"\n");
        bw.close();
    }
}
