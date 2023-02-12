package algorithm.programmers.dfs;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class TargetNumber implements TestCase {
    int answer = 0;

    @Override
    public void test() throws ParseException, IOException {
        int[] numbers = {4,1,2,1};
        int target = 4;
        System.out.println(solution(numbers, target));
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target);
        return answer;
    }

    public void dfs(int[] numbers, int depth, int target) {
        if ((depth == numbers.length)) {
            if(target == 0)
            answer++;
            return;
        }
        dfs(numbers, depth + 1, target + numbers[depth]);
        dfs(numbers, depth + 1, target - numbers[depth]);
    }
}
