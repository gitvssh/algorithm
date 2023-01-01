package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class FashionKing implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        HashMap<String, Integer> map;
        int tc = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < tc; i++) {
            int sum = 1;
            int n = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            Set<String> strings = map.keySet();
            System.out.println("strings.size() = " + strings.size());
            for (String string : strings) {
                int l = map.get(string);
                System.out.println("string = " + string);
                sum *= (l+1);
                System.out.println("sum = " + sum);
            }
            sum--;
            bw.write(sum + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
