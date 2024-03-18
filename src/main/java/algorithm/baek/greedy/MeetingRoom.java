package algorithm.baek.greedy;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/submit/1931
 * 회의실 배정
 */
public class MeetingRoom implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); 
            meetings[i][1] = Integer.parseInt(st.nextToken()); 
        }

        Arrays.sort(meetings, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        int endTime = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            if (start >= endTime) { 
                endTime = end; 
                count++; 
            }
        }

        
        System.out.println(count); 
    }
}
