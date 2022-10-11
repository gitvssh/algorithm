package algorithm.baek.bfs;

import algorithm.TestCase;

import java.io.DataInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
    public void goRight(int[][] grid, int n, int m) {

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        //방문노드 체크
        int[][] visited = new int[n][m];

        endSet.add(endWord);
        while (!beginSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<>();
            //뎁스별 전체검사
            for (String word : beginSet) {
                //파싱
                char[] chs = word.toCharArray();
                //문자별 검사
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return;
                        }

                        //최초방문 && 단어리스트 포함
                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
        }
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    private static void initFI(){
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    private static int nextInt() throws IOException{
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
            boolean neg = (c == '-');
        if (neg) c = read();
        do{
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if( neg) return -ret;
        return ret;
    }

    private static byte read() throws IOException{
        if (curIdx == maxIdx){
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if(maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
