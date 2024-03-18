package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20920
 * 영단어 암기는 어려워
 */
public class MemorizeWord implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() < m) continue;
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<WordNote> pq = new PriorityQueue<>();
        for (String key : map.keySet()) {
            Integer cnt = map.get(key);
            pq.add(new WordNote(key, cnt));
        }
        while (!pq.isEmpty()) {
            bw.write(pq.poll().word + "\n");
        }
        bw.flush();
        bw.close();
    }

    static class WordNote implements Comparable<WordNote> {
        String word;
        int cnt;

        public WordNote(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }


        @Override
        public int compareTo(WordNote o) {
            if (this.cnt == o.cnt) {
                if (this.word.length() == o.word.length()) return this.word.compareTo(o.word);
                return o.word.length() - this.word.length();
            }
            return o.cnt - this.cnt;
        }
    }
}
