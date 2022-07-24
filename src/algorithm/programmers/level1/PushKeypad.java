package algorithm.programmers.level1;

import algorithm.TestCase;

public class PushKeypad implements TestCase {

    public String solution(int[] numbers, String hand) {
        int leftPos = 10;
        int rightPos = 12;


        StringBuilder sb = new StringBuilder();

        for (int number : numbers) {
            if (number == 0) number = 11;
            String str = pushedBy(number, leftPos, rightPos, hand);
            if (str.equals("L")) {
                leftPos = number;
            } else {
                rightPos = number;
            }
            sb.append(str);
        }

        return sb.toString();
    }

    private String pushedBy(int number, int leftPos, int rightPos, String dex) {
        if (number % 3 == 1) return "L";
        if (number % 3 == 0 && number != 0) return "R";
        int leftDis = checkDistance(number, leftPos);
        int rightDis = checkDistance(number, rightPos);
        if ((leftDis - rightDis) == 0) {
            return dex.equals("right") ? "R" : "L";
        } else {
            return (leftDis - rightDis) < 0 ? "L" : "R";
        }
    }

    private int checkDistance(int number, int handPos) {
        int temp = Math.abs(number - handPos);
        int y = temp / 3;
        int x = temp % 3;
        return y + x;
        //타겟 - 현재위치
        // 3나눈 몫, 나머지 더해서 거리 측정
    }

    @Override
    public void test() {
        int[] testCase = new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hands = "right";
        solution(testCase, hands);
    }
}
