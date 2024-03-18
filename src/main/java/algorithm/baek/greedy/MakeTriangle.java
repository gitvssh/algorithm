package algorithm.baek.greedy;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1448
 * 삼각형 만들기
 */
public class MakeTriangle implements TestCase {
    static int[] arr;

    @Override
    public void test() throws ParseException, IOException {
        //1. 삼각형 조건
        //2. 가장 긴 변을 찾는다.
        //3. 가장 긴 변을 제외한 나머지 두 변의 합이 가장 긴 변보다 길어야 한다.
        //4. 삼각형이 여러개라면 가장 큰 둘레를 출력한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int max = -1;
        for (int i = n - 1; i >= 2; i--) {
            if (arr[i - 2] + arr[i - 1] > arr[i]) {
                max = arr[i - 2] + arr[i - 1] + arr[i];
                break;
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
