package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * https://www.acmicpc.net/problem/7662
 * 이중 우선순위 큐
 */
public class DoublePriorityQueue implements TestCase {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

    @Override
    public void test() throws ParseException, IOException {
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> que = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (cmd.equals("I")) {
                    que.put(num, que.getOrDefault(num, 0) + 1);
                } else {
                    if (que.isEmpty()) continue;
                    int key = num == 1 ? que.lastKey() : que.firstKey();
                    if(que.get(key) == 1) {
                        que.remove(key);
                    } else {
                        que.put(key, que.get(key) - 1);
                    }
                }
            }
            if (que.isEmpty()) {
                bw.write("EMPTY");
                bw.newLine();
            } else {
                bw.write(que.lastKey() + " " + que.firstKey());
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();

//        sol1();
    }

    private static void sol1() throws IOException {
        int tc = Integer.parseInt(br.readLine());
        PriorityQueue ascPq = new PriorityQueue();
        PriorityQueue descPq = new PriorityQueue((o1, o2) -> (int) o2 - (int) o1);
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (cmd.equals("I")) {
                    ascPq.add(num);
                    descPq.add(num);
                } else {
                    if (ascPq.isEmpty()) {
                        continue;
                    }
                    if (num == 1) {
                        int tgt = (int) descPq.poll();
                        ascPq.remove(tgt);
                    } else {
                        int tgt = (int) ascPq.poll();
                        descPq.remove(tgt);
                    }
                }
            }
            if (ascPq.isEmpty()) {
                bw.write("EMPTY");
                bw.newLine();
            } else {
                bw.write(descPq.poll() + " " + ascPq.poll());
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
