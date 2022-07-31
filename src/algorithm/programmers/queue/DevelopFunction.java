package algorithm.programmers.queue;

import algorithm.TestCase;

import java.util.ArrayList;

public class DevelopFunction implements TestCase {
    private int index = 0;
    private int answerIndex = 0;

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<>();
        int cnt;
        //전체순회
        for (int j = 0; j < 100; j++) {
            if (index >= progresses.length) break;

            // 1번에 개발완료된 수
            cnt = 0;
            // 1회 개발 진행, 진척도 상승
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            // 젤 처음 개발완료 체크
            if (progresses[index] < 100) continue;
            // 개발 성공
            index++;

            cnt++;
            cnt += isMoreDeveloped(progresses, index);
            answerList.add(cnt);
            answerIndex++;
        }

        return answerList.stream().mapToInt(a -> a).toArray();
    }

    private int isMoreDeveloped(int[] progresses, int innerIndex) {
        if (innerIndex >= progresses.length) return 0;
        if (progresses[innerIndex] >= 100) {
            innerIndex++;
            this.index++;
            return 1 + isMoreDeveloped(progresses, innerIndex);
        }
        return 0;
    }

    @Override
    public void test() {
        int[] solution = solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
