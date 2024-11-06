package algorithm.baek.twopointer;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;

public class Good implements TestCase {

    /*
    입력:
    숫자의 수
    숫자들

    로직:
    1. 숫자들을 오름차순으로 정렬한다.
    2. 각 수마다 투포인터로 해당 수를 만들 수 있는지 확인
    3. 만들 수 있다면 카운트를 증가시킨다.

    출력:
    각 수마다 다른 두 수의 합으로 나타낼 수 있는 수의 갯수

     */
    @Override
    public void test() throws ParseException, IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            String[] sarr = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(sarr[i]);
            }
            Arrays.sort(arr);


            int count = 0;
            for (int i = 0; i < n; i++) {
                int start = 0;
                int end = n - 1;
                while (start < end) {
                    if (start == i) {
                        start++;
                        continue;
                    }
                    if (end == i) {
                        end--;
                        continue;
                    }
                    int sum = arr[start] + arr[end];
                    if (sum == arr[i]) {
                        count++;
                        break;
                    } else if (sum < arr[i]) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
