package algorithm.programmers.level1;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class CleanScreen implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int[] solution = solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."});
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }

    public int[] solution(String[] wallpaper) {
        int lux = 0;
        int luy = 0;
        int rdx = 0;
        int rdy = 0;
        int ylen = wallpaper.length;
        int xlen = wallpaper[0].length();
        char[][] map = new char[ylen][xlen];

        for (int i = 0; i < ylen; i++) {
            map[i] = wallpaper[i].toCharArray();
            ;
        }
        //최소 x좌표
        for (int i = 0; i < ylen; i++) {
            boolean flag = false;
            for (int j = 0; j < xlen; j++) {
                if (map[i][j] == '#') {
                    lux = i;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        //최소 y좌표
        for (int i = 0; i < xlen; i++) {
            boolean flag = false;
            for (int j = 0; j < ylen; j++) {
                if (map[j][i] == '#'){
                    luy = i;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        //최대 x좌표
        for (int i = ylen -1; i >= 0; i--) {
            boolean flag = false;
            for (int j = xlen - 1; j >= 0; j--) {
                if (map[i][j] == '#'){
                    rdx = i+1;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        //최대 y좌표
        for (int i = xlen - 1; i >= 0; i--) {
            boolean flag = false;
            for (int j = ylen - 1; j >= 0; j--) {
                if (map[j][i] == '#'){
                    rdy = i + 1;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        int[] answer = {lux, luy, rdx, rdy};
        return answer;
    }
}
