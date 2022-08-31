package algorithm.programmers.codingtest.crema;

import algorithm.TestCase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EliminateSubstring implements TestCase {
    public static String getFinalString(String s) {
        StringBuffer sf = new StringBuffer(s);
//        String s1 = sf.toString();
//        String pattern = ".*AWS.*";
        int idx = sf.indexOf("AWS");
        while (idx != -1) {
//            System.out.println("idx = " + idx);
            sf.replace(idx, idx + 3, "");
            idx = sf.indexOf("AWS");
//            s = s.replace("AWS", "");
        }
        return (sf.toString().length()==0)?"-1":sf.toString();
    }

    @Override
    public void test() {
        String awawssg = getFinalString("AWAWSSG");
        log.info(awawssg);
    }
}
