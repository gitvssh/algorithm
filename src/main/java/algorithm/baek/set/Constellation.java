package algorithm.baek.set;

import algorithm.TestCase;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/4386
 * 별자리 만들기
 * set
 */
public class Constellation implements TestCase {

    static int n;

    static Star[] stars;
    static int[] parent;

    @Override
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        stars = new Star[n];
        parent = new int[n + 1];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i] = new Star(x, y, i + 1);
        }

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            Star star = stars[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                Star target = stars[j];
                double distance = getDistance(star, target);
                star.setShortestDistance(distance, j + 1);
            }
        }

        double result = 0;

        Arrays.sort(stars);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            Star star = stars[i];
            int target = star.shortTarget;
            if (find(star.index) != find(target)) {
                union(star.index, target);
                result += star.shortestDistance;
                cnt++;
            }
            if(cnt == n - 1) break;
        }

        bw.write(String.format("%.2f", result));
        bw.newLine();
        bw.close();
    }

    private double getDistance(Star star, Star target) {
        return Math.sqrt(Math.pow(star.x - target.x, 2) + Math.pow(star.y - target.y, 2));
    }

    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa < pb) parent[b] = pa;
        else parent[a] = pb;
    }

    public int find(int a) {
        if (parent[a] == a) return parent[a];
        return parent[parent[a]];
    }

    class Star implements Comparable<Star> {
        @Override
        public int compareTo(Star o) {
            return Double.compare(this.shortestDistance, o.shortestDistance);
        }

        double x;
        double y;

        int index;

        double shortestDistance;
        int shortTarget;

        Star(double x, double y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
            this.shortestDistance = Double.MAX_VALUE;
        }

        void setShortestDistance(double distance, int target) {
            if (shortestDistance > distance) {
                shortestDistance = distance;
                shortTarget = target;
            }
        }
    }
}
