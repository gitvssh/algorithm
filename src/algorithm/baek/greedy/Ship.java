package algorithm.baek.greedy;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1092
 * 배
 * 그리디
 */
public class Ship implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> crane = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(crane, Collections.reverseOrder());

        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(box, Collections.reverseOrder());

        if (crane.get(0) < box.get(0)) System.out.println("-1");
        else {
            int time = 0;
            while (!box.isEmpty()) {
                int idx = 0;
                for (int i = 0; i < crane.size(); ) {
                    if (idx == box.size()) break;
                    else if (crane.get(i) >= box.get(idx)) {
                        box.remove(idx);
                        i++;
                    } else idx++;
                }
                time++;
            }
            System.out.println(time);
        }
    }
}
