package algorithm.baek.sort;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.Arrays;

public class Statistics implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        int mean, median, range;
        int sum = 0;
        int[] arr = new int[tc];
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            sum += n;
        }
        Arrays.sort(arr);

        boolean flag = false;
        int modeMax = 0;
        int mode = 10000;

        for (int i = 0; i < tc; i++) {
            int jump = 0;
            int count = 1;
            for (int j = i + 1; j < tc; j++) {
                if (arr[i] != arr[j]) {
                    break;
                }
                count++;
                jump++;
            }
            if (count > modeMax) {
                modeMax = count;
                mode = arr[i];
                flag = true;
            } else if (count == modeMax && flag == true) {
                mode = arr[i];
                flag = false;
            }
            i += jump;
        }

        mean = (int) Math.round((double) sum / tc);
        median = arr[tc / 2];
        range = arr[tc - 1] - arr[0];
        bw.write(mean + "\n" + median + "\n" + mode + "\n" + range);
        bw.flush();
        bw.close();
    }
}
