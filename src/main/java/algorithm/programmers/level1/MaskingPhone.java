package algorithm.programmers.level1;

import algorithm.TestCase;

public class MaskingPhone implements TestCase {
    public String solution(String phoneNumber) {
        StringBuilder sb = new StringBuilder();
        int length = phoneNumber.length();
        for (int i = 0; i < length - 4; i++) {
            sb.append("*");
        }
        sb.append(phoneNumber.substring(length - 4));
        return sb.toString();
    }

    @Override
    public void test() {
        solution("01033334444");
    }
}
