package algorithm.baek.dfs;

import algorithm.TestCase;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1388
 * 바닥 장식
 */
public class CountFloorTile implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        String[] tiles = new String[n];
        for(int y=0;y<n;y++){
            tiles[y] = sc.nextLine();
        }
        Floor floor = new Floor(tiles);
        floor.inspect();
        System.out.println(floor.getTiles());
    }

    static class Floor{
        char[][] floor;
        boolean[][] visited;
        int horizontalTile;
        int verticalTile;

        Floor(String[] tiles){
            int yLen = tiles.length;
            int xLen = tiles[0].length();
            floor = new char[yLen][xLen];
            visited = new boolean[yLen][xLen];

            for(int y=0;y<yLen;y++){
                for(int x=0;x<xLen;x++){
                    floor[y][x] = tiles[y].charAt(x);
                }
            }
        }

        public void inspect(){
            for(int y=0;y<floor.length;y++){
                for(int x=0;x<floor[0].length;x++){
                    if(!visited[y][x]){
                        if(floor[y][x]=='|'){
                            verticalTile++;
                        }else{
                            horizontalTile++;
                        }
                        visited[y][x] = true;
                        dfs(new Position(x,y), floor[y][x]);
                    }
                }
            }
        }

        private void dfs(Position pos, char target){
            for(Direction dir : Direction.values()){
                if(target=='-'){
                    if(dir==Direction.NORTH || dir==Direction.SOUTH){
                        continue;
                    }
                }else if(target=='|'){
                    if(dir==Direction.EAST || dir==Direction.WEST){
                        continue;
                    }
                }

                Position np = pos.add(dir.getCorrelation());

                int nx = np.getX();
                int ny = np.getY();
                if(!isValidRange(np)) continue;
                if(visited[ny][nx]) continue;

                char nextChar = floor[ny][nx];
                if(target==nextChar){
                    visited[ny][nx] = true;
                    dfs(np,target);
                }else{
                    break;
                }
            }
        }

        public int getTiles(){
            return horizontalTile + verticalTile;
        }

        private boolean isValidRange(Position position){
            int x = position.getX();
            int y = position.getY();
            return y>=0 && y<floor.length && x>=0 && x<floor[0].length;
        }
    }

    static enum Direction{
        NORTH(new Position(-1,0)),EAST(new Position(0,1)),SOUTH(new Position(1,0)),WEST(new Position(0,-1));

        private final Position correlation;

        Direction(Position correlation){
            this.correlation = correlation;
        }

        public Position getCorrelation(){
            return correlation;
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
}

