package algorithm.baek.dfs;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Cabbage2 implements TestCase {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void test() throws ParseException, IOException {
        int tc = Integer.parseInt(br.readLine());

        for(int z=0;z<tc;z++){
            int result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            Map map = new Map(n, m);

            for(int i=0;i<k;i++){
                String[] pos = br.readLine().split(" ");
                map.map[Integer.parseInt(pos[1])][Integer.parseInt(pos[0])] = 1;
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map.map[i][j] == 1 && !map.visited[i][j]){
                        map.bfs(new Position(j,i));
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    static class Map{
        private static int[][] map;
        private static boolean[][] visited;

        public Map(int n, int m) {
            map = new int[n][m];
            visited = new boolean[n][m];
        }

        public static void checkVisited(Position pos){
            visited[pos.getY()][pos.getX()] = true;
        }

        public static boolean isVisited(Position pos){
            return visited[pos.getY()][pos.getX()];
        }

        public int get(Position pos){
            return map[pos.getY()][pos.getX()];
        }

        public static boolean isValidRange(Position np) {
            int x = np.getX();
            int y = np.getY();
            return y>=0 && y<map.length && x>=0 && x<map[0].length;
        }

        public static void bfs(Position pos){
            Queue<Position> queue = new LinkedList<>();
            queue.add(pos);
            while(!queue.isEmpty()){
                Position cur = queue.poll();
                checkVisited(cur);
                for(Direction dir : Direction.values()){
                    Position np = cur.add(dir.getCorrelation());
                    if(!isValidRange(np)) continue;
                    if(isVisited(np)) continue;
                    if(map[np.getY()][np.getX()]==1){
                        queue.add(np);
                    }
                }
            }

        }


        public static void dfs(Position pos){
            checkVisited(pos);
            for(Direction dir : Direction.values()){
                Position np = pos.add(dir.getCorrelation());
                if(!isValidRange(np)) continue;
                if(isVisited(np)) continue;
                if(map[np.getY()][np.getX()] == 1){
                    dfs(np);
                }
            }
        }
    }

    static class Position{
        private int x;
        private int y;

        Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }

        public Position add(Position pos){
            return new Position(x+pos.getX(), y+pos.getY());
        }
    }

    enum Direction{
        NORTH(new Position(0, -1)),WEST(new Position(1, 0)),SOUTH(new Position(0, 1)),EAST(new Position(-1, 0));

        private final Position correlation;

        Direction(Position correlation){
            this.correlation = correlation;
        }

        public Position getCorrelation(){
            return correlation;
        }
    }
}