package algorithm.leetcode.search.binarysearch;

/*
 * A peak element is an element that is strictly greater than its neighbors.
 * Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞.
 * You must write an algorithm that runs in O(log n) time.
 *
 * 최고점 찾는 것이 목표
 * 1점 찍고, 좌 우 비교, 아닐시 재탐색 -> O(log n) -> 탐색시 /2 사용
 * 아무 최고점이나 상관없음, 최고점 나올때까지 계속 반복하면됨
 * 케이스 4개 ( 최고점 - return , 좌상향 - 방향선택, 우상향, 최저점)
 *
 * 1. 재귀함수 작성
 * 2. 탈출조건 체크
 * 3. 왼쪽 탐색
 * 4. 오른쪽 탐색
 *
 * */

import algorithm.TestCase;

public class FindPeakElement implements TestCase {
    public int findPeakElement(int[] num) {
        return solve(num, 0, num.length - 1);
    }

    public int solve(int[] num, int start, int end) {
        // 탐색 마지막 or 1개일 때
        if (start == end) {
            return start;
            //2개 남았을 때
        } else if (start + 1 == end) {
            if (num[start] > num[end]) return start;
            return end;
        } else {
            //log(n) 다음 기준점
            int m = (start + end) / 2;
            // 탈출 조건(최고점)
            if (num[m - 1] < num[m]  && num[m] > num[m + 1]) {
                return m;
                //왼쪽 탐색
            } else if (num[m - 1] > num[m] && num[m] > num[m + 1]) {
                return solve(num, start, m - 1);
                //오른쪽 탐색
            } else {
                return solve(num, m + 1, end);
            }
        }
    }

    @Override
    public void test() {
        int[] num = {1, 2, 3, 2};
        int peakElement = findPeakElement(num);
        System.out.println("인덱스 = " + peakElement);
        System.out.println("해당 인덱스 값 = " + num[peakElement]);
    }
}
