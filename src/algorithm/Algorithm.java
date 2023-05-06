package algorithm;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

//        CountScore testCase = new CountScore();
//        doTest(testCase);
        int solution = solution(new String[]{"z", "d", "x"}, new String[]{"def", "dww", "dzx", "loveaw"});
        System.out.println(solution);
    }

    public static int solution(String[] spell, String[] dic) {
        int answer = 0;
        for (int i = 0; i < dic.length; i++) {
            boolean[] check = new boolean[spell.length];
            boolean isOk = true;
            String cur = dic[i];

            for (int j = 0; j < cur.length(); j++) {
                String s = Character.toString(cur.charAt(j));
                for (int k = 0; k < spell.length; k++) {
                    if (s.equals(spell[k])) {
                        if (check[k]) {
                            isOk = false;
                            break;
                        }
                        check[k] = true;
                    }
                }

                if (!isOk) {
                    break;
                }
            }
            //모두 체크되었는지 확인
            for (int k = 0; k < spell.length; k++) {
                if (!check[k]) {
                    isOk = false;
                    break;
                }
            }
            //최종결과
            if (isOk) {
                return 1;
            }
        }
        return 2;
    }

    public static void doTest(TestCase testCase) {
        try {
            testCase.test();
        } catch (ParseException | IOException e) {
            throw new ShCodingTestException(e);
        }
    }
}
