package algorithm.baek.bfs;

import algorithm.TestCase;

import java.text.ParseException;

public class GridGame implements TestCase {

    static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    int height, width;

    //n(row) m(column)
    //o....oo.
    //o...oo..
    //....o...
    //k(sec)
    /*
     * 1. make grid from input
     * 2. count exist adjacent living square
     * 3. ignore k(sec)
     * */
    @Override
    public void test() throws ParseException {

    }

    public int longestIncreasingPath(int[][] matrix, int m, int n, int l) {
        height = m;
        width = n;

        int[][] cache = new int[height][width];
        int max = l;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(checkPath(matrix, i, j, cache)) l--;
            }
        }
        return max;
    }

    private boolean checkPath(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return false;
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= height || y < 0 || y >= width || matrix[x][y] <= matrix[i][j]) continue;
            int len = checkPath(matrix, x, y, cache);
            max = Math.max(max, len);
            return max;
        }
        cache[i][j] = max;
        return max;
    }
}
