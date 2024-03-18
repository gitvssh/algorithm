package algorithm.baek.bfs;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/149440
 * 쉬운 최단거리
 * BFS
 */
public class EasyShortcut implements TestCase {
    static int[][] map;
    static boolean[][] visited;
    static int[][] result;
    static int n,m;
    static int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];
        Node start = null;
        for(int y=0;y<n;y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0;x<m;x++){
                map[y][x] = Integer.parseInt(st.nextToken());
                if(map[y][x] == 2){
                    start = new Node(y,x);
                }
            }
        }
        bfs(start);

        for(int y=0;y<n;y++){
            for(int x=0;x<m;x++){
                if(!visited[y][x]){
                    result[y][x] = -1;
                }
                if(map[y][x]==2||map[y][x]==0){
                    result[y][x] = 0;
                }
                bw.write(result[y][x]+" ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static void bfs(Node start){
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        int distance = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node cur = q.poll();
                int cx = cur.x;
                int cy = cur.y;
                if(map[cy][cx]==0) continue;
                for(int[] dir : dirs){
                    int nx = cx + dir[0];
                    int ny = cy + dir[1];
                    if(nx<0||nx>=m || ny<0||ny>=n) continue;
                    if(visited[ny][nx]) continue;
                    visited[ny][nx] = true;
                    if(map[ny][nx]==0){
                        result[ny][nx] = 0;
                    }else if(map[ny][nx]==1){
                        result[ny][nx] = distance;
                        q.add(new Node(ny,nx));
                    }
                }
            }
            distance++;
        }
    }


}

class Node{
    int x;
    int y;

    Node(int y, int x){
        this.x = x;
        this.y = y;
    }
}