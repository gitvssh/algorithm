package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.ArrayList;

public class NoMoreSameNumber implements TestCase {
    public int[] solution(int[] arr) {
        int[] answer;
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                temp.add(arr[0]);
                continue;
            }
            if (arr[i] != arr[i - 1]) temp.add(arr[i]);
        }
        answer = temp.stream()
                .mapToInt(a -> a)
                .toArray();
        return answer;
    }

    @Override
    public void test() {
        int[] arr = new int[]{1, 1, 3, 3, 0, 1, 1};
        solution(arr);
    }
}
