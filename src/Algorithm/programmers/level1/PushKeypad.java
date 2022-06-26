package Algorithm.programmers.level1;

import Algorithm.TestCase;

import java.util.stream.IntStream;

public class PushKeypad implements TestCase {

    final int[] keypad = {1,2,3,4,5,6,7,8,9,11,0,12};

    public String solution(int[] numbers, String hand) {
        String answer = "";
        int leftPos = 11;
        int rightPos = 12;


        StringBuilder sb = new StringBuilder();

        for (int number : numbers) {
            String str = pushedBy(number, leftPos, rightPos, hand);
            if(str.equals("L")){
                leftPos = number;
            } else {
                rightPos = number;
            }
            sb.append(str);
        }

        return sb.toString();
    }

    private String pushedBy(int number, int leftPos, int rightPos, String dex) {
        String hand = "";
        if(number%3==1) return "L";
        if(number%3==0 && number!=0) return "R";
//        int i = Arrays.asList(keypad).indexOf(number);
        int leftDis = checkDistance(number, leftPos);
        int rightDis = checkDistance(number, rightPos);
        if((leftDis-rightDis)==0){
            return dex.equals("right")?"R":"L";
        }else{
            return (leftDis - rightDis)<0?"L":"R";
        }
    }

    private int checkDistance(int number, int handPos) {
        int numCord = findPos(number);
        int handCord = findPos(handPos);
        return Math.abs(numCord-handCord);
    }

    private int findPos(int number) {
        int numPos = IntStream.range(0, keypad.length)
                .filter(i -> number == keypad[i])
                .findFirst().orElse(-1);
        int a = numPos % 3;
        int b = numPos / 3;
        return a+b;
    }

    @Override
    public void test() {
        int[] testCase = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hands = "right";
        String solution = solution(testCase, hands);
        System.out.println("solution = " + solution);
    }
}
