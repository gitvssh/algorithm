package algorithm.programmers.greedy;

import algorithm.TestCase;

import java.util.Arrays;

public class GymSuit implements TestCase {
    public int solution(int n, int[] lost, int[] reserve) {
        /*
        여분 체육복 기준으로 검색
        1. 줄 수 있는 방향 판별
        2. 1개면 넘겨주고 제외하기
        3. 못넘겨주면 없애기
        다 돌면 다시 한번 시도 -> 줄수 있는 체육복이 없어질 때 까지
        그리고 나서 LOST에 남아있나 확인

        체육복을 넘겨주거나 못주면 reserve에서 빼고, 넘겨받으면 lost에서 뺌
        최종적으로 n - lost.length로 리턴하면 됨됨
       */
        Arrays.sort(lost);
        Arrays.sort(reserve);
        // 기본 0
        int[] students = new int[n];
        // 잃어버리면 -1
        for (int lostStudent : lost) {
            students[lostStudent - 1]--;
        }
        // 여유분 +1
        for (int reserveStudent : reserve) {
            students[reserveStudent - 1]++;
        }
        Arrays.stream(students).filter(a -> a ==0).count();

        // +1이상이 -1로 주는 작업
        if (students[0] >= 1 && students[1] == -1) {
            students[0] = 0;
            students[1] = 0;
        }
        if (students[n-1] >= 1 && students[n-2] == -1) {
            students[n-1] = 0;
            students[n-2] = 0;
        }
        for (int j = 0; j < 2; j++) {
            for (int i = 1; i < n; i++) {
                if (students[i] < 1) continue;
                if (i + 1 < n && students[i - 1] == -1 && students[i + 1] != -1) {
                    students[i - 1] = 0;
                    students[i] = 0;
                } else if (i + 1 < n && students[i + 1] == -1 && students[i - 1] != -1) {
                    students[i + 1] = 0;
                    students[i] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (students[i] < 1) continue;
            if (i + 1 < n && students[i - 1] == -1) {
                students[i - 1] = 0;
                students[i] = 0;
            } else if (i + 1 < n && students[i + 1] == -1) {
                students[i + 1] = 0;
                students[i] = 0;
            }
        }
        return n - (int)Arrays.stream(students).filter(a -> a<0).count();
    }

    @Override
    public void test() {
        solution(5, new int[]{2, 4}, new int[]{1, 3, 5});
    }
}
