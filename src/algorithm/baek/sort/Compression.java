package algorithm.baek.sort;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Compression implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
//        int tc = Integer.parseInt(br.readLine());
        int tc = Integer.parseInt("6");
        int[] arr = new int[tc];
        int[] arr2 = new int[tc];
        st = new StringTokenizer("1000 999 1000 999 1000 999");
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
            arr2[i] = n;
        }
        Arrays.sort(arr2);
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tc; i++) {
            if (map.get(arr2[i]) == null) {
                map.put(arr2[i], cnt++);
            }
        }
        for (int i = 0; i < tc; i++) {
            bw.write(map.get(arr[i]) + " ");
        }
        bw.flush();
        bw.close();
    }
}
