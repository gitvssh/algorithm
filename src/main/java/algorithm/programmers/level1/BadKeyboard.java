package algorithm.programmers.level1;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class BadKeyboard implements TestCase {
    static int INF = 987654321;

    @Override
    public void test() throws ParseException, IOException {
        int[] solution = solution(new String[]{"AGB", "BSSS"},
                new String[]{"AGZ", "BSSS"});
        System.out.println(solution[0]);
    }

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        //각 문자별 최소 횟수 dp 배열 작성
        int[] dp = new int[26];
        for (int i = 0; i < 26; i++) {
            dp[i] = INF;
        }
        for (String origin : keymap) {
            char[] keymaps = origin.toCharArray();
            for (int i = 0; i < keymaps.length; i++) {
                int n = keymaps[i] - 'A';
                dp[n] = Math.min(dp[n], i + 1);
            }
        }
        //target 검사
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int sum = 0;
            char[] targetArr = target.toCharArray();
            for (int j = 0; j < targetArr.length; j++) {
                int n = targetArr[j] - 'A';
                if (dp[n] == INF) return new int[]{-1};
                sum += dp[n];
            }
            answer[i] = sum;
        }
        return answer;
    }
}
