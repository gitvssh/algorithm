package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20920
 * 영단어 암기는 어려워
 */
public class MemorizeWord implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() < m) continue;
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        ArrayList<String> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> {
            if (map.get(o1) == map.get(o2)) {
                if (o1.length() == o2.length()) return o2.compareTo(o1);
                return o2.length() - o1.length();
            }
            return map.get(o2) - map.get(o1);
        });
        list.forEach(System.out::println);
    }
}
