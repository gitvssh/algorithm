package algorithm.baek.graph;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/1976 여행 가자
 */
public class GoToTrip implements TestCase {

    /*
    연결 여부를 union-find로 집합으로 표현
    모두 같은 그룹에 속해있는지 확인
     */


    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        DisjointSet set = new DisjointSet(n);
        int m = Integer.parseInt(br.readLine());
        String[] line = new String[n];
        for (int i = 0; i < n; i++) {
            line[i] = br.readLine();
        }
        set.init(line);
        String city = br.readLine();
        System.out.println(set.isPossible(city));
    }

    class DisjointSet {

        int[] parent;

        DisjointSet(int n){
            parent = new int[n];
            for (int i = 0; i <n; i++) {
                parent[i] = i;
            }
        }

        private void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa < pb) {
                parent[pb] = pa;
            } else {
                parent[pa] = pb;
            }
        }

        private int find(int a) {
            if (parent[a] == a) {
                return a;
            } else {
                parent[a] = find(parent[a]);
                return parent[a];
            }
        }

        public void init(String[] line) {
            for (int i = 0; i < line.length; i++) {
                String[] cities = line[i].split(" ");
                for (int j = 0; j < cities.length; j++) {
                    if(cities[j].equals("1")){
                        union(i,j);
                    }
                }
            }
        }

        public String isPossible(String city) {
            String[] cities = city.split(" ");
            int setNum = find(Integer.parseInt(cities[0])-1);
            for (int i = 0; i < cities.length; i++) {
                if(setNum != find(Integer.parseInt(cities[i])-1)){
                    return "NO";
                }
            }
            return "YES";
        }
    }
}
