package Algorithm.programmers.greedy;

import Algorithm.TestCase;

import java.util.ArrayList;

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
        ArrayList<Integer> reserves = new ArrayList<>();
        ArrayList<Integer> losts = new ArrayList<>();
        boolean hasOne = true;
        for (int i : reserve) {
            reserves.add(i);
        }
        for (int i : lost) {
            losts.add(i);
        }
        System.out.println(reserves.size());
        do {
            boolean flag = false;
            int num = 0;
            for (int i = 0; i < reserves.size(); i++) {
                int target = 0;
                if (losts.contains(reserves.get(i))) {
                    losts.remove(reserves.get(i));
                    reserves.remove(reserves.get(i));
                }
                if (losts.contains(reserves.get(i) + 1)) {
                    num++;
                    target = reserves.get(i);
                }
                if (losts.contains(reserves.get(i) - 1)) {
                    num++;
                    target = reserves.get(i);
                }
                switch (num) {
                    case 2:
                        break;
                    case 1:
                        losts.remove(reserves.get(i));
                    case 0:
                        flag = true;
                        reserves.remove(reserves.get(i));
                        break;
                }
            }
            System.out.println("num = " + num);
            System.out.println("flag = " + flag);
            if (num != 0 ||flag == true) hasOne = false;
            System.out.println("hasOne = " + hasOne);
        } while (hasOne);

//        System.out.println(reserves.size());
        for (int i = 0; i < reserves.size(); i++) {
            if (losts.contains(reserves.get(i) + 1)) {
                System.out.println("reserves.get(i) + 1 = " + (reserves.get(i) + 1));
                losts.remove(new Integer(reserves.get(i) + 1));
            }
            if (losts.contains(reserves.get(i) - 1)) {
                losts.remove(new Integer(reserves.get(i) - 1));
            }
        }
        return n - losts.size();
    }

    @Override
    public void test() {
        int solution = solution(5, new int[]{2, 4}, new int[]{3});
        System.out.println("solution = " + solution);
    }
}
