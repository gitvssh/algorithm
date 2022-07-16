package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.Arrays;

public class KimInSeoul implements TestCase {
    public String solution(String[] seoul) {
        int index = -1;
        for (int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")){
                index = i;
                break;
            }
        }
//        String answer = "김서방은 " + index + "에 있다";
        String format = "김서방은 %d에 있다";
        return String.format(format,index);
    }
    @Override
    public void test() {
        String solution = solution(new String[]{"Jane", "Kim"});
        System.out.println("solution = " + solution);
    }
}
