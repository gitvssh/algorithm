package algorithm.programmers.level0;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Babbling implements TestCase {
    String[] babblingList = {"aya", "ye", "woo", "ma"};

    @Override
    public void test() throws ParseException, IOException {
        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        System.out.println(solution(babbling));
    }

    public int solution(String[] babbling) {
        Pattern p = Pattern.compile("z+");
        Matcher m;
        int answer = 0;
        StringBuilder sb;
        for (int i = 0; i < babbling.length; i++) {
//            System.out.println("****test Text = " + babbling[i] + "******");
            sb = new StringBuilder(babbling[i]);
            for (int j = 0; j < babblingList.length; j++) {

//                System.out.println("before = " + sb.toString());
                int index = sb.indexOf(babblingList[j]);
                if (index >= 0) {
//                    System.out.println(babblingList[j] + " contains at  " + index);
                    sb = sb.replace(index, index + babblingList[j].length(), "z");

//                    System.out.println("after = " + sb.toString());
                    m = p.matcher(sb);
                    if (m.matches()) {
//                        System.out.println("Match OK");
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
