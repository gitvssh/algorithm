package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1389
 * 케빈 베이컨의 6단계 법칙
 */
public class KevinBacon implements TestCase {

    static int[][] graph;

    @Override
    public void test() throws ParseException, IOException {
//        prev();
        KevinBacon2 kv = new KevinBacon2();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            kv.init(br);
            bw.write(kv.getResult() + "\n");
            bw.flush();
        }
    }

    public void prev() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    graph[i][j] = 10000000;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int minSum = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] < 10000000) {
                    sum += graph[i][j];
                }
            }
            if (sum < minSum) {
                minSum = sum;
                result = i;
            }
        }

        System.out.println(result);

    }
}

class KevinBacon2 {
    int n;

    private int[][] graph;
    private int kevinBaconNumber = 1000000;

    public void init(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i!=j){
                    graph[i][j] = 1000000;
                }
            }
        }

        for(int i=0;i<m;i++){
            updateGraph(br.readLine());
        }
    }

    private void updateGraph(String input) throws IOException{
        String[] inputs = input.split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);

        graph[a][b] = 1;
        graph[b][a] = 1;
    }

    private void floydWarshall(){
        for(int k=1;k<= n;k++){
            for(int i=1;i<= n;i++){
                for(int j=1;j<= n;j++){
                    int newDistance = graph[i][k] + graph[k][j];
                    if(newDistance < graph[i][j]){
                        graph[i][j] = newDistance;
                    }
                }
            }
        }
    }

    public int getResult(){
        floydWarshall();
        int minSum = Integer.MAX_VALUE;
        int result = 0;
        for(int i=1;i<=n;i++){
            int sum = 0;
            for(int j=1;j<=n;j++){
                if (graph[i][j] < 10000000) {
                    sum += graph[i][j];
                }
            }
            if(sum <= minSum){
                minSum = sum;
                result = i;
            }
        }
        return result;
    }


}