package algorithm.baek.set;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FindNumber implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(st.nextToken(),1);
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        String str = "";
        for (int i = 0; i < m; i++) {
            str = st.nextToken();
            if (map.get(str) != null) {
                bw.write(1 + "\n");
            } else {
                bw.write(0 + "\n");
            }
        }
        bw.close();
    }
}
