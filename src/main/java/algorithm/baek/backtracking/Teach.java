package algorithm.baek.backtracking;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1062
 * 가르침
 * 백트래킹
 */
public class Teach implements TestCase {
    static int N, K;
    static int[] words;
    static int max = 0;
    static boolean[] visited = new boolean[26];

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt((st.nextToken()));
        K = Integer.parseInt((st.nextToken()));
        words = new int[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            str.replace("anta", "");
            str.replace("tica", "");
            for (int j = 0; j < str.length(); j++) {
                words[i] |= (1 << (str.charAt(j) - 'a'));
            }
        }

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;
        K -= 5;
        dfs(0, 0);
        System.out.println(max);
    }

    private void dfs(int alpha, int len) {
        if(len == K ) {
            int count = 0;
            for(int i = 0; i < N; i++) { //뽑은 알파벳으로 몇개의 단어를 읽을 수 있는지 카운트.
                boolean read = true;
                for(int j = 0; j < 26; j++) {
                    if((words[i] & (1 << j)) > 0 && visited[j] == false) {
                        read = false;
                        break;
                    }
                }
                if(read) count++;
            }
            max = Math.max(max, count);
            return;
        }

        for(int i = alpha; i < 26; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                dfs(i, len + 1);
                visited[i] = false;
            }
        }
    }
}
