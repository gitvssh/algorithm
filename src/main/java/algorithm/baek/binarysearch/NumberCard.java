package algorithm.baek.binarysearch;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10815 숫자 카드
 */
public class NumberCard implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(binarySearch(cards, Integer.parseInt(st.nextToken())));
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private int binarySearch(int[] cards, int target) {
        int min = 0;
        int max = cards.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (cards[mid] == target) {
                return 1;
            } else if (cards[mid] < target) {
                min = mid+1;
            } else if (cards[mid] > target) {
                max = mid-1;
            }
        }
        return 0;
    }
}
