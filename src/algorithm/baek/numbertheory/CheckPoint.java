package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.Arrays;

public class CheckPoint implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
//        for (int i = 1; i < n; i++) {
//            arr[i] = arr[i] % arr[0];
//        }
        boolean flag = false;
        for (int i = 2; i < arr[0]; i++) {
            int remain = arr[0] % i;
            flag = true;
            for (int j = 1; j < n; j++) {
                if (arr[j] % i != remain) {
                    flag = false;
                    break;
                }
            }
            if (flag) bw.write(i + " ");
        }
        bw.write("\n");
        bw.close();
    }
}
