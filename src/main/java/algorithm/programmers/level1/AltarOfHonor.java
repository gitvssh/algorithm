package algorithm.programmers.level1;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.PriorityQueue;

public class AltarOfHonor implements TestCase {
    static int[] answer;

    @Override
    public void test() throws ParseException, IOException {
        int[] solution = solution(3, new int[]{10, 100, 20, 150, 1, 100, 200});
        for (int i = 0; i < solution.length; i++) {
            System.out.print(solution[i] + " ");
        }

    }

    public int[] solution(int k, int[] score) {
        answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < score.length; i++) {
            pq.add(score[i]);
            if (pq.size() > k) {
                pq.poll();
            }
            answer[i] = pq.peek();
        }
        return answer;
    }
}
