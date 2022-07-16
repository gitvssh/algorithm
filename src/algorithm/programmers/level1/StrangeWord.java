package algorithm.programmers.level1;

import algorithm.TestCase;

public class StrangeWord implements TestCase {
    public String solution(String s) {
//        String[] s1 = s.toLowerCase().split("[\\s]+");
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s1.length; i++) {
//            String[] split = s1[i].split("");
//            for (int j = 0; j < split.length; j++) {
//            sb.append((j%2==0)?(split[j].toUpperCase()):split[j]);
//            }
//            sb.append(" ");
//        }
//        return sb.toString().trim();
        int cnt = 0;
        String[] split = s.split("");
        StringBuilder sb = new StringBuilder();
        for (String s1 : split) {
            //내부포문 다른방식
            cnt = s1.contains(" ") ? 0 : cnt + 1;
            sb.append((cnt%2==0)?(s1.toLowerCase()):s1.toUpperCase());
        }
        return sb.toString();
    }

    @Override
    public void test() {
        String try_hello_world = solution("trasdfdfy helfdfsdflo worlwerwerd");
        System.out.println("try_hello_world = " + try_hello_world);
    }
}
