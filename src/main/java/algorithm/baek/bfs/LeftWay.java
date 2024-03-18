package algorithm.baek.bfs;

import algorithm.TestCase;

import java.io.DataInputStream;
import java.io.IOException;
import java.text.ParseException;

public class LeftWay implements TestCase {
    static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    //WWWWWWBWBBBWWWWBBWW
    //BBBWWWWWWWWWWBWWWWB
    /*
     * 1. calculate longest way length (DFS or BFS)
     * 2. calculate shortest way length (BFS)
     * 3. minus 1. - 2.
     *
     * * can go up,right,down
     * */
    @Override
    public void test() throws ParseException {

    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    private static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    private static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
