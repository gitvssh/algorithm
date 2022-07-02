package Algorithm.programmers.level1;

import Algorithm.TestCase;

public class PushKeypad implements TestCase {

    final int[] keypad = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    public String solution(int[] numbers, String hand) {
        String answer = "";
        int leftPos = 10;
        int rightPos = 12;


        StringBuilder sb = new StringBuilder();

        for (int number : numbers) {
//            System.out.println("number = " + number);
            if (number == 0) number = 11;
            String str = pushedBy(number, leftPos, rightPos, hand);
            if (str.equals("L")) {
                leftPos = number;
            } else {
                rightPos = number;
            }
//            System.out.println("leftPos = " + leftPos + " , rightPos = " + rightPos);
            sb.append(str);
        }

        return sb.toString();
    }

    private String pushedBy(int number, int leftPos, int rightPos, String dex) {
        String hand = "";
        if (number % 3 == 1) return "L";
        if (number % 3 == 0 && number != 0) return "R";
//        int i = Arrays.asList(keypad).indexOf(number);
        int leftDis = checkDistance(number, leftPos);
        int rightDis = checkDistance(number, rightPos);
//        System.out.println("leftDis = " + leftDis + " right dis = " + rightDis);
        if ((leftDis - rightDis) == 0) {
//            System.out.println("checked 0 ");
//            System.out.println("dex = " + dex);
//            System.out.println(dex.equals("right"));
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
//        int numCord = findPos(number);
//        int handCord = findPos(handPos);
//        return Math.abs(numCord - handCord);
    }
/*
    private int findPos(int number) {
        int numPos = IntStream.range(0, keypad.length)
                .filter(i -> number == keypad[i])
                .findFirst().orElse(-1);
        int a = numPos % 3;
        int b = numPos / 3;
        return a + b;
    }
*/

    @Override
    public void test() {
//        int[] testCase = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        int[] testCase = new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hands = "right";
        String solution = solution(testCase, hands);
        System.out.println("solution = " + solution);
    }
}
