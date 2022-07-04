package Algorithm.programmers.level1;

import Algorithm.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

public class NoMoreSameNumber implements TestCase {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(i==0) {
                temp.add(arr[0]);
                continue;
            }
            if(arr[i]!=arr[i-1]) temp.add(arr[i]);
        }
        answer = temp.stream()
                .mapToInt(a->a)
                .toArray();
//        int[] answer = Arrays.stream(arr)
//                .distinct()
//                .map(a -> )
//                .toArray();
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//        for (int anInt : answer) {
//            System.out.println("anInt = " + anInt);
//        }
        return answer;
    }

    @Override
    public void test() {
        int[] arr = new int[]{1, 1, 3, 3, 0, 1, 1};
        int[] solution = solution(arr);

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
