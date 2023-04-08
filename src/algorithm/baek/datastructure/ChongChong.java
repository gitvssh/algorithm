package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/26069
 * 붙임성 좋은 총총이
 */
public class ChongChong implements TestCase {
    static String CHONGCHONG = "ChongChong";

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        String a = "";
        String b = "";
        boolean aDance;
        boolean bDance;
        HashMap<String, Boolean> map = new HashMap<>();
        int count = 1;
        map.put(CHONGCHONG, true);
        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = st.nextToken();
            b = st.nextToken();
            aDance = map.getOrDefault(a, false);
            bDance = map.getOrDefault(b, false);

            if (aDance && bDance) {
                continue;
            } else if (aDance || bDance) {
                if (aDance) {
                    map.put(b, true);
                } else {
                    map.put(a, true);
                }
                count++;
            } else {
                map.put(a, false);
                map.put(b, false);
            }
        }
        System.out.println(count);
    }
}
