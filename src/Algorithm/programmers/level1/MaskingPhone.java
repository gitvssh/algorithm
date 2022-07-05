package Algorithm.programmers.level1;

import Algorithm.TestCase;

public class MaskingPhone implements TestCase {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        int length = phone_number.length();
        for (int i = 0; i < length - 4; i++) {
            sb.append("*");
        }
        sb.append(phone_number.substring(length - 4));
        return sb.toString();
    }
    @Override
    public void test() {
        String solution = solution("01033334444");
        System.out.println("solution = " + solution);
    }
}
