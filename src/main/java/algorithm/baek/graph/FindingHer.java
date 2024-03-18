package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16502
 * 그녀를 찾아서
 */
public class FindingHer implements TestCase {
    static double[][] possible;
    static double[] location;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int time = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        possible = new double[4][4];
        location = new double[4];

        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = st.nextToken().charAt(0) - 'A';
            int to = st.nextToken().charAt(0) - 'A';
            double percent = Double.parseDouble(st.nextToken());
            possible[from][to] = percent;
        }
        bfs(time);
        for (int i = 0; i < location.length; i++) {
            bw.write(String.format("%.2f\n", location[i] * 100));
        }
        bw.close();
        br.close();
    }

    private void bfs(int time) {
        Queue<Double[]> queue = new LinkedList<>();
        queue.add(new Double[]{Double.valueOf(0), Double.valueOf(0.25)});
        queue.add(new Double[]{Double.valueOf(1), Double.valueOf(0.25)});
        queue.add(new Double[]{Double.valueOf(2), Double.valueOf(0.25)});
        queue.add(new Double[]{Double.valueOf(3), Double.valueOf(0.25)});
        while (time-- > 0) {
            location = new double[4];
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Double[] poll = queue.poll();
                int idx = poll[0].intValue();
                for (int j = 0; j < possible.length; j++) {
                    double curPossibility = possible[idx][j];
                    if (curPossibility != 0) {
                        Double accumPossibility = poll[1];
                        queue.add(new Double[]{(double) j, curPossibility * accumPossibility});
                        location[j] += curPossibility * accumPossibility;
                    }
                }
            }
        }
    }
}
