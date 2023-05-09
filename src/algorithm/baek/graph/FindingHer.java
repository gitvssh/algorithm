package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.PriorityQueue;
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
        possible = new double[edge][edge];
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
            bw.write(location[i]/4+"\n");
        }
        bw.close();
        br.close();
    }

    private void bfs(int time) {
        PriorityQueue<Double[]> queue = new PriorityQueue<>();
        queue.add(new Double[]{Double.valueOf(0),possible[0][0]});
        queue.add(new Double[]{Double.valueOf(0),possible[0][1]});
        queue.add(new Double[]{Double.valueOf(0),possible[0][2]});
        queue.add(new Double[]{Double.valueOf(0),possible[0][3]});
        while (time-- > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Double[] poll = queue.poll();
                for (int j = 0; j < possible.length; j++) {
//                    if (possible[poll[0]][j] != 0) {
//                        queue.add(new Double[]{(double) j, possible[(int)poll[0]][j] * poll[1]});
//                        location[j] += possible[(int)poll[0]][j] * poll[1];
//                    }
                }
            }
        }
    }

}
