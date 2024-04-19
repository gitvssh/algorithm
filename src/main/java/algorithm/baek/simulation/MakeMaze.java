package algorithm.baek.simulation;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;

public class MakeMaze implements TestCase {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    @Override
    public void test() throws ParseException, IOException {
        int n = Integer.parseInt(br.readLine());
        String command = br.readLine();
        MazeBoard maze = new MazeBoard();
        MazeUser user = new MazeUser(maze);
        user.command(command);
        bw.write(user.printMap().toString());
        bw.flush();
        bw.close();
    }

    static class MazeBoard{
        char[][] maze;

        int maxX = 50;
        int maxY = 50;
        int minX = 50;
        int minY = 50;
        static final int MAZE_SIZE = 101;

        MazeBoard(){
            maze = new char[MAZE_SIZE][MAZE_SIZE];
            for(int i = 0; i < MAZE_SIZE; i++){
                for(int j = 0; j < MAZE_SIZE; j++){
                    maze[i][j] = '#';
                }
            }
            maze[50][50] = '.';
        }

        public void writeMap(MazeUser user){
            int x = user.x+50;
            int y = user.y+50;

            maze[x][y] = '.';
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
        }
    }

    static class MazeUser{
        int x;
        int y;

        MazeBoard map;

        DIRECTION dir;

        MazeUser(){
            x = 0;
            y = 0;
            dir = DIRECTION.NORTH;
        }

        MazeUser(MazeBoard map){
            x = 0;
            y = 0;
            dir = DIRECTION.NORTH;
            this.map = map;
        }


        private void move(Character command){
            if(command.equals('F')){
                if(dir.equals(DIRECTION.NORTH)){
                    y++;
                }else if(dir.equals(DIRECTION.SOUTH)){
                    y--;
                }else if(dir.equals(DIRECTION.EAST)){
                    x++;
                }else{
                    x--;
                }
            }
            map.writeMap(this);
        }

        public void command(String r) {
            for(Character c : r.toCharArray()){
                if(c.equals('R')) {
                    this.dir = DIRECTION.values()[(this.dir.getValue()+3)%4];
                }else if(c.equals('L')){
                    this.dir = DIRECTION.values()[(this.dir.getValue()+1)%4];
                }else if(c.equals('F')){
                    move(c);
                }
            }
        }

        public StringBuilder printMap() {
            StringBuilder sb = new StringBuilder();
            for(int j = map.minY; j <= map.maxY; j++){
                for(int i = map.minX; i <= map.maxX; i++){
                    sb.append(map.maze[i][j]);
                }
                sb.append("\n");
            }
            return sb;
        }
    }

    enum DIRECTION{
        NORTH(0), EAST(1), SOUTH(2), WEST(3);
        final int value;

        DIRECTION(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
