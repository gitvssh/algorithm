package algorithm.baek.greedy;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13305
 * 주유소
 */
public class OilStation implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] distance = new int[n - 1];
        int[] price = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        int minPrice = price[0];
        for (int i = 0; i < n - 1; i++) {
            if (minPrice > price[i]) {
                minPrice = price[i];
            }
            sum += (long) minPrice * distance[i];
        }

        System.out.println(sum);
    }
}
