package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import lombok.extern.slf4j.Slf4j;

/**
 * https://www.acmicpc.net/problem/5430 AC
 */
@Slf4j
public class AC implements TestCase {


    public static int[] arr;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    @Override
    public void test() throws ParseException, IOException {
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String command;
        ArrayDeque<Integer> deque;
        int len;
        while (tc-- > 0) {
            command = br.readLine();
            len = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");
            deque = new ArrayDeque<>();
            for (int j = 0; j < len; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            ac(command, deque);
        }
        log.info("result : {}", sb.toString());
    }

    private void ac(String command, ArrayDeque<Integer> deque) {
        boolean isReverse = false;
        long dCount = command.chars().filter(c -> c == 'D').count();
        if (dCount > deque.size()) {
            sb.append("error").append("\n");
            return;
        }
        command = command.replace("RR", "");
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'R') {
                isReverse = !isReverse;
                continue;
            }
            if (isReverse) {
                deque.pollLast();
            } else {
                deque.pollFirst();
            }
        }
        makeString(deque, isReverse);
    }

    private void makeString(ArrayDeque<Integer> deque, boolean isReverse) {
        sb.append("[");
        if (deque.size() > 0) {
            if (isReverse) {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollLast());
                }
            } else {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollFirst());
                }
            }
        }

        sb.append("]").append("\n");
    }
}
