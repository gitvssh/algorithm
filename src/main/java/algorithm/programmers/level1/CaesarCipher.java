package algorithm.programmers.level1;

import algorithm.TestCase;

/*
문자열 이동
스트링으로 조작하면 비용 많이 소모
아스키코드로 바꿔서 숫자로 계산하는 것이 빨라보임
그럼 어떻게 아스키코드로 바꾸고, 아스키코드를 어떻게 다시 문자로 바꿀 것인지?
아스키코드로 바꾸는 것은 바이트로 바꾸면 됨

* */
public class CaesarCipher implements TestCase {
    public String solution(String s, int n) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ' ') {
                sb.append(' ');
                continue;
            }
            if (Character.isUpperCase(aChar)) {
                sb.append((char) (65 + ((aChar - 65 + n) % 26)));
            } else {
                sb.append((char) (97 + ((aChar - 97 + n) % 26)));
            }
        }
        return sb.toString();
    }

    @Override
    public void test() {
        solution("a B z", 4);
    }
}
