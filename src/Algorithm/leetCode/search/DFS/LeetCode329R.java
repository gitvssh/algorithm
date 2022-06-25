package Algorithm.leetCode.search.DFS;

public class LeetCode329R {

    int height = 0;
    int width = 0;
    final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        height = matrix.length;
        width = matrix[0].length;

        int[][] cache = new int[height][width];
        int max = 1;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int len = checkPath(matrix, i, j, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    private int checkPath(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= height || y < 0 || y >= width || matrix[x][y] <= matrix[i][j]) continue;
            int len = checkPath(matrix, x, y, cache);
            max = Math.max(max, len);
            return max;
        }
        cache[i][j] = max;
        return max;
    }
}

