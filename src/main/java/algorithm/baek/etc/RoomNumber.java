package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class RoomNumber implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        int count = 0;
        while (n > 0) {
            arr[n % 10]++;
            n /= 10;
        }
        if (arr[6] + arr[9] == 0) {
            for (int i = 0; i < 10; i++) {
                if (arr[i] > count) count = arr[i];
            }
        } else {
            int temp = (arr[6] + arr[9]) / 2;
            if ((arr[6] + arr[9]) % 2 == 1) temp++;
            for (int i = 0; i < 10; i++) {
                if (i == 6 || i == 9) continue;
                if (arr[i] > count) count = arr[i];
            }
            if (temp > count) count = temp;
        }
        System.out.println(count);
    }
}
