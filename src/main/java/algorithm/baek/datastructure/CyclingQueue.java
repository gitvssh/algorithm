package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1021
 * 회전하는 큐
 */
public class CyclingQueue implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int targetSize = Integer.parseInt(st.nextToken());
        int[] targets = new int[targetSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < targetSize; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= size; i++) {
            deque.addLast(i);
        }
        int min = 0;
        for (int i = 0; i < targetSize; i++) {
            int target = targets[i];
            int left = 0;
            int right = 0;
            for (Integer integer : deque) {
                if (integer == target) {
                    break;
                }
                left++;
            }
            right = deque.size() - left;
            if (left < right) {
                while (deque.peekFirst() != target) {
                    deque.addLast(deque.pollFirst());
                    min++;
                }
                deque.pollFirst();
            } else {
                while (deque.peekFirst() != target) {
                    deque.addFirst(deque.pollLast());
                    min++;
                }
                deque.pollFirst();
            }
        }
        System.out.println(min);
    }
}
