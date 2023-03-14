package algorithm.baek.greedy;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://www.acmicpc.net/problem/11047
 * 동전 0
 */
public class CoinZero implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        //1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int tgt = Integer.parseInt(input[1]);
        Integer[] coins = new Integer[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        //2. 내림차순 정렬
        Arrays.sort(coins, Collections.reverseOrder());
        //3. 큰 동전부터 빼기
        int cnt = 0;
        for (int coin : coins) {
            if (tgt == 0) break;
            cnt += tgt / coin;
            tgt %= coin;
        }
        //4. 뺀 동전의 개수 출력
        System.out.println(cnt);
    }
}
