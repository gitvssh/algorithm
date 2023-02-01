package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class ThreeNumber implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        char[] op = new char[4];
        op[0] = '+';
        op[1] = '-';
        op[2] = '*';
        op[3] = '/';
        for (int i = 0; i < op.length; i++) {
            if (case1(arr, op[i])) {
                bw.write(arr[0] + "" + op[i] + "" + arr[1] + "=" + arr[2]);
                break;
            }else if (case2(arr, op[i])) {
                bw.write(arr[0] + "=" + arr[1] + "" + op[i] + "" + arr[2]);
                break;
            }
        }
        bw.close();
    }

    private boolean case1(int[] arr, char c) {
        switch (c) {
            case '+':
                return (arr[0] + arr[1]) == arr[2];
            case '-':
                return (arr[0] - arr[1]) == arr[2];
            case '*':
                return (arr[0] * arr[1]) == arr[2];
            case '/':
                return (arr[0] / arr[1]) == arr[2];
        }
        return false;
    }

    private boolean case2(int[] arr, char c) {
        switch (c) {
            case '+':
                return arr[0] == (arr[1] + arr[2]);
            case '-':
                return arr[0] == (arr[1] - arr[2]);
            case '*':
                return arr[0] == (arr[1] * arr[2]);
            case '/':
                return arr[0] == (arr[1] / arr[2]);
        }
        return false;
    }
}
